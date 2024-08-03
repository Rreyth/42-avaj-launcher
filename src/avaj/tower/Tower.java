package avaj.tower;

import avaj.flyable.Flyable;
import avaj.utils.Print;

import java.util.ArrayList;
import java.util.List;

public class Tower {

	private List<Flyable*> observers = new ArrayList<>();

	public void register(Flyable* p_flyable){ //add to list + print
		observers.add(p_flyable);
		String infos = "test";  // Baloon#B1(1) -> type, #name, (id) // getters dans Aircraft + type getter surcharger dans les sous classes
		Print.print("Tower says: " + infos + " registered to weather tower.");
	}

	public void unregister(Flyable* p_flyable){ //rm from list + print
		// Tower says: Baloon#B1(1) unregistered from weather tower.
		observers.remove(p_flyable);
		String infos = "tqt";
		Print.print("Tower says: " + infos + " unregistered from weather tower.");
	}

	protected void conditionChanged(){  //idk

	}
}