package submarinegame.classes;

import java.util.Scanner;

public class Game {

	public static final int SUBMARINES_NUMBER = 5;

	private int points;
	private final int startGueses = 100;
	private int guesses;
	private int hits;
	protected BoardGame boardGame;
	protected TrackerBoard guessBoard;

	public Game() {
		points = 1000;
		guesses = startGueses;
		hits = 0;
		boardGame = new BoardGame();
		boardGame.printBoard();
		guessBoard = new TrackerBoard();

	}

	public void play() {
		Scanner sc = new Scanner(System.in);
		int currentPoints, x, y;
		String input = "";
		boolean lastGuess = false;

		while (guesses > 0 && points > 0 && input != "q" && hits != boardGame.getTotalSubsCells()) {
			printBoardAndScore();

			x = getCoordinate('X', sc);
			if (x == 0)
				break;

			y = getCoordinate('Y', sc);
			if (y == 0)
				break;

			if (!guessBoard.checkValidInput(x, y))
				continue;
			
			if (checkGuess(x, y)) {
				guessBoard.markHit(x, y);
				currentPoints = 200;
				if (lastGuess)
					currentPoints = 1000;
				points += currentPoints;
				lastGuess = true;
				hits++;
			} else {
				guessBoard.markMiss(x, y);
				lastGuess = false;
				points -= 10;
			}
			guesses--;
		}
		
		System.out.println("Bye Bye!");
		sc.close();
	}

	private void printBoardAndScore() {
		guessBoard.printBoard();
		System.out.println(
				"Your score is: " + points + ", number of hits is: " + hits + ", number of misses: " + getMisses());
		System.out.println("Enter X and Y coordinate, Or press q to quit.");
	}

	public int getMisses() {
		return startGueses - guesses - hits;
	}

	protected boolean checkGuess(int x, int y) {
		if (boardGame.getCellValue(x, y) == 'S')
			return true;

		return false;
	}

	protected int getCoordinate(char coordinate, Scanner sc) {
		String input;
		System.out.println("Enter " + coordinate + " coordinate");
		input = sc.nextLine();
		if (input.equals("q"))
			return 0;

		return Integer.parseInt(input);
	}
}
