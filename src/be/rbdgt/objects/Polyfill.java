package be.rbdgt.objects;

import be.rbdgt.PictureSketchV2;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;
import stabilocolors.library.*;

public class Polyfill extends PApplet {

	// TODO Make stabilo a static class
	Stabilo stabilo = new Stabilo(this);

	// TODO parametrize penAlpha
	int penAlpha = 200;

	Polygon poly;
	int tileCount;
	PVector[] VArr;
	PGraphics pg;
	PictureSketchV2 pa;

	int sc = color(0);
	int sw = 1;

	float x, y;
	float w, h;

	public Polyfill(PictureSketchV2 pa, PGraphics pg, Polygon polygon, int tc, float x, float y, int sc) {
		this.poly = polygon;
		this.tileCount = tc;
		this.VArr = polygon.getVectorArray();
		this.pg = pg;
		this.pa =pa;
		this.x = x;
		this.y = y;
		this.sc = sc;
	}

	public void hatchLeft(PGraphics pg) {
		drawIt(pa, pg, 1, pg.width, pg.height);
	}

	public void hatchRight(PGraphics pg) {
		drawIt(pa, pg, 2, pg.width, pg.height);
	}

	// TODO: fix this
	public void hatchVertical(PGraphics pg) {
		drawIt(pa, pg, 3, pg.width, pg.height);
	}

	public void hatchHorizontal(PGraphics pg) {
		drawIt(pa, pg, 4, pg.width, pg.height);
	}

	public void randomDiagGrid(PGraphics pg, int w, int h) {
		drawIt(pa, pg, 0, w, h);
	}
	
	public void randomHVGrid(PGraphics pg, int w, int h) {
		drawIt(pa, pg, -1, w, h);
	}

	public void arab(PGraphics pg, int w, int h) {
		//drawArab(pg, pg.width, pg.height);
		drawArab(pa, pg, w, h);
	}

	public void drawIt(PictureSketchV2 pa, PGraphics pg, int type, int areaWidth, int areaHeight) {
		randomSeed(2);
		pa.strokeWeight(sw);
		pa.stroke(sc);
		for (float gridY = 0; gridY < tileCount; gridY++) {
			for (float gridX = 0; gridX < tileCount; gridX++) {
				float posX = (areaWidth / tileCount * gridX) + x / 2;
				float posY = (areaHeight / tileCount * gridY) + y / 2;
				if (poly.pointInPolygon(posX + (areaWidth / tileCount / 2), posY + (areaHeight / tileCount / 2))) {
					int toggle = switchType(type);
					if (toggle == 1) {
						if (poly.intersectsEdge(VArr, posX, posY, posX + areaWidth / tileCount,
								posY + areaHeight / tileCount)) {
							if (poly.pointInPolygon(posX, posY)) {
								pa.line(posX, posY, poly.getIntersectPoint().x, poly.getIntersectPoint().y); // PART
																												// OF
																												// LINE
																												// INSIDE
							} else {
								pa.line(poly.getIntersectPoint().x, poly.getIntersectPoint().y,
										posX + areaWidth / tileCount, posY + areaHeight / tileCount); // PART
																										// OF
																										// LINE
																										// INSIDE
							}
						} else { // In case there is no intersection the
									// line is drawn as is...
							pa.line(posX, posY, posX + areaWidth / tileCount, posY + areaHeight / tileCount);
						}
					}
					if (toggle == 2) {
						if (poly.intersectsEdge(VArr, posX, posY + areaHeight / tileCount, posX + areaWidth / tileCount,
								posY)) {
							if (poly.pointInPolygon(posX, posY + areaHeight / tileCount)) {
								pa.line(posX, posY + areaHeight / tileCount, poly.getIntersectPoint().x,
										poly.getIntersectPoint().y); // PART
																		// OF
																		// LINE
																		// INSIDE
							} else {
								pa.line(poly.getIntersectPoint().x, poly.getIntersectPoint().y,
										posX + areaWidth / tileCount, posY); // PART
																				// OF
																				// LINE
																				// INSIDE
							}
						} else { // In case there is no intersection the
									// line is drawn as is...
							pa.line(posX, posY + areaHeight / tileCount, posX + areaWidth / tileCount, posY);
						}
					}
					if (toggle == 3) {
						if (poly.intersectsEdge(VArr, posX, posY, posX,	posY + areaHeight / tileCount)) {
							if (poly.pointInPolygon(posX, posY)) {
								pa.line(posX, posY, poly.getIntersectPoint().x, poly.getIntersectPoint().y); // PART
																												// OF
																												// LINE
																												// INSIDE
							} else {
								pa.line(poly.getIntersectPoint().x, poly.getIntersectPoint().y,	posX, posY + areaHeight / tileCount); // PART
																										// OF
																										// LINE
																										// INSIDE
							}
						} else { // In case there is no intersection the
									// line is drawn as is...
							pa.line(posX, posY, posX, posY + areaHeight / tileCount);
						}
					}
					if (toggle == 4) {
						if (poly.intersectsEdge(VArr, posX, posY, posX + areaWidth / tileCount,	posY)) {
							if (poly.pointInPolygon(posX, posY)) {
								pa.line(posX, posY, poly.getIntersectPoint().x,
										poly.getIntersectPoint().y); // PART
																		// OF
																		// LINE
																		// INSIDE
							} else {
								pa.line(poly.getIntersectPoint().x, poly.getIntersectPoint().y,
										posX + areaWidth / tileCount, posY); // PART
																				// OF
																				// LINE
																				// INSIDE
							}
						} else { // In case there is no intersection the
									// line is drawn as is...
							pa.line(posX, posY, posX + areaWidth / tileCount, posY);
						}
					}
				}
			}
		}
	}

	
	public void drawArab(PictureSketchV2 pa, PGraphics pg, int areaWidth, int areaHeight) {
		randomSeed(1);
		pa.strokeWeight(sw);
		pa.stroke(sc);
		//pg.stroke(color(0, 187, 218));
		//System.out.println("sc: "+sc);
	
		
		float var = 200/tileCount;
		for (float gridY = 0; gridY < tileCount; gridY++) {
			for (float gridX = 0; gridX < tileCount; gridX++) {
				float posX = (areaWidth / tileCount * gridX) + x / var;
				float posY = (areaHeight / tileCount * gridY) + y / var;
				if (poly.pointInPolygon(posX + (areaWidth / tileCount / var), posY + (areaHeight / tileCount / var))) {
					int radius = round(areaWidth / tileCount / 2);
					int numpoints = 16;
					float squeeze = radius / var / 2;
					PVector[] vArr = new PVector[numpoints];
					float angle = TWO_PI / numpoints;
					for (int a = 0; a < numpoints; a++) {
						if (a % 2 == 0) {
							vArr[a] = new PVector(radius * squeeze * sin(angle * a) + 0.5f,
									radius * squeeze * cos(angle * a) + 0.5f);
						} else {
							vArr[a] = new PVector(radius * sin(angle * a) + 0.5f, radius * cos(angle * a) + 0.5f);
						}
					}
					for (int v = 0; v < numpoints; v++) {
						PVector v1 = vArr[v];
						PVector v2 = vArr[(v + 1) % numpoints];
						if (poly.intersectsEdge(VArr, v1.x, v1.y, v2.y, v2.y)) {
							if (poly.pointInPolygon(v1.x, v1.y)) {
								pa.line(v1.x + posX + areaWidth / tileCount / var, v1.y + posY + areaHeight / tileCount / var,
										poly.getIntersectPoint().x, poly.getIntersectPoint().y);
							} else {
								pa.line(poly.getIntersectPoint().x, poly.getIntersectPoint().y,
										v2.x + posX + areaWidth / tileCount / var,
										v2.y + posY + areaHeight / tileCount / var);
							}
						} else {
							pa.line(v1.x + posX + areaWidth / tileCount / var, v1.y + posY + areaHeight / tileCount / var,
									v2.x + posX + areaWidth / tileCount / var, v2.y + posY + areaHeight / tileCount / var);
						}
					}
				}
			}
		}
	}

	public int switchType(int type) {
		switch (type) {
		case -1:
			return (int) random(3, 5);
			//return 2;
		case 0:
			return (int) random(1, 3);
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
		}
		return -1;
	}

	public void setStrokeColor(int penColor) {
		this.sc = color(stabilo.s88(penColor), penAlpha);
	}

	public void setStrokeWeight(int sw) {
		this.sw = sw;
	}
}