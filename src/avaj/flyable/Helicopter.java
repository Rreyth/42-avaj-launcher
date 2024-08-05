package avaj.flyable;

import avaj.flyable.Aircraft;
import avaj.generators.WeatherProvider;

public class Helicopter extends Aircraft {

	public Helicopter(long p_id, String p_name, int p_longitude, int p_latitude, int p_height) {
		super(p_id, p_name, p_longitude, p_latitude, p_height);
	}

	@Override
	public void updateConditions() { //add message for each case
		String weather = WeatherProvider.getInstance().getCurrentWeather(this.coordinates);
		int new_longitude = this.coordinates.getLongitude();
		int new_height = this.coordinates.getHeight();
		switch (weather) {
			case "SUN":
				new_longitude += 10;
				new_height += 2;
				if (new_height > 100)
					new_height = 100;
				break;
			case "RAIN":
				new_longitude += 5;
				break;
			case "FOG":
				new_longitude += 1;
				break;
			case "SNOW":
				new_height -= 12;
				if (new_height <= 0)
					new_height = 0;
					//landind
				break;
		}
		this.coordinates.updateCoordinates(new_longitude, this.coordinates.getLatitude(), new_height);
	}
}