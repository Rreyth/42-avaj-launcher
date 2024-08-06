package avaj.flyable;

import avaj.flyable.Aircraft;
import avaj.generators.WeatherProvider;

public class JetPlane extends Aircraft {

	public JetPlane(long p_id, String p_name, int p_longitude, int p_latitude, int p_height) {
		super(p_id, p_name, p_longitude, p_latitude, p_height);
	}

	@Override
	public void updateConditions() {
		String weather = WeatherProvider.getInstance().getCurrentWeather(this.coordinates);
		int new_latitude = this.coordinates.getLatitude();
		int new_height = this.coordinates.getHeight();
		switch (weather) {
			case "SUN":
				new_latitude += 10;
				new_height += 2;
				if (new_height > 100)
					new_height = 100;
				//msg
				break;
			case "RAIN":
				new_latitude += 5;
				//msg
				break;
			case "FOG":
				new_latitude += 1;
				//msg
				break;
			case "SNOW":
				new_height -= 7;
				//msg
				if (new_height <= 0)
					new_height = 0;
					//msg landing
					//landing
				break;
		}
		this.coordinates.updateCoordinates(this.coordinates.getLongitude(), new_latitude, new_height);
	}
}