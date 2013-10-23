package ai;

import java.util.ArrayList;
import java.util.List;

import level.Point;
import level.Tile;
import entity.Creature;

/**
 * LogicalTile value 1 means the tile is visible, 0 otherwise
 */
public class VisionMap extends LogicalMap {
	private int visionRange;
	private final double INCREMENT = 0.1;
	
	public VisionMap(Creature parent, int visionRange) {
		super(parent, visionRange, visionRange);
		
		this.setVisionRange(visionRange);
	}
	
	@Override
	public void compute() {
		for(double i = 0; i <= this.getVisionRange(); i += this.INCREMENT){
			for(double j = -i; j <= i; j += this.INCREMENT) {
				double x, y;
				
				x = i;
				y = j;
				if(this.tile((int) Math.round(x), (int) Math.round(y)).getValue() == 0) {
					this.checkVisibility(x, y);
				}
				
				x = -i;
				y = j;
				if(this.tile((int) Math.round(x), (int) Math.round(y)).getValue() == 0) {
					this.checkVisibility(x, y);
				}

				x = j;
				y = i;
				if(this.tile((int) Math.round(x), (int) Math.round(y)).getValue() == 0) {
					this.checkVisibility(x, y);
				}

				x = j;
				y = -i;
				if(this.tile((int) Math.round(x), (int) Math.round(y)).getValue() == 0) {
					this.checkVisibility(x, y);
				}
			}
		}
		
//		this.checkVisibility(0, this);
	}
	
	public void checkVisibility(double i, double j) {
		double slope, x, y;
		int levelX, levelY;
		Tile levelTile;
		List<Point> points = new ArrayList<Point>(this.getVisionRange());
		
//		if(i == 0f && j == 0f) {
//			return;
//		}
		
		
		if(i != 0f) {
			slope = j / i;
			
			if(Math.abs(i - j) > 3) {
				System.out.println(slope);
			}
			
			// Going from the inside out.
			for(x = Math.signum(i); Math.abs(x) <= this.getVisionRange(); x += (i > 0 ? 1 : -1) * this.INCREMENT) {
				y = slope * x;
				
				if(Math.abs(Math.round(y)) <= this.getVisionRange()) {
					// Add point to tested set.
					Point p = new Point((int) Math.round(x), (int) Math.round(y));
					if(!points.contains(p)) {
						points.add(p);
					}
				}
			}
		} else {
			System.out.println();
			for(y = 1 * Math.signum(j); Math.abs(y) <= this.getVisionRange(); y += (j > 0 ? 1 : -1)) {
				Point p = new Point(0, (int) y);
				if(!points.contains(p)) {
					points.add(p);
				}
			}
		}
		
//		System.out.println();
//		// Update all checked points as visible or not
		for(Point p: points) {
			// Compute real tile coords .
			levelX = (int) Math.floor(p.getX()) + this.getParent().getX();
			levelY = (int) Math.floor(p.getY()) + this.getParent().getY();
			
//			System.out.printf("%2d %2d\n", p.getX(), p.getY());
			try {
				levelTile = this.getParent().getParent().tile(levelX, levelY);
				
				this.tile(p.getX(), p.getY()).setValue(1);
				
				if(!levelTile.getType().isSeethrough()) {
					break;
				}
				
//				if(this.tile(p.getX(), p.getY()).getValue() == 0) {
//					this.tile(p.getX(), p.getY()).setValue(1);
//				}
			} catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
		}
		
//		this.dump();
	}
	
	@Override
	public void dump() {
		int i, j;
		System.out.println();
		for(j = 0; j < this.getHeight(); j++){ 
			for(i = 0; i < this.getWidth(); i++) {
				if(i == this.getVisionRange() && i == j) {
					System.out.print("@ ");
				} else {
					System.out.print((int) Math.max(this.tile(i - this.getWidth() / 2, j - this.getHeight() / 2).getValue(), 0) + " ");
				}
			}
			
			System.out.println();
		}
	}
	
	public int getVisionRange() {
		return visionRange;
	}

	public void setVisionRange(int visionRange) {
		this.visionRange = visionRange;
	}

}
