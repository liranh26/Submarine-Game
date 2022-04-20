package submarinegame.classes;

import java.awt.Point;

public class Submarine {
	int size;
	Point[] locations;
	
	public Submarine(int size) {
		this.size = size;
		locations = new Point[size];
	}
	
	public void setOnBoard(BoardGame board) {
		
	}
}
