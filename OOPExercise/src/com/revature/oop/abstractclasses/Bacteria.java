package com.revature.oop.abstractclasses;

import com.revature.oop.interfaces.Creature;

public abstract class Bacteria implements Creature {

	public abstract void absorption();
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
