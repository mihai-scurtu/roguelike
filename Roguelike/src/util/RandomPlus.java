package util;
import java.util.Random;

public class RandomPlus extends Random {
	private static final long serialVersionUID = 1L;

	public RandomPlus() {
		super();
	}
	
	public RandomPlus(long seed) {
		super(seed);
	}
	
	public int nextInt(int a, int b) {
		return super.nextInt(b - a + 1) + a;
	}
	
	public int percent() {
		return this.nextInt(0, 100);
	}
}
