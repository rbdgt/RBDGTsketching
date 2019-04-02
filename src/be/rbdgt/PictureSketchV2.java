package be.rbdgt;

//import gab.opencv.OpenCV;
import be.rbdgt.customProcessingOCV.OpenCV;
import be.rbdgt.drawing.Dcontour;
import be.rbdgt.drawing.Dcrosses;
import be.rbdgt.drawing.Ddelaunay;
import be.rbdgt.drawing.DdelaunaySquares;
import be.rbdgt.drawing.Ddistortedlines;
import be.rbdgt.drawing.Dfacepattern;
import be.rbdgt.drawing.Dhoughlines;
import be.rbdgt.drawing.Dpoints;
import be.rbdgt.drawing.Dsketchlines;
import be.rbdgt.drawing.Dsquarehatch;
import be.rbdgt.drawing.Dsquares;
import be.rbdgt.drawing.Dvertex;
import be.rbdgt.util.Logger;
import be.rbdgt.util.Source;
import be.rbdgt.util.Stabilo;
import processing.core.PApplet;
import processing.core.PImage;
import processing.video.Movie;

public class PictureSketchV2 extends PApplet {

    OpenCV openCV;
    String[] arguments;
    private PImage original;

    private Stabilo stabilo = new Stabilo(this);

    private String filename;
    private String extension;
    private String folder;
    private String suffix;
    private String timestamp;

    private String outputFolder;

    private Logger log;

    private Source source = new Source(log, this);
    private Movie mov;
    private boolean fileIsMovie = false;
    private int fCount = 0;

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
    public Dsquares squares;
    public Dcrosses crosses;

    boolean saveSVG = true;
    boolean saveImage = true;

    boolean keypressedFlag = false;
    boolean useCameraFlag = false;
    
    float scale = 3;
    int setWidth = 800;

    Object[] instrArr;
    String[] fileData;

    public static void main(String args[]) {
	PApplet.main(new String[] { "be.rbdgt.PictureSketchV2" });
    }

    // public void runSketch(String[] fileData) {
    // setFile(fileData);
    // //Map sketch = Thread.getAllStackTraces();
    // }

    public void initSketch() {
	Instructions.setFile(this);
	log = new Logger(outputFolder, folder, filename, suffix, timestamp, false);
	source = new Source(log, this);

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
	squares = new Dsquares(log, this, stabilo);
	crosses = new Dcrosses(log, this, stabilo);
    }

    public void settings() {
	if (fileIsMovie) {
	    size(1280, 720);
	} else {
	    size(400, 400);
	}
    }

    public void setup() {
	initSketch();
	if (fileIsMovie) {
	    mov = new Movie(this, folder + "/" + filename + "." + extension);
	    mov.play();
	    mov.loop();
	} else {
	    original = loadImage(folder + "/" + filename + "." + extension);
	    resizeMethod();
	}
	background(255);
    }

    public void draw() {
	original.resize(width, height);
	image(original, 0, 0);
			
	if (keypressedFlag) {
	    background(255);
	    log.createLog("width: " + width + " / height: " + height);
	    if (saveSVG) {
		beginRecord(SVG, "/" + outputFolder + "/" + filename + "_" + suffix + timestamp + ".svg");
		println("Begin SVG record: ");
	    }
	    Instructions.draw(this);
	    if (saveSVG) {
		endRecord();
		println("End SVG record.");
		log.writeLogLine("SVG saved as: /" + outputFolder + "/" + filename + "_" + suffix + timestamp + ".svg");
	    }
	    if (saveImage) {
		save("/" + outputFolder + "/" + filename + "_" + suffix + timestamp + ".png");
		log.writeLogLine("PNG saved as: /" + outputFolder + "/" + filename + "_" + suffix + timestamp + ".png");
	    }
	    log.closeLog();
	    if (fileIsMovie) {
		loop();
	    } else {
		noLoop();
	    }
	    fCount++;
	    println("Frame " + fCount + " done!");
	}
    }
    
    public void keyPressed(){
	keypressedFlag = true;
    }
    
//    public void useCamera(boolean useCam){
//	useCameraFlag = useCam;
//    }
    
    public void showOriginalFirst(boolean flag){
	keypressedFlag = flag;
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

    public void setFile(String folder, String filename, String extension, String suffix, String outputFolder,
	    String timestamp) { // TODO
	// too
	// convoluted
	this.folder = folder;
	this.filename = filename;
	this.extension = extension;
	this.suffix = suffix;
	this.outputFolder = outputFolder;
	this.timestamp = timestamp;
	// if (extension.equalsIgnoreCase("mov")) {
	// fileIsMovie = true;
	// }
    }
}
