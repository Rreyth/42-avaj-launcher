package avaj;

import avaj.flyable.*;
import avaj.generators.*;
import avaj.utils.*;
import avaj.tower.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
	private static int loop = 0;
	private static AircraftFactory factory = AircraftFactory.getInstance();
	private static WeatherTower weatherTower = new WeatherTower();

	public static void main(String[] args) {
		if (args.length == 1) {
			Simulator.parser(args[0]);
			// Simulator.simulate();
		}
		else { //exception
			System.out.println("Usage: java avaj.Simulator scenario.txt");
		}
	}

	private static void parser(String path) {
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line = reader.readLine();
			// Simulator.lineVerifier(line);
			Simulator.loop = Integer.parseInt(line);
			line = reader.readLine();
			while (line != null) {
				// Print.print(line);
				// Simulator.lineVerifier(line);
				String[] parts = line.split(" ");
				Flyable aircraft = Simulator.factory.newAircraft(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
				aircraft.registerTower(Simulator.weatherTower);
				line = reader.readLine();
			}
		}		
		catch (IOException e) { // replace with own exceptions
			Print.printErr("Error parsing file: " + e.getMessage());
			//exit ?
		}
	}

	private static void lineVerifier(String line) {
		// check if line is valid
		// if not, throw exception
	}

	private static void simulate() {
		// simulation loop
		// save in string

		// end: save to file
		// this.saveToFile("");
	}

	private static void saveToFile(String save) {
		// create file or open and rewrite
		// Print.printToFile(save, filepath);
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