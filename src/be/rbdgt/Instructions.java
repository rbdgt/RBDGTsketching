package be.rbdgt;

import be.rbdgt.util.SC;
import be.rbdgt.util.Source;
import processing.core.PImage;

public class Instructions {

    private static final int CIRCLE = 0;
    private static final int TRIANGLE = 1;
    private static final int SQUARE = 2;

    private static final boolean INV = true;
    private static final int L = 0; // int for LEFT hatching
    private static final int R = 1; // int for RIGHT hatching
    private static final int V = 2; // int for VERTICAL hatching
    private static final int H = 3; // int for HORIZONTAL hatching
    private static final int RD = 4; // int for Random Diagonal hatching
    private static final int RHV = 5; // int for Random Horizontal/Vertical
				      // hatching
    private static final int ARAB = 6; // int for Arab pattern
    private static Source source;
    //private static Stabilo stabilo;

    public static void setFile(PictureSketchV2 pa) {
	pa.setFile("card", "kf2", "jpg", "face", "output");
    }

    public static void draw(PictureSketchV2 pa) {
	//stabilo = pa.getStabilo();
	source = pa.getSource();

	/*
	 * pa.facepattern.drawface(1, TRIANGLE, 180, 0, 0, 1, 60,
	 * SC.ULTRAMARINE, 100, RD); pa.delaunaySquares.draw(source.oi(false),
	 * 1, SC.BROWN, SC.APRICOT, 0, 10, 20, 5, 0);
	 * pa.contour.draw(source.fci(false, TRIANGLE, 0, -0, 50, 150), 1,
	 * SC.BLACK);
	 */

	// pa.facepattern.drawface(1, TRIANGLE, 45, 130, 120, 1, 60, SC.TURQUOISE, 100, RD);
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
	 pa.dlines.draw(source.fohi(false, TRIANGLE, 0, 0), 1, SC.APRICOT, 50, 10, 0.2f, false, false, false);
	// pa.vertex.draw(source.fchi(false, TRIANGLE, 0, -0, 0, 150), 1,
	// SC.BLACK);

	PImage img = source.ci(false, 20, 40);

	pa.contour.draw(source.cannyImage(false, 200, 500), 1, SC.LIGHTGREY);
	pa.delaunaySquares.draw(source.oi(false), 1, SC.ORANGE, SC.ORANGE, 0, 10, 20, 5, 0);
	pa.delaunaySquares.draw(source.oi(false), 1, SC.NIGHTBLUE, SC.TURQUOISE, 0, 10, 20, 5, 0);

    }
}
