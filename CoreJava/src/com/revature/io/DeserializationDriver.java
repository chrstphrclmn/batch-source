package com.revature.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDriver {

	public static void main(String[] args) {
		String path = "src/com/revature/io/person_data.txt";
		try(FileInputStream inputStream = new FileInputStream(path);
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){
			Person person = (Person)objectInputStream.readObject();
			System.out.println(person);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
