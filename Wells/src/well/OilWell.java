package well;

public class OilWell extends WellType {
	
	public OilWell() {
		super();
		setPermission(true);
		setBaseVal(1000);
	}

	@Override
	public double calculatedValue() {
		// TODO Auto-generated method stub
		return  this.getMarketFactor() * this.getBaseVal() * this.getEfficiency();
	}
	
//	Overloading "calculatedValue" method. It just changes the baseval of the well
	
	public double calculatedValue(int changedBaseVal) {
		setBaseVal(changedBaseVal);
		return  this.getMarketFactor() * this.getBaseVal() * this.getEfficiency();
	}
	
	
	
	
}
