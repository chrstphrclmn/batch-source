package com.revature.shapes;

public abstract class Shape implements Drawable {

	private int numSides;

	public Shape() {
		super();
	}

	public int getNumSides() {
		return numSides;
	}

	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}

}
