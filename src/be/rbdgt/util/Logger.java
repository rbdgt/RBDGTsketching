package be.rbdgt.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	private BufferedWriter writer = null;
	private String outputfolder;
	private String folder;
	private String filename;
	private String suffix;
	private boolean report;

	public Logger(String outputfolder, String folder, String filename, String suffix, boolean report) {
		this.folder = folder;
		this.outputfolder = outputfolder;
		this.filename = filename;
		this.suffix = suffix;
		this.report = report;
	}

	public void createLog() {
		try {
			File file = new File(outputfolder + "/" + filename + "_" + suffix + "_log.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			writer = new BufferedWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// writer = new PrintWriter(file);

	/*
	 * public void createLog() { printOutput = createWriter("/" + folder + "/" +
	 * filename + "_" + suffix + "_log.txt"); }
	 */

	public void writeLogLine(String s) {
		if (report){System.out.println(s);}
		try {
			writer.write(s);
			writer.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeLog() {
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
