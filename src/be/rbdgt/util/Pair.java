package be.rbdgt.util;

import java.awt.GridBagConstraints;

import javax.swing.JComponent;

public class Pair {
	JComponent c;
	GridBagConstraints gbc;
	
	Pair(JComponent c, GridBagConstraints gbc){
		this.c = c;
		this.gbc = gbc;
	}
	
	public JComponent getControl(){
		return this.c;
	}
	
	public GridBagConstraints getGBC(){
		return this.gbc;
	}

}
