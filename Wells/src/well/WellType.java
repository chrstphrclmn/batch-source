package well;

import com.revature.exceptions.NegativeSidesException;
 

public abstract class WellType implements CalculateValue {
	
	private boolean drillPermission;
	
	private double marketFactor;
	
	private int baseVal;
	
	private double efficiency;
	
	
	
	public double getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}

	public int getBaseVal() {
		return baseVal;
	}

	public void setBaseVal(int baseVal) {
		this.baseVal = baseVal;
	}

	public void setMarketFactor(double d) {
		if(d < 0) {
			throw new NegativeSidesException("Market value cannot be negative");
		}else {
			this.marketFactor = d;
		}
	}
	
	
	
	public double getMarketFactor() {
		return marketFactor;
	}
	
	
	public void setPermission(boolean ourBool) {
		this.drillPermission = ourBool;
	}

	
	public boolean getPermission() {
		return drillPermission;
	}
	
	public void drilling() {
		System.out.println("Drilling a well");
	}
	

	
}
