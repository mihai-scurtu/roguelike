package entity.creature;

import level.Level;
import level.Seeing;
import ai.VisionMap;

public class Player extends Creature implements Seeing {
	private VisionMap visionMap;

	public Player(Level parent, int x, int y) {
		super(CreatureType.PLAYER, parent, x, y);
		
		this.visionMap = new VisionMap(this, 10);
	}

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub

	}

	public VisionMap getVisionMap() {
		return visionMap;
	}

}
