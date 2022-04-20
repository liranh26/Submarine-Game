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
	
	public void printBoard()
	{
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.println(board[i][j]);
			}
		System.out.println();
		}
	}
	
	public char[][] getBoard() {
		return board;
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getCols() {
		return cols;
	}
}
