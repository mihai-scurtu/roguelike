package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import level.Level;
import level.Point;


public class EntityLayer<T extends Entity> {
	private Level parent;
	
	private Map<Point, T> entities;
	
	public EntityLayer(Level parent) {
		this.setParent(parent);
		this.entities = new HashMap<Point, T>();
	}
	
	public void add(T entity) {
		this.entities.put(entity.getLocation(), entity);
	}

	public Level getParent() {
		return parent;
	}

	public void setParent(Level parent) {
		this.parent = parent;
	}

	public Map<Point, T> getEntities() {
		return entities;
	}
	
	public List<T> getEntityList() {
		return new ArrayList<T>(this.getEntities().values());
	}
	
	public T get(int id) {
		for(T e: this.getEntities().values()) {
			if(e.getID() == id) {
				return e;
			}
		}
		
		return null;
	}
}
