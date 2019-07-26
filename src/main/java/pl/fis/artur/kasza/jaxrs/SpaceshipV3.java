package pl.fis.artur.kasza.jaxrs;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="spaceship")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpaceshipV3 {
	@JsonbProperty(value = "name")
	private String name;
	private double speed;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public SpaceshipV3() {
		this.speed = 3.5;
	}
	public SpaceshipV3(String name) {
		this.name = name;
		this.speed = 3.5;
	}
	public SpaceshipV3(String name, double speed) {
		this.speed = speed;
	}
	
	
	
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public boolean equals(SpaceshipV3 s) {
		return this.name.contentEquals(s.getName());
	}
	
	public SpaceshipV2 toSpaceshipV2() {
		return new SpaceshipV2(this.name);
	}
	
	
}
