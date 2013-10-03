package system;

import level.Level;
import level.TileType;

public interface GraphicsEngine {
	public void init(int x, int y, int tileWidth, int tileHeight);
	
	public void drawLevel(Level level);
	public void drawTile(TileType type, int x, int y);
}

