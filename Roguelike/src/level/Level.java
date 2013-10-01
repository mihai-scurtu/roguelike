package level;

import entity.Creature;
import entity.EntityLayer;

public class Level {
	private Tile[][] tiles;
	
	private int width;
	private int height;
	
	private EntityLayer<Creature> creatures;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		
		this.tiles = new Tile[width][];
		
		for(int i = 0; i < this.width; i++) {
			this.tiles[i] = new Tile[this.height];
			for(int j = 0; j < this.height; j++) {
				this.tiles[i][j] = new Tile(i, j);
				this.tiles[i][j].setType(TileType.VOID);
			}
		}
	}
	
	public void fill(TileType type) {
		for(int i = 0; i < this.width; i++) {
			for(int j = 0; j < this.height; j++) {
				this.tiles[i][j].setType(type);
			}
		}
		
//		this.draw();
	}

	public Tile tile(int x, int y) {
		return this.tiles[x][y];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public EntityLayer<Creature> getCreatures() {
		return creatures;
	}
}
