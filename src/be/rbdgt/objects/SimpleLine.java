package be.rbdgt.objects;
public class SimpleLine {
	
	//TODO Reconsider public variables
	private int x1, y1, x2, y2;

	public SimpleLine(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public int x1() {
		return this.x1;
	}

	public int y1() {
		return this.y1;
	}

	public int x2() {
		return this.x2;
	}

	public int y2() {
		return this.y2;
	}
}
