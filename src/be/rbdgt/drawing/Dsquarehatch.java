package be.rbdgt.drawing;

import java.util.ArrayList;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.objects.SimpleLine;
import be.rbdgt.util.ColorMethods;
import be.rbdgt.util.Logger;
import be.rbdgt.util.SC;
import be.rbdgt.util.Stabilo;
import processing.core.PConstants;
import processing.core.PImage;

public class Dsquarehatch {
	
	Logger log;
	PictureSketchV2 pa;
	Stabilo stabilo;
	
	public Dsquarehatch(Logger log, PictureSketchV2 pa, Stabilo stabilo){
		this.log = log;
		this.pa = pa;
		this.stabilo = stabilo;
	}
	
	public void draw(PImage img, int strokeWeight, int detColor, int penColor, int iSide, int Sens, int dir,
			int joinIterations) {
		
		log.writeLogLine("[ SQUAREHATCH ]");
		//log.writeLogLine("-----------------------------------------");
		log.writeLogLine("strokeWeight: " + strokeWeight);
		log.writeLogLine("detColor: " + stabilo.getColorName(detColor).toUpperCase());
		log.writeLogLine("penColor: " + stabilo.getColorName(penColor).toUpperCase());
		log.writeLogLine("iSide: " + iSide);
		log.writeLogLine("Sens: " + Sens);
		log.writeLogLine("dir: " + dir);
		log.writeLogLine("joinIterations: " + joinIterations);
		log.writeLogLine("");
		
		pa.strokeWeight(strokeWeight);
		pa.stroke(stabilo.s88(penColor, 180)); // TODO fix contourAlpha
		pa.strokeCap(PConstants.ROUND);
		pa.noFill();
		
		int width = img.width;
		int height = img.height;
		
		ArrayList<SimpleLine> hatchLines = new ArrayList<SimpleLine>();

		int blackbordercompensation = 0; // To prevent black lines/dots along
											// border
		if (detColor == SC.BLACK) {
			blackbordercompensation = 1;
		}
		for (int x = blackbordercompensation; x < width - blackbordercompensation; x = x + iSide) {
			for (int y = blackbordercompensation; y < height - blackbordercompensation; y = y + iSide) {
				PImage tile = img.get(x, y, iSide, iSide);
				if (ColorMethods.determineColor(ColorMethods.getAverageColor(tile), detColor)) {
					drawRect(hatchLines, x, y, iSide, Sens, dir);
				}
			}
		}
		drawHatchLines(pa, JoinHatchLines(hatchLines, joinIterations));
		// println(JoinHatchLines(hatchLines).size());
		// drawHatchLines(hatchLines);
	}
	
	private ArrayList<SimpleLine> drawRect(ArrayList<SimpleLine> hatchLines, int x, int y, int iSide, int Sens, int dir) {
		ArrayList<SimpleLine> ar = new ArrayList<SimpleLine>(); 
		if (dir == 1) {
			ar = hatchRightColor(hatchLines, x, y, iSide, Sens);
		}
		if (dir == 0) {
			ar = hatchLeftColor(hatchLines, x, y, iSide, Sens);
		}
		if (dir == 2) {
			ar = hatchVertColor(hatchLines, x, y, iSide, Sens);
		}
		if (dir == 3) {
			ar = hatchHorColor(hatchLines, x, y, iSide, Sens);
		}
		return ar;
	}
	
	private ArrayList<SimpleLine> hatchRightColor(ArrayList<SimpleLine> hatchLines, int xPos, int yPos, int w, int Sens) {
		if (w < Sens) {
			for (int i = 0; i <= w; i = i + Sens) {
				int startX = xPos + w / 2;
				int startY = yPos + w / 2;
				int endX = xPos + w / 2;
				int endY = yPos + w / 2;
				hatchLines.add(new SimpleLine(startX, startY, endX, endY));
				// line(startX, startY, endX, endY);
			}
		} else {
			for (int i = 0; i <= w; i = i + Sens) {
				// if (xPos+w/2!=xPos+w/2&&yPos+w/2!=yPos+w/2) {
				int startX = xPos - 0;
				int startY = yPos + i;
				int endX = xPos + i;
				int endY = yPos - 0;
				hatchLines.add(new SimpleLine(startX, startY, endX, endY));
				if (i != w) {
					startX = xPos + w - i;
					startY = yPos + w;
					endX = xPos + w;
					endY = yPos + w - i;
					hatchLines.add(new SimpleLine(startX, startY, endX, endY));
					// line(startX, startY, endX, endY);
				}
			}
		}
		return hatchLines;
	}

	private ArrayList<SimpleLine> hatchLeftColor(ArrayList<SimpleLine> hatchLines, int xPos, int yPos, int w, int Sens) {
		if (w < Sens) {
			for (int i = 0; i <= w; i = i + Sens) {
				int startX = xPos + w / 2;
				int startY = yPos + w / 2;
				int endX = xPos + w / 2;
				int endY = yPos + w / 2;
				hatchLines.add(new SimpleLine(startX, startY, endX, endY));
				// line(startX, startY, endX, endY);
			}
		} else {
			for (int i = 0; i <= w; i = i + Sens) {
				int startX = xPos - 0;
				int startY = yPos + w - i;
				int endX = xPos + i;
				int endY = yPos + w;
				hatchLines.add(new SimpleLine(startX, startY, endX, endY));
				// line(startX, startY, endX, endY);
				if (i != w) {
					startX = xPos + w - i;
					startY = yPos - 0;
					endX = xPos + w;
					endY = yPos + i;
					hatchLines.add(new SimpleLine(startX, startY, endX, endY));
					// line(startX, startY, endX, endY);
				}
			}
		}
		return hatchLines;
	}

	private ArrayList<SimpleLine> hatchVertColor(ArrayList<SimpleLine> hatchLines, int xPos, int yPos, int w, int Sens) {
		if (w < Sens) {
			for (int i = 0; i <= w; i = i + Sens) {
				int startX = xPos + w / 2;
				int startY = yPos + w / 2;
				int endX = xPos + w / 2;
				int endY = yPos + w / 2;
				hatchLines.add(new SimpleLine(startX, startY, endX, endY));
				// line(startX, startY, endX, endY);
			}
		} else {
			for (int i = 0; i < w; i = i + Sens) {
				int startX = xPos + i;
				int startY = yPos + w;
				int endX = xPos + i;
				int endY = yPos;
				hatchLines.add(new SimpleLine(startX, startY, endX, endY));
				;
				// line(startX, startY, endX, endY);
			}
		}
		return hatchLines;
	}

	private ArrayList<SimpleLine> hatchHorColor(ArrayList<SimpleLine> hatchLines, int xPos, int yPos, int w, int Sens) {
		if (w < Sens) {
			for (int i = 0; i <= w; i = i + Sens) {
				int startX = xPos + w / 2;
				int startY = yPos + w / 2;
				int endX = xPos + w / 2;
				int endY = yPos + w / 2;
				hatchLines.add(new SimpleLine(startX, startY, endX, endY));
				// line(startX, startY, endX, endY);
			}
		} else {
			for (int i = 0; i < w; i = i + Sens) {
				int startX = xPos;
				int startY = yPos + i;
				int endX = xPos + w;
				int endY = yPos + i;
				hatchLines.add(new SimpleLine(startX, startY, endX, endY));
				// line(startX, startY, endX, endY);
			}
		}
		return hatchLines;
	}

	private void drawHatchLines(PictureSketchV2 pa, ArrayList<SimpleLine> hl) {
		for (int i = 0; i < hl.size(); i++) {
			SimpleLine l = (SimpleLine) hl.get(i);
			pa.line((float) l.x1(), (float) l.y1(), (float) l.x2(), (float) l.y2());
		}
	}
	
	private ArrayList<SimpleLine> JoinHatchLines(ArrayList<SimpleLine> input, int joinIterations) {
		for (int ol = 0; ol < input.size() * joinIterations; ol++) {
			for (int nl = 0; nl < input.size() * joinIterations; nl++) {
				if (nl != ol) {
					SimpleLine oLine = input.get(ol % input.size());
					SimpleLine nLine = input.get(nl % input.size());
					if (oLine.x2() == nLine.x1() && oLine.y2() == nLine.y1()) {// &&
						// oLine.x1!=nLine.x2
						// &&
						// oLine.y1!=nLine.y2)
						// {
						input.set(ol % input.size(), joinLines(oLine, nLine));
						input.set(nl % input.size(), new SimpleLine(0, 0, 0, 0));
						// println("line "+nl+" with coords
						// "+nLine.x1+"-"+nLine.y1+"-"+nLine.x2+"-"+nLine.y2+"
						// moved away.");
					}
				}
			}
		}
		for (int i = 0; i < input.size(); i++) {
			SimpleLine l = input.get(i % input.size());
			if (l.x2() == 0 && l.y2() == 0 && l.x1() == 0 && l.y1() == 0) {
				input.remove(i % input.size());
				// println("line with coords "+l.x1+"-"+l.y1+"-"+l.x2+"-"+l.y2+"
				// removed.");
				i--;
			}
			/*
			 * if (l.x1==l.x2 && l.y1==l.y2) { input.remove(i%input.size()); }
			 */
		}
		return input;
	}

	private SimpleLine joinLines(SimpleLine l1, SimpleLine l2) {
		return new SimpleLine(l1.x1(), l1.y1(), l2.x2(), l2.y2());
	}
}
