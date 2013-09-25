package entity;

import level.Point;

public abstract class Entity extends Point {
	private String name;
	private String type;
	private final int id;
	
	public Entity(String type, String name, int x, int y) {
		super(x, y);
		
		this.id = EntityFactory.nextID();
		this.setName(name);
		this.setType(type);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

}
