package com.revature;

import java.util.Comparator;

public class Product implements Comparable<Product>{

	private int productId;
	private int quantity;
	private double price;
	
	private Comparator<Product> comparator;
	
	public Product() {
		
		super();
		this.comparator = (p1, p2) -> {return p1.getProductId() - p2.getProductId();};
	}
	
	public Product(int productId, int quantity, double price) {
		
		this();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productId;
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productId != other.productId)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Id: " + productId + ", quantity: " + quantity + ", price: " + price + "]";
	}

	@Override
	public int compareTo(Product p) {
		
		return this.comparator.compare(this, p);
	}
	
}
