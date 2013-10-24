package entity;

import entity.creature.Player;
import roguelike.Roguelike;
import level.Level;

public class EntityFactory {
	private static int id = 0;
	private static EntityFactory instance;
	
	private EntityFactory() {
	}
	
	public static EntityFactory getInstance() {
		if(instance == null) {
			instance = new EntityFactory();
		}
		
		return instance;
	}
	
	public Player createPlayer(Level level, int x, int y) {
		if(this.isSafeSpawn(level, x, y)) {
			return new Player(level, x, y);
		}
		
		return null;
	}
	
	public static int nextID() {
		return ++id;
	}
	
	public boolean isSafeSpawn(Level level, int x, int y) {
		boolean value = true;
		
		if(level.tile(x, y).getType().isPassthrough()) {
			for(Entity entity: level.getCreatures().values()) {
				if(entity.getX() == x && entity.getY() == y) {
					value = false;
					break;
				}
			}
		} else {
			value = false;
		}
		
		return value;
	}
}