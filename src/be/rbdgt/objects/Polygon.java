package be.rbdgt.objects;
import processing.core.*;


public class Polygon extends PApplet{
	private PVector[] vectorArray = null;
	private PVector intersectPoint;
	final int CIRCLE = 0;
	final int TRIANGLE = 1;
	final int SQUARE = 2;

	public Polygon(){
		
	}
	
	public Polygon(int shape){
		switch (shape) {
		case 0:
			vectorArray = makeCircle();
			break;
		case 1:
			vectorArray = makeTriangle();
			break;
		case 2:
			vectorArray = makeSquare();
			break;
		default:
			vectorArray = makeCircle();
			break;
		}
	}
	
	public Polygon(PVector[] vArr) {
		this.vectorArray = vArr;
	}

	/*public void drawPoly(boolean show, float x, float y, float scale,
			float degrees) {
		//drawPoly(show, g, x, y, scale, degrees);
		drawPoly(show, this.g, x, y, scale, degrees);
	}*/

	public String getShapeName(int shape) {
		switch (shape) {
		case 0:
			return "CIRCLE";
		case 1:
			return "TRIANGLE";
		case 2:
			return "SQUARE";
		default:
			return "CIRCLE";
		}
	}
	
	public void drawPoly(PGraphics pg, boolean show, float x, float y,
			float scale, float degrees) {
		/*
		 * if (sc!=-1) { pg.stroke(sc); } else { pg.noStroke(); } if (pf!=-1) {
		 * pg.fill(pf); } else { pg.noFill(); } if (sw!=-1) {
		 * pg.strokeWeight(sw); } else { pg.strokeWeight(1); }
		 */
		pg.beginShape();
		for (int i = 0; i < vectorArray.length; i++) {
			vectorArray[i].mult(scale);
			vectorArray[i].sub(scale / 2, scale / 2);
			vectorArray[i].rotate(PI / 180 * degrees);
			vectorArray[i].add(x, y);
			if (show) {
				pg.vertex(vectorArray[i].x, vectorArray[i].y);
			}
		}
		pg.endShape(CLOSE);
	}
	
	public PVector[] makeTriangle(){
		vectorArray = new PVector[3];
		vectorArray[0] = new PVector(0.5f, 0);
		vectorArray[1] = new PVector(1, 1);
		vectorArray[2] = new PVector(0, 1);
		return vectorArray;
	}
	
	public PVector[] makeSquare(){
		vectorArray = new PVector[4];
		vectorArray[0] = new PVector(0, 0);
		vectorArray[1] = new PVector(1, 0);
		vectorArray[2] = new PVector(1, 1);
		vectorArray[3] = new PVector(0, 1);
		return vectorArray;
	}
	
	public PVector[] makeCircle(){
		float radius = 0.5f;
		int numpoints = 90;
		double angle = Math.PI *2 / numpoints;
		vectorArray = new PVector[numpoints];
		for (int i = 0; i < numpoints; i++) {
			float vx = (float) (radius * Math.sin(angle * i) + 0.5f);
			float vy = (float) (radius * Math.cos(angle * i) + 0.5f);
			vectorArray[i] = (new PVector(vx, vy));
		}
		return vectorArray;
	}

	public void printVertexes() {
		for (int i = 0; i < vectorArray.length; i++) {
			println(vectorArray[i].x, vectorArray[i].y);
		}
	}

	public boolean pointOnEdge(float x, float y) {
		PVector[] VArr = this.vectorArray;
		for (int polyEdge = 0; polyEdge < VArr.length; polyEdge++) {
			float x3 = VArr[polyEdge].x;
			float y3 = VArr[polyEdge].y;
			float x4 = VArr[(polyEdge + 1) % VArr.length].x;
			float y4 = VArr[(polyEdge + 1) % VArr.length].y;
			if (pointOnSegment(x3, y3, x4, y4, x, y)) {
				return true;
			}
		}
		return false;
	}

	public boolean pointOnSegment(float x1, float y1, float x2, float y2,
			float x, float y) {
		if (min(x1, x2) <= x && x <= max(x1, x2) && min(y1, y2) <= y
				&& y <= max(y1, y2)) {
			return true;
		}
		return false;
	}

	public boolean pointInPolygon(float x, float y) {
		int i;
		int j = vectorArray.length - 1;
		boolean oddNodes = false;
		for (i = 0; i < vectorArray.length; i++) {
			float vix = vectorArray[i].x;
			float viy = vectorArray[i].y;
			float vjx = vectorArray[j].x;
			float vjy = vectorArray[j].y;
			if ((viy < y && vjy >= y || vjy < y && viy >= y)
					&& (vix <= x || vjx <= x)) {
				if (vix + (y - viy) / (vjy - viy) * (vjx - vix) < x) {
					oddNodes = !oddNodes;
				}
			}
			j = i;
		}
		if (!oddNodes && pointOnEdge(x, y)) {
		}
		return oddNodes;
	}

	public void setIntersectPoint(float x1, float y1, float x2, float y2,
			float x3, float y3, float x4, float y4) {
		// PVector intersectPoint;
		float A1 = y2 - y1;
		float B1 = x1 - x2;
		float C1 = A1 * x1 + B1 * y1;
		float A2 = y4 - y3;
		float B2 = x3 - x4;
		float C2 = A2 * x3 + B2 * y3;

		float det = A1 * B2 - A2 * B1;
		if (det == 0) {
			// intersectPoint = new PVector(0, 0);
			//println("Parallel Lines!");
		} else {
			float x = (B2 * C1 - B1 * C2) / det;
			float y = (A1 * C2 - A2 * C1) / det;
			if (crossingSegments(x1, y1, x2, y2, x3, y3, x4, y4, x, y)) {
				intersectPoint = new PVector(x, y);
			} else {
				intersectPoint = new PVector(x2, y2);
			}
		}
		// return intersectPoint;
	}

	public boolean doesIntersect(float x1, float y1, float x2, float y2,
			float x3, float y3, float x4, float y4) {
		float A1 = y2 - y1;
		float B1 = x1 - x2;
		float C1 = A1 * x1 + B1 * y1;
		float A2 = y4 - y3;
		float B2 = x3 - x4;
		float C2 = A2 * x3 + B2 * y3;

		float det = A1 * B2 - A2 * B1;
		if (det == 0) {
			// intersectPoint = new PVector(0, 0);
			//println("Parallel Lines!");
			return false;
		} else {
			float x = (B2 * C1 - B1 * C2) / det;
			float y = (A1 * C2 - A2 * C1) / det;
			if (crossingSegments(x1, y1, x2, y2, x3, y3, x4, y4, x, y)) {
				intersectPoint = new PVector(x, y);
				return true;
			} else {
				intersectPoint = new PVector(x2, y2);
				return false;
			}
		}
		// return intersectPoint;
	}

	public boolean intersectsEdge(PVector[] VArr, float x1, float y1, float x2,
			float y2) {
		for (int polyEdge = 0; polyEdge < VArr.length; polyEdge++) {
			float x3 = VArr[polyEdge].x;
			float y3 = VArr[polyEdge].y;
			float x4 = VArr[(polyEdge + 1) % VArr.length].x;
			float y4 = VArr[(polyEdge + 1) % VArr.length].y;
			if (doesIntersect(x1, y1, x2, y2, x3, y3, x4, y4)) {
				setIntersectPoint(x1, y1, x2, y2, x3, y3, x4, y4);
				return true;
			}
		}
		return false;
	}

	public boolean crossingSegments(float x1, float y1, float x2, float y2,
			float x3, float y3, float x4, float y4, float x, float y) {
		if ((min(x1, x2) <= x && x <= max(x1, x2) && min(y1, y2) <= y && y <= max(
				y1, y2))
				&& (min(x3, x4) <= x && x <= max(x3, x4) && min(y3, y4) <= y && y <= max(
						y3, y4))) {
			return true;
		}
		return false;
	}

	/*public void setPolyFill(int c) {
		this.pf = c;
	}

	public void setStrokeColor(int c) {
		this.sc = c;
	}

	public void setStrokeWeight(int sw) {
		this.sw = sw;
	}*/

	public PVector[] getVectorArray() {
		return this.vectorArray;
	}

	public PVector getIntersectPoint() {
		return this.intersectPoint;
	}
}