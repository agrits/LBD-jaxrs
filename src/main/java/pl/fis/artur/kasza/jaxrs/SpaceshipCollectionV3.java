package pl.fis.artur.kasza.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "spaceships")

public class SpaceshipCollectionV3 {
	@XmlElement(name="spaceship")
	private List<SpaceshipV3> spaceships = new ArrayList<SpaceshipV3>();
	public SpaceshipCollectionV3(List<SpaceshipV3> spaceships) {
		this.spaceships = spaceships;
	}
	public SpaceshipCollectionV3() {
		
	}
	
	public SpaceshipCollectionV3(String[] names) {
		for(String name : names) {
			SpaceshipV3 spaceship = new SpaceshipV3();
			spaceship.setName(name);
			spaceships.add(spaceship);
		}
	}
	
	public void add(SpaceshipV3 spaceship) {
		spaceships.add(spaceship);
	}
	


	
}
