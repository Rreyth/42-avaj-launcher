package avaj.flyable;

import avaj.tower.WeatherTower;

public abstract class Flyable {

	protected WeatherTower weatherTower;

	public abstract void updateConditions();

	public registerTower(WeatherTower* p_tower) {
		this.weatherTower = p_tower;
	}
}