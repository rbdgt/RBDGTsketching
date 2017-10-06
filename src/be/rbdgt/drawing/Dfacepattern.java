package be.rbdgt.drawing;

import java.awt.Rectangle;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.objects.Polyfill;
import be.rbdgt.objects.Polygon;
import be.rbdgt.util.Logger;
import gab.opencv.OpenCV;
import stabilocolors.library.Stabilo;

public class Dfacepattern {

	Logger log;
	PictureSketchV2 pa;
	Stabilo stabilo;
	Polygon poly;

	public Dfacepattern(Logger log, PictureSketchV2 pa, Stabilo stabilo) {
		this.log = log;
		this.pa = pa;
		this.stabilo = stabilo;
	}

	public void drawfaces(int faceNr, int shape, int rotation, int displaceX, int displaceY, int strokeWeight, int shrink, int penColor,
			int tileCount, int patternNr) {
		System.out.println("FACES");
		poly = new Polygon(shape);
		log.writeLogLine("[ FACEPATTERN (multiple) ]");
		// log.writeLogLine("-----------------------------------------");
		log.writeLogLine("faceNr: " + faceNr);
		log.writeLogLine("shape: " + poly.getShapeName(shape));
		log.writeLogLine("rotation: " + rotation + "°");
		log.writeLogLine("strokeWeight: " + strokeWeight);
		log.writeLogLine("shrink: " + shrink);
		log.writeLogLine("penColor: " + stabilo.getColorName(penColor).toUpperCase());
		log.writeLogLine("tileCount: " + tileCount);
		log.writeLogLine("");

		Rectangle[] faces;
		OpenCV ocv = new OpenCV(pa, pa.getOriginal());
		ocv.loadCascade(OpenCV.CASCADE_FRONTALFACE);
		faces = ocv.detect();
		for (int i = 0; i < faces.length; i++) {
			float x = (faces[i].x + displaceX + (faces[i].width + (shrink * 2)) / 2) - (shrink);
			float y = (faces[i].y + displaceY + (faces[i].height + (shrink * 2)) / 2) - (shrink);

			 //float x = faces[i].x;
			 //float y = faces[i].y;
			poly = new Polygon(shape);
			poly.drawPoly(pa.g, false, x, y, faces[i].height + shrink * 2, rotation);
			Polyfill pf = new Polyfill(pa, pa.g, poly, tileCount, 0, 0, stabilo.s88(penColor));
			
			//pf.setStrokeColor(penColor);
			pf.setStrokeWeight(strokeWeight);
			// pf.randomGrid(faces[i].width, faces[i].height);
			//int rasterSize = Math.max(pa.g.width, pa.g.height);
			//pf.randomGrid(pa.g, rasterSize, rasterSize);
			// pf.arab(g, rasterSize, rasterSize);
			pickPattern(pf, patternNr);
		}
	}

	public void drawface(int faceNr, int shape, int rotation, int displaceX, int displaceY, int strokeWeight, int shrink, int penColor,
			int tileCount, int patternNr) {
		System.out.println("FACE");
		poly = new Polygon(shape);

		Rectangle[] faces;
		OpenCV ocv = new OpenCV(pa, pa.getOriginal());
		ocv.loadCascade(OpenCV.CASCADE_FRONTALFACE);
		faces = ocv.detect();
		if (faces.length-1 < faceNr) {
			drawfaces(0, shape, rotation, displaceX, displaceY, strokeWeight, shrink, penColor, tileCount, patternNr);
			//faceNr = 0;
		} else {
			log(faceNr, shape, rotation, strokeWeight, shrink, penColor, tileCount);
			float x = (faces[faceNr].x + displaceX + (faces[faceNr].width + (shrink * 2)) / 2) - (shrink);
			float y = (faces[faceNr].y + displaceY + (faces[faceNr].height + (shrink * 2)) / 2) - (shrink);

			poly.drawPoly(pa.g, false, x, y, faces[faceNr].height + shrink * 2, rotation);

			Polyfill pf = new Polyfill(pa, pa.g, poly, tileCount, 0, 0, stabilo.s88(penColor));
			//pf.setStrokeColor(penColor);
			pf.setStrokeWeight(strokeWeight);
			// pf.randomGrid(faces[i].width, faces[i].height);
			//int rasterSize = Math.max(pa.g.width, pa.g.height);
			//pf.randomGrid(pa.g, rasterSize, rasterSize);
			//pf.arab(pa.g, rasterSize, rasterSize);
			pickPattern(pf, patternNr);
		}
	}
	
	private void pickPattern(Polyfill pf, int patternNr){
		int rasterSize = Math.max(pa.g.width, pa.g.height);
		switch(patternNr){
			case 0:
				pf.hatchLeft(pa.g);
				break;
			case 1:
				pf.hatchRight(pa.g);
				break;
			case 2:
				pf.hatchVertical(pa.g);
				break;
			case 3:
				pf.hatchHorizontal(pa.g);
				break;
			case 4:
				pf.randomDiagGrid(pa.g, rasterSize, rasterSize);
				break;
			case 5:
				pf.randomHVGrid(pa.g, rasterSize, rasterSize);
				break;
			case 6:
				pf.arab(pa.g, rasterSize, rasterSize);
				break;
		}	
	}

	private void log(int faceNr, int shape, int rotation, int strokeWeight, int shrink, int penColor, int tileCount) {
		log.writeLogLine("[ FACEPATTERN ]");
		// log.writeLogLine("-----------------------------------------");
		log.writeLogLine("faceNr: " + faceNr);
		log.writeLogLine("shape: " + poly.getShapeName(shape));
		log.writeLogLine("rotation: " + rotation);
		log.writeLogLine("strokeWeight: " + strokeWeight);
		log.writeLogLine("shrink: " + shrink);
		log.writeLogLine("penColor: " + stabilo.getColorName(penColor));
		log.writeLogLine("tileCount: " + tileCount);
		log.writeLogLine("");
	}
}
