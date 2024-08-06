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
			Print.print("Simulation complete");
			Print.print("Output written to simulation.txt");
		}
		else {
			Print.printErr("Error: Invalid number of arguments");
			Print.printErr("Usage: java -cp src avaj.Simulator <scenario file>");
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
