/* Example of Inheritance
 * defined an Oil Well that inherits from a "general" well type.
 * Similarly for other types of wells
 */

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
	
/*	Polymorphism is demonstrated here. Overloading "calculatedValue" method. 
*	We just get a different baseVal of the well and now we have a different
*	value of the well
*/
	
	public double calculatedValue(int changedBaseVal) {
		setBaseVal(changedBaseVal);
		return  this.getMarketFactor() * this.getBaseVal() * this.getEfficiency();
	}
	
	
	
	
}
