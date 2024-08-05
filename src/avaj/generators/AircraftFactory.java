package avaj.generators;

import avaj.flyable.Baloon;
import avaj.flyable.Flyable;
import avaj.flyable.JetPlane;
import avaj.flyable.Helicopter;

public class AircraftFactory {
	private static AircraftFactory instance;
	private static int id = 0;

	private AircraftFactory() {
	}

	public static AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, int p_longitude, int p_latitude, int p_height) {
		id++;
		if (p_type.equals("Baloon")) {
			return new Baloon(id, p_name, p_longitude, p_latitude, p_height);
		}
		else if (p_type.equals("JetPlane")) {
			return new JetPlane(id, p_name, p_longitude, p_latitude, p_height);
		}
		else if (p_type.equals("Helicopter")) {
			return new Helicopter(id, p_name, p_longitude, p_latitude, p_height);
		}
		else {
			id--;
			return null; // throw custom exception
		}
	}
}
