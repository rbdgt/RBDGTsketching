package be.rbdgt.util;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelCreator {

	public static JPanel getPanel(String type) {
		JPanel sourcePanel = new JPanel();
		sourcePanel.setBounds(10, 50, 450, 200);
		GridBagLayout gbl_sourcePanel = new GridBagLayout();
		gbl_sourcePanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_sourcePanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_sourcePanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_sourcePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		sourcePanel.setLayout(gbl_sourcePanel);
		
		
		System.out.println("Getting panel for type: "+type);
		
		
		switch (type) {
		case "Original Image":
			sourcePanel.add(getInvertLabel().getControl(), getInvertLabel().gbc);
			sourcePanel.add(getInvertCheckBox().getControl(), getInvertCheckBox().gbc);
			return sourcePanel;
		case "Original High Contrast Image":
			sourcePanel.add(getInvertLabel().getControl(), getInvertLabel().gbc);
			sourcePanel.add(getInvertCheckBox().getControl(), getInvertCheckBox().gbc);
			System.out.println("ohci");
			return sourcePanel;
		case "foi":
			sourcePanel.add(getInvertLabel().getControl(), getInvertLabel().gbc);
			sourcePanel.add(getInvertCheckBox().getControl(), getInvertCheckBox().gbc);
			sourcePanel.add(getShapeLabel().getControl(), getShapeLabel().gbc);
			sourcePanel.add(getShapeCombobox().getControl(), getShapeCombobox().gbc);
			sourcePanel.add(getRotationLabel().getControl(), getRotationLabel().gbc);
			sourcePanel.add(getRotationSlider().getControl(), getRotationSlider().gbc);
			sourcePanel.add(getRotationText().getControl(), getRotationText().gbc);
			sourcePanel.add(getShrinkLabel().getControl(), getShrinkLabel().gbc);
			sourcePanel.add(getShrinkText().getControl(), getShrinkText().gbc);
			return sourcePanel;
		case "fohi":
			sourcePanel.add(getInvertLabel().getControl(), getInvertLabel().gbc);
			sourcePanel.add(getInvertCheckBox().getControl(), getInvertCheckBox().gbc);
			sourcePanel.add(getShapeLabel().getControl(), getShapeLabel().gbc);
			sourcePanel.add(getShapeCombobox().getControl(), getShapeCombobox().gbc);
			sourcePanel.add(getRotationLabel().getControl(), getRotationLabel().gbc);
			sourcePanel.add(getRotationSlider().getControl(), getRotationSlider().gbc);
			sourcePanel.add(getRotationText().getControl(), getRotationText().gbc);
			sourcePanel.add(getShrinkLabel().getControl(), getShrinkLabel().gbc);
			sourcePanel.add(getShrinkText().getControl(), getShrinkText().gbc);
			return sourcePanel;
		case "fohci":
			sourcePanel.add(getInvertLabel().getControl(), getInvertLabel().gbc);
			sourcePanel.add(getInvertCheckBox().getControl(), getInvertCheckBox().gbc);
			sourcePanel.add(getShapeLabel().getControl(), getShapeLabel().gbc);
			sourcePanel.add(getShapeCombobox().getControl(), getShapeCombobox().gbc);
			sourcePanel.add(getRotationLabel().getControl(), getRotationLabel().gbc);
			sourcePanel.add(getRotationSlider().getControl(), getRotationSlider().gbc);
			sourcePanel.add(getRotationText().getControl(), getRotationText().gbc);
			sourcePanel.add(getShrinkLabel().getControl(), getShrinkLabel().gbc);
			sourcePanel.add(getShrinkText().getControl(), getShrinkText().gbc);
			return sourcePanel;
		case "fci":
			sourcePanel.add(getInvertLabel().getControl(), getInvertLabel().gbc);
			sourcePanel.add(getInvertCheckBox().getControl(), getInvertCheckBox().gbc);
			sourcePanel.add(getShapeLabel().getControl(), getShapeLabel().gbc);
			sourcePanel.add(getShapeCombobox().getControl(), getShapeCombobox().gbc);
			sourcePanel.add(getRotationLabel().getControl(), getRotationLabel().gbc);
			sourcePanel.add(getRotationSlider().getControl(), getRotationSlider().gbc);
			sourcePanel.add(getRotationText().getControl(), getRotationText().gbc);
			sourcePanel.add(getShrinkLabel().getControl(), getShrinkLabel().gbc);
			sourcePanel.add(getShrinkText().getControl(), getShrinkText().gbc);
			sourcePanel.add(getLCLabel().getControl(), getLCLabel().gbc);
			sourcePanel.add(getLCText().getControl(), getLCText().gbc);
			sourcePanel.add(getRCLabel().getControl(), getRCLabel().gbc);
			sourcePanel.add(getRCText().getControl(), getRCText().gbc);

			return sourcePanel;
		case "fchi":
			sourcePanel.add(getInvertLabel().getControl(), getInvertLabel().gbc);
			sourcePanel.add(getInvertCheckBox().getControl(), getInvertCheckBox().gbc);
			sourcePanel.add(getShapeLabel().getControl(), getShapeLabel().gbc);
			sourcePanel.add(getShapeCombobox().getControl(), getShapeCombobox().gbc);
			sourcePanel.add(getRotationLabel().getControl(), getRotationLabel().gbc);
			sourcePanel.add(getRotationSlider().getControl(), getRotationSlider().gbc);
			sourcePanel.add(getRotationText().getControl(), getRotationText().gbc);
			sourcePanel.add(getShrinkLabel().getControl(), getShrinkLabel().gbc);
			sourcePanel.add(getShrinkText().getControl(), getShrinkText().gbc);
			sourcePanel.add(getLCLabel().getControl(), getLCLabel().gbc);
			sourcePanel.add(getLCText().getControl(), getLCText().gbc);
			sourcePanel.add(getRCLabel().getControl(), getRCLabel().gbc);
			sourcePanel.add(getRCText().getControl(), getRCText().gbc);
			return sourcePanel;
		case "ci":
			sourcePanel.add(getInvertLabel().getControl(), getInvertLabel().gbc);
			sourcePanel.add(getInvertCheckBox().getControl(), getInvertCheckBox().gbc);
			sourcePanel.add(getLCLabel().getControl(), getLCLabel().gbc);
			sourcePanel.add(getLCText().getControl(), getLCText().gbc);
			sourcePanel.add(getRCLabel().getControl(), getRCLabel().gbc);
			sourcePanel.add(getRCText().getControl(), getRCText().gbc);
			return sourcePanel;
		default:
			return sourcePanel;
		}
	}

	private static Pair getInvertLabel() {
		JLabel lblInvert = new JLabel("Invert");
		GridBagConstraints gbc_lblInvert = new GridBagConstraints();
		gbc_lblInvert.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvert.gridx = 0;
		gbc_lblInvert.gridy = 0;
		return new Pair(lblInvert, gbc_lblInvert);
	}

	private static Pair getInvertCheckBox() {
		JCheckBox chckbxInvert = new JCheckBox("");
		chckbxInvert.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxInvert = new GridBagConstraints();
		gbc_chckbxInvert.anchor = GridBagConstraints.WEST;
		gbc_chckbxInvert.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxInvert.gridx = 1;
		gbc_chckbxInvert.gridy = 0;
		return new Pair(chckbxInvert, gbc_chckbxInvert);
	}

	private static Pair getShapeLabel() {
		JLabel lblShape = new JLabel("Shape");
		GridBagConstraints gbc_lblShape = new GridBagConstraints();
		gbc_lblShape.anchor = GridBagConstraints.EAST;
		gbc_lblShape.insets = new Insets(0, 0, 5, 5);
		gbc_lblShape.gridx = 0;
		gbc_lblShape.gridy = 1;
		return new Pair(lblShape, gbc_lblShape);
	}

	private static Pair getShapeCombobox() {
		JComboBox cbbShape = new JComboBox();
		cbbShape.setModel(new DefaultComboBoxModel(new String[] { "Circle", "Triangle", "Square" }));
		GridBagConstraints gbc_cbbShape = new GridBagConstraints();
		gbc_cbbShape.insets = new Insets(0, 0, 5, 5);
		gbc_cbbShape.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbShape.gridx = 1;
		gbc_cbbShape.gridy = 1;
		return new Pair(cbbShape, gbc_cbbShape);
	}

	private static Pair getRotationLabel() {
		JLabel lblRotation = new JLabel("Rotation");
		GridBagConstraints gbc_lblRotation = new GridBagConstraints();
		gbc_lblRotation.insets = new Insets(0, 0, 5, 5);
		gbc_lblRotation.gridx = 0;
		gbc_lblRotation.gridy = 2;
		return new Pair(lblRotation, gbc_lblRotation);
	}

	private static Pair getRotationSlider() {
		JSlider sliderRotation = new JSlider();
		sliderRotation.setPaintTicks(true);
		sliderRotation.setSnapToTicks(true);
		sliderRotation.setValue(0);
		sliderRotation.setMinorTickSpacing(5);
		sliderRotation.setMajorTickSpacing(10);
		sliderRotation.setMinimum(-180);
		sliderRotation.setMaximum(180);
		GridBagConstraints gbc_sliderRotation = new GridBagConstraints();
		gbc_sliderRotation.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderRotation.insets = new Insets(0, 0, 5, 5);
		gbc_sliderRotation.gridx = 1;
		gbc_sliderRotation.gridy = 2;
		return new Pair(sliderRotation, gbc_sliderRotation);
	}

	private static Pair getRotationText() {
		JTextField txtRotation = new JTextField();
		txtRotation.setHorizontalAlignment(SwingConstants.CENTER);
		txtRotation.setText("0");
		GridBagConstraints gbc_txtRotation = new GridBagConstraints();
		gbc_txtRotation.anchor = GridBagConstraints.EAST;
		gbc_txtRotation.insets = new Insets(0, 0, 5, 0);
		gbc_txtRotation.gridx = 2;
		gbc_txtRotation.gridy = 2;
		txtRotation.setColumns(5);
		return new Pair(txtRotation, gbc_txtRotation);
	}

	private static Pair getShrinkLabel() {
		JLabel lblShrink = new JLabel("Shrink");
		GridBagConstraints gbc_lblShrink = new GridBagConstraints();
		gbc_lblShrink.anchor = GridBagConstraints.EAST;
		gbc_lblShrink.insets = new Insets(0, 0, 5, 5);
		gbc_lblShrink.gridx = 0;
		gbc_lblShrink.gridy = 3;
		return new Pair(lblShrink, gbc_lblShrink);
	}

	private static Pair getShrinkText() {
		JTextField txtShrink = new JTextField();
		GridBagConstraints gbc_txtShrink = new GridBagConstraints();
		gbc_txtShrink.anchor = GridBagConstraints.NORTH;
		gbc_txtShrink.insets = new Insets(0, 0, 5, 5);
		gbc_txtShrink.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShrink.gridx = 1;
		gbc_txtShrink.gridy = 3;
		txtShrink.setColumns(10);
		return new Pair(txtShrink, gbc_txtShrink);
	}

	private static Pair getLCLabel() {
		JLabel lblRC = new JLabel("lC");
		GridBagConstraints gbc_lblLc = new GridBagConstraints();
		gbc_lblLc.anchor = GridBagConstraints.EAST;
		gbc_lblLc.insets = new Insets(0, 0, 5, 5);
		gbc_lblLc.gridx = 0;
		gbc_lblLc.gridy = 4;
		return new Pair(lblRC, gbc_lblLc);
	}

	private static Pair getLCText() {
		JTextField txtLC = new JTextField();
		GridBagConstraints gbc_txtLC = new GridBagConstraints();
		gbc_txtLC.anchor = GridBagConstraints.NORTH;
		gbc_txtLC.insets = new Insets(0, 0, 5, 5);
		gbc_txtLC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLC.gridx = 1;
		gbc_txtLC.gridy = 4;
		txtLC.setColumns(10);
		return new Pair(txtLC, gbc_txtLC);
	}

	private static Pair getRCLabel() {
		JLabel lblRc = new JLabel("rC");
		GridBagConstraints gbc_lblRc = new GridBagConstraints();
		gbc_lblRc.anchor = GridBagConstraints.EAST;
		gbc_lblRc.insets = new Insets(0, 0, 0, 5);
		gbc_lblRc.gridx = 0;
		gbc_lblRc.gridy = 5;
		return new Pair(lblRc, gbc_lblRc);
	}

	private static Pair getRCText() {
		JTextField txtRC = new JTextField();
		GridBagConstraints gbc_txtRC = new GridBagConstraints();
		gbc_txtRC.insets = new Insets(0, 0, 0, 5);
		gbc_txtRC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRC.gridx = 1;
		gbc_txtRC.gridy = 5;
		txtRC.setColumns(10);
		return new Pair(txtRC,gbc_txtRC);
	}
	

}
