package pl.fis.artur.kasza.jaxrs;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "ship")
public class SpaceshipV2 {
	private String name;
	
	public SpaceshipV2() {
		
	}
	
	public SpaceshipV2(String name) {
		this.name = name;
	}
	
	@XmlValue
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
