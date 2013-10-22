package entity;

import level.Level;
import ai.VisionMap;

public class Player extends Creature {
	private VisionMap visionMap;

	public Player(Level parent, int x, int y) {
		super(CreatureType.PLAYER, parent, x, y);
		
		this.visionMap = new VisionMap(this, 5);
	}

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub

	}

	public VisionMap getVisionMap() {
		return visionMap;
	}

}
