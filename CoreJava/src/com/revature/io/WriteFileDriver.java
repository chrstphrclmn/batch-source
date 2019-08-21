package com.revature.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {


	public static void main(String[] args) {
		String path = "src/com/revature/io/write_data.txt";
		try(FileWriter fileWriter = new FileWriter(path, true); BufferedWriter bF = new BufferedWriter(fileWriter)){
			bF.append("\n Hello World");
			System.out.println("Our file has been written to");
		}catch (IOException io) {
			io.printStackTrace();
		}
	}
}
