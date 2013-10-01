package entity;

import java.util.ArrayList;
import java.util.List;

import level.Level;


public class EntityLayer {
	private Level parent;
	
	private List<Entity> entities;
	
	public EntityLayer(Level parent) {
		this.setParent(parent);
		this.entities = new ArrayList<Entity>();
	}
	
	public void add(Entity entity) {
		this.entities.add(entity);
	}

	public Level getParent() {
		return parent;
	}

	public void setParent(Level parent) {
		this.parent = parent;
	}

	public List<Entity> getEntities() {
		return entities;
	}
	
	public Entity get(int id) {
		for(Entity e: this.getEntities()) {
			if(e.getID() == id) {
				return e;
			}
		}
		
		return null;
	}
}
