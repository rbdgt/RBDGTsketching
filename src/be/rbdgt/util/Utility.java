package be.rbdgt.util;

import java.util.ArrayList;

import be.rbdgt.objects.SketchLine;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Utility {

	private static int loopCount;
	// private static PImage input;

	public static int random(int max) {
		int range = (max - 0) + 1;
		return (int) (Math.random() * range) + 0;
	}

	public static int random(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	public static double delta(float sX, float sY, float eX, float eY) {
		return Math.sqrt((sX - eX) * (sX - eX) + (sY - eY) * (sY - eY));
	}

	public static ArrayList<PVector> initPointCloud(PImage img, int detColor, int particles) {
		new ArrayList<SketchLine>(); // TODO: find out what this does
		ArrayList<PVector> pointCloud = new ArrayList<PVector>();
		PVector[] targets = getTargets(img, detColor, particles); // get
																	// particlecloud
		for (int i = 0; i < targets.length; i++) {
		    if (targets[i].x!=0 && targets[i].y!=0) {
			pointCloud.add(targets[i]);
		    }
		}
		return pointCloud;
	}

	public static ArrayList<PVector> initSquarePointCloud(PImage img, int detColor, int iSide, int holes,
			int randomness) {
		ArrayList<PVector> squarePointCloud = new ArrayList<PVector>();

		for (int x = iSide; x < img.width - iSide; x = x + iSide) {
			for (int y = iSide; y < img.height - iSide; y = y + iSide) {
				PImage ap = img.get(x, y, iSide, iSide);
				if (ColorMethods.determineColor(ColorMethods.getAverageColor(ap), detColor) && random(0, 100) > holes) {
					//squarePointCloud = addPoint(x, y, randomness, iSide);
					squarePointCloud.add(new PVector(x+iSide/2+random(-randomness, randomness), y+iSide/2+random(-randomness, randomness)));
				}
			}
		}
		return squarePointCloud;
	}

//	private ArrayList addPoint(float x, float y, int randomness, int iSide) {
//		// if (!calibrate) {
//		if (false) {
//			iSide = 0;
//		}
//		float[][] location = new float[1][2];
//		location[0][0] = x + iSide / 2 + random(-randomness, randomness);
//		location[0][1] = y + iSide / 2 + random(-randomness, randomness);
//		points = (float[][]) append(points, location[0]);
//		pointcount++;
//		return 
//	}

	private static PVector[] getTargets(PImage img, int detColor, int n) {
		PVector[] targets = new PVector[n];
		// PVector pos;
		img.loadPixels();
		int width = img.width;
		int height = img.height;
		// System.out.println(input.pixels.length);
		// System.out.println(width + " - " + input.width + " - " + height + " -
		// " + input.height);
		for (int i = 0; i < targets.length; i++) {
			targets[i] = target(img.pixels, width, height, Utility.random(width), Utility.random(height), detColor);
		}
		return targets;
	}

	private static PVector target(int[] colors, int width, int height, int xPos, int yPos, int detColor) {
		PVector pos = new PVector(0, 0);
		int index = (yPos * width + xPos) % (width * height);
		// color c = colors[index];
		// PImage img = input.get(xPos-1, yPos-1, xPos+1, yPos+1);
		// if (determineColor(c, detColor)) {
		// System.out.println(yPos * width + xPos);
		if (ColorMethods.determineColor(colors[index], detColor)) {
			pos.x = xPos;
			pos.y = yPos;
			// p = true;
			// targetCount++;
			return pos;
		} else {
			loopCount++; // Amount of retries permitted
			if (loopCount > 3000) {
				pos.x = 0;
				pos.y = 0;
				loopCount = 0;
				return pos;
			}
			pos = target(colors, width, height, PApplet.parseInt(Utility.random(width)),
					PApplet.parseInt(Utility.random(height)), detColor);
		}
		return pos;
	}

	public static int shapeToInt(String shape) {
		final int CIRCLE = 0;
		final int TRIANGLE = 1;
		final int SQUARE = 2;

		switch (shape) {
		case "CIRCLE":
			return CIRCLE;
		case "TRIANGLE":
			return TRIANGLE;
		case "SQUARE":
			return SQUARE;
		default:
			System.out.println("Default shape CIRCLE chosen");
			return CIRCLE;
		}
	}

	public static int dirToInt(String shape) {
		final int L = 0;
		final int R = 1;
		final int V = 2;
		final int H = 3;

		switch (shape) {
		case "L":
			return L;
		case "R":
			return R;
		case "V":
			return V;
		case "H":
			return H;
		default:
			System.out.println("Default direction L chosen");
			return L;
		}
	}

}
