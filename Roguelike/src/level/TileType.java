package level;

public enum TileType {
	VOID(false, false),
	WALL(false, false),
	FLOOR(true, true);
	
//	private String name;
	private boolean passthrough;
	private boolean seethrough;
	
	TileType(boolean passthrough, boolean seethrough) {
		this.passthrough = passthrough;
		this.seethrough = seethrough;
	}
	
	public static TileType find(String name) {
		for(TileType type: TileType.values()) {
			if(type.toString().equals(name)) {
				return type;
			}
		}
		
		return null;
	}
	
//	public String getName() {
//		return name;
//	}
//	
//	@Override
//	public String toString() {
//		return name;
//	}

	public boolean isPassthrough() {
		return passthrough;
	}

	public boolean isSeethrough() {
		return seethrough;
	}
}