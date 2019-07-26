package pl.fis.artur.kasza.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "spaceships")
public class SpaceshipCollectionV2 {
	
	private StringBuilder sb = new StringBuilder();
	
	@XmlElement(name="ship")
	private List<SpaceshipV2> spaceships = new ArrayList<SpaceshipV2>();
	public SpaceshipCollectionV2(List<SpaceshipV2> spaceships) {
		this.spaceships = spaceships;
	}
	
	public SpaceshipCollectionV2() {
		
	}
	
	public SpaceshipCollectionV2(String[] names) {
		for(String name : names) {
			SpaceshipV2 spaceship = new SpaceshipV2();
			spaceship.setName(name);
			spaceships.add(spaceship);
		}
	}
	
	public void add(SpaceshipV2 spaceship) {
		spaceships.add(spaceship);
	}
	
	public String toJSON(){
		sb.setLength(0);
		sb.append("{");
		sb.append("\"spaceships\": [");
		String prefix = "";
		for(SpaceshipV2 s : spaceships) {
			sb.append(prefix);
			sb.append('"'+s.getName()+'"');
			prefix = ",";
		}
		sb.append("]}");
		return sb.toString();
		
	}

	public SpaceshipV2 remove(String name) {
		for(SpaceshipV2 s : spaceships) {
			if(s.getName().contentEquals(name)) {
				spaceships.remove(s);
				return s;
			}
		}
		return null;
	}
}
