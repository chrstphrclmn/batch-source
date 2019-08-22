package com.revature.pilars;

import javax.management.RuntimeErrorException;

public class Speaker extends Device {//Inheritance speaker Inherit device
	
	
	
	public Speaker(boolean on_off, boolean wifi, double batteryLife, String brand, int volume) {
		super(on_off, wifi, batteryLife, brand, volume);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bassLevel;
		result = prime * result + middleLevel;
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
		Speaker other = (Speaker) obj;
		if (bassLevel != other.bassLevel)
			return false;
		if (middleLevel != other.middleLevel)
			return false;
		return true;
	}

	public Speaker() {
		super();
	}
	
	public Speaker(int bassLevel, int middleLevel) { //Static Polymorphism 
		
		this.bassLevel = bassLevel;
		this.middleLevel = middleLevel; 
		
	}
	
	
	private int bassLevel;
	private int middleLevel;
	
	
	public int getBassLevel() {
		return bassLevel;
	}
	
	public void setBassLevel(int bassLevel) {
		this.bassLevel=bassLevel;
	}
	
	
	public int getMiddleLevel() {
		
		return middleLevel;
	}
	
	public void setMiddleLevel(int middleLevel) {
		
		this.middleLevel=middleLevel;
	}
	
	
	

	@Override
	public void using() {
		System.out.println("Speaker"+Speaker.super.getBrand()+"is running");
		
	}

	@Override
	public void turnOn() {
		System.out.println("Turning on"+Speaker.super.getBrand()+"speaker");
		
	}

	@Override
	public void turnOf() {
		System.out.println("Turning off"+Speaker.super.getBrand()+"speaker");
		
	}

	@Override
	public void volumeUp() {
		int v = Speaker.super.getVolume();
		v=v++;	
		Speaker.super.setVolume(v);
		
		System.out.println("Volume: "+Speaker.super.getVolume());
		
	}

	@Override
	public void volumeDown() {
		int v = Speaker.super.getVolume();
		v=v--;	
		Speaker.super.setVolume(v);
		
		System.out.println("Volume: "+Speaker.super.getVolume());
	}

	@Override
	public void takePhoto() {
		throw new IllegalArgumentException("Speaker cannot take photos");
	}

	@Override
	public void connect() {
		System.out.println("Speaker is connected");
		
	}

	@Override
	public void charging() {
		System.out.println("Speaker is charging");
		
	}
}
