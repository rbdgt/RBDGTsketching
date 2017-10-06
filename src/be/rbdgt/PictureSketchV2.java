package be.rbdgt;

import java.lang.reflect.Method;
import java.util.Map;

import be.rbdgt.drawing.Dcontour;
import be.rbdgt.drawing.Ddelaunay;
import be.rbdgt.drawing.DdelaunaySquares;
import be.rbdgt.drawing.Ddistortedlines;
import be.rbdgt.drawing.Dfacepattern;
import be.rbdgt.drawing.Dhoughlines;
import be.rbdgt.drawing.Dpoints;
import be.rbdgt.drawing.Dsketchlines;
import be.rbdgt.drawing.Dsquarehatch;
import be.rbdgt.drawing.Dvertex;
import be.rbdgt.gui.RBDGTgui;
import be.rbdgt.objects.instructions.InstructionObject;
import be.rbdgt.util.Logger;
import be.rbdgt.util.Source;
import gab.opencv.OpenCV;
import processing.core.PApplet;
import processing.core.PImage;
import stabilocolors.library.Stabilo;

public class PictureSketchV2 extends PApplet {

	private final int CIRCLE = 0;
	private final int TRIANGLE = 1;
	private final int SQUARE = 2;
	private final boolean INV = true;
	private final int L = 0; // int for LEFT hatching
	private final int R = 1; // int for RIGHT hatching
	private final int V = 2; // int for VERTICAL hatching
	private final int H = 3; // int for HORIZONTAL hatching

	OpenCV openCV;
	String[] arguments;
	private PImage original;

	private Stabilo stabilo = new Stabilo(this);

	private String filename;
	private String extension;
	private String folder;
	private String suffix;

	private String outputFolder;

	// private Logger log = new Logger(folder, filename, suffix, false);
	private Logger log;

	private Source source = new Source(log, this);

	// public Parser parser = new Parser(this, source, stabilo);
	// public Dcontour contour = new Dcontour(log, this, stabilo);
	// public Ddelaunay delaunay = new Ddelaunay(log, this, stabilo);
	// public DdelaunaySquares delaunaySquares = new DdelaunaySquares(log, this,
	// stabilo);
	// public Dfacepattern facepattern = new Dfacepattern(log, this, stabilo);
	// public Dhoughlines houghlines = new Dhoughlines(log, this, stabilo);
	// public Dpoints points = new Dpoints(log, this, stabilo);
	// public Dsketchlines sketchlines = new Dsketchlines(log, this, stabilo);
	// public Dsquarehatch squarehatch = new Dsquarehatch(log, this, stabilo);
	// public Dvertex vertex = new Dvertex(log, this, stabilo);
	// public Ddistortedlines dlines = new Ddistortedlines(log, this, stabilo);

	public Parser parser;
	public Dcontour contour;
	public Ddelaunay delaunay;
	public DdelaunaySquares delaunaySquares;
	public Dfacepattern facepattern;
	public Dhoughlines houghlines;
	public Dpoints points;
	public Dsketchlines sketchlines;
	public Dsquarehatch squarehatch;
	public Dvertex vertex;
	public Ddistortedlines dlines;

	boolean saveSVG = true;
	boolean saveImage = true;

	float scale = 3;
	int setWidth = 800;

	// InstructionsObject instobj;
	Object[] instrArr;
	String[] fileData;

	public static void main(String args[]) {
		PApplet.main(new String[] { "be.rbdgt.PictureSketchV2" });
	}



	public void runSketch(String[] fileData) {

		setFile(fileData);
		Map sketch = Thread.getAllStackTraces();
	}



	public void initSketch() {
		Instructions.setFile(this);
		log = new Logger(outputFolder, folder, filename, suffix, false);
		source = new Source(log, this);
		parser = new Parser(this, source, stabilo);
		contour = new Dcontour(log, this, stabilo);
		delaunay = new Ddelaunay(log, this, stabilo);
		delaunaySquares = new DdelaunaySquares(log, this, stabilo);
		facepattern = new Dfacepattern(log, this, stabilo);
		houghlines = new Dhoughlines(log, this, stabilo);
		points = new Dpoints(log, this, stabilo);
		sketchlines = new Dsketchlines(log, this, stabilo);
		squarehatch = new Dsquarehatch(log, this, stabilo);
		vertex = new Dvertex(log, this, stabilo);
		dlines = new Ddistortedlines(log, this, stabilo);

	}

	private void parseArgs() {
		if (args != null) {
			parser.parseInstr(args);
		}
	}

	public void settings() {
		size(400, 400);
	}

	public void setup() {
		initSketch();
		original = loadImage(folder + "/" + filename + "." + extension);
		background(255);
		resizeMethod();

	}

	public void draw() {
		original.resize(width, height);
		log.createLog();
		log.writeLogLine("width: " + width + " / height: " + height);
		log.writeLogLine("");
		if (saveSVG) {
			beginRecord(SVG, "/" + outputFolder + "/" + filename + "_" + suffix + ".svg");
			println("Begin SVG record: ");
		}

		Instructions.draw(this);

		if (saveSVG) {
			endRecord();
			println("End SVG record.");
			log.writeLogLine("SVG saved as: /" + outputFolder + "/" + filename + "_" + suffix + ".svg");
		}

		if (saveImage) {
			save("/" + outputFolder + "/" + filename + "_" + suffix + ".png");
			log.writeLogLine("PNG saved as: /" + outputFolder + "/" + filename + "_" + suffix + ".png");
		}

		log.closeLog();
		noLoop();
		println("DONE!");
	}

	private void resizeMethod() {
		surface.setResizable(true);
		if (setWidth > 0) {
			surface.setSize(setWidth, round(original.height / ((float) original.width / setWidth)));
		} else {
			surface.setSize(round(original.width * scale), round(original.height * scale));
		}
	}

	public PImage getOriginal() {
		return this.original;
	}

	public OpenCV getOpenCV() {
		return openCV;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public Source getSource() {
		return this.source;
	}

	public Ddelaunay getDelaunay() {
		return this.delaunay;
	}

	public Dcontour getContour() {
		return this.contour;
	}

	public Dfacepattern getFacepattern() {
		return this.facepattern;
	}

	public Dhoughlines getHoughlines() {
		return this.houghlines;
	}

	public Dpoints getPoints() {
		return this.points;
	}

	public Dsketchlines getSketchlines() {
		return this.sketchlines;
	}

	public Dsquarehatch getSquarehatch() {
		return this.squarehatch;
	}

	public Dvertex getVertex() {
		return vertex;
	}

	public Stabilo getStabilo() {
		return this.stabilo;
	}

	public Source getsource() {
		return this.source;
	}

	public void setFile(String folder, String filename, String extension, String suffix, String outputFolder) { // TODO
																												// too
																												// convoluted
		this.folder = folder;
		this.filename = filename;
		this.extension = extension;
		this.suffix = suffix;
		this.outputFolder = outputFolder;
	}

	public void setFile(String[] fd) { // TODO
		// too
		// convoluted
		this.folder = fd[0];
		this.filename = fd[1];
		this.extension = fd[2];
		this.suffix = fd[3];
		this.outputFolder = fd[4];
	}
}
