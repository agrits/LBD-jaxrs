package pl.fis.artur.kasza.jaxrs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class DataStorage {
	private SpaceFleetV3 spaceFleetV3;
	private SpaceFleetV4 spaceFleetV4;
	private SpaceshipCollectionV2 spaceshipCollectionV2;
	private final String[] SPACESHIPS_NAMES = {"Battlestar Galactica", 
			"Elysium", 
			"Reapers", 
			"USS Enterprise",
			"Spaceball One"};
	@PostConstruct
	public void initializeFleet() {
		
		
		List<SpaceshipV3> spaceshipsV3 = Arrays.asList(SPACESHIPS_NAMES).stream().map(name -> 
		{
			SpaceshipV3 s = new SpaceshipV3(name);
			return s;
		}).collect(Collectors.toList());
		
		List<SpaceshipV4> spaceshipsV4 = Arrays.asList(SPACESHIPS_NAMES).stream().map(name -> 
		{
			SpaceshipV4 s = new SpaceshipV4(name, 3.5, LocalDate.parse("2003-03-17", DateTimeFormatter.ISO_LOCAL_DATE));
			return s;
		}).collect(Collectors.toList());
		
		spaceshipCollectionV2 = new SpaceshipCollectionV2(SPACESHIPS_NAMES);
		spaceFleetV3 = new SpaceFleetV3("FIS Space Fleet", spaceshipsV3);
		spaceFleetV4 = new SpaceFleetV4("FIS Space Fleet", spaceshipsV4);
	}
	
	public SpaceshipV3 add(SpaceshipV3 spaceship) throws SpaceshipExistsInFleetException {
		spaceFleetV3.add(spaceship);
		return spaceship;
	}
	
	public SpaceFleetV3 getSpaceFleet() {
		return spaceFleetV3;
	}
	
	public SpaceshipV2 addV2(SpaceshipV2 spaceship) {
		spaceshipCollectionV2.add(spaceship);
		return spaceship;
	}
	
	public SpaceshipCollectionV2 getSpaceshipCollectionV2() {
		return spaceshipCollectionV2;
	}

	public SpaceshipV2 removeV2(String name) {
		return spaceshipCollectionV2.remove(name);
	}

	public SpaceshipV4 addV4(SpaceshipV4 spaceship) throws SpaceshipExistsInFleetException {
		spaceFleetV4.add(spaceship);
		return spaceship;
	}

	public SpaceFleetV4 getSpaceFleetV4() {
		return spaceFleetV4;
	}
}
