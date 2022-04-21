package submarinegame.classes;

import java.awt.Point;

public class TrackerBoard extends Board {

	public TrackerBoard() {
		super();
	}

	public void updateHitOrMiss(Point point, char hOrM) {
		board[point.x][point.y] = hOrM;
	}
}
