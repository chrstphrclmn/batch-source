package com.revature.oop.implementations;

import java.util.Objects;

import com.revature.oop.abstractclasses.Aves;

public class Parrot extends Aves{

	public Parrot() {}
	public Parrot(String name, int ageInHumanYears) {
		this.setName(name);
		this.setAgeInHumanYears(ageInHumanYears);
	}

	
	@Override
	public String toString() {
		return "Parrot [getName()=" + getName() + ", getAge()=" + getAgeInHumanYears() + "]";
	}
	@Override
	public void eat() {
		System.out.println("The bird eats bird food");
	}

	@Override
	public void fly() {
		System.out.println("The bird is flying");
	}

	@Override
	public void rest() {
		System.out.println("The bird is resting on a perch");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
        if (!(obj instanceof Parrot)) {
            return false;
        }
        Parrot parrot = (Parrot) obj;
        return this.getAgeInAnimalYears() == parrot.getAgeInAnimalYears() 
				&& this.getAgeInHumanYears() == parrot.getAgeInAnimalYears()
				&& this.getName().equals(parrot.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getName(), this.getAgeInHumanYears(), this.getAgeInAnimalYears());
	}
	@Override
	public void calculateAgeInAnimalYears() {
		System.out.println(4 + (this.getAgeInHumanYears() * 2 - 2)) ;
	}
}
