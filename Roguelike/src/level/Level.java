package level;

import org.newdawn.slick.Graphics;

public class Level {
	private Tile[][] tiles;
	
	private int width;
	private int height;
	
	@Deprecated
	public static final int TILE_WIDTH = 10;
	
	@Deprecated
	public static final int TILE_HEIGHT = 10;
	
	@Deprecated
	private Graphics g;
	
	@Deprecated
	public Level(int width, int height, int offsetX, int offsetY) {
		this(width, height);
	}
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		
		this.tiles = new Tile[width][];
		
		for(int i = 0; i < this.width; i++) {
			this.tiles[i] = new Tile[this.height];
			for(int j = 0; j < this.height; j++) {
				this.tiles[i][j] = new Tile(i, j);
				this.tiles[i][j].setType("void");
			}
		}
	}
	
	@Deprecated
	public Level(int width, int height, Graphics g) {
		this(width, height);
		this.g = g;
	}

	public void fill(String type) {
		for(int i = 0; i < this.width; i++) {
			for(int j = 0; j < this.height; j++) {
				this.tiles[i][j].setType(type);
			}
		}
		
//		this.draw();
	}

	@Deprecated
	public void draw(Graphics g) throws NullPointerException {
		if(g == null) {
			throw new NullPointerException();
		}
		
		for(int i = 0; i < this.width; i++) {
			for(int j = 0; j < this.height; j++) {
				int x = this.getOffsetX() + (i * Level.TILE_WIDTH);
				int y = this.getOffsetY() + (j * Level.TILE_HEIGHT);
				this.tiles[i][j].draw(g, x, y);
			}
		}
	}
	
	@Deprecated
	public void draw() throws IllegalStateException {
		if(this.g != null) {
			this.draw(this.g);
		} else {
			throw new IllegalStateException("Graphics not set.");
		}
	}
	
	public Tile tile(int x, int y) {
		return this.tiles[x][y];
	}
	
	@Deprecated
	public int getOffsetX() {
		return 0;
	}

	@Deprecated
	public int getOffsetY() {
		return 0;
	}

	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public Graphics getGraphics() {
		return g;
	}

	public void setGraphics(Graphics g) {
		this.g = g;
	}
}
