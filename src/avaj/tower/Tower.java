package avaj.tower;

import avaj.flyable.Flyable;
import avaj.utils.Print;

import java.util.ArrayList;
import java.util.List;

public class Tower {

	private List<Flyable> observers = new ArrayList<>();

	public void register(Flyable p_flyable){
		observers.add(p_flyable);
		String infos = p_flyable.getInfos();
		Print.printToFile("Tower says: " + infos + " registered to weather tower.\n", "simulation.txt");
	}

	public void unregister(Flyable p_flyable){
		observers.remove(p_flyable);
		String infos = p_flyable.getInfos();
		Print.printToFile("Tower says: " + infos + " unregistered from weather tower.\n", "simulation.txt");
	}

	//testing
	public void printObservers(){
		for (Flyable flyable : observers){
			Print.print(flyable.getInfos());
		}
	}

	protected void conditionChanged(){  //update all flyables ? observer.updateConditions()

	}
}