package avaj;

import avaj.flyable.*;
import avaj.generators.*;
import avaj.utils.*;
import avaj.tower.*;


public class Simulator {
	public static void main(String[] args) {
		if (args.length == 1) {
			System.out.println(args[0]);
		} else {
			System.out.println("Usage: java avaj.Main scenario.txt");
		}

		AircraftFactory factory = AircraftFactory.getInstance();
		Flyable test = factory.newAircraft("Baloon", "Test", 1, 2, 3);
		System.out.println(test);
		// Print.print(test)
	}
}