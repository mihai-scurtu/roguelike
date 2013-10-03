package entity;

import level.Level;
import level.Point;

public abstract class Entity extends Point {
	private String name;
	private final int id;
	private Level parent;
	
	public Entity(Level parent, int x, int y) {
		super(x, y);
		
		this.id = EntityFactory.nextID();
		this.setParent(parent);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return id;
	}
	
	public void setLocation(Point p) {
		this.setX(p.getX());
		this.setY(p.getY());
	}
	
	public Point getLocation() {
		return new Point(this.getX(), this.getY());
	}

	public Level getParent() {
		return parent;
	}

	public void setParent(Level parent) {
		this.parent = parent;
	}

}
