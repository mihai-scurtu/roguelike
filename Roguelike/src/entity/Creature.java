package entity;

public abstract class Creature extends Entity implements Actor {

	public Creature(String type, String name, int x, int y) {
		super(type, name, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract void takeTurn();

}
