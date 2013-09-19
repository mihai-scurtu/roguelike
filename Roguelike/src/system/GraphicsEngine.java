package system;

import level.Level;
import level.Tile;

public interface GraphicsEngine {
	public void init(int x, int y, int tileWidth, int tileHeight);
	
	public void drawLevel(Level level);
	public void drawTile(Tile tile, int x, int y);
}

