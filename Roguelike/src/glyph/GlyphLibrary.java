package glyph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import level.TileType;

public class GlyphLibrary {
	private Map<TileType, Glyph> list;
	private static GlyphLibrary instance;
	
	private GlyphLibrary() {
		this.list = new HashMap<TileType, Glyph>();
	}
	
	public static GlyphLibrary getInstance() {
		if(instance == null) {
			instance = new GlyphLibrary();
		}
		return instance;
	}
	
	public void load(String file) {
		try {
			BufferedReader buff;
			String line;
			TileType type;
			
			buff = new BufferedReader(new FileReader("data/" + file));
			while ((line = buff.readLine()) != null) {
				//commented line, move on
				if(line.length() < 1 || line.charAt(0) == '#') {
					continue;
				}
				
				String[] parts = line.split(" ");
				if(parts.length < 5 || parts[0].length() < 1) {
					continue;
				}
				
				type = TileType.find(parts[0]);
				
				if(type != null) {
					this.list.put(type, new Glyph(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
				}
			}
			buff.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + file);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Glyph get(TileType type) {
		return this.list.get(type);
	}
}