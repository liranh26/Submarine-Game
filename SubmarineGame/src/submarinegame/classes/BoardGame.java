package submarinegame.classes;

public class BoardGame {
	public int rows;
	public int cols;
	private char[][] board;
	
	public BoardGame() {
		board = new char[rows][cols];
		initializeBoard();
	}
	
	
	private void initializeBoard() {
		for(int i=0; i< rows; i++) {
			for(int j=0; j<cols; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	
	public void setSubmarine() {
		
		
	}
}
