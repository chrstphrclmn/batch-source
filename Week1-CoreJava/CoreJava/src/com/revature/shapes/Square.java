package com.revature.shapes;

public class Square extends Rectangle {
	
	public Square() {
		super();
	}
	
	public Square(int sideLength) {
		super(sideLength, sideLength);
//		setHeight(sideLength);
//		setWidth(sideLength);
	}
	
	public void setHeight(int height) {
		super.setHeight(height);
		super.setWidth(height);
	}
	
	public void setWidth(int width) {
		super.setHeight(width);
		super.setWidth(width);
	}

	// overriding this method is considered dynamic or runtime polymorphism
	@Override
	public String toString() {
		return "Square [ height=" + getHeight() + ", width=" + getWidth() + "]";
	}
	
	

}
