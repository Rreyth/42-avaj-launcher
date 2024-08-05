package avaj.flyable;

import avaj.flyable.Aircraft;
import avaj.generators.WeatherProvider;

public class Baloon extends Aircraft {

	public Baloon(long p_id, String p_name, int p_longitude, int p_latitude, int p_height) {
		super(p_id, p_name, p_longitude, p_latitude, p_height);
	}

	@Override
	public void updateConditions() { //add message for each case
		String weather = WeatherProvider.getInstance().getCurrentWeather(this.coordinates);
		int new_longitude = this.coordinates.getLongitude();
		int new_height = this.coordinates.getHeight();
		switch (weather) {
			case "SUN":
				new_longitude += 2;
				new_height += 4;
				if (new_height > 100)
					new_height = 100;
				break;
			case "RAIN":
				new_height -= 5;
				if (new_height <= 0)
					new_height = 0;
					//landind
				break;
			case "FOG":
				new_height -= 3;
				if (new_height <= 0)
					new_height = 0;
					//landind
				break;
			case "SNOW":
				new_height -= 15;
				if (new_height <= 0)
					new_height = 0;
					//landind
				break;
		}
		this.coordinates.updateCoordinates(new_longitude, this.coordinates.getLatitude(), new_height);
	}
}