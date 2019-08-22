package com.revature.pilars;

public class CellPhone extends LapTop { //Inheritance CellPhone Inherit Laptop
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((serviceProvider == null) ? 0 : serviceProvider.hashCode());
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
		CellPhone other = (CellPhone) obj;
		if (serviceProvider == null) {
			if (other.serviceProvider != null)
				return false;
		} else if (!serviceProvider.equals(other.serviceProvider))
			return false;
		return true;
	}

	private String serviceProvider; //Encapsulation
	
	public CellPhone() {
		super();
	}
	
	
	
	public CellPhone(String serviceProvider) {
		super();
		this.serviceProvider = serviceProvider;
	}
	
	

	public CellPhone(boolean on_off, boolean wifi, double batteryLife, String brand, int volume) {
		super(on_off, wifi, batteryLife, brand, volume);
		
	}
	
	public CellPhone(String serviceProvider, boolean on_off, boolean wifi, double batteryLife, String brand, int volume) {
		super(on_off, wifi, batteryLife, brand, volume);
		this.serviceProvider = serviceProvider;
	}
	
	
	

	public String getServiceProvider() {
		
		return serviceProvider;
	}
	
	public void setServiceProvider(String serviceProvider) {
		
		this.serviceProvider=serviceProvider;
	}
	
	
	public void turnOn() {
		System.out.println("Turning on"+CellPhone.super.getBrand()+"  cellPhone");
		
	}
	
	public void volumeUp() {
		int v = CellPhone.super.getVolume();
		v=v++;	
		CellPhone.super.setVolume(v);
		
		System.out.println("Volume: "+CellPhone.super.getVolume());
	}
	
	public void volumeDown() {
		int v = CellPhone.super.getVolume();
		v=v--;	
		CellPhone.super.setVolume(v);
		
		System.out.println("Volume: "+CellPhone.super.getVolume());
	}
	

}
