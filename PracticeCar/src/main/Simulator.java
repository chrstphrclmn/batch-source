package main;

public class Simulator {

	public static void main(String[] args) {
		
		Car c = new Car();
		
		for (int i = 0 ; i < 15 ; i++) {
			
			c.run();
		}
	}
}
