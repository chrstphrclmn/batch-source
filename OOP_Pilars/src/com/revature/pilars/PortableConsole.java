package com.revature.pilars;

public class PortableConsole extends Device {//Inheritance PortableConsole Inherit Device
	
	public PortableConsole(boolean on_off, boolean wifi, double batteryLife, String brand, int volume) {
		super(on_off, wifi, batteryLife, brand, volume);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gameRuning == null) ? 0 : gameRuning.hashCode());
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
		PortableConsole other = (PortableConsole) obj;
		if (gameRuning == null) {
			if (other.gameRuning != null)
				return false;
		} else if (!gameRuning.equals(other.gameRuning))
			return false;
		return true;
	}

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
	
	
	// Dynamic polymorphism
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
