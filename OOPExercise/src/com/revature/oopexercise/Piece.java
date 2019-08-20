package com.revature.oopexercise;


public abstract class Piece implements Movable{

	int value = 0;
	int color = 0;
	int status = 0;
	char label;
	
	int[] pos = {0, 0};
	
	public abstract boolean verify(int[] pos);
	
	public boolean verify(int x, int y) {
		
		int[] param = {x, y};
		
		return this.verify(param);
	}

	public void move(int[] pos) {
		
		if(this.verify(pos)) {
			
			System.out.printf("%C: (%d, %d) -> (%d, %d)\n", this.label, this.pos[0], this.pos[1], pos[0], pos[1]);
			this.pos[0] = pos[0]; this.pos[1] = pos[1];
			return;
		}
		
		throw new InvalidMoveException();
	}
	
	public void move(int x, int y){
		
		int[] param = {x, y};
		
		this.move(param);
	}
}
