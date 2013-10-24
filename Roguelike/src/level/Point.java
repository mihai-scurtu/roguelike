package level;

public class Point {
	protected int x;
	protected int y;
	
	public Point() {
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this.setX(p.getX());
		this.setY(p.getY());
	}
	
	public double distanceTo(Point p) {
		return Math.sqrt((this.x - p.getX()) * (this.x - p.getX()) + (this.y - p.getY()) * (this.y - p.getY()));
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		Point p = (Point) obj;
		return this.getX() == p.getX() && this.getY() == p.getY();
	}
	
	/**
	 * Thank you, Edwin Buck on Stack Overflow!
	 */
	public int hashCode() {
		int x = this.getX();
		int y = this.getY();
		
		int value = x ^ y;
		
//		long bits = Double.doubleToLongBits(y);
//	    byte[] ybits = new byte[] {
//	        (byte)((y >> 56) & 0xff),
//	        (byte)((y >> 48) & 0xff),
//	        (byte)((y >> 40) & 0xff),
//	        (byte)((y >> 32) & 0xff),
//	        (byte)((y >> 24) & 0xff),
//	        (byte)((y >> 16) & 0xff),
//	        (byte)((y >> 8) & 0xff),
//	        (byte)((y >> 0) & 0xff),
//	    };
//	    byte[] xbits = new byte[] {
//	        (byte)((x >> 56) & 0xff),
//	        (byte)((x >> 48) & 0xff),
//	        (byte)((x >> 40) & 0xff),
//	        (byte)((x >> 32) & 0xff),
//	        (byte)((x >> 24) & 0xff),
//	        (byte)((x >> 16) & 0xff),
//	        (byte)((x >> 8) & 0xff),
//	        (byte)((x >> 0) & 0xff),
//	    };
//	    // this combines the bytes of X with the reversed order
//	    // bytes of Y, and then packs both of those into 4 bytes
//	    // because we need to return an int (4 bytes).
//	    byte[] xorbits = new byte[] {
//	         (byte) ((xbits[0]^ybits[7])^(xbits[4]^ybits[3])),
//	         (byte) ((xbits[1]^ybits[6])^(xbits[5]^ybits[2])),
//	         (byte) ((xbits[2]^ybits[5])^(xbits[6]^ybits[1])),
//	         (byte) ((xbits[3]^ybits[4])^(xbits[7]^ybits[0])),
//	    };
//
//	    int value = 0;
//	    for (int i = 0; i < 3; i++) {
//	       value = (value << 8) + (xorbits[i] & 0xff);
//	    }
	    return value;
		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
