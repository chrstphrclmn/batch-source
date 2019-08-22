package well;

public class WaterWell extends WellType{
	
	public WaterWell() {
		super();
		setMarketFactor(1.4);
		setPermission(false);
		setBaseVal(450);
	}

	@Override
	public double calculatedValue() {
		// TODO Auto-generated method stub
		return  this.getMarketFactor() * this.getBaseVal();

	}
	
}
