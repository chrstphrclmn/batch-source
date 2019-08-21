package com.revature.shapes;

public class Rectangle extends Shape {
	
	private int height;
	private int width;
	
	public Rectangle() {
		super();
		setNumOfSides(4);
	}
	
	// constructor overloading - overloading is considered compile time or static polymorphism
	public Rectangle(int height, int width) {
		this();
		this.height = height;
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void draw() {
		System.out.println("Drawing a rectangle");
	}
	

	@Override
	public int calculateArea() {
		return width*height;
	}

	@Override
	public int calculatePerimeter() {
		return 2*(width+height);
	}

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}

	
}
