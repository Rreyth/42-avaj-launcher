package avaj.utils;

import avaj.utils.Print;
import avaj.flyable.Flyable;
import avaj.tower.WeatherTower;
import avaj.utils.AvajException;
import avaj.generators.AircraftFactory;

import java.util.List;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;

public class Parser {
	private static List<Flyable> aircrafts = new ArrayList<>();

	public static int parseFile(String path, AircraftFactory factory, WeatherTower weatherTower) {
		int loop = 0;
		int nb = 1;
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line = reader.readLine();
			lineVerifier(line, nb);
			nb++;
			loop = Integer.parseInt(line);
			line = reader.readLine();
			while (line != null) {
				lineVerifier(line, nb);
				String[] parts = line.split(" ");
				aircrafts.add(factory.newAircraft(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
				line = reader.readLine();
				nb++;
			}
		}		
		catch (Exception e) {
			Print.printErr("Error parsing file:\n" + e.getMessage());
			return -1;
		}

		for (Flyable aircraft : aircrafts) {
			aircraft.registerTower(weatherTower);
		}

		return loop;
	}

	public static void lineVerifier(String line, int nb) throws AvajException {
		if (nb == 1 && !isPositiveInt(line)) {
			throw new AvajException("Error in line " + nb + ": First line must be a positive integer (number of simulation loops)");
		}
		else if (nb != 1) {
			String[] parts = line.split(" ");
			if (parts.length != 5) {
				throw new AvajException("Error in line " + nb + ": Line must contain 5 parts");
			}
			if (!validType(parts[0])) {
				throw new AvajException("Error in line " + nb + ": Invalid aircraft type");
			}
			if (!isPositiveInt(parts[2]) || !isPositiveInt(parts[3]) || !isPositiveInt(parts[4])) {
				throw new AvajException("Error in line " + nb + ": Coordinates must be positive integers");
			}
			if (Integer.parseInt(parts[4]) > 100) {
				throw new AvajException("Error in line " + nb + ": Height must be less or equal to 100");
			}
		}
	}

	public static Boolean validType(String type) {
		if (type.equals("Baloon") || type.equals("JetPlane") || type.equals("Helicopter")) {
			return true;
		}
		return false;
	}

	public static Boolean isPositiveInt(String str) {
		try {
			int num = Integer.parseInt(str);
			if (num < 0) {
				return false;
			}
		}
		catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}