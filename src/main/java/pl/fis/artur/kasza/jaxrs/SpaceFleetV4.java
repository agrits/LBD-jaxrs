package pl.fis.artur.kasza.jaxrs;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="fleet")
public class SpaceFleetV4 {
	
	private List<SpaceshipV4> ships;
	
	@XmlElement(name = "name")
	private String name;
	
	public SpaceFleetV4(String name, List<SpaceshipV4> ships) {
		this.ships = ships;
		this.name = name;
	}
	
	public SpaceFleetV4() {
		
	}
	
	public void add(SpaceshipV4 s) throws SpaceshipExistsInFleetException {
		if(ships.stream().anyMatch(ship -> ship.equals(s))) {
			throw new SpaceshipExistsInFleetException();
		}
		
		else {
			ships.add(s);
		}
	}
	
	public SpaceshipV4 findShipByName(String name) throws ResourceNotFoundException {
		for(SpaceshipV4 ship : ships) {
			if(ship.getName().contentEquals(name)){
				return ship;
			}
		}
		throw new ResourceNotFoundException(name);
	}
	@XmlElement(name="spaceship")

	public List<SpaceshipV4> getShips() {
		return ships;
	}
	
	
	public void setShips(List<SpaceshipV4> ships) {
		this.ships = ships;
	}

}
