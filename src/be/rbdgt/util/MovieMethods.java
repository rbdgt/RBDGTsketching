package be.rbdgt.util;

import processing.video.*;

public class MovieMethods {
   
    public void movieEvent(Movie m) {
	m.read();
    }

    public int getMovieLength(Movie mov) {
	  // println(int(mov.duration() * 59));
	  return (int) (mov.duration()/1 * 59);
	}

    public int getMovieFrame(Movie mov) {
	return (int) (Math.ceil(mov.time() * 59) - 1);
    }
}
