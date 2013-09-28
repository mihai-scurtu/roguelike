package level;

public enum TileType {
	VOID("", false, false),
	WALL("wall", false, false),
	FLOOR("floor", true, true);
	
	private String name;
	private boolean passthrough;
	private boolean seethrough;
	
	TileType(String name, boolean passthrough, boolean seethrough) {
		this.name = name;
		this.passthrough = passthrough;
		this.seethrough = seethrough;
	}
	
	public static TileType find(String name) {
		for(TileType type: TileType.values()) {
			if(type.getName() == name) {
				return type;
			}
		}
		
		return null;
	}
	
	public String getName() {
		return name;
	}

	public boolean isPassthrough() {
		return passthrough;
	}

	public boolean isSeethrough() {
		return seethrough;
	}
}