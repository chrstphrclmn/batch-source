package com.revature.pilars;

public abstract class Device implements Usable,Chargeable {
	
	private boolean on_off;
	private boolean wifi;
	private double batteryLife;
	private String brand;
	private int volume;
	public Device() {
		
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
