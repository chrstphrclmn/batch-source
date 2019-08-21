package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

//	- application should read the contents of a file "count.txt"
//	- count.txt should hold a number
//	- if it does not have a numeric value, the count should reset to 0
//	- if it does have a numeric value, the number should be read in, incremented and then rewritten to the file
//	- each consecutive execution of the program should increment the number again

//	-?     --> negative sign, could have none or one
//	\\d+   --> one or more digits
	private static String regex = "\\d+";
	private static int count;

	public static void main(String[] args) {
		System.out.println("9".matches(regex));
		String path = "src/com/revature/io/count.txt";
		try (FileReader fileReader = new FileReader(path); BufferedReader bR = new BufferedReader(fileReader)) {

			String line = bR.readLine();

			Boolean numberExists = false;
			System.out.println(line);
			while (line != null) {
				numberExists = numberExists(line);
				line = bR.readLine();
			}
			if (numberExists) {
				count++;
			} else {
				count = 0;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}

		try (FileWriter fileWriter = new FileWriter(path); BufferedWriter bF = new BufferedWriter(fileWriter);) {
			bF.append("Count is " + count);
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	private static Boolean numberExists(String line) {
		String[] content = line.split(" ");
		for (String s : content) {
			if (s.matches(regex)) {
				System.out.println(s);
				count = Integer.parseInt(s);
				return true;
			}
		}
		return false;
	}
}
