package roguelike;


import generator.AbstractGenerator;
import generator.Direction;
import generator.MazeGenerator;
import generator.RecursiveMazeGenerator;
import glyph.GlyphLibrary;

import java.util.ArrayList;
import java.util.List;

import level.Level;
import level.Viewport;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import system.AsciiGraphicsEngine;
import system.GraphicsEngine;
import util.ClassPicker;
import util.RandomPlus;


public class Roguelike extends BasicGame {
	private long seed = rng.nextLong();
	private boolean needsRefresh = false;
	
	
	/** Static members **/
	private static GraphicsEngine graphicsEngine;
	private static Level currentLevel;
	private static Viewport viewport;
	private static RandomPlus rng = new RandomPlus();
	
	/** Constants **/
	private static final String FONT_FILE = "fonts/DejaVuSansMono.ttf";
//	private static final String FONT_FILE = "fonts/Inconsolata.otf";
	private static UnicodeFont font;
	
	public static final int SCREEN_WIDTH = 1024;
	public static final int SCREEN_HEIGHT = 640;

	public static final int TILE_WIDTH = 16;
	public static final int TILE_HEIGHT = 16;

	public static final int LEVEL_WIDTH = 150;
	public static final int LEVEL_HEIGHT = 120;
	
	public static final int VIEWPORT_X = 50;
	public static final int VIEWPORT_Y = 50;
	public static final int VIEWPORT_WIDTH = 45;
	public static final int VIEWPORT_HEIGHT = 35;
	
	public static final int SIDE_UI_X = Roguelike.VIEWPORT_X * 2 + Roguelike.VIEWPORT_WIDTH * Roguelike.TILE_WIDTH;
	public static final int SIDE_UI_Y = Roguelike.VIEWPORT_Y;

	public Roguelike() {
		super("Roguelike");
	}
 
	@Override
	public void init(GameContainer container) throws SlickException {
		Roguelike.rng.setSeed(this.seed);
		
		GlyphLibrary.getInstance().load("glyphs.txt");
		
		Roguelike.setCurrentLevel(new Level(Roguelike.LEVEL_WIDTH, Roguelike.LEVEL_HEIGHT));
		Roguelike.setViewport(new Viewport(Roguelike.getCurrentLevel(), Roguelike.VIEWPORT_WIDTH, Roguelike.VIEWPORT_HEIGHT));
		
		Roguelike.setGraphicsEngine(AsciiGraphicsEngine.getInstance());
		Roguelike.getGraphicsEngine().init(
			Roguelike.VIEWPORT_WIDTH,
			Roguelike.VIEWPORT_HEIGHT,
			Roguelike.TILE_WIDTH,
			Roguelike.TILE_HEIGHT
		);

		// Slick specific options
		container.setVSync(true);
		container.getInput().enableKeyRepeat();
//		container.setTargetFrameRate(30);
//		container.setShowFPS(false);
		
		// Do shit
		this.randomGenerator().generate(Roguelike.getCurrentLevel());
	}
 
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		this.handleInput(input, container);
	}
 
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
//		if(this.needsRefresh()) {
			Roguelike.getGraphicsEngine().drawLevel(Roguelike.getViewport());
//		}
		
//		this.isRefreshed();
//		this.currentLevel.draw(g);
	}
 
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Roguelike());
 
		app.setDisplayMode(Roguelike.SCREEN_WIDTH, Roguelike.SCREEN_HEIGHT, false);
		app.start();
	}
	
	private void handleInput(Input input, GameContainer container) {
		boolean keyPressed = false;
		
		if(input.isKeyPressed(Input.KEY_SPACE)) {
			this.randomGenerator().generate(Roguelike.getCurrentLevel());
			keyPressed = true;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD1)) {
			Roguelike.getViewport().move(Direction.DOWN);
			Roguelike.getViewport().move(Direction.LEFT);
			keyPressed = true;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD2)) {
			Roguelike.getViewport().move(Direction.DOWN);
			keyPressed = true;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD3)) {
			Roguelike.getViewport().move(Direction.DOWN);
			Roguelike.getViewport().move(Direction.RIGHT);
			keyPressed = true;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD4)) {
			Roguelike.getViewport().move(Direction.LEFT);
			keyPressed = true;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD6)) {
			Roguelike.getViewport().move(Direction.RIGHT);
			keyPressed = true;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD7)) {
			Roguelike.getViewport().move(Direction.LEFT);
			Roguelike.getViewport().move(Direction.UP);
			keyPressed = true;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD8)) {
			Roguelike.getViewport().move(Direction.UP);
			keyPressed = true;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD9)) {
			Roguelike.getViewport().move(Direction.UP);
			Roguelike.getViewport().move(Direction.RIGHT);
			keyPressed = true;
		}
		
		if(input.isKeyPressed(Input.KEY_ESCAPE)) {
			container.exit();
			keyPressed = true;
		}
		
		if(keyPressed) {
			this.requestRefresh();
		}
	}
	
	public AbstractGenerator randomGenerator() {
		AbstractGenerator generator;
		
		List<Class<?>> generatorList = new ArrayList<Class<?>>();
		generatorList.add(MazeGenerator.class);
		generatorList.add(RecursiveMazeGenerator.class);
		
		ClassPicker picker = new ClassPicker(generatorList);
		
		Class<?> generatorClass = picker.pickRandomClass();

		try {
			generator = (AbstractGenerator) generatorClass.newInstance();
			return generator;
		} catch (Exception e) {
			e.printStackTrace();
			return new RecursiveMazeGenerator();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static UnicodeFont getFont() throws SlickException {
		if(Roguelike.font == null) {
			Roguelike.font = new UnicodeFont(Roguelike.FONT_FILE, Roguelike.TILE_HEIGHT, false, false);
			Roguelike.font.getEffects().add(new ColorEffect());
			Roguelike.font.addAsciiGlyphs();
			Roguelike.font.loadGlyphs();
		}
		
		return Roguelike.font;
	}
	
	public static RandomPlus getRNG() {
		return Roguelike.rng;
	}
	
	public void requestRefresh() {
		this.needsRefresh = true;
	}
	
	public void isRefreshed() {
		this.needsRefresh = false;
	}
	
	@SuppressWarnings("unused")
	public boolean needsRefresh() {
		return true || this.needsRefresh;
	}

	public static Level getCurrentLevel() {
		return Roguelike.currentLevel;
	}

	private static void setCurrentLevel(Level currentLevel) {
		Roguelike.currentLevel = currentLevel;
	}

	public static GraphicsEngine getGraphicsEngine() {
		return Roguelike.graphicsEngine;
	}

	private static void setGraphicsEngine(GraphicsEngine graphicsEngine) {
		Roguelike.graphicsEngine = graphicsEngine;
	}

	public static Viewport getViewport() {
		return viewport;
	}

	public static void setViewport(Viewport viewport) {
		Roguelike.viewport = viewport;
	}
	
	
}