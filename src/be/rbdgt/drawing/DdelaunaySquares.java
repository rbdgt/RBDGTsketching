package be.rbdgt.drawing;

import java.util.ArrayList;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.util.Logger;
import be.rbdgt.util.Stabilo;
import be.rbdgt.util.Utility;
import megamu.mesh.Delaunay;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class DdelaunaySquares {

	// private static ArrayList<PVector> pointCloud;
	
	Logger log;
	PictureSketchV2 pa;
	Stabilo stabilo;
	
	public DdelaunaySquares(Logger log, PictureSketchV2 pa, Stabilo stabilo){
		this.log = log;
		this.pa = pa;
		this.stabilo = stabilo;
	}
	
	public void draw(PImage img, int strokeWeight, int detColor, int penColor, int minLength, int maxLength, int iSide, int holes, int randomness) {
		
		log.writeLogLine("[ DELAUNAY SQUARES]");
		//log.writeLogLine("-----------------------------------------");
		log.writeLogLine(pa.getSource().getInfo());
		log.writeLogLine("strokeWeight: " + strokeWeight);
		log.writeLogLine("detColor: " + stabilo.getColorName(detColor).toUpperCase());
		log.writeLogLine("penColor: " + stabilo.getColorName(penColor).toUpperCase());
		log.writeLogLine("minLength: " + minLength);
		log.writeLogLine("maxLength: " + maxLength);
		log.writeLogLine("iSide: " + iSide);
		log.writeLogLine("holes: " + holes);
		log.writeLogLine("randomness: " + randomness);
		log.writeLogLine("");
		
		ArrayList<PVector> pointCloud = Utility.initSquarePointCloud(img, detColor, iSide, holes, randomness);
		// println(targetCount, "targets found for", stabilo.getColorName(detColor), "in DELAUNAY-mode.");
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
				pa.strokeWeight(strokeWeight);
				pa.strokeCap(PConstants.ROUND);
				pa.noFill();
				pa.curveTightness(Utility.random(0, 0));
				pa.curve(startX, startY, startX, startY, endX, endY, endX, endY);
			}
			pa.endShape();
		}
	}

}