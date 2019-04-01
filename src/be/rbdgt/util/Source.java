package be.rbdgt.util;

import java.awt.Rectangle;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.objects.Polygon;
import be.rbdgt.customProcessingOCV.OpenCV;
//import gab.opencv.OpenCV;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

public class Source {

	// TODO: Look into relevance of contourType variable

	Logger log;
	PictureSketchV2 pa;
	String info = "no info available";
	Polygon poly;

	int lCanny = 50;
	int rCanny = 150;
	PImage original;
	
	public String getInfo(){
		return this.info;
	}

	public Source(Logger log, PictureSketchV2 pa) {
		this.log = log;
		this.pa = pa;
	}

	public PImage oi(boolean invert) {
		return originalImage(invert);
	}

	public PImage ohci(boolean invert) {
		return originalHighContrastImage(invert);
	}

	public PImage foi(boolean invert, int shape, int rotation, int shrink) {
		return facesOriginalImage(invert, shape, rotation, shrink);
	}

	public PImage fohi(boolean invert, int shape, int rotation, int shrink) {
		return facesOriginalHollowImage(invert, shape, rotation, shrink);
	}

	public PImage fohci(boolean invert, int shape, int rotation, int shrink) {
		return facesOriginalHighContrastImage(invert, shape, rotation, shrink);
	}

	public PImage fci(boolean invert, int shape, int rotation, int shrink, int lC, int rC, int tH) {
		return facesCannyImage(invert, shape, rotation, shrink, lC, rC, tH);
	}

	public PImage fchi(boolean invert, int shape, int rotation, int shrink, int lC, int rC, int tH) {
		return facesCannyHollowImage(invert, shape, rotation, shrink, lC, rC, tH);
	}

	public PImage ci(boolean invert, int lC, int rC, int tH) {
		return cannyImage(invert, lC, rC, tH);
	}

	/*public ArrayList<Contour> originalArraylist(PictureSketchV2 pa, boolean invert) {
		OpenCV openCV = new OpenCV(pa, pa.getOriginal());
		if (invert) {
			openCV.invert();
		}
		return openCV.findContours();
	}*/

	public PImage originalImage(boolean invert) {
		this.info = "oi("+invert+")";
		PImage input = pa.getOriginal();
		if (invert) {
			input.filter(PConstants.INVERT);
		}
		return input;
	}

	public PImage originalHighContrastImage(boolean invert) {
		this.info = "ohci("+invert+")";
		PImage input = pa.getOriginal();
		input.filter(PConstants.THRESHOLD);
		if (invert) {
			input.filter(PConstants.INVERT);
		}
		return input;
	}

	public PImage facesOriginalImage(boolean invert, int shape, int rotation, int shrink) {
		PImage input = faceImage(shape, rotation, shrink);
		this.info = "foi("+invert+", "+poly.getShapeName(shape)+", "+rotation+", "+shrink+")";
		if (invert) {
			input.filter(PConstants.INVERT);
		}
		return input;
	}

	public PImage facesOriginalHollowImage(boolean invert, int shape, int rotation, int shrink) {
		PImage input = faceImageHollow(shape, rotation, shrink);
		this.info = "fohi("+invert+", "+poly.getShapeName(shape)+", "+rotation+", "+shrink+")";

		if (invert) {
			input.filter(PConstants.INVERT);
		}
		return input;
	}

	public PImage facesOriginalHighContrastImage(boolean invert, int shape, int rotation,
			int shrink) {
		PImage input = faceImage(shape, rotation, shrink);
		this.info = "fohci("+invert+", "+poly.getShapeName(shape)+", "+rotation+", "+shrink+")";
		input.filter(PConstants.THRESHOLD);
		if (invert) {
			input.filter(PConstants.INVERT);
		}
		return input;
	}

	public PImage facesCannyImage(boolean invert, int shape, int rotation, int shrink, int lC,
			int rC, int threshold) {
		OpenCV openCV = new OpenCV(pa, faceImage(shape, rotation, shrink));
		this.info = "fci("+invert+", "+poly.getShapeName(shape)+", "+rotation+", "+shrink+", "+lC+", "+rC+")";
		openCV.threshold(threshold);
		openCV.findCannyEdges(lC, rC);
		if (invert) {
			openCV.invert();
		}
		return openCV.getSnapshot();
	}

	public PImage facesCannyHollowImage(boolean invert, int shape, int rotation, int shrink, int lC,
			int rC, int threshold) {
		OpenCV openCV = new OpenCV(pa, faceImageHollow(shape, rotation, shrink));
		this.info = "fchi("+invert+", "+poly.getShapeName(shape)+", "+rotation+", "+shrink+", "+lC+", "+rC+")";
		openCV.threshold(threshold);
		openCV.findCannyEdges(lC, rC);
		if (invert) {
			openCV.invert();
		}
		return openCV.getSnapshot();
	}

	public PImage cannyImage(boolean invert, int lC, int rC, int threshold) {
		OpenCV openCV = new OpenCV(pa, pa.getOriginal());
		this.info = "ci("+invert+", "+lC+", "+rC+")";
		openCV.threshold(threshold);
		openCV.findCannyEdges(lC, rC);
		if (invert) {
			openCV.invert();
		}
		
		return openCV.getSnapshot();
	}

	private PImage faceImage(int shape, int rotation, int shrink) {
		Rectangle[] faces;
		OpenCV ocv = new OpenCV(pa, pa.getOriginal());
		ocv.loadCascade(OpenCV.CASCADE_FRONTALFACE);
		faces = ocv.detect();
		PGraphics output = pa.createGraphics(pa.width, pa.height);
		output.beginDraw();
		for (int i = 0; i < faces.length; i++) {
			PImage face = pa.getOriginal().get(faces[i].x - shrink, faces[i].y - shrink, faces[i].width + (shrink * 2),
					faces[i].height + (shrink * 2));
			face.mask(imagemask(pa, shape, rotation, faces[i].x - shrink, faces[i].y - shrink,
					faces[i].width + (shrink * 2), faces[i].height + (shrink * 2)));
			output.image(face, faces[i].x - shrink, faces[i].y - shrink);
		}
		output.endDraw();
		PImage faceimg = output.get();
		return faceimg;
	}

	private PImage faceImageHollow(int shape, int rotation, int shrink) {
		Rectangle[] faces;
		OpenCV ocv = new OpenCV(pa, pa.getOriginal());
		ocv.loadCascade(OpenCV.CASCADE_FRONTALFACE);
		faces = ocv.detect();
		PGraphics output = pa.createGraphics(pa.width, pa.height);
		output.beginDraw();
		output.image(pa.getOriginal(), 0, 0);
		for (int i = 0; i < faces.length; i++) {
			pa.fill(255);
			pa.noStroke();
			drawShape(output, shape, rotation, shrink, faces[i].x, faces[i].y, faces[i].width, faces[i].height);
		}
		output.endDraw();
		PImage faceimg = output.get();
		return faceimg;
	}

	private PGraphics imagemask(PictureSketchV2 pa, int shape, int rotation, int x, int y, int w, int h) {
		PGraphics mask = pa.createGraphics(w, h, PConstants.JAVA2D);
		int shrink = 0;
		mask.beginDraw();
		mask.fill(255);
		mask.noStroke();
		drawShape(mask, shape, rotation, shrink, 0, 0, w, h);
		mask.filter(PConstants.BLUR, 0);
		mask.endDraw();
		return mask;
	}

	private void drawShape(PGraphics output, int shape, int rotation, int shrink, int x, int y, int w, int h) {
		switch (shape) {
		case 0:
			poly = new Polygon(shape);
			poly.drawPoly(output, true, x + w / 2, y + h / 2, h - shrink, rotation);
			break;
		case 1:
			poly = new Polygon(shape);
			poly.drawPoly(output, true, x + w / 2, y + h / 2, h - shrink, rotation);
			break;
		case 2:
			poly = new Polygon(shape);
			poly.drawPoly(output, true, x + w / 2, y + h / 2, h - shrink, rotation);
			break;
		}
	}
}