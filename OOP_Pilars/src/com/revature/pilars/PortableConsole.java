package com.revature.pilars;

public class PortableConsole extends Device {
	
	private String gameRuning;
	
	public String getGameRunning() {
		
		return gameRuning;
		
	}
	
	public void setGameRunning(String gameRuning) {
		
		this.gameRuning=gameRuning;
	}
	
	public PortableConsole() {
		super();
	}

	@Override
	public void using() {
		
		System.out.println("Console"+PortableConsole.super.getBrand()+"is running");
		
	}

	@Override
	public void turnOn() {
		
		System.out.println("Turning on"+PortableConsole.super.getBrand()+"console");
		
	}

	@Override
	public void turnOf() {

		System.out.println("Turning off"+PortableConsole.super.getBrand()+"console");
		
	}

	@Override
	public void volumeUp() {
		int v = PortableConsole.super.getVolume();
		v=v++;	
		PortableConsole.super.setVolume(v);
		
		System.out.println("Volume: "+PortableConsole.super.getVolume());
		
	}

	@Override
	public void volumeDown() {
		
		int v = PortableConsole.super.getVolume();
		v=v--;	
		PortableConsole.super.setVolume(v);
	
		System.out.println("Volume: "+PortableConsole.super.getVolume());
		
	}

	@Override
	public void takePhoto() {
		
		System.out.println("click");
		
		
	}

	@Override
	public void connect() {
		
		System.out.println("Console is connected");
		
	}

	@Override
	public void charging() {
		
		System.out.println("Console is charging");
		
		
	}
}
