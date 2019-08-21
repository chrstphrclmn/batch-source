package com.revature.pilars;

public class LapTop extends Device {
	
	private String os; 
	
	public LapTop() {
		super();
	}
	
	public String getOs() {
		return os;
	}
	
	public void setOs(String os) {
		this.os=os;
	}

	@Override
	public void using() {
		System.out.println("Speaker"+LapTop.super.getBrand()+"is running");
		
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnOf() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takePhoto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void charging() {
		// TODO Auto-generated method stub
		
	}
	
	

}
