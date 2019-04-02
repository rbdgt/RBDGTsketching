package be.rbdgt.camera;

import be.rbdgt.PictureSketchV2;
import processing.video.Capture;

public class Camera {

    static Capture cam;
    
    public static void setup(PictureSketchV2 pa) {
	String[] cameras = Capture.list();

	if (cameras.length == 0) {
	    pa.println("There are no cameras available for capture.");
	    pa.exit();
	} else {
	    pa.println("Available cameras:");
	    for (int i = 0; i < cameras.length; i++) {
		pa.println(cameras[i]);
	    }

	    // The camera can be initialized directly using an
	    // element from the array returned by list():
	    cam = new Capture(pa, cameras[0]);
	    cam.start();
	}
	
	if (cam.available() == true) {
	    cam.read();
	  }
	  pa.image(cam, 0, 0);
	  // The following does the same, and is faster when just drawing the image
	  // without any additional resizing, transformations, or tint.
	  //set(0, 0, cam);
    }

}
