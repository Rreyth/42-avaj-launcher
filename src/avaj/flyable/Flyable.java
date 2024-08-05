package avaj.flyable;

import avaj.tower.WeatherTower;

public abstract class Flyable {

	protected WeatherTower weatherTower;

	public abstract void updateConditions();
	public abstract String getInfos();

	public void registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
		this.weatherTower.register(this);
	}
}