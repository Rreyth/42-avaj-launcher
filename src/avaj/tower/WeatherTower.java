// import Tower
// import Coordinates
// import WeatherProvider

public class WeatherTower extends Tower {

	public String getWeather(Coordinates p_coordinates){
		return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
	}

	public void changeWeather(){
		
	}
}