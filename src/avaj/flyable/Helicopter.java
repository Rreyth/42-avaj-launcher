package avaj.flyable;

import avaj.utils.Print;
import avaj.flyable.Aircraft;
import avaj.generators.WeatherProvider;

public class Helicopter extends Aircraft {

	public Helicopter(long p_id, String p_name, int p_longitude, int p_latitude, int p_height) {
		super(p_id, p_name, p_longitude, p_latitude, p_height);
	}

	@Override
	public void updateConditions() {
		String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
		int new_longitude = coordinates.getLongitude();
		int new_height = coordinates.getHeight();
		switch (weather) {
			case "SUN":
				new_longitude += 10;
				new_height += 2;
				if (new_height > 100)
					new_height = 100;
				Print.printToFile(getInfos() + ": Dazot.\n", "simulation.txt");
				break;
			case "RAIN":
				new_longitude += 5;
				Print.printToFile(getInfos() + ": It's raining men, alleluia.\n", "simulation.txt");
				break;
			case "FOG":
				new_longitude += 1;
				Print.printToFile(getInfos() + ": I'm flying blind.\n", "simulation.txt");
				break;
			case "SNOW":
				new_height -= 12;
				Print.printToFile(getInfos() + ": Brrrrrrrrr.\n", "simulation.txt");
				if (new_height <= 0){
					Print.printToFile(getInfos() + " landing.\n", "simulation.txt");
					unregisterTower();
					return;
				}
				break;
		}
		coordinates.updateCoordinates(new_longitude, coordinates.getLatitude(), new_height);
	}
}