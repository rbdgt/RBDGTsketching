package be.rbdgt.drawing;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.util.ColorMethods;
import be.rbdgt.util.Logger;
import processing.core.PImage;
import stabilocolors.library.Stabilo;

public class Ddistortedlines {

	Logger log;
	PictureSketchV2 pa;
	Stabilo stabilo;

	private int blackBorderCompensation = 1;
	private int treshold = 120;
	private boolean continuous;
	private boolean invert;
	private float brightnessFactor = 0.1f;
	private float cTightnessVario = 0;

	public Ddistortedlines(Logger log, PictureSketchV2 pa, Stabilo stabilo) {
		this.log = log;
		this.pa = pa;
		this.stabilo = stabilo;
	}

	public void draw(PImage img, int strokeWeight, int penColor, int iSide, int treshold, float brightnessFactor, boolean invert, boolean brightnessUp, boolean continuous) {
		log.writeLogLine("[ DISTORTEDLINES ]");
		//log.writeLogLine("-----------------------------------------");
		log.writeLogLine("strokeWeight: " + strokeWeight);
		log.writeLogLine("penColor: " + stabilo.getColorName(penColor).toUpperCase());
		log.writeLogLine("iSide: " + iSide);
		log.writeLogLine("treshold: " + treshold);
		log.writeLogLine("brightnessFactor: " + brightnessFactor);
		log.writeLogLine("invert: " + invert);
		log.writeLogLine("brightnessUp: " + brightnessUp);
		log.writeLogLine("continuous: " + continuous);
		log.writeLogLine("");
		
		this.brightnessFactor = brightnessFactor;
		this.continuous = continuous;
		this.invert = invert;
		this.treshold = treshold;
		
		for (int y = 0; y < img.height - blackBorderCompensation; y = y + iSide) {
			pa.stroke(stabilo.s88(penColor, 180));
			pa.noFill();
			pa.beginShape();
			pa.strokeWeight(strokeWeight);
			for (int x = 0; x < img.width - blackBorderCompensation; x = x + iSide) {
				PImage ap = img.get(x, y, iSide, iSide);
				drawLine(x, y, ColorMethods.getAverageColor(ap), iSide, brightUp(brightnessUp));
			}
			pa.endShape();
		}
	}

	private void drawLine(int x, int y, int c, int iSide, int upOrDown) {
		
		int brightness;
		if (!invert) {
			brightness = -(Math.round(pa.brightness(c)) - 255);
		} else {
			brightness = Math.round(pa.brightness(c));
		}
		pa.curveTightness(cTightnessVario);
		pa.curveVertex(x, y + (pa.brightness(c) * (brightnessFactor)) * upOrDown);
		if (brightness < treshold && !continuous) {
			pa.endShape();
			pa.beginShape();
		}
	}

	private int brightUp(boolean bu) {
		if (bu) {
			return 1;
		} else {
			return -1;
		}
	}
}
