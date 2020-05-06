package main;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.lang.reflect.Type;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Agent;
import model.Booking;


@Path("/booking")
public class BookingRestService {
	
	@GET
	@Path("/getallbookings")
    @Produces(MediaType.APPLICATION_JSON)
	public String getAllBookings() {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		Query query = (Query) em.createQuery("select a from Booking a");
		List<Agent> list = ((javax.persistence.Query) query).getResultList();
		
		Gson gson = new Gson();
		//Type type = new TypeToken<List<Agent>>() {}.getType();
		em.close();
		factory.close();

        return gson.toJson(list); //, type);	
	}


	@GET
	@Path("/getbooking/{ bookingId }")
    @Produces(MediaType.APPLICATION_JSON)
	public String getBooking(@PathParam("bookingId") int bookingId) {
		EntityManagerFactory factory
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		Query query = (Query) em.createQuery("select a from Booking a where a.bookingId=" + bookingId);
		Booking booking = (Booking) ((javax.persistence.Query) query).getSingleResult();
	
		Gson gson = new Gson();
		em.close();
		factory.close();
	
        return gson.toJson(booking);	
	}

	@POST
	@Path("/postbooking")
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String postBooking(String jsonString) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		
		Gson gson = new Gson();
		Type type = new TypeToken<Agent>() {}.getType();
		Booking booking = gson.fromJson(jsonString, type);
		em.getTransaction().begin();
		Booking newBooking = em.merge(booking);
		em.getTransaction().commit();
		em.close();
		factory.close();

        return "Booking was updated";	
	}

	@PUT
	@Path("/putBooking")
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String putBooking(String jsonString) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		
		Gson gson = new Gson();
		//Type type = new TypeToken<Agent>() {}.getType();
		Booking booking = gson.fromJson(jsonString, Booking.class);
		em.getTransaction().begin();
		em.persist(booking);
		em.getTransaction().commit();
		em.close();
		factory.close();
		
        return "Booking added to database";	
	}

	@DELETE
	@Path("/deletebooking/{ bookingId }")
	public String deleteBooking(@PathParam("bookingId") int bookingId) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		
		Booking booking = em.find(Booking.class, bookingId);
		em.getTransaction().begin();
		em.remove(booking);
		if (em.contains(booking))
		{
			em.getTransaction().rollback();
			em.close();
			factory.close();
			return "There was an error while deleting this agent";
		}
		else
		{
			em.getTransaction().commit();
			em.close();
			factory.close();
			return "Booking was deleted";
		}
	}
}
