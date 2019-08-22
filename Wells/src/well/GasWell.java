package well;

public class GasWell extends WellType  {
	
	public GasWell() {
		super();
		setMarketFactor(1.8);
		setPermission(true);
		setBaseVal(850);
	}

	@Override
	public double calculatedValue() {
		// TODO Auto-generated method stub
		return  this.getMarketFactor() * this.getBaseVal();

	}
	
}
