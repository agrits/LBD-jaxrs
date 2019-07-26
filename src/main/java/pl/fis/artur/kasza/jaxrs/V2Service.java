package pl.fis.artur.kasza.jaxrs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v2")
public class V2Service {
	
	@Inject
	private DataStorage dataStorage;
	
	
	@GET
	@Path("/spaceships")
	@Produces({MediaType.TEXT_XML})
	public SpaceshipCollectionV2 getSpaceshipsXML() {
		return dataStorage.getSpaceshipCollectionV2();
	}
	
	@GET
	@Path("/spaceships")
	@Produces({MediaType.APPLICATION_JSON})
	public String getSpaceshipsJSON() {
		return dataStorage.getSpaceshipCollectionV2().toJSON();
	}
	
	@POST
	@Path("/spaceships")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public SpaceshipV2 addSpaceship(SpaceshipV2 s) {
		return dataStorage.addV2(s);
	}
	
	@POST
	@Path("/spaceships")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SpaceshipV2 addSpaceshipJSON(SpaceshipV2 s) {
		return dataStorage.addV2(s);
	}
	
	@DELETE
	@Path("/spaceships/{name}")
	public SpaceshipV2 removeSpaceship(@PathParam("name") String name) {
		return dataStorage.removeV2(name);
	}
	
	
}
