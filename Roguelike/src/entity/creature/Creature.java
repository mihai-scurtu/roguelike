package entity.creature;

import entity.Actor;
import entity.Entity;
import level.Level;

public abstract class Creature extends Entity implements Actor {
	private CreatureType type;
	
	public Creature(CreatureType type, Level parent, int x, int y) {
		super(parent, x, y);
		
		this.setType(type);
	}

	@Override
	public abstract void takeTurn();

	public CreatureType getType() {
		return type;
	}

	public void setType(CreatureType type) {
		this.type = type;
	}

}
