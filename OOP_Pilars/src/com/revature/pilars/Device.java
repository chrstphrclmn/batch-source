package com.revature.pilars;

public abstract class Device implements Usable,Chargeable { // Device uses interfaces, abstraction;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(batteryLife);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + (on_off ? 1231 : 1237);
		result = prime * result + volume;
		result = prime * result + (wifi ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (Double.doubleToLongBits(batteryLife) != Double.doubleToLongBits(other.batteryLife))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (on_off != other.on_off)
			return false;
		if (volume != other.volume)
			return false;
		if (wifi != other.wifi)
			return false;
		return true;
	}

	private boolean on_off; //Encapsulation
	private boolean wifi;//Encapsulation
	private double batteryLife;//Encapsulation
	private String brand;//Encapsulation
	private int volume;//Encapsulation
	public Device() {
		
	}
	
	public Device(boolean on_off, boolean wifi, double batteryLife, String brand, int volume) {
		super();
		this.on_off = on_off;
		this.wifi = wifi;
		this.batteryLife = batteryLife;
		this.brand = brand;
		this.volume = volume;
	}

	public boolean getOn_off() {
		
		return on_off;
	}
	
	public boolean getWifi() {
		return wifi;
	}
	
	public double getBatteryLife() {
		return batteryLife;
	}
	
	public String getBrand() {
		return brand;
	}
	
	
	public void setOn_off(boolean on_off) {
		this.on_off=on_off;
	}
	
	public void setWifi(boolean wifi) {
		
		this.wifi=wifi;
		
	}
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume=volume;
	}
	
	public void setBatteryLife(double batteryLife) {
		
		this.batteryLife=batteryLife;
	}
	
	public void setBrand(String brand) {
		this.brand=brand;
	}
	

}
