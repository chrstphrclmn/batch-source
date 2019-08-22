/*
 * Abstract class to define well type
 * each well will have a drill permission, market factor, 
 * base value (can be based on lot of different factors) and 
 * an extraction efficiency
 */

package well;

import com.revature.exceptions.NegativeSidesException;
 

public abstract class WellType implements CalculateValue {
	
	private boolean drillPermission;
	
	private double marketFactor;
	
	private int baseVal;
	
	private double efficiency;
	
	
//	getter and setter methods for variables
	
	
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

//	
	public void setMarketFactor(double d) {
		if(d < 0) {
//			exception thrown if market factor is set to negative  
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
	
	
	

	
}
