package be.rbdgt;

import java.lang.reflect.Method;
import java.util.ArrayList;

import be.rbdgt.util.SC;
import be.rbdgt.util.Source;
import stabilocolors.library.Stabilo;

public class InstructionsObject {

	private final int CIRCLE = 0;
	private final int TRIANGLE = 1;
	private final int SQUARE = 2;

	private final boolean INV = true;
	private final int L = 0; // int for LEFT hatching
	private final int R = 1; // int for RIGHT hatching
	private final int V = 2; // int for VERTICAL hatching
	private final int H = 3; // int for HORIZONTAL hatching
	private final int RD = 4; // int for Random Diagonal hatching
	private final int RHV = 5; // int for Random Horizontal/Vertical hatching
	private final int ARAB = 6; // int for Arab pattern
	private Source source;
	private Stabilo stabilo;

	Method method;
	//Runnable runnablemethod;

	ArrayList<Runnable> runnableList = new ArrayList<Runnable>();
	Method[] methodlist;

	public InstructionsObject() {

	}

	public void setFile(PictureSketchV2 pa) {
		pa.setFile("faces", "assad", "jpg", "face", "test");
	}

	public void makeInstructions(PictureSketchV2 pa) {
		runnableList.add(() -> pa.facepattern.drawface(1, TRIANGLE, 90, 0, 0, 1, 40, SC.RED, 200, RD));
		runnableList.add(() -> pa.contour.draw(source.ohci(true), 1, SC.BLACK));
	}

	public void draw(PictureSketchV2 pa) {
		stabilo = pa.getStabilo();
		source = pa.getSource();

		for (Runnable r : runnableList){
			r.run();
		}

		// pa.facepattern.drawface(1, TRIANGLE, 90, 1, 40, SC.RED, 200, RD);
		// pa.delaunay.draw(source.oi(false), 1, SC.BLACK, SC.RED, 2, 20, 1000);
		// pa.delaunaySquares.draw(source.oi(false), 1, SC.RED, SC.GREEN, 0, 10,
		// 20, 10, 3);
		// pa.dlines.draw(source.fohi(false, CIRCLE, 180, 0), 1, SC.BLACK, 4,
		// 200, 0.2f, false, false, false);
		// pa.vertex.draw(source.fchi(false, TRIANGLE, 45, -70, 0, 150), 1,
		// SC.BLACK);
		// pa.contour.draw(source.fci(false, TRIANGLE, 45, -70, 50, 150), 1,
		// SC.BLACK);

		// pa.contour.draw(source.ohci(true), 1, SC.BLACK);

		// pa.houghlines.draw(source.fci(false, SQUARE, 45, 0, 50, 150), 1,
		// SC.RED, 20, 5, 100, 0, 180);
		// pa.sketchlines.draw(source.fohci(true, TRIANGLE, 45, 0), 1, SC.BLACK,
		// SC.RED, 500);
		// pa.squarehatch.draw(source.ohci(true), 1, SC.BLACK, SC.BLACK, 40, 20,
		// H, 1);
		// pa.squarehatch.draw(source.foi(false, TRIANGLE, 180, 0), 1, SC.BLACK,
		// SC.BLACK, 10, 5, H, 1);
		// pa.points.drawshards(source.oi(false), 1, SC.BLACK, SC.BLACK, 2000);

	}

	public void addInstruction(Runnable r) {
		runnableList.add(r);
	}

	public ArrayList<Runnable> getRunnableList() {
		return this.runnableList;
	}
}
