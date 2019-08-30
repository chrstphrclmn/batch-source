package main;

public class Application {

	public static void main(String[] args) {
		
		Runner x = new Runner();
		try {
			x.run();
		}
		catch(CustomException e){
			System.out.println("Exception Caught.");
		}
	}
}
