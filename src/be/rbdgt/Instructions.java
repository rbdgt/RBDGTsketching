package be.rbdgt;

import be.rbdgt.util.Hatch;
import be.rbdgt.util.Shape;
import be.rbdgt.util.SC;
import be.rbdgt.util.Source;

public class Instructions {
   
    private static Source source;

    public static void setFile(PictureSketchV2 pa) {
	pa.setFile("faces", "male", "jpg", "01", "output", timestamp);
    }

    public static void draw(PictureSketchV2 pa) {
	source = pa.getSource();

	/*
	 * pa.facepattern.drawface(1, TRIANGLE, 180, 0, 0, 1, 60,
	 * SC.ULTRAMARINE, 100, RD); pa.delaunaySquares.draw(source.oi(false),
	 * 1, SC.BROWN, SC.APRICOT, 0, 10, 20, 5, 0);
	 * pa.contour.draw(source.fci(false, TRIANGLE, 0, -0, 50, 150), 1,
	 * SC.BLACK);
	 */

	pa.facepattern.drawface(1, Shape.TRIANGLE, 45, 130, 120, 1, 60, SC.TURQUOISE, 100, 1);
	// pa.delaunaySquares.draw(source.oi(false), 1, SC.BLACK, SC.APRICOT, 0, 10, 20, 5, 0);
	// pa.contour.draw(source.fci(false, TRIANGLE, -90, -0, 50, 150), 1,
	// SC.BLACK);
	// pa.contour.draw(source.fchi(false, TRIANGLE, 0, 0, 15, 250), 1,
	// SC.APRICOT);
	// pa.facepattern.drawface(1, CIRCLE, 45, 1, 0, SC.GREEN, 20, ARAB);
	// pa.delaunay.draw(source.oi(false), 1, SC.ROSE, SC.APRICOT, 2, 20,
	// 200);
	// pa.delaunaySquares.draw(source.oi(false), 1, SC.YELLOW, SC.LIGHTGREY,
	// 0, 10, 20, 5, 0);
	//pa.dlines.draw(source.fohi(false, Shape.triangle(), 0, 0), 1, SC.APRICOT, 50, 10, 0.2f, false, false, false);
	// pa.vertex.draw(source.fchi(false, TRIANGLE, 0, -0, 0, 150), 1,
	// SC.BLACK);

	//PImage img = source.ci(false, 20, 40);

	
	//pa.delaunaySquares.draw(source.oi(false), 1, SC.BLACK, SC.RED, 0, 10, 20, 5, 0);
	
	//pa.delaunaySquares.draw(source.oi(false), 1, SC.NIGHTBLUE, SC.TURQUOISE, 0, 10, 20, 5, 0);
	pa.contour.draw(source.cannyImage(false, 200, 500, 180), 1, SC.BLACK);
	//pa.contour.draw(source.cannyImage(false, 20, 40, 180), 1, SC.RED);
	
	//pa.contour.draw(source.cannyImage(false, 100, 250, 180), 1, SC.BLACK);
	//pa.sketchlines.draw(source.ohci(false), 1, SC.BLACK, SC.BLACK, 1000);
	
	//doomglitter(pa);
	
	//scribble(pa);

    }
    
    public static void scribble(PictureSketchV2 pa){
	pa.sketchlines.draw(source.oi(false), 1, SC.BLACK, SC.BLACK, 2000);
	pa.sketchlines.draw(source.oi(false), 1, SC.ROSE, SC.CRIMSONRED, 2000);
    }
    
    public static void doomglitter(PictureSketchV2 pa){
	pa.background(0);
	//pa.delaunaySquares.draw(source.oi(false), 1, SC.ORANGE, SC.GOLD, 0, 10, 20, 0, 5);
	pa.squares.draw(source.originalImage(false), 1, SC.SILVER, 3, 180, 4, 20);
	pa.crosses.draw(source.originalImage(false), 1, SC.ORANGE, SC.GOLD, Hatch.HORIZONTAL, 300, 40, 80, 0);
    }
}
