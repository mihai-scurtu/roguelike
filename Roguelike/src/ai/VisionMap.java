package ai;

import java.util.HashSet;
import java.util.Set;

import level.Point;
import level.Tile;
import entity.Creature;

/**
 * LogicalTile value 1 means the tile is visible, -1 otherwise.
 * Hopefully it all defaults to 0 on construction. 
 */
public class VisionMap extends LogicalMap {
	private int visionRange;
	private final double INCREMENT = 0.5;
	
	public VisionMap(Creature parent, int visionRange) {
		super(parent, visionRange, visionRange);
		
		this.setVisionRange(visionRange);
	}
	
	@Override
	public void compute() {
		for(int i = this.getVisionRange(); i > 0; i--) {
			for(int j = -i; j <= i; j++) {
				int x, y;
				
				x = i;
				y = j;
				if(this.tile(x, y).getValue() == 0) {
					this.checkVisibility(x, y);
				}
				
				x = -i;
				y = j;
				if(this.tile(x, y).getValue() == 0) {
					this.checkVisibility(x, y);
				}
				
				x = j;
				y = i;
				if(this.tile(x, y).getValue() == 0) {
					this.checkVisibility(x, y);
				}
				
				x = j;
				y = -i;
				if(this.tile(x, y).getValue() == 0) {
					this.checkVisibility(x, y);
				}
			}
		}
	}
	
	public boolean checkVisibility(int i, int j) {
		double slope, x, y;
		int levelX, levelY;
		Tile levelTile;
		Set<Point> points = new HashSet<Point>(this.getVisionRange());
		boolean visible = true;
		
		if(i == 0 && j == 0) {
			return true;
		}
		
		if(i != 0) {
			slope = (double) j / i;
			
			// Going from the exterior to the interior.
			for(x = i; x != 0; x += (i > 0 ? -1 : 1) * this.INCREMENT) {
				y = slope * x;
				
				// Add point to tested set.
				points.add(new Point((int) Math.floor(x), (int) Math.floor(y)));
				
//				// Compute real tile coords .
				levelX = (int) Math.floor(x) + this.getParent().getX();
				levelY = (int) Math.floor(y) + this.getParent().getY();
				
				try {
					levelTile = this.getParent().getParent().tile(levelX, levelY);
					
					if(!levelTile.getType().isSeethrough()) {
						visible = false;
						break;
					}
				} catch(ArrayIndexOutOfBoundsException e) {
					// It's definitely the first out of bounds tile since where going from outside in.
					visible = false;
					break;
				}
			}
		} else {
			for(y = j; y != 0; y += (j > 0 ? -1 : 1)) {
				points.add(new Point(0, (int) y));
				
				// Compute real tile coords .
				levelX = 0 + this.getParent().getX();
				levelY = (int) Math.floor(y) + this.getParent().getY();
				
				try {
					levelTile = this.getParent().getParent().tile(levelX, levelY);
					
					if(!levelTile.getType().isSeethrough()) {
						visible = false;
						break;
					}
				} catch(ArrayIndexOutOfBoundsException e) {
					// It's definitely the first out of bounds tile since where going from outside in.
					visible = false;
					break;
				}
			}
		}
		
		// Update all checked points as visible or not
		for(Point p: points) {
			this.tile(p.getX(), p.getY()).setValue(visible ? 1 : -1);
		}
		
		return visible;
	}
	
	@Override
	public void dump() {
		int i, j;
		System.out.println();
		for(j = 0; j < this.getHeight(); j++){ 
			for(i = 0; i < this.getWidth(); i++) {
				System.out.print((int) Math.max(this.tile(i - this.getWidth() / 2, j - this.getHeight() / 2).getValue(), 0) + " ");
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
