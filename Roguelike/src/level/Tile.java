package level;

public class Tile extends Point {
	TileType type;

	public Tile(int x, int y) {
		super(x, y);
		this.type = TileType.VOID;
	}

	public Tile(int x, int y, TileType type) {
		super(x, y);

		this.type = type;
	}
	
	public boolean canBeSeenBy(Seeing creature) {
		try {
			if(creature.getVisionMap().tile(this.getX() - creature.getX(), this.getY() - creature.getY()).getValue() > 0) {
				return true;
			} else {
				return false;
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public TileType getType() {
		return type;
	}
	
	public void setType(TileType type) {
		this.type = type;
	}
}
