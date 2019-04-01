package be.rbdgt.drawing;

import java.util.ArrayList;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.objects.SimpleLine;
import be.rbdgt.util.ColorMethods;
import be.rbdgt.util.Logger;
import be.rbdgt.util.Stabilo;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Dsquares {

    Logger log;
    PictureSketchV2 pa;
    Stabilo stabilo;

    public Dsquares(Logger log, PictureSketchV2 pa, Stabilo stabilo) {
	this.log = log;
	this.pa = pa;
	this.stabilo = stabilo;
    }

    public void draw(PImage img, int strokeWeight, int penColor, int mult, int max, int hatchamnt, int iSide) {
	log.writeLogLine("[ SQUARES ]");
	// log.writeLogLine("-----------------------------------------");
	log.writeLogLine("strokeWeight: " + strokeWeight);
	log.writeLogLine("penColor: " + stabilo.getColorName(penColor).toUpperCase());
	log.writeLogLine("iSide: " + iSide);

	log.writeLogLine("");

	pa.strokeWeight(strokeWeight);
	pa.stroke(stabilo.s88(penColor, 180)); // TODO fix contourAlpha
	pa.strokeCap(PConstants.ROUND);
	pa.noFill();

	int width = img.width;
	int height = img.height;

	int blackbordercompensation = 1; // To prevent black lines/dots along
	// border
	for (int x = blackbordercompensation; x < width - blackbordercompensation; x = x + iSide) {
	    for (int y = blackbordercompensation; y < height - blackbordercompensation; y = y + iSide) {
		PImage tile = img.get(x, y, iSide, iSide);
		float brightness = ColorMethods.getBrightness(ColorMethods.getAverageColor(tile));
		// System.out.println(brightness);
		if (ColorMethods.getBrightness(ColorMethods.getAverageColor(tile)) < max) {
		    drawRect(brightness, x, y, iSide, mult, max, hatchamnt);
		}
	    }
	}
    }

    public void drawRect(float brightness, int x, int y, int iSide, int mult, int max, int hatchamnt) {
	float b = PApplet.round(PApplet.map(brightness, 0, 255, -mult, mult));
	pa.rectMode(PConstants.CENTER);
	float s = iSide * b;
	// System.out.println(s);
	// pa.rect(x, y, iSide*b, iSide*b);
	if (s != 0) {
	    pa.line(x - s / 2, y - s / 2, x + s / 2, y - s / 2);
	    pa.line(x - s / 2, y + s / 2, x + s / 2, y + s / 2);
	    pa.line(x - s / 2, y - s / 2, x - s / 2, y + s / 2);
	    pa.line(x + s / 2, y - s / 2, x + s / 2, y + s / 2);
	}
	if (pa.random(1) < 0.08) {
	    if (pa.random(1) > 0.5) {
		hatchSquareRight((int) (x + s / 2), (int) (y + s / 2), (int) -s, iSide / hatchamnt);
	    } else {
		hatchSquareLeft((int) (x + s / 2), (int) (y + s / 2), (int) -s, iSide / hatchamnt);
	    }
	}
    }

    public void hatchSquareRight(int xPos, int yPos, int w, int Sens) {
	// System.out.println(w);
	ArrayList<SimpleLine> hatchLines = new ArrayList<SimpleLine>();
	if (w < Sens) {
	    for (int i = 0; i <= w; i = i + Sens) {
		int startX = xPos + w / 2;
		int startY = yPos + w / 2;
		int endX = xPos + w / 2;
		int endY = yPos + w / 2;
		hatchLines.add(new SimpleLine(startX, startY, endX, endY));
		// line(startX, startY, endX, endY);
	    }
	} else {
	    for (int i = 0; i <= w; i = i + Sens) {
		// if (xPos+w/2!=xPos+w/2&&yPos+w/2!=yPos+w/2) {
		int startX = xPos - 0;
		int startY = yPos + i;
		int endX = xPos + i;
		int endY = yPos - 0;
		hatchLines.add(new SimpleLine(startX, startY, endX, endY));
		if (i != w) {
		    startX = xPos + w - i;
		    startY = yPos + w;
		    endX = xPos + w;
		    endY = yPos + w - i;
		    hatchLines.add(new SimpleLine(startX, startY, endX, endY));
		    // line(startX, startY, endX, endY);
		}
	    }
	}
	for (int i = 0; i < hatchLines.size(); i++) {
	    SimpleLine l = (SimpleLine) hatchLines.get(i);
	    pa.line((float) l.x1(), (float) l.y1(), (float) l.x2(), (float) l.y2());
	}
    }

    public void hatchSquareLeft(int xPos, int yPos, int w, int Sens) {
	ArrayList<SimpleLine> hatchLines = new ArrayList<SimpleLine>();
	if (w < Sens) {
	    for (int i = 0; i <= w; i = i + Sens) {
		int startX = xPos + w / 2;
		int startY = yPos + w / 2;
		int endX = xPos + w / 2;
		int endY = yPos + w / 2;
		hatchLines.add(new SimpleLine(startX, startY, endX, endY));
		// line(startX, startY, endX, endY);
	    }
	} else {
	    for (int i = 0; i <= w; i = i + Sens) {
		int startX = xPos - 0;
		int startY = yPos + w - i;
		int endX = xPos + i;
		int endY = yPos + w;
		hatchLines.add(new SimpleLine(startX, startY, endX, endY));
		// line(startX, startY, endX, endY);
		if (i != w) {
		    startX = xPos + w - i;
		    startY = yPos - 0;
		    endX = xPos + w;
		    endY = yPos + i;
		    hatchLines.add(new SimpleLine(startX, startY, endX, endY));
		    // line(startX, startY, endX, endY);
		}
	    }
	}
	for (int i = 0; i < hatchLines.size(); i++) {
	    SimpleLine l = (SimpleLine) hatchLines.get(i);
	    pa.line((float) l.x1(), (float) l.y1(), (float) l.x2(), (float) l.y2());
	}
    }

}
