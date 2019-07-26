package pl.fis.artur.kasza.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "spaceships")

public class SpaceshipCollectionV4 {
	@XmlElement(name="spaceship")
	private List<SpaceshipV4> spaceships = new ArrayList<SpaceshipV4>();
	public SpaceshipCollectionV4(List<SpaceshipV4> spaceships) {
		this.spaceships = spaceships;
	}
	public SpaceshipCollectionV4() {
		
	}
	
	public SpaceshipCollectionV4(String[] names) {
		for(String name : names) {
			SpaceshipV4 spaceship = new SpaceshipV4();
			spaceship.setName(name);
			spaceships.add(spaceship);
		}
	}
	
	public void add(SpaceshipV4 spaceship) {
		spaceships.add(spaceship);
	}
	


	
}
