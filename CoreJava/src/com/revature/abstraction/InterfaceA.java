package com.revature.abstraction;

public interface InterfaceA {

	void doSomething();
	
	default void doSomethingElse() {
		System.out.println("InterfaceA do something else");
	}
}
