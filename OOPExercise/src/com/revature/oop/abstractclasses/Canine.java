package com.revature.oop.abstractclasses;

import java.util.Objects;

public abstract class Canine extends Animal {

	public abstract void run();
	
	@Override
	public String toString() {
		return "Canine [getName()=" + getName() + ", getAge()=" + getAgeInHumanYears() + "]";
	}

	@Override
	public void type() {
		System.out.println("The animal type is canine");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
        if (!(obj instanceof Canine)) {
            return false;
        }
        Canine canine = (Canine) obj;
		return this.getAgeInAnimalYears() == canine.getAgeInAnimalYears() 
				&& this.getAgeInHumanYears() == canine.getAgeInAnimalYears()
				&& this.getName().equals(canine.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getName(), this.getAgeInHumanYears(), this.getAgeInAnimalYears());
	}
}
