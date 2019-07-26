package pl.fis.artur.kasza.jaxrs;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "spaceship")
public class SpaceshipV4{
	
	
	private LocalDate yearOfManufacturing;
	
	
	private String name;
	private double speed;
	
	public SpaceshipV4() {
		
	}
	
	public SpaceshipV4(String name, double speed, LocalDate yearOfManufacturing) {
		this.name = name;
		this.yearOfManufacturing = yearOfManufacturing;
		this.speed = speed;
	}

	@PastOrPresent
	@XmlElement(name = "year-of-manufacturing")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getYearOfManufacturing() {
		return yearOfManufacturing;
	}

	public void setYearOfManufacturing(LocalDate yearOfManufacturing) {
		this.yearOfManufacturing = yearOfManufacturing;
	}
	
	@NotBlank
	@XmlElement(name = "name", required = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Positive
	@XmlElement(name = "speed", required = true)
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	
}
