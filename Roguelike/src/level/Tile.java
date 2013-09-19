package level;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import roguelike.Roguelike;



public class Tile extends Point {
	String type;
	
	public String getType() {
		return type;
	}

//	private int width = 10;
//	private int height = 10;
	
	public Tile(int x, int y) {
		super(x, y);
//		this.x = x;
//		this.y = y;
		
		this.type = "void";
	}
	
	public Tile(int x, int y, String type) {
		super(x, y);
		
		this.type = type;
	}
	
	@Deprecated
	public void draw(Graphics g, int x, int y) {
//		Rectangle tile = new Rectangle(x * width, y * height, width, height);
		String c = "";
		
		if(this.type == "floor") {
			c = ".";
		} else if(this.type == "wall") {
			c= "#";
		}
		
		try {
			Roguelike.getFont().drawString(x, y, c);
		} catch (SlickException e) {
			System.out.println(x + " " + y + " " + c);
			e.printStackTrace();
		}
		
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
