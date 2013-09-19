package level;

import generator.Direction;

public class Viewport extends SubLevel {

	public Viewport(Level parent, int width, int height) {
		super(parent, width, height);
	}

	public Viewport(Level parent, int x, int y, int width, int height) {
		super(parent, x, y, width, height);
	}
	
	public void move(Direction dir) {
		this.setX(Direction.nextX(this.getX(), dir));
		this.setY(Direction.nextY(this.getY(), dir));
	}

}
