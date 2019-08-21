package com.revature.fourpillars;


//The Apple Class "Inherits" from the food class.
public class Apple extends Food {
	
	Integer bumps = this.getNumOfFoodItems();
	
	public Apple(int num) {
		super(num);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bumps == null) ? 0 : bumps.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		if (bumps == null) {
			if (other.bumps != null)
				return false;
		} else if (!bumps.equals(other.bumps))
			return false;
		return true;
	}

	public void fallDown() {
		
		
		
		System.out.println(bumps.toString()+" apples fall off the tree.");
	}

	@Override
	public void rotSomewhere() {
		System.out.println("The apple(s) rot on the ground.");
		
	}

}
