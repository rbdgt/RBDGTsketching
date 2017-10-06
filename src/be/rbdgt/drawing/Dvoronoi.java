package be.rbdgt.drawing;

import java.util.ArrayList;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.util.Logger;
import be.rbdgt.util.Utility;
import megamu.mesh.Delaunay;
import megamu.mesh.Voronoi;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;
import stabilocolors.library.Stabilo;

public class Dvoronoi {

	// private static ArrayList<PVector> pointCloud;

	Logger log;
	PictureSketchV2 pa;
	Stabilo stabilo;

	public Dvoronoi(Logger log, PictureSketchV2 pa, Stabilo stabilo) {
		this.log = log;
		this.pa = pa;
		this.stabilo = stabilo;
	}

	public void draw(PImage img, int sWeight, int detColor, int penColor, int minLength, int maxLength,
			int particles) {
		// writeLogLine("drawContour(" + contourType + ", " + sWeight + ", " +
		// detColor + ", " + penColor + ", "
		// + maxLength + ", " + particles + ")");
		// targetCount = 0;
		// sketch = false;
		ArrayList<PVector> pointCloud = Utility.initPointCloud(img, detColor, particles);
		// println(targetCount, "targets found for",
		// stabilo.getColorName(detColor), "in DELAUNAY-mode.");
		float[][] points = new float[pointCloud.size()][2];
		for (int i = 0; i < pointCloud.size(); i++) {
			points[i][0] = pointCloud.get(i).x;
			points[i][1] = pointCloud.get(i).y;
		}
		Delaunay md = new Delaunay(points);
		// Voronoi md = new Voronoi(points);
		float[][] myEdges = md.getEdges();
		pa.beginShape();
		for (int i = 0; i < myEdges.length; i++) {
			float startX = myEdges[i][0];
			float startY = myEdges[i][1];
			float endX = myEdges[i][2];
			float endY = myEdges[i][3];
			if (!(Utility.delta(startX, startY, endX, endY) > maxLength * 3)
					&& !(Utility.delta(startX, startY, endX, endY) < minLength)) {
				pa.stroke(stabilo.s88(penColor), 180); // TODO fix Alpha
				pa.strokeWeight(sWeight);
				pa.strokeCap(PConstants.ROUND);
				pa.noFill();
				pa.curveTightness(Utility.random(0, 0));
				pa.curve(startX, startY, startX, startY, endX, endY, endX, endY);
			}
			pa.endShape();
		}
	}

}