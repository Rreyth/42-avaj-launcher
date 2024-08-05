package avaj.flyable;

import avaj.flyable.Flyable;
import avaj.flyable.Coordinates;

public class Aircraft extends Flyable {

	protected long id;
	protected String name;
	protected Coordinates coordinates;

	public Aircraft(long p_id, String p_name, int p_longitude, int p_latitude, int p_height){
		this.id = p_id;
		this.name = p_name;
		this.coordinates = new Coordinates(p_longitude, p_latitude, p_height);
	}

	@Override
	public void updateConditions(){
	}

	@Override
	public String getInfos() {
		return this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")";
	}
}