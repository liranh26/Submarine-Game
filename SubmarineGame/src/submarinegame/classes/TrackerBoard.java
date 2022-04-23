package submarinegame.classes;

public class TrackerBoard extends Board {

	
	public TrackerBoard() {
		super();
	}

	protected boolean checkValidInput(int x, int y) {
		if (x > getRows()-2 || x < 1 || y > getCols()-2 || y < 1) {
			System.out.println("Your input is not valid, Try again.");
			return false;
		}

		return true;
	}

	protected void markHit(int x, int y) {
		board[x][y] = 'H';
	}
	
	protected void markMiss(int x, int y) {
		board[x][y] = 'm';
	}
	
}
