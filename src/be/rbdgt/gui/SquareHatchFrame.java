package be.rbdgt.gui;

import java.awt.EventQueue;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class SquareHatchFrame extends TemplateFrame{
	private JTextField textField;
	private JTextField txtiSide;
	private JTextField txtSens;
	private JTextField txtJoiniterations;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SquareHatchFrame frame = new SquareHatchFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//TODO Points not fully implemented
	
	public SquareHatchFrame(){
		super();
		setTitle("Squarehatch");
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 243, 477, 195);
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblIside = new JLabel("iSide");
		GridBagConstraints gbc_lblIside = new GridBagConstraints();
		gbc_lblIside.anchor = GridBagConstraints.WEST;
		gbc_lblIside.insets = new Insets(0, 0, 5, 5);
		gbc_lblIside.gridx = 0;
		gbc_lblIside.gridy = 3;
		panel.add(lblIside, gbc_lblIside);
		
		txtiSide = new JTextField();
		GridBagConstraints gbc_txtiSide = new GridBagConstraints();
		gbc_txtiSide.insets = new Insets(0, 0, 5, 0);
		gbc_txtiSide.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtiSide.gridx = 1;
		gbc_txtiSide.gridy = 3;
		panel.add(txtiSide, gbc_txtiSide);
		txtiSide.setColumns(10);
		
		JLabel lblSensitivity = new JLabel("Sensitivity");
		GridBagConstraints gbc_lblSensitivity = new GridBagConstraints();
		gbc_lblSensitivity.anchor = GridBagConstraints.EAST;
		gbc_lblSensitivity.insets = new Insets(0, 0, 5, 5);
		gbc_lblSensitivity.gridx = 0;
		gbc_lblSensitivity.gridy = 4;
		panel.add(lblSensitivity, gbc_lblSensitivity);
		
		txtSens = new JTextField();
		GridBagConstraints gbc_txtSens = new GridBagConstraints();
		gbc_txtSens.insets = new Insets(0, 0, 5, 0);
		gbc_txtSens.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSens.gridx = 1;
		gbc_txtSens.gridy = 4;
		panel.add(txtSens, gbc_txtSens);
		txtSens.setColumns(10);
		
		JLabel lblDirection = new JLabel("Direction");
		GridBagConstraints gbc_lblDirection = new GridBagConstraints();
		gbc_lblDirection.anchor = GridBagConstraints.EAST;
		gbc_lblDirection.insets = new Insets(0, 0, 5, 5);
		gbc_lblDirection.gridx = 0;
		gbc_lblDirection.gridy = 5;
		panel.add(lblDirection, gbc_lblDirection);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		panel.add(comboBox, gbc_comboBox);
		
		JLabel lblJoiniterations = new JLabel("Joiniterations");
		GridBagConstraints gbc_lblJoiniterations = new GridBagConstraints();
		gbc_lblJoiniterations.anchor = GridBagConstraints.EAST;
		gbc_lblJoiniterations.insets = new Insets(0, 0, 0, 5);
		gbc_lblJoiniterations.gridx = 0;
		gbc_lblJoiniterations.gridy = 6;
		panel.add(lblJoiniterations, gbc_lblJoiniterations);
		
		txtJoiniterations = new JTextField();
		GridBagConstraints gbc_txtJoiniterations = new GridBagConstraints();
		gbc_txtJoiniterations.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtJoiniterations.gridx = 1;
		gbc_txtJoiniterations.gridy = 6;
		panel.add(txtJoiniterations, gbc_txtJoiniterations);
		txtJoiniterations.setColumns(10);
	}
}
