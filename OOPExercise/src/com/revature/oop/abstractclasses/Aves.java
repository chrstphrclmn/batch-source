package com.revature.oop.abstractclasses;

import java.util.Objects;

public abstract class Aves extends Animal {

	public abstract void fly();

	@Override
	public String toString() {
		return "Bird [getName()=" + getName() + ", getAge()=" + getAgeInHumanYears() + "]";
	}

	@Override
	public void type() {
		System.out.println("The animal type is aves");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Aves)) {
			return false;
		}
		Aves bird = (Aves) obj;
		return this.getAgeInHumanYears() == bird.getAgeInHumanYears()
				&& this.getAgeInAnimalYears() == bird.getAgeInAnimalYears()
				&& this.getName().equals(bird.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getName(), this.getAgeInHumanYears(), this.getAgeInAnimalYears());
	}
}
