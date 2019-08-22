package well;

public class MixWell extends WellType  {

	public MixWell() {
		super();
		setMarketFactor(1.7);
		setPermission(true);
		setBaseVal(700);
	}

	@Override
	public double calculatedValue() {
		// TODO Auto-generated method stub
		return  this.getMarketFactor() * this.getBaseVal();

	}
	
}
