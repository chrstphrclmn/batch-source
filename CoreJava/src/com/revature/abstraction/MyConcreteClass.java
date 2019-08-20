package com.revature.abstraction;

public class MyConcreteClass extends MyAbstractClass implements InterfaceA, InterfaceB{

	@Override
	public void myABstractMethod() {
		System.out.println("Not so abstract anymore");
	}
	
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSomethingElse() {
		// TODO Auto-generated method stub
		InterfaceA.super.doSomethingElse();
	}

}
