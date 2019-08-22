package com.revature.pilars;

public class LapTop extends Device {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((os == null) ? 0 : os.hashCode());
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
		LapTop other = (LapTop) obj;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		return true;
	}

	private String os; 
	
	public LapTop() {
		super();
	}
	
	public LapTop(boolean on_off, boolean wifi, double batteryLife, String brand, int volume) {
		super(on_off, wifi, batteryLife, brand, volume);
		
	}

	public LapTop(String os) {
		super();
		this.os = os;
	}

	public String getOs() {
		return os;
	}
	
	public void setOs(String os) {
		this.os=os;
	}
	
	//Dynamic polymorphism
	
	@Override
	public void using() {
		System.out.println("Laptop"+LapTop.super.getBrand()+"is running");
		
	}

	@Override
	public void turnOn() {
		System.out.println("Turning on"+LapTop.super.getBrand()+"laptop");
		
	}

	@Override
	public void turnOf() {
		System.out.println("Turning off"+LapTop.super.getBrand()+"laptop");
		
	}

	@Override
	public void volumeUp() {

		int v = LapTop.super.getVolume();
		v=v++;	
		LapTop.super.setVolume(v);
		
		System.out.println("Volume: "+LapTop.super.getVolume());
		
	}

	@Override
	public void volumeDown() {
		int v = LapTop.super.getVolume();
		v=v--;	
		LapTop.super.setVolume(v);
		
		System.out.println("Volume: "+LapTop.super.getVolume());
	}

	@Override
	public void takePhoto() {
		
		System.out.println("click");
		
	}

	@Override
	public void connect() {
		System.out.println("CellPhone is connected");
	}

	@Override
	public void charging() {
		System.out.println("CellPhone is charging");
		
	}
	
	

}
