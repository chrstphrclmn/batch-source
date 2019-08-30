package game;

public class Game {

	public static void main(String[] args) {
		
		Player p = new Player();
		Enemy e1 = new Enemy();
		
		GameObject[] objlist = {p, e1};
		
		for(GameObject temp : objlist) {
			
			temp.update();
		}
	}
}
