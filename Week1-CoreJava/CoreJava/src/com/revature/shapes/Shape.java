package com.revature.shapes;

import com.revature.exceptions.NegativeSidesException;

public abstract class Shape implements Drawable, Calculatable {
	
	private int numOfSides;
	
	public Shape() {
		super();
	}
	
	public int getNumOfSides() {
		return numOfSides;
	}
	
	public void setNumOfSides(int numOfSides) {
		if(numOfSides<0) {
			throw new NegativeSidesException("cannot set num of sides to "+numOfSides);
		} else {
			this.numOfSides = numOfSides;			
		}
	}

}
