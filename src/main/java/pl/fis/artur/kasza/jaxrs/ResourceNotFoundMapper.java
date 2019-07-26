package pl.fis.artur.kasza.jaxrs;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ResourceNotFoundMapper  implements ExceptionMapper<ResourceNotFoundException>{


	@Override
	@Produces(MediaType.APPLICATION_JSON)
	public Response toResponse(ResourceNotFoundException exception) {
		return Response.status(Response.Status.NOT_FOUND)
				.type(MediaType.APPLICATION_JSON)
				.entity("{\"status\":\"NOT_FOUND\", \"message\":\"resource '"+ exception.getResourceName() +"' not found\"}")
				.build();
	}
	
	
	
}
