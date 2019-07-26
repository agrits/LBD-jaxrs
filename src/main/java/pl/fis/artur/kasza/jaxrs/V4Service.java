package pl.fis.artur.kasza.jaxrs;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api("Service for v4 operations")
@Path("/v4")
public class V4Service {
	
	@Inject
	DataStorage dataStorage;
	
	
	
	@GET
	@Path("/space-fleet")
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	@ApiOperation(value = "Retrieve Space Fleet", notes = "Return current Space Fleet representation to the client in XML/JSON.")
	public SpaceFleetV4 getSpacefleets() {
		return dataStorage.getSpaceFleetV4();
	}
	
	
	@POST
	@Path("/space-fleet")
	@Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	@ApiOperation(value = "Add Spaceship to Space Fleet", notes = "Add new Spaceship to Space Fleet and return its instance in JSON/XML")
	public SpaceshipV4 addSpaceship(@Valid SpaceshipV4 spaceship) throws SpaceshipExistsInFleetException{
		return dataStorage.addV4(spaceship);
	}
	
	@GET
	@Path("/spaceship/{name}")
	@Produces({MediaType.TEXT_XML,MediaType.APPLICATION_JSON})
	@ApiOperation(value = "Retrieve specific Spaceship", notes = "Find Spaceship by name and return i to the client in XML/JSON.")
	public SpaceshipV4 getSpaceship(@PathParam("name") String name) throws ResourceNotFoundException{
		return dataStorage.getSpaceFleetV4().findShipByName(name);
	}
	
	
	
}
