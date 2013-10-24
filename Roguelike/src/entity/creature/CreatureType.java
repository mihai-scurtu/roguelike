package entity.creature;

import level.TileType;

public enum CreatureType {
	PLAYER("Player");
	
	private String title;
	private TileType tileType;
	
	CreatureType(String title) {
		this.title = title;
		this.tileType = TileType.find(this.toString());
	}

	public String getTitle() {
		return title;
	}

	public TileType getTileType() {
		return tileType;
	}
}
