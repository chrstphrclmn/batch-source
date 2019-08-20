package com.revature.abstraction;

public interface InterfaceA {
	
	public static final int MY_INT = 6;
	
	void doSomething();
	
	default void doSomethingElse() {
		System.out.println("InterfaceA is doing something else");
	}

}
