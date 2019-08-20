package com.revature.oop.main;

import com.revature.oop.abstractclasses.*;
import com.revature.oop.abstractclasses.Aves;
import com.revature.oop.implementations.*;

public class Main {

	public static void main(String[] args) {
		Animal parrotAnimal = new Parrot("Polly", 3);
		Animal dogAnimal = new Dog("Ruffy", 4);
		parrotAnimal.eat();
		parrotAnimal.type();
		System.out.println(parrotAnimal);
		
		dogAnimal.eat();
		dogAnimal.type();
		System.out.println(dogAnimal);
		
		((Aves)parrotAnimal).fly();
		((Canine)dogAnimal).run();
		
		((Aves)parrotAnimal).calculateAgeInAnimalYears();;
		((Canine)dogAnimal).calculateAgeInAnimalYears();;
		
		parrotAnimal.setName(null);
	}

}
