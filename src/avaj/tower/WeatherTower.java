package avaj.tower;

import avaj.tower.Tower;
import avaj.flyable.Coordinates;
import avaj.generators.WeatherProvider;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates p_coordinates){
		return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
	}

	public void changeWeather(){ //call conditionChanged() from Tower
		
	}
}