package entity;

import java.util.ArrayList;
import java.util.List;

import level.Level;


public class EntityLayer<T extends Entity> {
	private Level parent;
	
	private List<T> entities;
	
	public EntityLayer(Level parent) {
		this.setParent(parent);
		this.entities = new ArrayList<T>();
	}
	
	public void add(T entity) {
		this.entities.add(entity);
	}

	public Level getParent() {
		return parent;
	}

	public void setParent(Level parent) {
		this.parent = parent;
	}

	public List<T> getEntities() {
		return entities;
	}
	
	public T get(int id) {
		for(T e: this.getEntities()) {
			if(e.getID() == id) {
				return e;
			}
		}
		
		return null;
	}
}
