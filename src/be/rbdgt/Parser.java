package be.rbdgt;

import be.rbdgt.util.SC;
import be.rbdgt.util.Source;
import be.rbdgt.util.Utility;
import processing.core.PImage;
import be.rbdgt.util.Stabilo;

public class Parser {

	private PictureSketchV2 pa;
	private Source source;
	//private Stabilo stabilo;

	public Parser(PictureSketchV2 pa, Source source, Stabilo stabilo) {
		this.pa = pa;
		this.source = source; //TODO tests
		//this.stabilo = stabilo;
	}

	public void parseInstr(String args[]) {
		// TODO create switch statement for different modes
		// TODO us this to differentiate modes
		if (args.length > 0) {
			for (String instrstring : args) {
				String argstring = instrstring.substring(instrstring.indexOf("(") + 1, instrstring.length() - 1);
				String subinstrstring = instrstring.substring(instrstring.indexOf(".")+1, instrstring.indexOf("("));
				System.out.println(subinstrstring);
				switch (instrstring.substring(0, instrstring.indexOf("."))) {
				case "delaunay":
					delaunay(argstring);
					break;
				case "contour":
					contour(argstring);
					break;
				case "vertex":
					vertex(argstring);
					break;
				case "houghlines":
					houghlines(argstring);
					break;
				case "sketchlines":
					sketchlines(argstring);
					break;
				case "squarehatch":
					squarehatch(argstring);
					break;
				case "points":
					points(argstring, subinstrstring);
					break;
				case "facepattern":
					facepattern(argstring, subinstrstring);
					break;
				default:
					System.out.println("***** SYNTAX ERROR *****");
				}
			}
		}
	}
	
	public void points(String argstring, String subinstrstring){
		String sourcestring = argstring.substring(0, argstring.indexOf(")") + 1);
		argstring = argstring.replace(sourcestring + ", ", "");
		String[] args = argstring.split(", ");
		int strokeWeight = Integer.parseInt(args[0]);
		int penColor = SC.getColorCode(getColorName(args[1]));
		int detColor = SC.getColorCode(getColorName(args[2]));
		int particles = Integer.parseInt(args[3]);
		// System.out.println(stabilo.s88(getColorName(args[1])));
		switch (subinstrstring){
		case "drawPoints":
			pa.getPoints().drawpoints(getSourceImage(sourcestring), strokeWeight, detColor, penColor, particles);
			break;
		case "drawShards":
			pa.getPoints().drawshards(getSourceImage(sourcestring), strokeWeight, detColor, penColor, particles);
			break;
		}
	}

	public void facepattern(String argstring, String subinstrstring) {
		String[] args = argstring.split(", ");
		int faceNr = Integer.parseInt(args[0]);
		int shape = Utility.shapeToInt(args[1]);
		int rotation = Integer.parseInt(args[2]);
		int displaceX = Integer.parseInt(args[3]);
		int displaceY = Integer.parseInt(args[4]);
		int strokeWeight = Integer.parseInt(args[5]);
		int shrink = Integer.parseInt(args[6]);
		int penColor = SC.getColorCode(getColorName(args[7]));
		int tileCount = Integer.parseInt(args[8]);
		int patternNr = Integer.parseInt(args[9]);
		// System.out.println(stabilo.s88(getColorName(args[1])));
		switch (subinstrstring){
		case "drawface":
			pa.getFacepattern().drawface(faceNr, shape, rotation, displaceX, displaceY, strokeWeight, shrink, penColor, tileCount, patternNr);
			break;
		case "drawfaces":
			pa.getFacepattern().drawfaces(faceNr, shape, rotation, displaceX, displaceY, strokeWeight, shrink, penColor, tileCount, patternNr);
			break;
		}
	}

	public void squarehatch(String argstring) {
		String sourcestring = argstring.substring(0, argstring.indexOf(")") + 1);
		argstring = argstring.replace(sourcestring + ", ", "");
		String[] args = argstring.split(", ");
		int strokeWeight = Integer.parseInt(args[0]);
		int detColor = SC.getColorCode(getColorName(args[1]));
		int penColor = SC.getColorCode(getColorName(args[2]));
		int iSide = Integer.parseInt(args[3]);
		int Sens = Integer.parseInt(args[4]);
		int dir = Utility.dirToInt(args[5]);
		int joinIterations = Integer.parseInt(args[6]);
		// System.out.println(stabilo.s88(getColorName(args[1])));
		pa.getSquarehatch().draw(getSourceImage(sourcestring), strokeWeight, detColor, penColor, iSide, Sens, dir,
				joinIterations);
	}

	public void sketchlines(String argstring) {
		String sourcestring = argstring.substring(0, argstring.indexOf(")") + 1);
		argstring = argstring.replace(sourcestring + ", ", "");
		String[] args = argstring.split(", ");
		int strokeWeight = Integer.parseInt(args[0]);
		int detColor = SC.getColorCode(getColorName(args[1]));
		int penColor = SC.getColorCode(getColorName(args[2]));
		int particles = Integer.parseInt(args[3]);
		// System.out.println(stabilo.s88(getColorName(args[1])));
		pa.getSketchlines().draw(getSourceImage(sourcestring), strokeWeight, detColor, penColor, particles);
	}

	public void houghlines(String argstring) {
		String sourcestring = argstring.substring(0, argstring.indexOf(")") + 1);
		argstring = argstring.replace(sourcestring + ", ", "");
		String[] args = argstring.split(", ");
		int strokeWeight = Integer.parseInt(args[0]);
		int penColor = SC.getColorCode(getColorName(args[1]));
		int threshold = Integer.parseInt(args[2]);
		int minLength = Integer.parseInt(args[3]);
		int maxLength = Integer.parseInt(args[4]);
		int loRadians = Integer.parseInt(args[5]);
		int hiRadians = Integer.parseInt(args[6]);
		// System.out.println(stabilo.s88(getColorName(args[1])));
		pa.getHoughlines().draw(getSourceImage(sourcestring), strokeWeight, penColor, threshold, minLength, maxLength,
				loRadians, hiRadians);
	}

	public void vertex(String argstring) {
		String sourcestring = argstring.substring(0, argstring.indexOf(")") + 1);
		argstring = argstring.replace(sourcestring + ", ", "");
		String[] args = argstring.split(", ");
		int strokeWeight = Integer.parseInt(args[0]);
		int penColor = SC.getColorCode(getColorName(args[1]));
		System.out.println(sourcestring);
		pa.getVertex().draw(getSourceImage(sourcestring), strokeWeight, penColor);
	}

	public void contour(String argstring) {
		String sourcestring = argstring.substring(0, argstring.indexOf(")") + 1);
		argstring = argstring.replace(sourcestring + ", ", "");
		String[] args = argstring.split(", ");
		int strokeWeight = Integer.parseInt(args[0]);
		int penColor = SC.getColorCode(getColorName(args[1]));
		System.out.println(sourcestring);
		pa.getContour().draw(getSourceImage(sourcestring), strokeWeight, penColor);
	}

	public void delaunay(String argstring) {
		String sourcestring = argstring.substring(0, argstring.indexOf(")") + 1);
		argstring = argstring.replace(sourcestring + ", ", "");
		String[] args = argstring.split(", ");
		int strokeWeight = Integer.parseInt(args[0]);
		int detColor = SC.getColorCode(getColorName(args[1]));
		int penColor = SC.getColorCode(getColorName(args[2]));
		int minLength = Integer.parseInt(args[3]);
		int maxLength = Integer.parseInt(args[4]);
		int particles = Integer.parseInt(args[5]);
		// System.out.println(stabilo.s88(getColorName(args[1])));
		pa.getDelaunay().draw(getSourceImage(sourcestring), strokeWeight, detColor, penColor, minLength, maxLength,
				particles);
	}

	private PImage getSourceImage(String sourcestring) {
		boolean invert;
		int shape, rotation, shrink, lC, rC, tH;
		sourcestring = sourcestring.replace("source.", "");
		String sourcetype = sourcestring.substring(0, sourcestring.indexOf("("));
		sourcestring = sourcestring.substring(sourcestring.indexOf("(") + 1, sourcestring.indexOf(")"));
		String[] sourceargs = sourcestring.split(", ");
		// return getSourceImage(sourcetype, sourceargs);
		switch (sourcetype) {
		case "oi":
			invert = sourceargs[0].equals("true");
			return source.oi(invert);
		case "ohci":
			invert = sourceargs[0].equals("true");
			return source.ohci(invert);
		case "foi":
			invert = sourceargs[0].equals("true");
			shape = Utility.shapeToInt(sourceargs[1]);
			rotation = Integer.parseInt(sourceargs[2]);
			shrink = Integer.parseInt(sourceargs[3]);
			return source.foi(invert, shape, rotation, shrink);
		case "fohi":
			invert = sourceargs[0].equals("true");
			shape = Utility.shapeToInt(sourceargs[1]);
			rotation = Integer.parseInt(sourceargs[2]);
			shrink = Integer.parseInt(sourceargs[3]);
			return source.fohi(invert, shape, rotation, shrink);
		case "fohci":
			invert = sourceargs[0].equals("true");
			shape = Utility.shapeToInt(sourceargs[1]);
			rotation = Integer.parseInt(sourceargs[2]);
			shrink = Integer.parseInt(sourceargs[3]);
			return source.fohci(invert, shape, rotation, shrink);
		case "fci":
			invert = sourceargs[0].equals("true");
			shape = Utility.shapeToInt(sourceargs[1]);
			rotation = Integer.parseInt(sourceargs[2]);
			shrink = Integer.parseInt(sourceargs[3]);
			lC = Integer.parseInt(sourceargs[4]);
			rC = Integer.parseInt(sourceargs[5]);
			tH = Integer.parseInt(sourceargs[6]);
			return source.fci(invert, shape, rotation, shrink, lC, rC, tH);
		case "fchi":
			invert = sourceargs[0].equals("true");
			shape = Utility.shapeToInt(sourceargs[1]);
			rotation = Integer.parseInt(sourceargs[2]);
			shrink = Integer.parseInt(sourceargs[3]);
			lC = Integer.parseInt(sourceargs[4]);
			rC = Integer.parseInt(sourceargs[5]);
			rC = Integer.parseInt(sourceargs[5]);
			tH = Integer.parseInt(sourceargs[6]);
			return source.fchi(invert, shape, rotation, shrink, lC, rC, tH);
		case "ci":
			invert = sourceargs[0].equals("true");
			lC = Integer.parseInt(sourceargs[1]);
			rC = Integer.parseInt(sourceargs[2]);
			tH = Integer.parseInt(sourceargs[6]);
			return source.ci(invert, lC, rC, tH);
		}
		return null;
	}

	private String getColorName(String colorarg) {
		return colorarg.substring(colorarg.indexOf(".") + 1);
	}

}
