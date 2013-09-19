package generator;

import java.util.ArrayList;

import roguelike.Roguelike;

import level.Level;
import util.RandomPlus;




public class MazeGenerator extends AbstractGenerator {
	
//	private final static int turnChance = 20;
	private static final double STOP_CHANCE = 0.1;
	private static final int BRANCHES_BEFORE_STOP = 30;
	private static final double LOOP_CHANCE = 0.2;
	private static final double BRANCH_CHANCE = 0.7;
	private static final int PADDING = 4;
	
	private ArrayList<Integer> branchX;
	private ArrayList<Integer> branchY;
	private ArrayList<Direction> branchDir;
	
	
	public MazeGenerator() {
		this.rng = Roguelike.getRNG();
	}
	
	public MazeGenerator(long seed) {
		this.seed = seed;
		this.rng = new RandomPlus(this.seed);
	}
	
	@Override
	public void generate(Level level, double attempts) {
		this.level = level;
		
		this.level.fill("wall");
		
		this.branchX = new ArrayList<Integer>();
		this.branchY = new ArrayList<Integer>();
		this.branchDir = new ArrayList<Direction>();
		
		this.dig(this.rng.nextInt(PADDING, this.level.getWidth() - PADDING - 1), this.rng.nextInt(PADDING, this.level.getHeight() - PADDING - 1), Direction.random(this.rng), false);
		
		for(int i = 0; i < this.branchX.size(); i++) {
			this.dig(this.branchX.get(i), this.branchY.get(i), this.branchDir.get(i), true);
		}
		
		if(!this.isWellGenerated(attempts)) {
			this.generate(level, attempts + 1);
		}
		
	}

	private void dig(int x, int y, Direction dir, boolean branch) {
		if(x < PADDING || y < PADDING || x > this.level.getWidth() - PADDING - 1 || y > this.level.getHeight() - PADDING - 1) return;
		
		if(this.rng.nextFloat() < STOP_CHANCE && this.branchX.size() > BRANCHES_BEFORE_STOP) {
			return;
		}
		
		if(this.level.tile(x + Direction.nextX(dir), y + Direction.nextY(dir)).getType() == "floor" && !branch) {
			if(this.rng.nextDouble() > LOOP_CHANCE) return;
		}
		
		this.level.tile(x, y).setType("floor");
		
		if(this.rng.nextDouble() < BRANCH_CHANCE && (!this.branchX.contains(x) || !this.branchY.contains(y))) {
			this.branchX.add(x);
			this.branchY.add(y);
			this.branchDir.add(Direction.randomTurn(dir, this.rng));
		}
			
		x += Direction.nextX(dir);
		y += Direction.nextY(dir);
		
		this.dig(x, y, dir, false);
	}

}
