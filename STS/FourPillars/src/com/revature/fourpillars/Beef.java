package com.revature.fourpillars;


//Beef inherits from food.
public class Beef extends Food {
	
	String rotBeef = "The beef rots.";
	
	//We are overriding the parent version of this method, part of Polymorphism.
	public void feedSomeone() {
		System.out.println("The food is being eaten....with BBQ sauce");
	}

	@Override
	public void rotSomewhere() {
		System.out.println(rotBeef);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((rotBeef == null) ? 0 : rotBeef.hashCode());
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
		Beef other = (Beef) obj;
		if (rotBeef == null) {
			if (other.rotBeef != null)
				return false;
		} else if (!rotBeef.equals(other.rotBeef))
			return false;
		return true;
	}
	
	

}
