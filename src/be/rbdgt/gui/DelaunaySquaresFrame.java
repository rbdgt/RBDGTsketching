package be.rbdgt.gui;

import java.awt.EventQueue;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class DelaunaySquaresFrame extends TemplateFrame{
	private JTextField textField;
	private JTextField txtTreshold;
	private JTextField txtiSide;
	private JTextField txtBrightnessfactor;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelaunaySquaresFrame frame = new DelaunaySquaresFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DelaunaySquaresFrame(){
		super();
		setTitle("Delaunay Squares");
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 241, 477, 228);
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblStrokeweight = new JLabel("Strokeweight");
		GridBagConstraints gbc_lblStrokeweight = new GridBagConstraints();
		gbc_lblStrokeweight.anchor = GridBagConstraints.WEST;
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
		
		JLabel lblPenColor = new JLabel("PenColor");
		GridBagConstraints gbc_lblPenColor = new GridBagConstraints();
		gbc_lblPenColor.anchor = GridBagConstraints.WEST;
		gbc_lblPenColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblPenColor.gridx = 0;
		gbc_lblPenColor.gridy = 1;
		panel.add(lblPenColor, gbc_lblPenColor);
		
		JComboBox cbbPencolor = new JComboBox();
		GridBagConstraints gbc_cbbPencolor = new GridBagConstraints();
		gbc_cbbPencolor.insets = new Insets(0, 0, 5, 0);
		gbc_cbbPencolor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbPencolor.gridx = 1;
		gbc_cbbPencolor.gridy = 1;
		panel.add(cbbPencolor, gbc_cbbPencolor);
		
		JLabel lblIside = new JLabel("iSide");
		GridBagConstraints gbc_lblIside = new GridBagConstraints();
		gbc_lblIside.anchor = GridBagConstraints.WEST;
		gbc_lblIside.insets = new Insets(0, 0, 5, 5);
		gbc_lblIside.gridx = 0;
		gbc_lblIside.gridy = 2;
		panel.add(lblIside, gbc_lblIside);
		
		txtiSide = new JTextField();
		GridBagConstraints gbc_txtiSide = new GridBagConstraints();
		gbc_txtiSide.anchor = GridBagConstraints.NORTH;
		gbc_txtiSide.insets = new Insets(0, 0, 5, 0);
		gbc_txtiSide.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtiSide.gridx = 1;
		gbc_txtiSide.gridy = 2;
		panel.add(txtiSide, gbc_txtiSide);
		txtiSide.setColumns(10);
		
		JLabel lblTreshold = new JLabel("Treshold");
		GridBagConstraints gbc_lblTreshold = new GridBagConstraints();
		gbc_lblTreshold.anchor = GridBagConstraints.WEST;
		gbc_lblTreshold.insets = new Insets(0, 0, 5, 5);
		gbc_lblTreshold.gridx = 0;
		gbc_lblTreshold.gridy = 3;
		panel.add(lblTreshold, gbc_lblTreshold);
		
		txtTreshold = new JTextField();
		GridBagConstraints gbc_txtTreshold = new GridBagConstraints();
		gbc_txtTreshold.insets = new Insets(0, 0, 5, 0);
		gbc_txtTreshold.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTreshold.gridx = 1;
		gbc_txtTreshold.gridy = 3;
		panel.add(txtTreshold, gbc_txtTreshold);
		txtTreshold.setColumns(10);
		
		JLabel lblBrightnessfactor = new JLabel("Brightnessfactor");
		GridBagConstraints gbc_lblBrightnessfactor = new GridBagConstraints();
		gbc_lblBrightnessfactor.anchor = GridBagConstraints.WEST;
		gbc_lblBrightnessfactor.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrightnessfactor.gridx = 0;
		gbc_lblBrightnessfactor.gridy = 4;
		panel.add(lblBrightnessfactor, gbc_lblBrightnessfactor);
		
		txtBrightnessfactor = new JTextField();
		GridBagConstraints gbc_txtBrightnessfactor = new GridBagConstraints();
		gbc_txtBrightnessfactor.anchor = GridBagConstraints.NORTH;
		gbc_txtBrightnessfactor.insets = new Insets(0, 0, 5, 0);
		gbc_txtBrightnessfactor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBrightnessfactor.gridx = 1;
		gbc_txtBrightnessfactor.gridy = 4;
		panel.add(txtBrightnessfactor, gbc_txtBrightnessfactor);
		txtBrightnessfactor.setColumns(10);
		
		JCheckBox chckbxInvert = new JCheckBox("Invert");
		GridBagConstraints gbc_chckbxInvert = new GridBagConstraints();
		gbc_chckbxInvert.anchor = GridBagConstraints.WEST;
		gbc_chckbxInvert.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxInvert.gridx = 0;
		gbc_chckbxInvert.gridy = 5;
		panel.add(chckbxInvert, gbc_chckbxInvert);
		
		JCheckBox chckbxBrightUp = new JCheckBox("Bright up");
		GridBagConstraints gbc_chckbxBrightUp = new GridBagConstraints();
		gbc_chckbxBrightUp.anchor = GridBagConstraints.WEST;
		gbc_chckbxBrightUp.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxBrightUp.gridx = 0;
		gbc_chckbxBrightUp.gridy = 6;
		panel.add(chckbxBrightUp, gbc_chckbxBrightUp);
		
		JCheckBox chckbxContinuous = new JCheckBox("Continuous");
		GridBagConstraints gbc_chckbxContinuous = new GridBagConstraints();
		gbc_chckbxContinuous.anchor = GridBagConstraints.WEST;
		gbc_chckbxContinuous.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxContinuous.gridx = 0;
		gbc_chckbxContinuous.gridy = 7;
		panel.add(chckbxContinuous, gbc_chckbxContinuous);
	}
}
