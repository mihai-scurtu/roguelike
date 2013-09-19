package generator;

import roguelike.Roguelike;
import util.RandomPlus;

public enum Direction {
	UP, DOWN, LEFT, RIGHT;
	
	public static Direction random(RandomPlus rng) {
		int i = rng.nextInt(4);
		
		switch(i) {
		case 0:
			return UP;
		case 1:
			return LEFT;
		case 2:
			return DOWN;
		case 3: 
			return RIGHT;
		}
		return UP;
	}
	
	public static int nextX(int x, Direction dir) {
		return x + Direction.nextX(dir);
	}
	
	public static int nextX(Direction dir) {
		if(dir == LEFT) return -1;
		if(dir == RIGHT) return 1;
		return 0;
	}
	
	public static int nextY(int y, Direction dir) {
		return y + Direction.nextY(dir);
	}
	
	public static int nextY(Direction dir) {
		if(dir == UP) return -1;
		if(dir == DOWN) return 1;
		return 0;
	}
	
	public static Direction randomTurn(Direction dir, RandomPlus rng) {
		if(dir == UP || dir == DOWN) {
			if(Roguelike.getRNG().nextInt(2) == 0) return LEFT;
			else return RIGHT;
		} else {
			if(Roguelike.getRNG().nextInt(2) == 0) return UP;
			else return DOWN;
		}
	}
}
