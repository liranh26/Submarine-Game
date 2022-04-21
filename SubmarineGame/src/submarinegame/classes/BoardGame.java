package submarinegame.classes;

import java.awt.Point;
import java.util.Random;

public class BoardGame extends Board {

	protected static final int NUMBER_OF_SUBMARINES = 5;
	protected Submarine[] submarines;

	public BoardGame() {
		super();
		initSubmarines();
		setSubsOnBoard();
	}

	private void initSubmarines() {
		submarines = new Submarine[5];
		for (int i = 0; i < submarines.length; i++) {
			submarines[i] = new Submarine();
		}
	}

	public Submarine[] getSubmarines() {
		return submarines;
	}
	
	private void setSubsOnBoard() {
		Point randPoint;

		for (int i = 0; i < NUMBER_OF_SUBMARINES; i++) {
			randPoint = getRandomPointOnBoard();

			if (checkValidLocation(randPoint, i)) {
				insertSubToBoard(randPoint, i);
			}
		}
	}

	private Point getRandomPointOnBoard() {
		Point p = new Point();
		Random rad = new Random();
		p.x = rad.nextInt(10) + 1;
		p.y = rad.nextInt(20) + 1;
		return p;
	}

	private boolean checkValidLocation(Point randomPoint, int subIndex) {
		int xtmp, ytmp;
		for (int i = 0; i < submarines[subIndex].getSize(); i++) {
			xtmp = randomPoint.x + submarines[subIndex].locations[i].x;
			ytmp = randomPoint.y + submarines[subIndex].locations[i].y;
			if (xtmp >= BOARD_NUM_OF_ROWS || ytmp >= BOARD_NUM_OF_COLS || xtmp < 1 || ytmp < 1 || isSubAround(new Point(xtmp, ytmp)))
				return false;
		}

		return true;
	}

	private boolean isSubAround(Point point) {
		for (int i = -1; i <= 1; i++)
			if (board[point.x - 1][point.y + i] == 'S' || board[point.x + i][point.y - 1] == 'S'
					|| board[point.x + 1][point.y + i] == 'S' || board[point.x + i][point.y + 1] == 'S')
				return true;
		return false;
	}

	private void insertSubToBoard(Point p, int subIndex) {
		int xtmp, ytmp;
		for (int i = 0; i < submarines[subIndex].getSize(); i++) {
			xtmp = p.x + submarines[subIndex].locations[i].x;
			ytmp = p.y + submarines[subIndex].locations[i].y;
			board[xtmp][ytmp] = 'S';
		}
	}

}
