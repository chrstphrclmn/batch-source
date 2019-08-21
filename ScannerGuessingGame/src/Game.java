import java.util.Scanner;

public class Game {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		play();
	}

	public static void play() {

		int random = (int) (Math.random() * 101);
		boolean playing = true;
		int high = 100;
		int low = 0;
		int guess = -1;
		int count = 1;
		while (playing) {
			System.out.println("Please guess a number between " + low + "-" + high);
			guess = checkNum();
			if (checkRange(low, high, guess)) {

				if (guess > random) {
					System.out.println("To high!");
					high = guess;
				} else if (guess < random) {
					System.out.println("To low!");
					low = guess;
				} else {
					System.out.println("You win!");
					playing = false;
				}
				count++;
			}
		}
		System.out.println("It took you " + count + " tries to guess that!");
	}

	private static boolean checkRange(int low, int high, int guess) {
		if(guess > high || guess < low) {
			System.out.println("invalid input");
			return false;
		}
		
		return true;
	}

	private static int checkNum() {
		String input = sc.nextLine();
		if (input.matches("^\\d+$")) {
			return Integer.parseInt(input);
		} else {
			System.out.println("Invalid input please enter an Integer");
			return checkNum();
		}
		// TODO Auto-generated method stub

	}
}
