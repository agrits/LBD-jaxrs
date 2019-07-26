package pl.fis.artur.kasza.jaxrs;

import java.time.LocalDate;

public interface SpaceshipV4Interface {
	public String getName();
	public double getSpeed();
	public LocalDate getYearOfManufacturing();
}
