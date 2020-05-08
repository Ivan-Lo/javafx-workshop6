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
import model.Package;



@Path("/package")
public class PackageRestService {
	
	@GET
	@Path("/getallpackages")
    @Produces(MediaType.APPLICATION_JSON)
	public String getAllPackages() {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select a from Package a");
		List<Package> list = query.getResultList();
		
		Gson gson = new Gson();
		//Type type = new TypeToken<List<Agent>>() {}.getType();
		em.close();
		factory.close();

        return gson.toJson(list); //, type);	
	}

	@GET
	@Path("/getpackage/{ packageId }")
    @Produces(MediaType.APPLICATION_JSON)
	public String getAgent(@PathParam("packageId") int packageId) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select a from Package a where a.packageId=" + packageId);
		Package packageget = (Package) query.getSingleResult();

		Gson gson = new Gson();
		//Type type = new TypeToken<Agent>() {}.getType();
		em.close();
		factory.close();

		return gson.toJson(packageget); //, type);	
	}

	
	

	@POST
	@Path("/postpackage")
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String postPackage(String jsonString) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		
		Gson gson = new Gson();
		Type type = new TypeToken<Package>() {}.getType();
		Package packageget = gson.fromJson(jsonString, type);
		em.getTransaction().begin();
		Package newPackage = em.merge(packageget);
		em.getTransaction().commit();
		em.close();
		factory.close();

        return "Package was updated";	
	}

	@PUT
	@Path("/putPackage")
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String putPackage(String jsonString) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		
		Gson gson = new Gson();
		//Type type = new TypeToken<Agent>() {}.getType();
		Package packageget = gson.fromJson(jsonString, Package.class);
		em.getTransaction().begin();
		em.persist(packageget);
		em.getTransaction().commit();
		em.close();
		factory.close();
		
        return "Package added to database";	
	}

	@DELETE
	@Path("/deletepackage/{ packageId }")
	public String deletePackage(@PathParam("packageId") int packageId) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		
		Package packageget = em.find(Package.class, packageId);
		em.getTransaction().begin();
		em.remove(packageget);
		if (em.contains(packageget))
		{
			em.getTransaction().rollback();
			em.close();
			factory.close();
			return "There was an error while deleting this package";
		}
		else
		{
			em.getTransaction().commit();
			em.close();
			factory.close();
			return "package was deleted";
		}
	}
}
