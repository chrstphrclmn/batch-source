package com.revature.shapes;

public class Rectangle extends Shape implements Drawable, Calculatable {

	private int height;
	private int width;

	public Rectangle() {
		super();
		setNumSides(4);
	}

	public Rectangle(int height, int width) {
		super();
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
	public void Draw() {
		System.out.println("Drawing a rectangle");

	}

	@Override
	public int calculateArea() {
		// TODO Auto-generated method stub
		return width*height;
	}

	@Override
	public int calculatePerimeter() {
		// TODO Auto-generated method stub
		return 2*(width + height);
	}

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}

}
