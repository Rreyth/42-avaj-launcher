package avaj.flyable;

import avaj.utils.Print;
import avaj.flyable.Aircraft;
import avaj.generators.WeatherProvider;

public class JetPlane extends Aircraft {

	public JetPlane(long p_id, String p_name, int p_longitude, int p_latitude, int p_height) {
		super(p_id, p_name, p_longitude, p_latitude, p_height);
	}

	@Override
	public void updateConditions() {
		String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
		int new_latitude = coordinates.getLatitude();
		int new_height = coordinates.getHeight();
		switch (weather) {
			case "SUN":
				new_latitude += 10;
				new_height += 2;
				if (new_height > 100)
					new_height = 100;
				Print.printToFile(getInfos() + ": Looks like I'm gonna need some sunscreen.\n", "simulation.txt");
				break;
			case "RAIN":
				new_latitude += 5;
				Print.printToFile(getInfos() + ": It'll take eternity to dry.\n", "simulation.txt");
				break;
			case "FOG":
				new_latitude += 1;
				Print.printToFile(getInfos() + ": I can't see anything.\n", "simulation.txt");
				break;
			case "SNOW":
				new_height -= 7;
				Print.printToFile(getInfos() + ": John Snow is that you?\n", "simulation.txt");
				if (new_height <= 0) {
					Print.printToFile(getInfos() + " landing.\n", "simulation.txt");
					unregisterTower();
					return;
				}
				break;
		}
		coordinates.updateCoordinates(coordinates.getLongitude(), new_latitude, new_height);
	}
}