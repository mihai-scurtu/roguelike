package generator;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import level.Level;
import level.TileType;



public class Area extends Rectangle {

	public Area() {
		// TODO Auto-generated constructor stub
	}

//	public Room(Rectangle arg0) {
//		super(arg0);
//		// TODO Auto-generated constructor stub
//	}
//
//	public Room(Point arg0) {
//		super(arg0);
//		// TODO Auto-generated constructor stub
//	}
//
//	public Room(Dimension arg0) {
//		super(arg0);
//		// TODO Auto-generated constructor stub
//	}
//
//	public Room(int arg0, int arg1) {
//		super(arg0, arg1);
//		// TODO Auto-generated constructor stub
//	}
//
//	public Room(Point arg0, Dimension arg1) {
//		super(arg0, arg1);
//		// TODO Auto-generated constructor stub
//	}

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
