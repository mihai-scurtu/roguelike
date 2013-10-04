package ai;

import level.Point;

public class LogicalTile extends Point {
	double value = 0;
	
	public LogicalTile(int x, int y) {
		super(x, y);
	}
	
	public LogicalTile(int x, int y, double value) {
		this(x, y);
		
		this.setValue(value);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
