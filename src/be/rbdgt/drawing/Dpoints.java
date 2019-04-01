package be.rbdgt.drawing;

import java.util.ArrayList;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.util.Logger;
import be.rbdgt.util.Stabilo;
import be.rbdgt.util.Utility;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;

public class Dpoints {

    PShape s;
    String[] svgfiles; // String svgfolder =
		       // "C://Users//robin.de.groote//Dropbox//Resources//Processing
		       // Sketches//sketching//SVG";
    String svgfolder = "/SVG";

    Logger log;
    PictureSketchV2 pa;
    Stabilo stabilo;

    public Dpoints(Logger log, PictureSketchV2 pa, Stabilo stabilo) {
	this.log = log;
	this.pa = pa;
	this.stabilo = stabilo;
    }

    public void draw(PImage img, int strokeWeight, int penColor) {

    }

    // private String[] filesToArrayList(String dir) {
    // File file = new File(dir);
    // if (file.isDirectory()) {
    // String names[] = file.list();
    // return names;
    // } else { // If it\u2019s not a directory println("IT'S NOT A DIR");
    // return null;
    // }
    // }

    public void drawpoints(PImage img, int strokeWeight, int detColor, int penColor, int particles) {
	log.writeLogLine("[ DRAWPOINTS ]");
	// log.writeLogLine("-----------------------------------------");
	log.writeLogLine(pa.getSource().getInfo());
	log.writeLogLine("faceNr: " + strokeWeight);
	log.writeLogLine("detColor: " + stabilo.getColorName(detColor));
	log.writeLogLine("penColor: " + stabilo.getColorName(penColor));
	log.writeLogLine("particles: " + particles);
	log.writeLogLine("");

	pa.stroke(stabilo.s88(penColor), 180); // TODO: fix Alpha
	pa.strokeWeight(strokeWeight);
	pa.fill(0, 0, 0, 0);
	ArrayList<PVector> pointcloud = Utility.initPointCloud(img, detColor, particles);
	for (int i = 0; i < pointcloud.size(); i++) {
	    pa.point(pointcloud.get(i).x, pointcloud.get(i).y);
	}
    }

    public void drawshards(PImage img, int strokeWeight, int detColor, int penColor, int particles) {
	log.writeLogLine("[ DRAWSHARDS ]");
	// log.writeLogLine("-----------------------------------------");
	log.writeLogLine(pa.getSource().getInfo());
	log.writeLogLine("faceNr: " + strokeWeight);
	log.writeLogLine("detColor: " + stabilo.getColorName(detColor));
	log.writeLogLine("penColor: " + stabilo.getColorName(penColor));
	log.writeLogLine("particles: " + particles);
	log.writeLogLine("");

	pa.stroke(stabilo.s88(penColor), 180); // TODO: fix Alpha
	pa.strokeWeight(strokeWeight);
	pa.fill(0, 0, 0, 0);
	int tr = 20;
	ArrayList<PVector> pointcloud = Utility.initPointCloud(img, detColor, particles);
	for (int i = 0; i < pointcloud.size(); i++) {
	    pa.triangle(pointcloud.get(i).x + Utility.random(tr), pointcloud.get(i).y + Utility.random(tr),
		    pointcloud.get(i).x + Utility.random(tr), pointcloud.get(i).y + Utility.random(tr),
		    pointcloud.get(i).x + Utility.random(tr), pointcloud.get(i).y + Utility.random(tr));
	}
    }

    public void drawSVG(PImage img, int strokeWeight, int detColor, int penColor, int particles, int size) {
	log.writeLogLine("[ DRAWSVG ]");
	// log.writeLogLine("-----------------------------------------");
	log.writeLogLine(pa.getSource().getInfo());
	log.writeLogLine("faceNr: " + strokeWeight);
	log.writeLogLine("detColor: " + stabilo.getColorName(detColor));
	log.writeLogLine("penColor: " + stabilo.getColorName(penColor));
	log.writeLogLine("particles: " + particles);
	log.writeLogLine("size: " + size);
	log.writeLogLine("");

	s.disableStyle();
	pa.stroke(stabilo.s88(penColor), 180); // TODO: fix Alpha
	pa.strokeWeight(strokeWeight);
	pa.fill(0, 0, 0, 0);
	// s = loadShape(svgfolder+"/"+svgfiles[round(random(0,
	// svgfiles.length-1))]);
	// s = loadShape(svgfolder+"/star-full.svg");
	s = pa.loadShape(svgfolder + "/stop2.svg");
	// int tr = 20; int tr = (int)random(20,80);
	ArrayList<PVector> pointcloud = Utility.initPointCloud(img, detColor, particles);
	for (int i = 0; i < pointcloud.size(); i++) {
	    int width = size;
	    int height = size;
	    pa.shape(s, pointcloud.get(i).x, pointcloud.get(i).y, width, height);
	}
    }
}
