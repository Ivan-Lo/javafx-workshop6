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


@Path("/agent")
public class AgentRestService {
	
	@GET
	@Path("/getallagents")
    @Produces(MediaType.APPLICATION_JSON)
	public String getAllAgents() {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select a from Agent a");
		List<Agent> list = query.getResultList();
		
		Gson gson = new Gson();
		//Type type = new TypeToken<List<Agent>>() {}.getType();
		em.close();
		factory.close();

        return gson.toJson(list); //, type);	
	}

	@GET
	@Path("/getagent/{ agentId }")
    @Produces(MediaType.APPLICATION_JSON)
	public String getAgent(@PathParam("agentId") int agentId) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select a from Agent a where a.agentId=" + agentId);
		Agent agent = (Agent) query.getSingleResult();

		Gson gson = new Gson();
		//Type type = new TypeToken<Agent>() {}.getType();
		em.close();
		factory.close();

		return gson.toJson(agent); //, type);	
	}

	@POST
	@Path("/postagent")
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String postAgent(String jsonString) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		
		Gson gson = new Gson();
		Type type = new TypeToken<Agent>() {}.getType();
		Agent agent = gson.fromJson(jsonString, type);
		em.getTransaction().begin();
		Agent newAgent = em.merge(agent);
		em.getTransaction().commit();
		em.close();
		factory.close();

        return "Agent was updated";	
	}

	@PUT
	@Path("/putagent")
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String putAgent(String jsonString) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		
		Gson gson = new Gson();
		//Type type = new TypeToken<Agent>() {}.getType();
		Agent agent = gson.fromJson(jsonString, Agent.class);
		em.getTransaction().begin();
		em.persist(agent);
		em.getTransaction().commit();
		em.close();
		factory.close();
		
        return "Agent added to database";	
	}

	@DELETE
	@Path("/deleteagent/{ agentId }")
	public String deleteAgent(@PathParam("agentId") int agentId) {
		EntityManagerFactory factory 
			= Persistence.createEntityManagerFactory("Lab8");
		EntityManager em = factory.createEntityManager();
		
		Agent agent = em.find(Agent.class, agentId);
		em.getTransaction().begin();
		em.remove(agent);
		if (em.contains(agent))
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
			return "Agent was deleted";
		}
	}
}
