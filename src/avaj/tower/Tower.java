import java.util.ArrayList;
import java.util.List;

// import Flyable

public class Tower {

	private List<Flyable*> observers = new ArrayList<>();

	public void register(Flyable* p_flyable){ //add to list + print
		observers.add(p_flyable);
		String infos = "test";  // Baloon#B1(1) -> type, #name, (id) // getters dans Aircraft + type getter surcharger dans les sous classes
		System.out.println("Tower says: " + infos + " registered to weather tower.");
	}

	public void unregister(Flyable* p_flyable){ //rm from list + print
		// Tower says: Baloon#B1(1) unregistered from weather tower.
		observers.remove(p_flyable);
		String infos = "tqt";
		System.out.println("Tower says: " + infos + " unregistered from weather tower.");
	}

	protected void conditionChanged(){  //idk

	}
}