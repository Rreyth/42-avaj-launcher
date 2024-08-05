package avaj.utils;

import java.io.FileWriter;
import java.io.IOException;

public class Print {
	public static void print(Object p_message) {
		System.out.println(p_message);
	}

	public static void printErr(Object p_message) {
		System.err.println(p_message);
	}

	public static void printToFile(String p_message, String path) {
		try (FileWriter writer = new FileWriter(path)) {
			writer.write(p_message);
		}
		catch (IOException e) { //replace with own exceptions
			printErr("Error writing to file: " + e.getMessage());
		}
	}
}