package be.rbdgt.gui;

import java.awt.EventQueue;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class HoughlinesFrame extends TemplateFrame{
	private JTextField textField;
	private JTextField txtMinLength;
	private JTextField txtMaxLineGap;
	private JTextField txtThreshold;
	private JTextField txtLoRadians;
	private JTextField txtHiRadians;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoughlinesFrame frame = new HoughlinesFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public HoughlinesFrame(){
		super();
		setTitle("Houghlines");
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 244, 477, 202);
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
		
		JLabel lblPencolor = new JLabel("Pencolor");
		GridBagConstraints gbc_lblPencolor = new GridBagConstraints();
		gbc_lblPencolor.anchor = GridBagConstraints.WEST;
		gbc_lblPencolor.insets = new Insets(0, 0, 5, 5);
		gbc_lblPencolor.gridx = 0;
		gbc_lblPencolor.gridy = 1;
		panel.add(lblPencolor, gbc_lblPencolor);
		
		JComboBox cbbPencolor = new JComboBox();
		GridBagConstraints gbc_cbbPencolor = new GridBagConstraints();
		gbc_cbbPencolor.insets = new Insets(0, 0, 5, 0);
		gbc_cbbPencolor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbPencolor.gridx = 1;
		gbc_cbbPencolor.gridy = 1;
		panel.add(cbbPencolor, gbc_cbbPencolor);
		
		JLabel lblThreshold = new JLabel("Threshold");
		GridBagConstraints gbc_lblThreshold = new GridBagConstraints();
		gbc_lblThreshold.anchor = GridBagConstraints.WEST;
		gbc_lblThreshold.insets = new Insets(0, 0, 5, 5);
		gbc_lblThreshold.gridx = 0;
		gbc_lblThreshold.gridy = 2;
		panel.add(lblThreshold, gbc_lblThreshold);
		
		txtThreshold = new JTextField();
		GridBagConstraints gbc_txtThreshold = new GridBagConstraints();
		gbc_txtThreshold.anchor = GridBagConstraints.NORTH;
		gbc_txtThreshold.insets = new Insets(0, 0, 5, 0);
		gbc_txtThreshold.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtThreshold.gridx = 1;
		gbc_txtThreshold.gridy = 2;
		panel.add(txtThreshold, gbc_txtThreshold);
		txtThreshold.setColumns(10);
		
		JLabel lblMinLength = new JLabel("Min Length");
		GridBagConstraints gbc_lblMinLength = new GridBagConstraints();
		gbc_lblMinLength.anchor = GridBagConstraints.WEST;
		gbc_lblMinLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinLength.gridx = 0;
		gbc_lblMinLength.gridy = 3;
		panel.add(lblMinLength, gbc_lblMinLength);
		
		txtMinLength = new JTextField();
		GridBagConstraints gbc_txtMinLength = new GridBagConstraints();
		gbc_txtMinLength.insets = new Insets(0, 0, 5, 0);
		gbc_txtMinLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMinLength.gridx = 1;
		gbc_txtMinLength.gridy = 3;
		panel.add(txtMinLength, gbc_txtMinLength);
		txtMinLength.setColumns(10);
		
		JLabel lblMaxLineGap = new JLabel("Max Line Gap");
		GridBagConstraints gbc_lblMaxLineGap = new GridBagConstraints();
		gbc_lblMaxLineGap.anchor = GridBagConstraints.WEST;
		gbc_lblMaxLineGap.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxLineGap.gridx = 0;
		gbc_lblMaxLineGap.gridy = 4;
		panel.add(lblMaxLineGap, gbc_lblMaxLineGap);
		
		txtMaxLineGap = new JTextField();
		GridBagConstraints gbc_txtMaxLineGap = new GridBagConstraints();
		gbc_txtMaxLineGap.insets = new Insets(0, 0, 5, 0);
		gbc_txtMaxLineGap.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaxLineGap.gridx = 1;
		gbc_txtMaxLineGap.gridy = 4;
		panel.add(txtMaxLineGap, gbc_txtMaxLineGap);
		txtMaxLineGap.setColumns(10);
		
		JLabel lblLoRadians = new JLabel("Lo Radians");
		GridBagConstraints gbc_lblLoRadians = new GridBagConstraints();
		gbc_lblLoRadians.anchor = GridBagConstraints.WEST;
		gbc_lblLoRadians.insets = new Insets(0, 0, 5, 5);
		gbc_lblLoRadians.gridx = 0;
		gbc_lblLoRadians.gridy = 5;
		panel.add(lblLoRadians, gbc_lblLoRadians);
		
		txtLoRadians = new JTextField();
		GridBagConstraints gbc_txtLoRadians = new GridBagConstraints();
		gbc_txtLoRadians.insets = new Insets(0, 0, 5, 0);
		gbc_txtLoRadians.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLoRadians.gridx = 1;
		gbc_txtLoRadians.gridy = 5;
		panel.add(txtLoRadians, gbc_txtLoRadians);
		txtLoRadians.setColumns(10);
		
		JLabel lblHiRadians = new JLabel("Hi Radians");
		GridBagConstraints gbc_lblHiRadians = new GridBagConstraints();
		gbc_lblHiRadians.anchor = GridBagConstraints.WEST;
		gbc_lblHiRadians.insets = new Insets(0, 0, 0, 5);
		gbc_lblHiRadians.gridx = 0;
		gbc_lblHiRadians.gridy = 6;
		panel.add(lblHiRadians, gbc_lblHiRadians);
		
		txtHiRadians = new JTextField();
		GridBagConstraints gbc_txtHiRadians = new GridBagConstraints();
		gbc_txtHiRadians.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHiRadians.gridx = 1;
		gbc_txtHiRadians.gridy = 6;
		panel.add(txtHiRadians, gbc_txtHiRadians);
		txtHiRadians.setColumns(10);
	}
}
