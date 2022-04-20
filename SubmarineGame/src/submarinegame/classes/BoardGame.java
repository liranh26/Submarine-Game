package submarinegame.classes;

import java.awt.Point;
import java.util.Random;

public class BoardGame extends Board {

	private Submarine[] subs;

	public BoardGame() {
		super();
		setSubsOnBoard();
	}

	private void getSubmarines() {
		subs = new Submarine[5];
		for (int i = 0; i < subs.length; i++) {
			subs[i] = new Submarine();
		}
	}

	private void setSubsOnBoard() {
		int i = 0;
		Point randPoint;

		getSubmarines();

		do {
			randPoint = getRandomPointOnBoard();
			
			if(checkValidLocation(randPoint, i)) {
				insertSubToBoard(randPoint, i);
				i++;
			}
			
		} while (i < subs.length);
	}

	private Point getRandomPointOnBoard() {
		Point p = new Point();
		Random rad = new Random();
		p.x = rad.nextInt(10) + 1;
		p.x = rad.nextInt(20) + 1;
		return p;
	}

	private boolean checkValidLocation(Point randomPoint, int subIndex) {
		int xtmp, ytmp;
		for (int i = 0; i < subs[subIndex].getSize(); i++) {
			xtmp = randomPoint.x + subs[subIndex].submarine[i].x;
			ytmp = randomPoint.y + subs[subIndex].submarine[i].y;
			if (xtmp >= getRows() || ytmp >= getCols() || xtmp < 1 || ytmp < 1 || isSubAround(new Point(xtmp, ytmp)))
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
		for (int i = 0; i < subs[subIndex].getSize(); i++) {
			xtmp = p.x + subs[subIndex].submarine[i].x;
			ytmp = p.y + subs[subIndex].submarine[i].y;
			board[xtmp][ytmp] = 'S';
		}
	}
		
	}
