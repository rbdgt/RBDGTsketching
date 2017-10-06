package be.rbdgt.drawing;

import java.util.ArrayList;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.objects.SketchLine;
import be.rbdgt.util.Logger;
import be.rbdgt.util.Utility;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;
import stabilocolors.library.Stabilo;

public class Dsketchlines {

	private static ArrayList<SketchLine> penlines =  new ArrayList<SketchLine>();
	private static ArrayList<PVector> pointCloud;
	private static int width;
	private static int height;
	private static PApplet papplet;

	Logger log;
	PictureSketchV2 pa;
	Stabilo stabilo;

	public Dsketchlines(Logger log, PictureSketchV2 pa, Stabilo stabilo) {
		this.log = log;
		this.pa = pa;
		this.stabilo = stabilo;
	}

	public void draw(PImage img, int strokeWeight, int detColor, int penColor, int particles) {

		log.writeLogLine("[ SKETCHLINES ]");
		// log.writeLogLine("-----------------------------------------");
		log.writeLogLine("strokeWeight: " + strokeWeight);
		log.writeLogLine("detColor: " + stabilo.getColorName(detColor).toUpperCase());
		log.writeLogLine("penColor: " + stabilo.getColorName(penColor).toUpperCase());
		log.writeLogLine("particles: " + particles);
		log.writeLogLine("");

		// println(targetCount, "targets found for",
		// stabilo.getColorName(detColor), "in SKETCH-mode.");
		papplet = pa;
		width = pa.getWidth();
		height = pa.getHeight();
		pointCloud = Utility.initPointCloud(img, detColor, particles);

		// pa.fill(0, 0, 0, 0);
		pa.noFill();
		pa.stroke(stabilo.s88(penColor), 180); // TODO fix Alpha
		pa.strokeWeight(strokeWeight);
		pa.strokeCap(PConstants.ROUND);
		for (int i = 0; i < particles; i++) {
			createConnection(0);
		}
		for (int i = 0; i < penlines.size(); i++) {
			penlines.get(i).drawSmooth();
		}
	}

	private void createConnection(int cMode) {
		// System.out.println("pointCloud.size(): " + pointCloud.size());

		if (penlines.size() == 0 && pointCloud.size() > 2) {
			PVector start, end;
			int startindex = Utility.random(pointCloud.size());
			start = pointCloud.get(startindex);
			pointCloud.remove(startindex);
			int endindex = getClosestIndex(start, pointCloud);
			end = pointCloud.get(endindex);
			pointCloud.remove(endindex);
			penlines.add(new SketchLine(papplet, start, end));
			// lines.get(lines.size()-1).setStrokeWeightAndColor(input.pixels,
			// input.width, input.height);
		} else if (pointCloud.size() > 0) {
			PVector start = penlines.get(penlines.size() - 1).end, end;
			int index = cMode == 0 ? getClosestIndex(start, 7, pointCloud) : getClosestIndex(start, pointCloud);
			end = pointCloud.get(index);
			pointCloud.remove(index);
			penlines.add(new SketchLine(papplet, start, end));
			// lines.get (lines.size()-1).setStrokeWeightAndColor(input.pixels,
			// input.width, input.height);
		}
	}

	private int getClosestIndex(PVector start, ArrayList<PVector> lookup) {
		float closestDist = width * height;
		int closestIndex = 0;

		float dis = 0;
		for (int i = 0; i < lookup.size(); i++) {
			dis = PVector.dist(start, lookup.get(i));
			if (dis < closestDist) {
				closestDist = dis;
				closestIndex = i;
			}
		}
		return closestIndex;
	}

	private int getClosestIndex(PVector start, int n, ArrayList<PVector> lookup) {
		float[] closestDist = new float[n];
		int[] closestIndex = new int[n];

		for (int i = 0; i < n; i++) {
			closestDist[i] = width * height;
			closestIndex[i] = 0;
		}

		float dis = 0;
		float disMin = width * height, disMax = disMin * 2;

		for (int i = 0; i < lookup.size(); i++) {
			dis = PVector.dist(start, lookup.get(i));
			if (dis < disMin) {
				disMin = dis;
				closestDist[0] = dis;
				closestIndex[0] = i;
			} else if (dis > disMin && dis < disMax) {
				int index = i;
				for (int j = 0; j < n - 1; j++) {
					if (closestDist[j] < dis && closestDist[j + 1] > dis) {
						index = j + 1;
						// println (index);
						break;
					}
				}

				for (int j = n - 1; j > 0; j--) {
					if (j == index) {
						closestDist[j] = dis;
						closestIndex[j] = i;
						break;
					} else {
						if (j > 1) {
							closestIndex[j] = closestIndex[j - 1];
							closestDist[j] = closestDist[j - 1];
						}
					}
				}
				// println(closestDist);
				disMax = closestDist[n - 1];
			}
		}
		// System.out.println("closestindex.length: " + closestIndex.length);
		int index = closestIndex[(int) Utility.random(n) % closestIndex.length]; // EDITED:
		// DIFFERENT
		// FROM
		// PROCESSING
		// System.out.println("index: " + index);
		return index;
	}

}
