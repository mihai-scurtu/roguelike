package generator;
import level.Level;
import util.RandomPlus;

public abstract class AbstractGenerator {
	protected RandomPlus rng;
	protected long seed;
	protected Level level;
	
	protected final double OPTIMAL_FLOOR_PERCENT = 0.80;
	protected final double MIN_FLOOR_PERCENT = 0.10;
	
	protected final double PERCENT_DECAY = 0.1;
	
	abstract public void generate(Level level, double attempts);
	
	public void generate(Level level) {
		this.generate(level, 0);
	}
	
	public boolean isWellGenerated() {
		return isWellGenerated(0);
	}
	
	public boolean isWellGenerated(double attempts) {
		int floors = 0;
		double percent;
		double threshold = Math.max(this.OPTIMAL_FLOOR_PERCENT * (1 - attempts * this.PERCENT_DECAY), this.MIN_FLOOR_PERCENT);
		
		for(int i = 0; i < this.getLevel().getWidth(); i ++) {
			for(int j = 0; j < this.getLevel().getHeight(); j++) {
				if(this.getLevel().tile(i, j).getType() == "floor") {
					floors++;
				}
			}
		}
		
		percent = (double) floors / (this.getLevel().getHeight() * this.getLevel().getWidth());
		return percent >= threshold ;
	}
	
	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
//	abstract TileType getWallType();
//	abstract TileType getFloorType();
}
