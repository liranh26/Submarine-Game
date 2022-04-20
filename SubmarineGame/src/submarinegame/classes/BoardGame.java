package submarinegame.classes;

public class BoardGame {
	public int rows;
	public int cols;
	private char[][] board;
	protected Submarine[] subs;
	

	public BoardGame() {
		board = new char[rows][cols];
		initializeBoard();
		subs = new Submarine[5];
	}

	private void initializeBoard() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public void setSubmarine() {
		for(int i=0; i<subs.length;i++) {
			int randomNum = 1 + (int)(Math.random() * 4);
			subs[i] = new Submarine(randomNum);
		}
	}

	public void printBoard() {
		for (int i = 0; i < board.length + 2; i++) {
			if (i == 0 || i == board.length - 1)
				System.out.println("*");
			else {
				for (int j = 0; j < board[i].length + 2; j++) {
					if (j == 0 || j == board[i].length - 1)
						System.out.println("*");
					else {
						System.out.println(board[i][j]);
					}
				}
			}
			System.out.println();
		}
	}
}
