package com.revature;

import java.util.Vector;

public class MyStack<E> extends Vector<E>{

	private static final long serialVersionUID = 1L;

	public boolean empty() {
		
		return this.elementCount == 0;
	}
	
	public E peek() {
		
		return this.lastElement();
	}
	
	public E pop() {
		
		return this.remove(this.elementCount - 1);
	}
	
	public E push(E element) {
		
		this.add(element);
		return element;
	}
	
	public int search(Object obj) {
		
		int idx = this.indexOf(obj);
		
		if(idx == -1) return idx;
		
		return this.elementCount - idx;
	}
	
	public static void main(String[] args) {
		
		MyStack<String> stack = new MyStack<>();
		stack.push("red"); stack.push("orange"); stack.push("yellow");
		
		System.out.println(stack);
		System.out.println(stack.isEmpty());
		
		System.out.println(stack.pop());
		
		System.out.println(stack);
		
	}
}
