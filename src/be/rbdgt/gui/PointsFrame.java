package be.rbdgt.gui;

import java.awt.EventQueue;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PointsFrame extends TemplateFrame{
	private JTextField textField;
	private JTextField txtParticles;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PointsFrame frame = new PointsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//TODO Points not fully implemented
	
	public PointsFrame(){
		super();
		setTitle("Points");
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 243, 477, 195);
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblStrokeweight = new JLabel("Strokeweight");
		GridBagConstraints gbc_lblStrokeweight = new GridBagConstraints();
		gbc_lblStrokeweight.anchor = GridBagConstraints.EAST;
		gbc_lblStrokeweight.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrokeweight.gridx = 0;
		gbc_lblStrokeweight.gridy = 0;
		panel.add(lblStrokeweight, gbc_lblStrokeweight);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		
		JLabel lblDetcolor = new JLabel("DetColor");
		GridBagConstraints gbc_lblDetcolor = new GridBagConstraints();
		gbc_lblDetcolor.anchor = GridBagConstraints.WEST;
		gbc_lblDetcolor.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetcolor.gridx = 0;
		gbc_lblDetcolor.gridy = 1;
		panel.add(lblDetcolor, gbc_lblDetcolor);
		
		JComboBox cbbDetColor = new JComboBox();
		GridBagConstraints gbc_cbbDetColor = new GridBagConstraints();
		gbc_cbbDetColor.insets = new Insets(0, 0, 5, 0);
		gbc_cbbDetColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbDetColor.gridx = 1;
		gbc_cbbDetColor.gridy = 1;
		panel.add(cbbDetColor, gbc_cbbDetColor);
		
		JLabel lblPenColor = new JLabel("PenColor");
		GridBagConstraints gbc_lblPenColor = new GridBagConstraints();
		gbc_lblPenColor.anchor = GridBagConstraints.WEST;
		gbc_lblPenColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblPenColor.gridx = 0;
		gbc_lblPenColor.gridy = 2;
		panel.add(lblPenColor, gbc_lblPenColor);
		
		JComboBox cbbPencolor = new JComboBox();
		GridBagConstraints gbc_cbbPencolor = new GridBagConstraints();
		gbc_cbbPencolor.insets = new Insets(0, 0, 5, 0);
		gbc_cbbPencolor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbPencolor.gridx = 1;
		gbc_cbbPencolor.gridy = 2;
		panel.add(cbbPencolor, gbc_cbbPencolor);
		
		JLabel lblParticles = new JLabel("Particles");
		GridBagConstraints gbc_lblParticles = new GridBagConstraints();
		gbc_lblParticles.anchor = GridBagConstraints.WEST;
		gbc_lblParticles.insets = new Insets(0, 0, 5, 5);
		gbc_lblParticles.gridx = 0;
		gbc_lblParticles.gridy = 3;
		panel.add(lblParticles, gbc_lblParticles);
		
		txtParticles = new JTextField();
		GridBagConstraints gbc_txtParticles = new GridBagConstraints();
		gbc_txtParticles.insets = new Insets(0, 0, 5, 0);
		gbc_txtParticles.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtParticles.gridx = 1;
		gbc_txtParticles.gridy = 3;
		panel.add(txtParticles, gbc_txtParticles);
		txtParticles.setColumns(10);
	}
}
