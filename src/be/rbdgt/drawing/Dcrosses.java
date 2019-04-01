package be.rbdgt.drawing;

import java.util.ArrayList;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.util.ColorMethods;
import be.rbdgt.util.Logger;
import be.rbdgt.util.Stabilo;
import be.rbdgt.util.Utility;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Dcrosses {

    Logger log;
    PictureSketchV2 pa;
    Stabilo stabilo;

    public Dcrosses(Logger log, PictureSketchV2 pa, Stabilo stabilo) {
	this.log = log;
	this.pa = pa;
	this.stabilo = stabilo;
    }

    public void draw(PImage img, int strokeWeight, int detColor, int penColor, int mult, int max, int iSide, int holes,
	    int randomness) {
	log.writeLogLine("[ CROSSES ]");
	// log.writeLogLine("-----------------------------------------");
	log.writeLogLine("strokeWeight: " + strokeWeight);
	log.writeLogLine("penColor: " + stabilo.getColorName(penColor).toUpperCase());
	log.writeLogLine("iSide: " + iSide);

	log.writeLogLine("");

	pa.strokeWeight(strokeWeight);
	pa.stroke(stabilo.s88(penColor, 180)); // TODO fix contourAlpha
	pa.strokeCap(PConstants.ROUND);
	pa.noFill();

	ArrayList<PVector> pointCloud = Utility.initSquarePointCloud(img, detColor, iSide, holes, randomness);
	// float[][] points = new float[pointCloud.size()][2];
	for (int i = 0; i < pointCloud.size(); i++) {
	    int x = (int) pointCloud.get(i).x;
	    int y = (int) pointCloud.get(i).y;
	    PImage tile = img.get(x, y, iSide, iSide);
	    float brightness = ColorMethods.getBrightness(ColorMethods.getAverageColor(tile));
	    drawCross(brightness, x, y, iSide, mult, max);
	}
    }

    public void drawCross(float brightness, int x, int y, int iSide, int mult, int max) {
	float b = PApplet.round(PApplet.map(brightness, 0, 255, -mult, mult));
	float s = iSide * b;
	// float s = 10;
	if (s != 0) {
	    if (pa.random(1) > 0.5) {
		pa.line(x - s / 2, y - s / 2, x + s / 2, y + s / 2);
		pa.line(x - s / 2, y + s / 2, x + s / 2, y - s / 2);
	    } else {
		pa.line(x+s/2,  y, x+s/2, y+s);
		pa.line(x, y+s/2, x+s, y+s/2);
	    }
	}
    }

}
