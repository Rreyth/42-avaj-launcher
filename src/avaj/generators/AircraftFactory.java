// import Flyable
// imnport Baloon
// import JetPlane
// import Helicopter


public class AircraftFactory {
	private static AircraftFactory instance;
	private static int id = 1;

	private AircraftFactory() {
	}

	public static AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable* newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		if (p_type.equals("Baloon")) {
			return new Baloon(id, p_name, p_coordinates);
		}
		else if (p_type.equals("JetPlane")) {
			return new JetPlane(id, p_name, p_coordinates);
		}
		else if (p_type.equals("Helicopter")) {
			return new Helicopter(id, p_name, p_coordinates);
		}
		else {
			return null; // throw custom exception
		}
		id++;
	}
}
