package submarinegame.classes;

public class BoardGame extends Board{

	protected Submarine[] subs;

	public BoardGame() {
		super();
		getSubmarines();
	}
	

	public void getSubmarines() {
		subs = new Submarine[5];
		for (int i = 0; i < subs.length; i++) {
			subs[i] = new Submarine();
		}
	}

	

	
}
