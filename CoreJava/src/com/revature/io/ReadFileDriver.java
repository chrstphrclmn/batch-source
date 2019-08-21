package com.revature.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {

//	- application should read the contents of a file "count.txt"
//	- count.txt should hold a number
//	- if it does not have a numeric value, the count should reset to 0
//	- if it does have a numeric value, the number should be read in, incremented and then rewritten to the file
//	- each consecutive execution of the program should increment the number again
	
	public static void main(String[] args) {
		String path = "src/com/revature/io/write_data.txt";
		try(FileReader fileReader = new FileReader(path); BufferedReader bR = new BufferedReader(fileReader)){
			String line = bR.readLine();
			while(line != null) {
				System.out.println(line);
				line = bR.readLine();
			}
		}catch (IOException io) {
			io.printStackTrace();
		}
		
	}
}
