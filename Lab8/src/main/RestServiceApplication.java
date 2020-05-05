package main;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
 
@ApplicationPath("main.RestServiceApplication")
public class RestServiceApplication  extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	 
	public RestServiceApplication() {
		singletons.add(new CustomerRestService());
		singletons.add(new AgentRestService());
		singletons.add(new BookingRestService());
		singletons.add(new ProductRestService());
		singletons.add(new PackageRestService());
	}
 
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {
		return null;
	}

}
