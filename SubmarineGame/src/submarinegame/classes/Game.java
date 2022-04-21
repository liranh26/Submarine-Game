package submarinegame.classes;

import java.awt.Point;
import java.util.Scanner;

public class Game {
	private static final int SUBMARINES_NUMBER = 5;

	protected int points;
	protected int guesses;
	protected int hits;
	protected BoardGame boardGame;
	protected TrackerBoard trackerBoard;
	protected Scanner sc = new Scanner(System.in);

	public Game() {
		this.points = 1000;
		this.guesses = 100;
		this.hits = 0;
		this.boardGame = new BoardGame();
		trackerBoard = new TrackerBoard();
	}

	public void play() {
		int x, y, currentPoints, fallenSubmarines = 0;
		boolean hit = false, firstHit = false;
		char hOrM;

		while (guesses > 0 || points > 0 || fallenSubmarines < SUBMARINES_NUMBER) {
			boardGame.printBoard();
			System.out.print("Enter X coordinate: ");
			x = sc.nextInt();
			System.out.print("Enter y coordinate: ");
			y = sc.nextInt();

			hit = checkGuess(new Point(x, y));

			if (hit) {
				hOrM = 'H';
				if (firstHit)
					currentPoints = 1000;
				else {
					currentPoints = 200;
					firstHit = true;
				}
				points += currentPoints;
				hits++;
			} else {
				hOrM = 'M';
				firstHit = false;
				points -= 10;
			}
			
			trackerBoard.updateHitOrMiss(new Point(x, y), hOrM);
			guesses--;
		}
	}

	private boolean checkGuess(Point guessPoint) {
		for (int i = 0; i < boardGame.getSubmarines().length; i++) {
			Submarine submarine = boardGame.getSubmarines()[i];
			for (int j = 0; j < submarine.getLocations().length; j++) {
				if (guessPoint.equals(submarine.getLocations()[j]))
					return true;
			}
		}
		return false;
	}

}
