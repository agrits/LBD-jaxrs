package pl.fis.artur.kasza.jaxrs;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="fleet")
public class SpaceFleetV3 {
	@XmlElement(name="spaceship")
	@JsonbProperty
	private List<SpaceshipV3> ships;
	@XmlElement
	@JsonbProperty
	private String name;
	
	public SpaceFleetV3(String name, List<SpaceshipV3> ships) {
		this.ships = ships;
		this.name = name;
	}
	
	public SpaceFleetV3() {
		
	}
	
	public void add(SpaceshipV3 s) throws SpaceshipExistsInFleetException {
		if(ships.stream().anyMatch(ship -> ship.equals(s))) {
			throw new SpaceshipExistsInFleetException();
		}
		
		else {
			ships.add(s);
		}
	}
	
	public SpaceshipV3 findShipByName(String name) throws ResourceNotFoundException {
		for(SpaceshipV3 ship : ships) {
			if(ship.getName().contentEquals(name)){
				return ship;
			}
		}
		throw new ResourceNotFoundException(name);
	}
	
	
}
