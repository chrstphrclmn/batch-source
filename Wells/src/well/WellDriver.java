package well;

public class WellDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OilWell O1 = new OilWell();
		O1.setPermission(true);
		O1.setMarketFactor(2.2);
		O1.drilling();
		O1.setEfficiency(0.6);
		System.out.println(O1.hashCode());
		
		OilWell O2 = new OilWell();
		O2.setMarketFactor(2.2);
		System.out.println(O2.hashCode());
		
		
		OilWell O3 = O1;
		System.out.println(O3.equals(O1));
		System.out.println(O3.hashCode());
		
		String aString = "10";
		System.out.println(Integer.parseInt(aString));

	}

}
