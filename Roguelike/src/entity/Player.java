package entity;

import level.Level;

public class Player extends Creature {

	public Player(Level parent, int x, int y) {
		super(CreatureType.PLAYER, parent, x, y);
	}

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub

	}

}
