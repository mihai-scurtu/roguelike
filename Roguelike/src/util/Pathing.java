package util;

import java.util.ArrayDeque;

import level.Point;



public class Pathing {
	public static int[][] lee(Point p, int maxX, int maxY) {
		int[][] d = new int[maxX][maxY];
		ArrayDeque queue = new ArrayDeque<Point>(maxX * maxY);
		
		for(int i = 1; i <= maxX; i++) {
			for(int j = 1; j < maxY; j++) {
				d[i][j] = -1;
			}
		}
		
		d[p.getX()][p.getY()] = 0;
		queue.addLast(p);
		
		
		return d;
	}
}
