package be.rbdgt.drawing;

import java.util.ArrayList;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.util.Logger;
import be.rbdgt.util.Stabilo;
//import gab.opencv.Contour;
//import gab.opencv.OpenCV;
import be.rbdgt.customProcessingOCV.*;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Dcontour {
	
	Logger log;
	PictureSketchV2 pa;
	Stabilo stabilo;
	
	public Dcontour(Logger log, PictureSketchV2 pa, Stabilo stabilo){
		this.log = log;
		this.pa = pa;
		this.stabilo = stabilo;
	}

	public void draw(PImage img, int strokeWeight, int penColor) {

		log.writeLogLine("[ CONTOUR ]");
		//log.writeLogLine("-----------------------------------------");
		log.writeLogLine(pa.getSource().getInfo());
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
			for (PVector point : contour.getPoints()) {
				pa.vertex(point.x, point.y);
			}
			pa.endShape();
		}
	}
}
