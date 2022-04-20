package submarinegame.classes;

import java.util.Scanner;

public class Game {
	
	private static final int SUBMARINES_NUMBER = 5;

	protected int points;
	protected int guesses;
	protected int hits;
	protected BoardGame board;
	
	public Game()
	{
		this.points = 1000;
		this.guesses = 100;
		this.hits = 0;
	}
	
	public void play()
	{
		Scanner sc = new Scanner(System.in);
		int x, y;
		while (guesses > 0 && points > 0 && hits < SUBMARINES_NUMBER)
		{
			System.out.println("Enter X coordinate");
			x = sc.nextInt();
			System.out.println("Enter y coordinate");
			y = sc.nextInt();
			//checkGuess(x,y)
		}
	}
	
	
}
