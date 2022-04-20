package submarinegame.classes;

import java.awt.Point;
import java.util.Random;

public class Submarine {
	protected int size;
	protected Point[] submarine;
	protected int xLength;
	protected int yLength;

	public Submarine() {
		size = getRandomSize();
		makeSub();
	}

	
	public Point[] makeSub() {
		int counter = 0, i = 1, step;
		submarine = new Point[size];
		submarine[0].x = submarine[0].y = 0;
		while (counter != size - 1) {
			step = getRandomDirection();
			submarine[i].y += step;
			if (submarine[i].y != submarine[i - 1].y) {
				i++;
				counter++;
				xLength++;
			} else {
				submarine[i].x += step;
				if (submarine[i].x != submarine[i - 1].x) {
					i++;
					counter++;
					yLength++;
				}
			}
		}

		return submarine;
	}

	/**
	 * creates the length of sub
	 * 
	 * @return the sub size
	 */
	public int getRandomSize() {
		Random rand = new Random();
		int subSize = rand.nextInt(4) + 1;
		return subSize;
	}

	/**
	 * 
	 * @return -1 / 0 / 1 randomly
	 */
	public int getRandomDirection() {
		Random rand = new Random();
		int subSize = rand.nextInt(3) - 1;
		return subSize;
	}
	
	
	public int subMaxLength() {
		if(xLength > yLength)
			return xLength;
		else
			return yLength;
	}


	public int getxLength() {
		return xLength;
	}


	public int getyLength() {
		return yLength;
	}
	

}

//public void setOnBoard(BoardGame board) {
//	Random rand = new Random();
//	int startLocRow = rand.nextInt(board.getRows());
//	int startLocCol = rand.nextInt(board.getCols());
//	
//	locations[0]= new Point(startLocRow, startLocCol);
//	
//	int direction = rand.nextInt(4); // 0 - UP, 1 - RIGHT, 2 - DOWN, 3 - LEFT
//}