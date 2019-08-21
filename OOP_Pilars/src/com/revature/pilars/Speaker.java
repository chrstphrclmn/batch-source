package com.revature.pilars;

public class Speaker extends Device {
	
	
	
	public Speaker() {
		super();
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
		System.out.println("Speaker cannot take photo");
		
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
