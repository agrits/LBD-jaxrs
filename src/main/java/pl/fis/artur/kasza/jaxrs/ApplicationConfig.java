package pl.fis.artur.kasza.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationConfig extends Application{
	@Override
	public Set<Class<?>> getClasses() {

	    Set<Class<?>> classes = new HashSet<>();

	    classes.add(V2Service.class);
	    classes.add(V3Service.class);
	    classes.add(V4Service.class);
	    classes.add(com.github.phillipkruger.apiee.ApieeService.class);

	    return classes;

	}
}
