package avaj.flyable;

import avaj.utils.Print;
import avaj.flyable.Aircraft;
import avaj.generators.WeatherProvider;

public class Baloon extends Aircraft {

	public Baloon(long p_id, String p_name, int p_longitude, int p_latitude, int p_height) {
		super(p_id, p_name, p_longitude, p_latitude, p_height);
	}

	@Override
	public void updateConditions() {
		String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
		int new_longitude = coordinates.getLongitude();
		int new_height = coordinates.getHeight();
		switch (weather) {
			case "SUN":
				new_longitude += 2;
				new_height += 4;
				if (new_height > 100)
					new_height = 100;
				Print.printToFile(getInfos() + ": Let me take my sunglasses.\n", "simulation.txt");
				break;
			case "RAIN":
				new_height -= 5;
				Print.printToFile(getInfos() + ": I'm drowning blblblbl.\n", "simulation.txt");
				if (new_height <= 0){
					Print.printToFile(getInfos() + " landing.\n", "simulation.txt");
					unregisterTower();
					return;
				}
				break;
			case "FOG":
				new_height -= 3;
				Print.printToFile(getInfos() + ": Where am I.\n", "simulation.txt");
				if (new_height <= 0){
					Print.printToFile(getInfos() + " landing.\n", "simulation.txt");
					unregisterTower();
					return;
				}
				break;
			case "SNOW":
				new_height -= 15;
				Print.printToFile(getInfos() + ": Damn Ice Cube is here.\n", "simulation.txt");
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