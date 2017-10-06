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

public class FacepatternFrame extends JFrame {

	String[] sources = { "Original Image", "Original High Contrast Image", "Faces Original Images",
			"Faces Original Hollow Image", "Faces Original High Contrast Image", "Faces Canny Edges Image",
			"Faces Canny Edges Hollow Image", "Canny Edges Image" };

	private JPanel contentPane;


	private JLabel lblFaceNr;
	private JTextField txtFaceNr;
	private JLabel lblShape;
	private JComboBox cbbShape = new JComboBox();
	private JLabel lblRotation = new JLabel("Rotation");
	private JSlider sliderRotation = new JSlider();
	private JTextField txtRotation;
	private JLabel lblShrink = new JLabel("Shrink");
	private JTextField txtShrink;
	private JLabel lblPencolor = new JLabel("Pencolor");
	private JComboBox cbbPencolor = new JComboBox();
	private JLabel lblStrokeweight = new JLabel("Strokeweight");
	private JTextField txtStrokeweight;
	private JLabel lblPattern = new JLabel("Pattern");
	private JComboBox cbbPattern = new JComboBox();
	private JLabel lblTilecount = new JLabel("Tilecount");
	private JTextField txtTilecount;

	/**
	 * Create the frame.
	 */
	public FacepatternFrame() {
		setTitle("Facepattern");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 339);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnOK.setBounds(400, 264, 89, 23);
		contentPane.add(btnOK);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(299, 264, 89, 23);
		contentPane.add(btnCancel);
		// optionPanel.setLayout(new CardLayout(0, 0));

		JPanel sourcePanel = new JPanel();
		sourcePanel.setBounds(12, 13, 477, 239);
		contentPane.add(sourcePanel);
		GridBagLayout gbl_sourcePanel = new GridBagLayout();
		gbl_sourcePanel.columnWidths = new int[] { 47, 21, 30, 200, 57, 66, 0 };
		gbl_sourcePanel.rowHeights = new int[] { 21, 22, 31, 22, 22, 22, 0, 0, 0 };
		gbl_sourcePanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_sourcePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		sourcePanel.setLayout(gbl_sourcePanel);

		lblFaceNr = new JLabel("FaceNr.");
		GridBagConstraints gbc_lblFaceNr = new GridBagConstraints();
		gbc_lblFaceNr.anchor = GridBagConstraints.WEST;
		gbc_lblFaceNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblFaceNr.gridx = 0;
		gbc_lblFaceNr.gridy = 0;
		sourcePanel.add(lblFaceNr, gbc_lblFaceNr);

		txtFaceNr = new JTextField();
		GridBagConstraints gbc_txtFaceNr = new GridBagConstraints();
		gbc_txtFaceNr.gridwidth = 5;
		gbc_txtFaceNr.insets = new Insets(0, 0, 5, 0);
		gbc_txtFaceNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFaceNr.gridx = 1;
		gbc_txtFaceNr.gridy = 0;
		sourcePanel.add(txtFaceNr, gbc_txtFaceNr);
		txtFaceNr.setColumns(10);

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

		GridBagConstraints gbc_lblPencolor = new GridBagConstraints();
		gbc_lblPencolor.anchor = GridBagConstraints.WEST;
		gbc_lblPencolor.insets = new Insets(0, 0, 5, 5);
		gbc_lblPencolor.gridx = 0;
		gbc_lblPencolor.gridy = 4;
		sourcePanel.add(lblPencolor, gbc_lblPencolor);

		GridBagConstraints gbc_cbbPencolor = new GridBagConstraints();
		gbc_cbbPencolor.gridwidth = 5;
		gbc_cbbPencolor.insets = new Insets(0, 0, 5, 0);
		gbc_cbbPencolor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbPencolor.gridx = 1;
		gbc_cbbPencolor.gridy = 4;
		sourcePanel.add(cbbPencolor, gbc_cbbPencolor);

		GridBagConstraints gbc_lblStrokeweight = new GridBagConstraints();
		gbc_lblStrokeweight.anchor = GridBagConstraints.WEST;
		gbc_lblStrokeweight.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrokeweight.gridx = 0;
		gbc_lblStrokeweight.gridy = 5;
		sourcePanel.add(lblStrokeweight, gbc_lblStrokeweight);

		txtStrokeweight = new JTextField();
		GridBagConstraints gbc_txtStrokeweight = new GridBagConstraints();
		gbc_txtStrokeweight.insets = new Insets(0, 0, 5, 0);
		gbc_txtStrokeweight.gridwidth = 5;
		gbc_txtStrokeweight.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStrokeweight.gridx = 1;
		gbc_txtStrokeweight.gridy = 5;
		sourcePanel.add(txtStrokeweight, gbc_txtStrokeweight);
		txtStrokeweight.setColumns(10);

		GridBagConstraints gbc_lblPattern = new GridBagConstraints();
		gbc_lblPattern.anchor = GridBagConstraints.WEST;
		gbc_lblPattern.insets = new Insets(0, 0, 5, 5);
		gbc_lblPattern.gridx = 0;
		gbc_lblPattern.gridy = 6;
		sourcePanel.add(lblPattern, gbc_lblPattern);

		GridBagConstraints gbc_cbbPattern = new GridBagConstraints();
		gbc_cbbPattern.gridwidth = 5;
		gbc_cbbPattern.insets = new Insets(0, 0, 5, 0);
		gbc_cbbPattern.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbPattern.gridx = 1;
		gbc_cbbPattern.gridy = 6;
		sourcePanel.add(cbbPattern, gbc_cbbPattern);

		GridBagConstraints gbc_lblTilecount = new GridBagConstraints();
		gbc_lblTilecount.anchor = GridBagConstraints.WEST;
		gbc_lblTilecount.insets = new Insets(0, 0, 0, 5);
		gbc_lblTilecount.gridx = 0;
		gbc_lblTilecount.gridy = 7;
		sourcePanel.add(lblTilecount, gbc_lblTilecount);

		txtTilecount = new JTextField();
		GridBagConstraints gbc_txtTilecount = new GridBagConstraints();
		gbc_txtTilecount.gridwidth = 5;
		gbc_txtTilecount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTilecount.gridx = 1;
		gbc_txtTilecount.gridy = 7;
		sourcePanel.add(txtTilecount, gbc_txtTilecount);
		txtTilecount.setColumns(10);

		initPanel();
	}

	private void initPanel() {
		lblFaceNr.setVisible(true);
	}
}
