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
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import model.Agent;
import model.Product;


@Path("/product")
public class ProductRestService {
	
	private static final JsonElement product = null;

	@GET
	@Path("/getallproducts")
    @Produces(MediaType.APPLICATION_JSON)
	public String getAllProducts() {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab7");
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select a from Product a");
		List<Product> list = query.getResultList();
		
		Gson gson = new Gson();
		//Type type = new TypeToken<List<Agent>>() {}.getType();
		em.close();
		factory.close();

        return gson.toJson(list); //, type);	
	}

	@GET
	@Path("/getproduct/{ productId }")
    @Produces(MediaType.APPLICATION_JSON)
	public String getProduct(@PathParam("productId") int productId) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab7");
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select a from Product a where a.productId=" + productId);
		Agent agent = (Agent) query.getSingleResult();

		Gson gson = new Gson();
		//Type type = new TypeToken<Agent>() {}.getType();
		em.close();
		factory.close();

		return gson.toJson(product); //, type);	
	}

	@POST
	@Path("/postproduct")
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String postProduct(String jsonString) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab7");
		EntityManager em = factory.createEntityManager();
		
		Gson gson = new Gson();
		Type type = new TypeToken<Agent>() {}.getType();
		Product product = gson.fromJson(jsonString, type);
		em.getTransaction().begin();
		Product newProduct = em.merge(product);
		em.getTransaction().commit();
		em.close();
		factory.close();

        return "Product was updated";	
	}

	@PUT
	@Path("/putproduct")
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String putProduct(String jsonString) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab7");
		EntityManager em = factory.createEntityManager();
		
		Gson gson = new Gson();
		//Type type = new TypeToken<Agent>() {}.getType();
		Product product = gson.fromJson(jsonString, Product.class);
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
		factory.close();
		
        return "Product added to database";	
	}

	@DELETE
	@Path("/deleteproduct/{ productId }")
	public String deleteProduct(@PathParam("productId") int productId) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab7");
		EntityManager em = factory.createEntityManager();
		
		Product product = em.find(Product.class, productId);
		em.getTransaction().begin();
		em.remove(product);
		if (em.contains(product))
		{
			em.getTransaction().rollback();
			em.close();
			factory.close();
			return "There was an error while deleting this product";
		}
		else
		{
			em.getTransaction().commit();
			em.close();
			factory.close();
			return "product was deleted";
		}
	}
}
