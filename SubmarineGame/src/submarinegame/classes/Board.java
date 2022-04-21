package submarinegame.classes;

public abstract class Board {
	protected static final int BOARD_NUM_OF_COLS = 21;
	protected static final int BOARD_NUM_OF_ROWS = 11;
	protected char frameChar='#';
	protected char[][] board;

	public Board() {
		board = new char[BOARD_NUM_OF_ROWS][BOARD_NUM_OF_COLS];
		initializeBoard();
	}

	private void initializeBoard() {
		// insert frame to the board
		for (int i = 0; i < BOARD_NUM_OF_COLS; i++) {
			board[0][i] = frameChar;
			board[BOARD_NUM_OF_ROWS - 1][i] = frameChar;
		}
		
		for(int i=0; i < BOARD_NUM_OF_ROWS; i++) {
			board[i][0] = frameChar;
			board[i][BOARD_NUM_OF_COLS - 1] = frameChar;
		}
		
		for (int i = 1; i < BOARD_NUM_OF_ROWS - 1; i++) {
			for (int j = 1; j < BOARD_NUM_OF_COLS - 1; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public void printBoard() {
		System.out.println("--Submarine BoardGame--");
		for (int i = 0; i < BOARD_NUM_OF_ROWS; i++) {
			for (int j = 0; j < BOARD_NUM_OF_COLS; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}	
}
