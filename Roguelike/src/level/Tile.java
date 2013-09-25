package level;

public class Tile extends Point {
	String type;
	
	public String getType() {
		return type;
	}

	public Tile(int x, int y) {
		super(x, y);
		this.type = "void";
	}
	
	public Tile(int x, int y, String type) {
		super(x, y);
		
		this.type = type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
