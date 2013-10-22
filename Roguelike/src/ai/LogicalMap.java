package ai;

import entity.Creature;

/**
 * Similar to a level, but you get the tile via relative coords to the creature. (I.e. the creature is (0, 0))
 */
public abstract class LogicalMap  {
	private LogicalTile tiles[][];
	private Creature parent;
	
	private int width, height;
	
	public LogicalMap(Creature parent, int widthFromParent, int heightFromParent) {
		int width = widthFromParent * 2 + 1;
		int height = heightFromParent * 2 + 1;
		
		this.setParent(parent);
		this.setWidth(width);
		this.setHeight(height);
		
		this.tiles = new LogicalTile[height][];
		
		int i, j;
		for(i = 0; i < this.getHeight(); i++) {
			this.tiles[i] = new LogicalTile[this.getWidth()];
			
			for(j = 0; j < this.getWidth(); j++) {
				this.tiles[i][j] = new LogicalTile(i - this.getWidth() / 2, j - this.getHeight() / 2);
			}
		}
	}
	
	public LogicalTile tile(int i, int j) throws ArrayIndexOutOfBoundsException {
		i += this.getWidth() / 2;
		j += this.getHeight() / 2;

		return this.tiles[i][j];
	}
	
	public abstract void compute();

	public void dump() {
		int i, j;
		
		for(j = 0; j < this.getHeight(); j++){ 
			for(i = 0; i < this.getWidth(); i++) {
				System.out.print(this.tile(i - this.getWidth() / 2, j - this.getHeight() / 2).getValue() + " ");
			}
			
			System.out.println();
		}
	}
	
	public Creature getParent() {
		return parent;
	}

	public void setParent(Creature parent) {
		this.parent = parent;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
