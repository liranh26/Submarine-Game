package submarinegame.classes;

public class Game {

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
		while (guesses > 0 && points > 0 )
	}
}
