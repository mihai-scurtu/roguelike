package system;

import glyph.Glyph;
import glyph.GlyphLibrary;
import level.Level;
import level.Tile;

import org.newdawn.slick.SlickException;

import roguelike.Roguelike;

public class AsciiGraphicsEngine implements GraphicsEngine {
	private static AsciiGraphicsEngine instance;
	
	private int x = 0;
	private int y = 0;
	
	private int tileWidth = 10;
	private int tileHeight = 10;
	
	private AsciiGraphicsEngine() {
	}
	
	public static AsciiGraphicsEngine getInstance() {
		if(instance == null) {
			instance = new AsciiGraphicsEngine();
		}
		
		return instance;
	}
	
	public void init(int x, int y, int tileWidth, int tileHeight) {
		this.setX(x);
		this.setY(y);
		this.setTileHeight(tileHeight);
		this.setTileWidth(tileWidth);
	}

	@Override
	public void drawLevel(Level level) {
		int i, j;
		
		for(i = 0; i < level.getWidth(); i++) {
			for(j = 0; j < level.getHeight(); j++) {
				int x = this.getX() + (i * this.getTileWidth());
				int y = this.getY() + (j * this.getTileHeight());
				
				this.drawTile(level.tile(i, j), x, y);
			}
		}
	}

	public void drawTile(Tile tile, int x, int y) {
		if(tile.getType() != "void") {
			Glyph glyph = GlyphLibrary.getInstance().get(tile.getType());
			
			try {
				Roguelike.getFont().drawString(x, y, glyph.getChar(), glyph.getColor());
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		if(x > 0 && x < Roguelike.SCREEN_WIDTH) {
			this.x = x;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if(y > 0 && y < Roguelike.SCREEN_HEIGHT) {
			this.y = y;
		}
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		if(tileHeight > 0) {
			this.tileHeight = tileHeight;
		}
	}
	
	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		if(tileWidth > 0) {
			this.tileWidth = tileWidth;
		}
	}
}
