package main;

public class Engine extends CarPart{
	
	public boolean state;
	
	public Engine() {
		
		this.condition = 100;
		this.state = true;
	}

	public void status() {
		
		System.out.printf("Simulating Engine: Condition %3d | On: %s\n", this.condition, Boolean.toString(this.state));
	}
	
	public void function() {
		
		if(this.condition == 1) this.state = false;
		this.condition --;
	}
}
