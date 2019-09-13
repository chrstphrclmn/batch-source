package com.revature.oopexercise;

//Class that similarly inherits from the Piece class like Pawn

public class Rook extends Piece{
	
	public Rook() {
		
		super();
		this.status = 1; this.value = 10;
		this.label = 'R';
	}
	
	public Rook(int xpos, int ypos, int ctype) {
		
		this();
		this.pos[0] = xpos; this.pos[1] = ypos;
		
		if((this.pos[0] < 0 || this.pos[0] >= 8 ) || (this.pos[1] < 0 || this.pos[1] >= 8) ) {
			
			throw new InvalidMoveException();
		}

		this.color = ctype;
		this.id = xpos + ypos + ctype + this.label;
	}
	
	public boolean verify(int[] pos) {
		
		if((pos[0] < 0 || pos[0] >= 8 ) || (pos[1] < 0 || pos[1] >= 8) ) {
			
			return false;
		}
		
		if(status == 1) {
			
			int xdiff = this.pos[0] - pos[0];
			int ydiff = this.pos[1] - pos[1];
			
			if(xdiff == 0 && ydiff == 0) return false;
			
			if(xdiff == 0 || ydiff == 0){
				
				return true;
			}
		}
		
		return false;
	}
}