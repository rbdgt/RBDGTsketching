package be.rbdgt.objects;

import processing.core.PImage;

public class Outputimg extends PImage {

	String info = "";
	
	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfo() {
		return this.info;
	}
}
