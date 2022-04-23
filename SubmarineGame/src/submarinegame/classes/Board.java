package submarinegame.classes;

public abstract class Board {
	private final int rows = 12;
	private final int cols = 22;
	private char frameChar='#';
	protected char[][] board;

	public Board() {
		board = new char[rows][cols];
		initializeBoard();
	}

	private void initializeBoard() {
		// insert frame to the board
		for (int i = 0; i < cols; i++) {
			board[0][i] = frameChar;
			board[rows - 1][i] = frameChar;
		}
		
		for(int i=0; i < rows; i++) {
			board[i][0] = frameChar;
			board[i][cols - 1] = frameChar;
		}
		
		for (int i = 1; i < rows - 1; i++) {
			for (int j = 1; j < cols - 1; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public void printBoard() {
		System.out.println("-Submarine Board Game-");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}
	
	
}
