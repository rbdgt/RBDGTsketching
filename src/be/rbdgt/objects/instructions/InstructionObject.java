package be.rbdgt.objects.instructions;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.util.Source;
import stabilocolors.library.Stabilo;

public class InstructionObject {
	
	private Source source;
	private Stabilo stabilo;
	
	private int strokeWeight = 1;
	private int penColor; 
	
	private String filename;
	private String extension;
	private String folder;
	private String suffix;

	private String outputFolder;
	
	private Runnable runnableInstruction;

	public InstructionObject(){

	}
	
	public void setFileData(String[] fileData){
		this.filename = fileData[0];
		this.extension = fileData[1];
		this.folder = fileData[2];
		this.suffix = fileData[3];
		this.outputFolder = fileData[4];
	}
	
	public void setFile(PictureSketchV2 pa) {
		pa.setFile(folder, filename, extension, suffix, outputFolder);
	}
	
	public void initInstructionObject(int strokeWeight, int penColor){ //TODO make abstract
		this.strokeWeight = strokeWeight;
		this.penColor = penColor;
	}
	
	public void buildInstruction(PictureSketchV2 pa) { //TODO make overridable
		//runnableList.add(() -> pa.facepattern.drawface(1, TRIANGLE, 90, 1, 40, SC.RED, 200, RD));
		//runnableInstruction = () -> pa.contour.draw(source.ohci(true), 1, SC.BLACK);
		runnableInstruction = () -> pa.contour.draw(source.ohci(true), strokeWeight, penColor);
	}
	
//	public void setFile(PictureSketchV2 pa) {
//		pa.setFile("faces", "assad", "jpg", "face");
//	}
	
	public void draw(PictureSketchV2 pa){
		//stabilo = pa.getStabilo();
		//source = pa.getSource();
		
		runnableInstruction.run();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "pa.contour.draw(source.ohci(true), "+strokeWeight+", "+penColor+");";
	}
	
	
	
}
