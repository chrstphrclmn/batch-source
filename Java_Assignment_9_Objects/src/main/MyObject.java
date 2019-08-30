package main;

public class MyObject {

	public long id = 1365;
	
	public MyObject() {}
	public MyObject(long id) {
		
		this.id = id;
	}
	
	public boolean equals(Object o) {
		
		if(o instanceof MyObject) return this.id == ((MyObject) o).id;
		
		return false;
	}
}
