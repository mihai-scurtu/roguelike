package glyph;

import org.newdawn.slick.Color;

public class Glyph {
	private String c;
	private Color color;
	
	public Glyph(String c, int r, int g, int b) {
		this.setChar(c);
		this.setColor(r, g, b);
	}

	public String getChar() {
		return c;
	}

	public void setChar(String c) {
		this.c = c;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(int r, int g, int b) {
		this.color = new Color(r, g, b);
	}
}
