package com.revature.oop.abstractclasses;

import com.revature.oop.interfaces.Creature;

public abstract class Plant implements Creature{

	public abstract void synthesize();
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
