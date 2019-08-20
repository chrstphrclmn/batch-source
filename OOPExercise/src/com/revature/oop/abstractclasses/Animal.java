package com.revature.oop.abstractclasses;

import java.util.Objects;

import com.revature.oop.exceptions.MyNullPointerException;
import com.revature.oop.interfaces.Creature;

public abstract class Animal implements Creature{

	//Encapsulation is used in the abstract class via private members and public getters and setters
	//Abstraction is used with method calculateAgeInAnimalYears - we supply the age of an animal to the
	//owner without them needing to know how the ages are calculated per animal
	//Polymorphism is used with the type method which is overridden in subclasses to behave differently based on the class
	//Inheritance is used by the classes extending this class and its subclasses, the fields here are inherited by the subclasses
	
	private String name;
	private int ageInHumanYears;
	private int ageInAnimalYears;
	
	public Animal() {}
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + ageInHumanYears + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null) {
			throw new MyNullPointerException("My null pointer");
		}
		this.name = name;
	}
	
	
	public int getAgeInHumanYears() {
		return ageInHumanYears;
	}

	public void setAgeInHumanYears(int ageInHumanYears) {
		this.ageInHumanYears = ageInHumanYears;
	}

	public int getAgeInAnimalYears() {
		return ageInAnimalYears;
	}

	public abstract void calculateAgeInAnimalYears();
	
	public void type() {
		System.out.println("The animal type is not specified");
	} 
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
        if (!(obj instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) obj;
		return this.ageInHumanYears == animal.ageInHumanYears && this.name.equals(animal.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, ageInHumanYears);
	}
}
