package well;

public class WellDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OilWell o1 = new OilWell();
		o1.setPermission(true);
		o1.setMarketFactor(2.2);
		o1.setEfficiency(0.6);
		
//		hashcode for Oilwell o1
		System.out.println(o1.hashCode());
		
		OilWell o2 = new OilWell();
		o2.setMarketFactor(2.2);
//		hashcode for o2. It will be different from that of o1
		System.out.println(o2.hashCode());
		
//		hashcode for o3 will be similar to that of o1
		OilWell o3 = o1;
//		.equals will also return true
		System.out.println(o3.equals(o1));
		
		System.out.println(o3.hashCode());
	
		GasWell g1 = new GasWell();
		g1.setPermission(false);
		GasWell g2 = g1;
		
//		they have similar hashcodes
		System.out.println(g2.hashCode());
		System.out.println(g1.hashCode());
		System.out.println(g2.equals(g1));
		
//		Water well
		
		WaterWell w1 = new WaterWell();
		
		WaterWell  w2 = new WaterWell();
		
//		they have different hashcodes
		System.out.println(w1.hashCode());
		System.out.println(w2.hashCode());
		System.out.println(w1.equals(w2));

//		Mixed Wells
		
		MixWell m1 = new MixWell();
		m1.setPermission(false);
		
		MixWell m2 = m1;
		
//		their hashcodes are similar because both are pointing to same obj in memory
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		System.out.println(m1.equals(m2));
		

	}

}
