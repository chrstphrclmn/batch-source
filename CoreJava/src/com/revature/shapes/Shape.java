package com.revature.shapes;

import com.revature.exceptions.NegativeSidesException;

public abstract class Shape implements Drawable {

	private int numSides;

	public Shape() {
		super();
	}

	public int getNumSides() {
		return numSides;
	}

	public void setNumSides(int numSides) throws NegativeSidesException {
		if(numSides < 0) {
			throw new NegativeSidesException();
		}
		this.numSides = numSides;
	}

}
