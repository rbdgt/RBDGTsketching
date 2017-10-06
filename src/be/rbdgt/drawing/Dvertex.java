package be.rbdgt.drawing;

import java.util.ArrayList;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.util.Logger;
import processing.core.*;
import stabilocolors.library.*;
import gab.opencv.*;

public class Dvertex {

	// TODO Make stabilo a static class
	// Stabilo stabilo = new Stabilo(this);
	
	Logger log;
	PictureSketchV2 pa;
	Stabilo stabilo;
	
	public Dvertex(Logger log, PictureSketchV2 pa, Stabilo stabilo){
		this.log = log;
		this.pa = pa;
		this.stabilo = stabilo;
	}

	public void draw(PImage img, int strokeWeight, int penColor) {

		log.writeLogLine("[ VERTEX ]");
		//log.writeLogLine("-----------------------------------------");
		log.writeLogLine("strokeWeight: " + strokeWeight);
		log.writeLogLine("penColor: " + stabilo.getColorName(penColor).toUpperCase());
		log.writeLogLine("");
		
		pa.strokeWeight(strokeWeight);
		pa.stroke(stabilo.s88(penColor, 180)); // TODO fix contourAlpha
		pa.strokeCap(PConstants.ROUND);
		pa.noFill();
		
		OpenCV openCV = new OpenCV(pa, img);
		ArrayList<Contour> c = openCV.findContours();
		for (Contour contour : c) {
			pa.beginShape();
			for (PVector point : contour.getPolygonApproximation().getPoints()) {
				pa.vertex(point.x, point.y);
			}
			pa.endShape();
		}
	}
}
