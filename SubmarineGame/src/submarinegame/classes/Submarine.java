package submarinegame.classes;

import java.awt.Point;
import java.util.Random;

public class Submarine {
	int size;
	Point[] locations;
	
	public Submarine(int size) {
		this.size = size;
		locations = new Point[size];
	}
	
	public void setOnBoard(BoardGame board) {
		Random rand = new Random();
		int startLocRow = rand.nextInt(board.getRows());
		int startLocCol = rand.nextInt(board.getCols());
		
		locations[0]= new Point(startLocRow, startLocCol);
		
		int direction = rand.nextInt(4); // 0 - UP, 1 - RIGHT, 2 - DOWN, 3 - LEFT
		
		
		
		
	}
}
