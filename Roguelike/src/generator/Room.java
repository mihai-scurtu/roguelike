package generator;

import level.Level;
import level.TileType;

public class Room extends Area {

	public Room() {
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

	public Room(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void applyToTileset(Level level) {
		int i, j;
		
		for(i = this.getIntX(); i < (int)this.getWidth(); i++) {
			for(j = this.getIntY(); j < (int) this.getHeight(); j++) {
				level.tile(i, j).setType("floor");
			}
		}
	}

}
