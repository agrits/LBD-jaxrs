package pl.fis.artur.kasza.jaxrs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("v3")
public class V3Service {
	
	@Inject
	DataStorage dataStorage;
	
	
	
	@GET
	@Path("/space-fleet")
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	public SpaceFleetV3 getSpacefleets() {
		return dataStorage.getSpaceFleet();
	}
	
	
	@POST
	@Path("/space-fleet")
	@Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	public SpaceshipV3 addSpaceship(SpaceshipV3 spaceship) throws SpaceshipExistsInFleetException{
		return dataStorage.add(spaceship);
	}
	
	@GET
	@Path("/spaceship/{name}")
	@Produces({MediaType.TEXT_XML,MediaType.APPLICATION_JSON})
	public SpaceshipV3 getSpaceship(@PathParam("name") String name) throws ResourceNotFoundException{
		return dataStorage.getSpaceFleet().findShipByName(name);
	}
	
	
	
}
