package main;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
import model.Customer;

@Path("/customer")
public class CustomerRestService {

	@GET
	@Path("/getcustomer/{ customerId }")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomer(@PathParam("customerId") int customerId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JSPDay7");
		EntityManager em = factory.createEntityManager();

		// Query query = em.createQuery("select c from Customer c where c.customerId=" +
		// customerId);
		// Customer customer = (Customer) query.getSingleResult();

		Customer customer = em.find(Customer.class, customerId);
		Gson gson = new Gson();

		return gson.toJson(customer);
	}

	@GET
	@Path("/getallcustomers")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCustomers() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JSPDay7");
		EntityManager em = factory.createEntityManager();

		Query query = em.createQuery("select c from Customer c");
		List<Customer> list = query.getResultList();

		Gson gson = new Gson();

		return gson.toJson(list);
	}

	@POST
	@Path("/postcustomer")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String postCustomer(String jsonString) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JSPDay7");
		EntityManager em = factory.createEntityManager();

		Gson gson = new Gson();
		Type type = new TypeToken<Customer>() {
		}.getType();
		Customer customer = gson.fromJson(jsonString, type);
		em.getTransaction().begin();
		Customer updatedCustomer = em.merge(customer);
		em.getTransaction().commit();
		em.close();
		factory.close();

		return "Customer Updated";
	}

	@PUT
	@Path("/putcustomer")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String putCustomer(String jsonString) {
		String response = "";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JSPDay7");
		EntityManager em = factory.createEntityManager();

		Gson gson = new Gson();
		Type type = new TypeToken<Customer>() {}.getType();
		Customer customer = gson.fromJson(jsonString, type);
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		if (em.contains(customer))
		{
			response = "Customer inserted";
		}
		else
		{
			response = "Customer insert failed";
		}
		em.close();
		factory.close();

		return response;
	}

	@DELETE
	@Path("/deletecustomer/{ customerId }")
	public String deleteCustomer(@PathParam("customerId") int customerId) {
		String response = "";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JSPDay7");
		EntityManager em = factory.createEntityManager();

		Customer customer = em.find(Customer.class, customerId);
		em.getTransaction().begin();
		em.remove(customer);
		if (em.contains(customer))
		{
			em.getTransaction().rollback();
			response = "Customer deletion failed";
		}
		else
		{
			em.getTransaction().commit();
			response = "Customer deleted";
		}
		em.close();
		factory.close();

		return response;
	}
}
