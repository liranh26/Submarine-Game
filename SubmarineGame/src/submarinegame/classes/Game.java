package submarinegame.classes;

import java.util.Scanner;

public class Game {
	
	public static final int SUBMARINES_NUMBER = 5;

	protected int points;
	protected int guesses;
	protected int hits;
	protected BoardGame board;
	
	public Game()
	{
		this.points = 1000;
		this.guesses = 100;
		this.hits = 0;
		this.board = new BoardGame();
	}
	
	public void play()
	{
		Scanner sc = new Scanner(System.in);
		int x, y, currentPoints;
		boolean hit = false, lastHit = false;
		while (guesses > 0 && points > 0 && hits < SUBMARINES_NUMBER)
		{
			board.printBoard();
			System.out.println("Enter X coordinate");
			x = sc.nextInt();
			System.out.println("Enter y coordinate");
			y = sc.nextInt();
			//hit = checkGuess(x,y)
			if (hit)
			{
				currentPoints = 200;
				if (lastHit)
					currentPoints =1000;
				points += currentPoints;
				lastHit = true;
				hits++;
			}
			else
			{
				lastHit = false;
				points -= 10;
			}
			guesses--;
		}
	}
	
	
}
