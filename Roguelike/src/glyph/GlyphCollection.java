package glyph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GlyphCollection {
	private Map<String, Glyph> list;
	private static GlyphCollection instance;
	
	private GlyphCollection() {
		list = new HashMap<String, Glyph>();
	}
	
	public static GlyphCollection getInstance() {
		if(instance == null) {
			instance = new GlyphCollection();
		}
		return instance;
	}
	
	public void load(String file) {
		try {
			BufferedReader buff;
			String line;
			
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
				
				//TODO validation maybe?
				this.list.put(parts[0], new Glyph(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
			}
			buff.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + file);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Glyph get(String type) {
		return this.list.get(type);
	}
}