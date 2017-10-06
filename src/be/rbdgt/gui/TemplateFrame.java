package be.rbdgt.gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.datatransfer.FlavorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.opencv.imgproc.Imgproc;

import be.rbdgt.util.PanelCreator;
import be.rbdgt.util.Source;
import processing.core.PImage;

import java.awt.CardLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class TemplateFrame extends JFrame {

	String[] sources = { "Original Image", "Original High Contrast Image", "Faces Original Images",
			"Faces Original Hollow Image", "Faces Original High Contrast Image", "Faces Canny Edges Image",
			"Faces Canny Edges Hollow Image", "Canny Edges Image" };

	private JPanel contentPane;

	private JLabel lblInvert;
	private JCheckBox chckbxInvert;
	private JLabel lblShape;
	private JComboBox cbbShape = new JComboBox();
	private JLabel lblRotation = new JLabel("Rotation");
	private JSlider sliderRotation = new JSlider();
	private JTextField txtRotation;
	private JLabel lblShrink = new JLabel("Shrink");
	private JTextField txtShrink;
	private JLabel lblLc = new JLabel("lC");
	private JTextField txtLC;
	private JLabel lblRc = new JLabel("rC");
	private JTextField txtRC;

	
	private boolean invert;
	private int shape;
	private int rotation;
	private int shrink;
	private int LC;
	private int RC;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemplateFrame frame = new TemplateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TemplateFrame() {
		setTitle("Template");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnOK.setBounds(401, 485, 89, 23);
		contentPane.add(btnOK);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(300, 485, 89, 23);
		contentPane.add(btnCancel);

		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.setBounds(12, 13, 478, 222);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		JLabel lblSource = new JLabel("Source");
		lblSource.setBounds(10, 14, 46, 14);
		mainPanel.add(lblSource);

		// JPanel ohciPanel = new JPanel();
		// optionPanel.add(ohciPanel, "ohciPanel");

		JComboBox cbbSource = new JComboBox(sources);

		cbbSource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();
				Object selected = comboBox.getSelectedItem();
				// System.out.println(comboBox.getSelectedItem().toString());
				showReqItems(comboBox.getSelectedItem().toString());
			}
		});

		cbbSource.setBounds(66, 11, 400, 20);
		mainPanel.add(cbbSource);
		// optionPanel.setLayout(new CardLayout(0, 0));

		JPanel sourcePanel = new JPanel();
		sourcePanel.setBounds(10, 39, 456, 176);
		mainPanel.add(sourcePanel);
		GridBagLayout gbl_sourcePanel = new GridBagLayout();
		gbl_sourcePanel.columnWidths = new int[] { 47, 21, 30, 200, 57, 66, 0 };
		gbl_sourcePanel.rowHeights = new int[] { 21, 22, 31, 22, 22, 22, 0 };
		gbl_sourcePanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_sourcePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		sourcePanel.setLayout(gbl_sourcePanel);

		lblInvert = new JLabel("Invert");
		GridBagConstraints gbc_lblInvert = new GridBagConstraints();
		gbc_lblInvert.anchor = GridBagConstraints.WEST;
		gbc_lblInvert.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvert.gridx = 0;
		gbc_lblInvert.gridy = 0;
		sourcePanel.add(lblInvert, gbc_lblInvert);

		chckbxInvert = new JCheckBox("");
		chckbxInvert.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxInvert = new GridBagConstraints();
		gbc_chckbxInvert.anchor = GridBagConstraints.WEST;
		gbc_chckbxInvert.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxInvert.gridx = 1;
		gbc_chckbxInvert.gridy = 0;
		sourcePanel.add(chckbxInvert, gbc_chckbxInvert);

		lblShape = new JLabel("Shape");
		GridBagConstraints gbc_lblShape = new GridBagConstraints();
		gbc_lblShape.anchor = GridBagConstraints.WEST;
		gbc_lblShape.insets = new Insets(0, 0, 5, 5);
		gbc_lblShape.gridx = 0;
		gbc_lblShape.gridy = 1;
		sourcePanel.add(lblShape, gbc_lblShape);

		cbbShape = new JComboBox();
		cbbShape.setModel(new DefaultComboBoxModel(new String[] { "Circle", "Triangle", "Square" }));
		GridBagConstraints gbc_cbbShape = new GridBagConstraints();
		gbc_cbbShape.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbShape.insets = new Insets(0, 0, 5, 0);
		gbc_cbbShape.gridwidth = 5;
		gbc_cbbShape.gridx = 1;
		gbc_cbbShape.gridy = 1;
		sourcePanel.add(cbbShape, gbc_cbbShape);

		lblRotation = new JLabel("Rotation");
		GridBagConstraints gbc_lblRotation = new GridBagConstraints();
		gbc_lblRotation.anchor = GridBagConstraints.WEST;
		gbc_lblRotation.insets = new Insets(0, 0, 5, 5);
		gbc_lblRotation.gridx = 0;
		gbc_lblRotation.gridy = 2;
		sourcePanel.add(lblRotation, gbc_lblRotation);

		sliderRotation = new JSlider();
		sliderRotation.setPaintTicks(true);
		sliderRotation.setSnapToTicks(true);
		sliderRotation.setValue(0);
		sliderRotation.setMinorTickSpacing(5);
		sliderRotation.setMajorTickSpacing(10);
		sliderRotation.setMinimum(-180);
		sliderRotation.setMaximum(180);
		GridBagConstraints gbc_sliderRotation = new GridBagConstraints();
		gbc_sliderRotation.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderRotation.gridwidth = 4;
		gbc_sliderRotation.insets = new Insets(0, 0, 5, 5);
		gbc_sliderRotation.gridx = 1;
		gbc_sliderRotation.gridy = 2;
		sourcePanel.add(sliderRotation, gbc_sliderRotation);

		sliderRotation.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider rs = (JSlider) e.getSource();
				txtRotation.setText(Integer.toString(rs.getValue()));
			}
		});

		txtRotation = new JTextField();
		txtRotation.setHorizontalAlignment(SwingConstants.CENTER);
		txtRotation.setText("0");
		GridBagConstraints gbc_txtRotation = new GridBagConstraints();
		gbc_txtRotation.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRotation.insets = new Insets(0, 0, 5, 0);
		gbc_txtRotation.gridx = 5;
		gbc_txtRotation.gridy = 2;
		sourcePanel.add(txtRotation, gbc_txtRotation);
		txtRotation.setColumns(5);

		txtRotation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField rtxt = (JTextField) e.getSource();
				sliderRotation.setValue(Integer.parseInt(rtxt.getText()));
			}
		});

		lblShrink = new JLabel("Shrink");
		GridBagConstraints gbc_lblShrink = new GridBagConstraints();
		gbc_lblShrink.anchor = GridBagConstraints.WEST;
		gbc_lblShrink.insets = new Insets(0, 0, 5, 5);
		gbc_lblShrink.gridx = 0;
		gbc_lblShrink.gridy = 3;
		sourcePanel.add(lblShrink, gbc_lblShrink);

		txtShrink = new JTextField();
		GridBagConstraints gbc_txtShrink = new GridBagConstraints();
		gbc_txtShrink.anchor = GridBagConstraints.NORTH;
		gbc_txtShrink.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShrink.insets = new Insets(0, 0, 5, 0);
		gbc_txtShrink.gridwidth = 5;
		gbc_txtShrink.gridx = 1;
		gbc_txtShrink.gridy = 3;
		sourcePanel.add(txtShrink, gbc_txtShrink);
		txtShrink.setColumns(10);

		lblLc = new JLabel("lC");
		GridBagConstraints gbc_lblLc = new GridBagConstraints();
		gbc_lblLc.anchor = GridBagConstraints.WEST;
		gbc_lblLc.insets = new Insets(0, 0, 5, 5);
		gbc_lblLc.gridx = 0;
		gbc_lblLc.gridy = 4;
		sourcePanel.add(lblLc, gbc_lblLc);

		txtLC = new JTextField();
		GridBagConstraints gbc_txtLC = new GridBagConstraints();
		gbc_txtLC.anchor = GridBagConstraints.NORTH;
		gbc_txtLC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLC.insets = new Insets(0, 0, 5, 0);
		gbc_txtLC.gridwidth = 5;
		gbc_txtLC.gridx = 1;
		gbc_txtLC.gridy = 4;
		sourcePanel.add(txtLC, gbc_txtLC);
		txtLC.setColumns(10);

		lblRc = new JLabel("rC");
		GridBagConstraints gbc_lblRc = new GridBagConstraints();
		gbc_lblRc.anchor = GridBagConstraints.WEST;
		gbc_lblRc.insets = new Insets(0, 0, 0, 5);
		gbc_lblRc.gridx = 0;
		gbc_lblRc.gridy = 5;
		sourcePanel.add(lblRc, gbc_lblRc);

		txtRC = new JTextField();
		GridBagConstraints gbc_txtRC = new GridBagConstraints();
		gbc_txtRC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRC.gridwidth = 5;
		gbc_txtRC.gridx = 1;
		gbc_txtRC.gridy = 5;
		sourcePanel.add(txtRC, gbc_txtRC);
		txtRC.setColumns(10);

		initPanel();
	}

	private void initPanel() {
		lblInvert.setVisible(true);
		chckbxInvert.setVisible(true);
		lblShape.setVisible(false);
		cbbShape.setVisible(false);
		lblRotation.setVisible(false);
		sliderRotation.setVisible(false);
		txtRotation.setVisible(false);
		lblShrink.setVisible(false);
		txtShrink.setVisible(false);
		lblLc.setVisible(false);
		txtLC.setVisible(false);
		lblRc.setVisible(false);
		txtRC.setVisible(false);
	}

	private void showReqItems(String sourceType) {
		System.out.println(sourceType);
		chckbxInvert.setSelected(false);
		cbbShape.setSelectedIndex(0);
		sliderRotation.setValue(0);
		txtShrink.setText("");
		txtLC.setText("");
		txtRC.setText("");

		switch (sourceType) {
		case "Original Image":
			lblInvert.setVisible(true);
			chckbxInvert.setVisible(true);
			lblShape.setVisible(false);
			cbbShape.setVisible(false);
			lblRotation.setVisible(false);
			sliderRotation.setVisible(false);
			txtRotation.setVisible(false);
			lblShrink.setVisible(false);
			txtShrink.setVisible(false);
			lblLc.setVisible(false);
			txtLC.setVisible(false);
			lblRc.setVisible(false);
			txtRC.setVisible(false);
			break;
		case "Original High Contrast Image":
			lblInvert.setVisible(true);
			chckbxInvert.setVisible(true);
			lblShape.setVisible(false);
			cbbShape.setVisible(false);
			lblRotation.setVisible(false);
			sliderRotation.setVisible(false);
			txtRotation.setVisible(false);
			lblShrink.setVisible(false);
			txtShrink.setVisible(false);
			lblLc.setVisible(false);
			txtLC.setVisible(false);
			lblRc.setVisible(false);
			txtRC.setVisible(false);
			break;
		case "Faces Original Images":
			lblInvert.setVisible(true);
			chckbxInvert.setVisible(true);
			lblShape.setVisible(true);
			cbbShape.setVisible(true);
			lblRotation.setVisible(true);
			sliderRotation.setVisible(true);
			txtRotation.setVisible(true);
			lblShrink.setVisible(true);
			txtShrink.setVisible(true);
			lblLc.setVisible(false);
			txtLC.setVisible(false);
			lblRc.setVisible(false);
			txtRC.setVisible(false);
			break;
		case "Faces Original Hollow Image":
			lblInvert.setVisible(true);
			chckbxInvert.setVisible(true);
			lblShape.setVisible(true);
			cbbShape.setVisible(true);
			lblRotation.setVisible(true);
			sliderRotation.setVisible(true);
			txtRotation.setVisible(true);
			lblShrink.setVisible(true);
			txtShrink.setVisible(true);
			lblLc.setVisible(false);
			txtLC.setVisible(false);
			lblRc.setVisible(false);
			txtRC.setVisible(false);
			break;
		case "Faces Original High Contrast Image":
			lblInvert.setVisible(true);
			chckbxInvert.setVisible(true);
			lblShape.setVisible(true);
			cbbShape.setVisible(true);
			lblRotation.setVisible(true);
			sliderRotation.setVisible(true);
			txtRotation.setVisible(true);
			lblShrink.setVisible(true);
			txtShrink.setVisible(true);
			lblLc.setVisible(false);
			txtLC.setVisible(false);
			lblRc.setVisible(false);
			txtRC.setVisible(false);
			break;
		case "Faces Canny Edges Image":
			lblInvert.setVisible(true);
			chckbxInvert.setVisible(true);
			lblShape.setVisible(true);
			cbbShape.setVisible(true);
			lblRotation.setVisible(true);
			sliderRotation.setVisible(true);
			txtRotation.setVisible(true);
			lblShrink.setVisible(true);
			txtShrink.setVisible(true);
			lblLc.setVisible(true);
			txtLC.setVisible(true);
			lblRc.setVisible(true);
			txtRC.setVisible(true);
			break;
		case "Faces Canny Edges Hollow Image":
			lblInvert.setVisible(true);
			chckbxInvert.setVisible(true);
			lblShape.setVisible(true);
			cbbShape.setVisible(true);
			lblRotation.setVisible(true);
			sliderRotation.setVisible(true);
			txtRotation.setVisible(true);
			lblShrink.setVisible(true);
			txtShrink.setVisible(true);
			lblLc.setVisible(true);
			txtLC.setVisible(true);
			lblRc.setVisible(true);
			txtRC.setVisible(true);
			break;
		case "Canny Edges Image":
			lblInvert.setVisible(true);
			chckbxInvert.setVisible(true);
			lblShape.setVisible(false);
			cbbShape.setVisible(false);
			lblRotation.setVisible(false);
			sliderRotation.setVisible(false);
			txtRotation.setVisible(false);
			lblShrink.setVisible(false);
			txtShrink.setVisible(false);
			lblLc.setVisible(true);
			txtLC.setVisible(true);
			lblRc.setVisible(true);
			txtRC.setVisible(true);
			break;
		}

	}
}
