package com.revature.pilars;
/*Create a Java Project which incorporates the 4 pillars of OOP
Create a hierarchy with classes representing different entities, including at least 4 classes (concrete or abstract) and at least one interface
Organize your classes into an appropriate package structure
Follow the appropriate naming conventions for the project, classes, and class members
Comment liberally to explain where and how each pillar of OOP is implemented in your code, include each of the mentioned examples for polymorphism and abstraction
Implement a custom exception 
Implement equals and hashcode method for each class 
Push this project to your github branch 

Upload to your GitHub branch by 22 August (Thursday) by 9am
*/

public class Aplication extends IllegalArgumentException{
	
	
	
	public static void main(String[] args) {
		
		CellPhone samsung = new CellPhone("At&t", false, false,0.0,"samsung",50);
		
		samsung.charging();
		samsung.turnOn();
		samsung.volumeUp();
		
		
		LapTop msi = new LapTop("Wndows10");
		Speaker bose = new Speaker();
		
		try {
			bose.takePhoto();
			
		}catch(Exception e){
			
		}
		
		PortableConsole psp = new PortableConsole();
		
		
		
	}
	
	
	
	
	
	

}
