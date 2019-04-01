package be.rbdgt.drawing;

import java.util.ArrayList;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.util.Logger;
import be.rbdgt.util.Stabilo;
import gab.opencv.Line;
import gab.opencv.OpenCV;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Dhoughlines {

	Logger log;
	PictureSketchV2 pa;
	Stabilo stabilo;

	public Dhoughlines(Logger log, PictureSketchV2 pa, Stabilo stabilo) {
		this.log = log;
		this.pa = pa;
		this.stabilo = stabilo;
	}

	public void draw(PImage img, int strokeWeight, int penColor, int threshold, int minLength, int maxLineGap,
			int loRadians, int hiRadians) {

		log.writeLogLine("[ HOUGHLINES ]");
		// log.writeLogLine("-----------------------------------------");
		log.writeLogLine("strokeWeight: " + strokeWeight);
		log.writeLogLine("penColor: " + stabilo.getColorName(penColor).toUpperCase());
		log.writeLogLine("threshold: " + threshold);
		log.writeLogLine("minLength: " + minLength);
		log.writeLogLine("maxLineGap: " + maxLineGap);
		log.writeLogLine("loRadians: " + loRadians);
		log.writeLogLine("hiRadians: " + hiRadians);
		log.writeLogLine("");

		OpenCV openCV = new OpenCV(pa, img);
		ArrayList<Line> foundLines = openCV.findLines(threshold, minLength, maxLineGap);
		pa.strokeWeight(strokeWeight);
		pa.stroke(stabilo.s88(penColor), 180); // TODO fix Alpha
		pa.strokeCap(PConstants.ROUND);
		for (Line line : foundLines) {
			if (line.angle >= PApplet.radians(loRadians) && line.angle <= PApplet.radians(hiRadians)) {
				pa.line(line.start.x, line.start.y, line.end.x, line.end.y);
			}
		}
	}

	public void draw(Logger log, PictureSketchV2 pa, Stabilo stabilo, PImage img, int penColor, int strokeWeight,
			int threshold, int minLength, int maxLineGap, int exactRadians) {
		draw(img, penColor, strokeWeight, threshold, minLength, maxLineGap, exactRadians, exactRadians);
	}

}
