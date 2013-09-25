package generator;

import java.awt.Rectangle;



public class Area extends Rectangle {
	private static final long serialVersionUID = -2518713580496414602L;

	public Area(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public int getIntX() {
		return (int) super.getX();
	}
	
	public int getIntY() {
		return (int) super.getY();
	}
}
