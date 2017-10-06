package be.rbdgt.objects;

import processing.core.*;

public class SketchLine extends PApplet {

	// TODO Parametrize Minlength and MaxLength
	private int linesMaxLength = 10000;
	private int minLength = 1;
	private PApplet pa;

	public PVector start, end, middle;

	public SketchLine(PVector start, PVector end) {
		this.start = start;
		this.end = end;
		setMiddle();
	}

	public SketchLine(PApplet pa, PVector start, PVector end) {
		this.pa = pa;
		this.start = start;
		this.end = end;
		setMiddle();
	}

	public void setMiddle() {
		float dis = PVector.dist(start, end) * random(0.25f, 0.75f);
		float angle = atan2(end.y - start.y, end.x - start.x);
		float randomAngle = random(-PI / 6, PI / 6);
		float x = start.x + cos(angle + randomAngle) * dis;
		float y = start.y + sin(angle + randomAngle) * dis;
		middle = new PVector(x, y);
	}

	public void drawSmooth() {
		if (!(dist(start.x, start.y, end.x, end.y) > linesMaxLength * 3)
				&& !(dist(start.x, start.y, end.x, end.x) < minLength)) {
			if (middle == null)
				setMiddle();
			if (this.pa != null) {
				pa.beginShape();
				pa.curveVertex(start.x, start.y);
				pa.curveVertex(start.x, start.y);
				pa.curveVertex(middle.x, middle.y);
				pa.curveVertex(end.x, end.y);
				pa.curveVertex(end.x, end.y);
				pa.endShape();
			}
		}
	}
}
