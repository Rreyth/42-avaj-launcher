package avaj;

import avaj.utils.*;
import avaj.tower.*;
import avaj.flyable.*;
import avaj.generators.*;

import java.io.File;
import java.io.FileOutputStream;

public class Simulator {
	private static int loop = 0;
	private static AircraftFactory factory = AircraftFactory.getInstance();
	private static WeatherTower weatherTower = new WeatherTower();

	public static void main(String[] args) {
		if (args.length == 1) {
			if (!createFile("simulation.txt")) {
				return;
			}
			loop = Parser.parseFile(args[0], factory, weatherTower);
			if (loop == -1) {
				new File("simulation.txt").delete();
				return;
			}
			simulate();
		}
		else {
			Print.print("Usage: java avaj.Simulator scenario.txt");
		}
	}

	private static void simulate() {
		for (int i = 0; i < loop; i++) {
			weatherTower.changeWeather();
		}
	}

	private static Boolean createFile(String name) {
		try (FileOutputStream fos = new FileOutputStream("simulation.txt", false)) {
		}
		catch (Exception e) {
			Print.printErr("Error creating file: " + e.getMessage());
			return false;
		}
		return true;
	}
}

// $cat -e simulation.txt
// Tower says: Baloon#B1(1) registered to weather tower.
// Tower says: JetPlane#J1(2) registered to weather tower.
// Tower says: Helicopter#H1(3) registered to weather tower.
// Tower says: Helicopter#H4(4) registered to weather tower.
// Baloon#B1(1): Let's enjoy the good weather and take some pics.
// JetPlane#J1(2): It's raining. Better watch out for lightings.
// Helicopter#H1(3): This is hot.
// Helicopter#H4(4): My rotor is going to freeze!
// Baloon#B1(1): Damn you rain! You messed up my baloon.
// JetPlane#J1(2): OMG! Winter is coming!
// Helicopter#H1(3): This is hot.
// Helicopter#H4(4): My rotor is going to freeze!
// Baloon#B1(1): It's snowing. We're gonna crash.
// JetPlane#J1(2): It's raining. Better watch out for lightings.
// Helicopter#H1(3): This is hot.
// Helicopter#H4(4): My rotor is going to freeze!
// Baloon#B1(1): Damn you rain! You messed up my baloon.
// Baloon#B1(1) landing.
// Tower says: Baloon#B1(1) unregistered from weather tower.
// JetPlane#J1(2): OMG! Winter is coming!
// Helicopter#H1(3): This is hot.
// Helicopter#H4(4): My rotor is going to freeze!