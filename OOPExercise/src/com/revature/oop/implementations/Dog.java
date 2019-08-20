package com.revature.oop.implementations;

import java.util.Objects;

import com.revature.oop.abstractclasses.Canine;

public class Dog extends Canine{

	public Dog() {}
	public Dog(String name, int ageInHumanYears) {
		this.setAgeInHumanYears(ageInHumanYears);
		this.setName(name);
	}

	
	@Override
	public String toString() {
		return "Dog [getName()=" + getName() + ", getAge()=" + getAgeInHumanYears() + "]";
	}
	@Override
	public void eat() {
		System.out.println("The dog eats dog food");
	}

	@Override
	public void run() {
		System.out.println("The dog runs");
	}

	@Override
	public void rest() {
		System.out.println("The dog is resting in the bed");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
        if (!(obj instanceof Dog)) {
            return false;
        }
        Dog dog = (Dog) obj;
        return this.getAgeInAnimalYears() == dog.getAgeInAnimalYears() 
				&& this.getAgeInHumanYears() == dog.getAgeInAnimalYears()
				&& this.getName().equals(dog.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getName(), this.getAgeInHumanYears(), this.getAgeInAnimalYears());
	}
	@Override
	public void calculateAgeInAnimalYears() {
		if(this.getAgeInHumanYears() <= 15) {
			System.out.println(1);
		}else if(this.getAgeInHumanYears() > 15 && this.getAgeInHumanYears() < 24) {
			System.out.println(2);
		}else {
			System.out.println(5*this.getAgeInHumanYears() + 2);
		}
		
	}


}
