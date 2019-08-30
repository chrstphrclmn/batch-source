package two;

public class MoverAndAnimate implements Animatable {

	@Override
	public void move() {
		System.out.println("Object Moved.");

	}

	@Override
	public void animate() {
		System.out.println("Object Animated.");

	}

}
