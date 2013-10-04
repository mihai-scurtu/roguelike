package ai;

import entity.Creature;

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
		
		int i, j;
		for(i = 0; i < this.getHeight(); i++) {
			this.tiles[i] = new LogicalTile[this.getWidth()];
			
			for(j = 0; j < this.getWidth(); j++) {
				this.tiles[i][j] = new LogicalTile(i, j);
			}
		}
	}
	
	public LogicalTile tile(int i, int j) {
//		i -= this.getWidth() / 2;
//		j -= this.getHeight() / 2;
//		if(i >= 0 && i < )
//		return this.tiles[i][j];
		return null;
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
