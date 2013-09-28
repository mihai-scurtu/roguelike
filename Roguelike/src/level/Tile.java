package level;

public class Tile extends Point {
	TileType type;

	public TileType getType() {
		return type;
	}

	public Tile(int x, int y) {
		super(x, y);
		this.type = TileType.VOID;
	}

	public Tile(int x, int y, TileType type) {
		super(x, y);

		this.type = type;
	}

	public void setType(TileType type) {
		this.type = type;
	}
}
