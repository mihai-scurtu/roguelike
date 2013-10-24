package level;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import roguelike.Roguelike;
import entity.EntityLayer;
import entity.creature.Creature;

public class Level {
	private Tile[][] tiles;
	
	private int width;
	private int height;
	
	private EntityLayer<Creature> creatures;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		
		this.creatures = new EntityLayer<Creature>(this);
		
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

	public Tile tile(int x, int y) throws ArrayIndexOutOfBoundsException {
		return this.tiles[x][y];
	}
	
	// TODO make sure key search works well!
	public Point getRandomSpawnPoint() {
		boolean valid = false;
		Point point = null;
		int x, y;
		int attempts = 0;
		
		List<Integer> blackListX = new ArrayList<Integer>();
		List<Integer> blackListY = new ArrayList<Integer>();
		
		do {
			x = Roguelike.getRNG().nextInt(this.getWidth());
			y = Roguelike.getRNG().nextInt(this.getHeight());
			
			if(!blackListX.contains(x) || !blackListY.contains(y)) {
				attempts += 1;
				
				if(this.tile(x, y).getType().isPassthrough()) {
					point = this.tile(x, y);
					
					if(!this.getCreatures().containsKey(point)) {
						valid = true;
					}
				}
			}
		} while(!valid && attempts <= this.getHeight() * this.getWidth());
		
		return point;
	}
	
	public Creature getCreature(int x, int y) {
		Creature creature = this.getCreatures().get(new Point(x, y));
		return creature;
	}
	
	public void addCreature(Creature creature) {
		creature.setParent(this);
		this.creatures.add(creature);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public EntityLayer<Creature> getCreatureLayer() {
		return this.creatures;
	}
	
	public Map<Point, Creature> getCreatures() {
		return creatures.getEntities();
	}
}
