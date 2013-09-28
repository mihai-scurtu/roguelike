package generator;

import level.Level;
import level.TileType;
import roguelike.Roguelike;


public class RecursiveMazeGenerator extends AbstractGenerator {
	private int branchCount = 0;
	
	private static final double STOP_CHANCE = 0.1;
	private static final int BRANCHES_BEFORE_STOP = 20;
	private static final double LOOP_CHANCE = 0.1;
	private static final double BRANCH_CHANCE = 0.2;
	private static final int PADDING = 5;
	
	
	public RecursiveMazeGenerator() {
		this.rng = Roguelike.getRNG();
	}
	
	@Override
	public void generate(Level level, double attempts) {
		this.level = level;
		
		this.level.fill(TileType.WALL);
		
		this.dig(this.rng.nextInt(PADDING, this.level.getWidth() - PADDING - 1), this.rng.nextInt(PADDING, this.level.getHeight() - PADDING - 1), Direction.random(this.rng), false);
		
		if(!this.isWellGenerated(attempts)) {
			this.generate(level, attempts + 1);
		}
	}

	private void dig(int x, int y, Direction dir, boolean branch) {
		if(x < PADDING || y < PADDING || x > this.level.getWidth() - PADDING - 1 || y > this.level.getHeight() - PADDING - 1) return;
		
		if(this.rng.nextFloat() < STOP_CHANCE && branchCount > BRANCHES_BEFORE_STOP) {
			return;
		}
		
		if(this.level.tile(x + Direction.nextX(dir), y + Direction.nextY(dir)).getType() == TileType.FLOOR && !branch) {
			if(this.rng.nextDouble() > LOOP_CHANCE) return;
		}
		
		this.level.tile(x, y).setType(TileType.FLOOR);
		
		if(this.rng.nextDouble() < BRANCH_CHANCE) {
			this.dig(x, y, Direction.randomTurn(dir, this.rng), true);
			this.branchCount++;
		}
		
		x += Direction.nextX(dir);
		y += Direction.nextY(dir);
		
		this.dig(x, y, dir, false);
	}

}
