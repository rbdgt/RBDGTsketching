package be.rbdgt.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import org.apache.commons.io.FilenameUtils;

import be.rbdgt.PictureSketchV2;
import be.rbdgt.objects.instructions.InstructionObject;
import processing.core.PApplet;

import javax.swing.JLabel;

public class RBDGTgui {

	private JFrame frmRbdgt;
	// InstructionsObject instr;
	private static JList<InstructionObject> list = new JList<InstructionObject>();
	private static String selectedValue = null;
	private static String[] fileData = new String[5];

	DefaultListModel<InstructionObject> m;
	private JTextField txtFile;
	private JTextField txtOutputsuffix;

	private PictureSketchV2 pa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RBDGTgui window = new RBDGTgui();
					window.frmRbdgt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RBDGTgui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRbdgt = new JFrame();
		frmRbdgt.setTitle("RBDGT");
		frmRbdgt.setBounds(100, 100, 702, 506);
		frmRbdgt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmRbdgt.setJMenuBar(menuBar);

		JMenu mnChooseInstr = new JMenu("New Instruction");
		menuBar.add(mnChooseInstr);

		JMenuItem mntmContour = new JMenuItem("Contour");
		mntmContour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContourFrame contourFrame = new ContourFrame();
				contourFrame.setVisible(true);
			}
		});
		mnChooseInstr.add(mntmContour);

		JMenuItem mntmDelaunay = new JMenuItem("Delaunay");
		mntmDelaunay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelaunayFrame delaunayFrame = new DelaunayFrame();
				delaunayFrame.setVisible(true);
			}
		});
		mnChooseInstr.add(mntmDelaunay);

		JMenuItem mntmDelaunaysquares = new JMenuItem("Delaunaysquares");
		mntmDelaunaysquares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelaunaySquaresFrame delaunaySquaresFrame = new DelaunaySquaresFrame();
				delaunaySquaresFrame.setVisible(true);
			}
		});
		mnChooseInstr.add(mntmDelaunaysquares);

		JMenuItem mntmDistortedLines = new JMenuItem("Distorted Lines");
		mntmDistortedLines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DistortedLinesFrame distortedLinesFrame = new DistortedLinesFrame();
				distortedLinesFrame.setVisible(true);
			}
		});
		mnChooseInstr.add(mntmDistortedLines);

		JMenuItem mntmFacepattern = new JMenuItem("Facepattern");
		mntmFacepattern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacepatternFrame facepatternFrame = new FacepatternFrame();
				facepatternFrame.setVisible(true);
			}
		});
		mnChooseInstr.add(mntmFacepattern);

		JMenuItem mntmHoughlines = new JMenuItem("Houghlines");
		mntmHoughlines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HoughlinesFrame houghlinesFrame = new HoughlinesFrame();
				houghlinesFrame.setVisible(true);
			}
		});
		mnChooseInstr.add(mntmHoughlines);

		JMenuItem mntmSketchlines = new JMenuItem("Sketchlines");
		mntmSketchlines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SketchlinesFrame sketchlinesFrame = new SketchlinesFrame();
				sketchlinesFrame.setVisible(true);
			}
		});
		mnChooseInstr.add(mntmSketchlines);

		JMenuItem mntmSquarehatch = new JMenuItem("Squarehatch");
		mntmSquarehatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SquareHatchFrame squareHatchFrmae = new SquareHatchFrame();
				squareHatchFrmae.setVisible(true);
			}
		});
		mnChooseInstr.add(mntmSquarehatch);

		JMenuItem mntmVertex = new JMenuItem("Vertex");
		mntmVertex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VertexFrame vertexFrame = new VertexFrame();
				vertexFrame.setVisible(true);
			}
		});
		mnChooseInstr.add(mntmVertex);

		JMenuItem mntmVoronoi = new JMenuItem("Voronoi");
		mntmVoronoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoronoiFrame voronoiFrame = new VoronoiFrame();
				voronoiFrame.setVisible(true);
			}
		});
		mnChooseInstr.add(mntmVoronoi);

		frmRbdgt.getContentPane().setLayout(null);

		m = new DefaultListModel<>();

		// for (int i = 1; i <= 5; i++) {
		// m.addElement(i);
		// }

		m.addElement(new InstructionObject());

		// list = new JList(new String[] { "1", "2", "3", "4", "5" });
		list = new JList(m);
		list.setBounds(8, 77, 596, 294);
		frmRbdgt.getContentPane().add(list);

		JButton btnUp = new JButton("");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstructionObject listobject = (InstructionObject) list.getSelectedValue();
				if (listobject != null && list.getSelectedIndex() != 0) {
					int newIndex = list.getSelectedIndex() - 1;
					m.insertElementAt(listobject, newIndex);
					m.removeElementAt(list.getSelectedIndex());
					list.setSelectedIndex(newIndex);
				}
			}
		});

		btnUp.setIcon(new ImageIcon(
				RBDGTgui.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-fewer-details@2x.png")));
		btnUp.setBounds(616, 77, 60, 80);
		frmRbdgt.getContentPane().add(btnUp);

		JButton btnDown = new JButton("");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstructionObject listobject = (InstructionObject) list.getSelectedValue();
				if (listobject != null && list.getSelectedIndex() != m.getSize() - 1) {
					int newIndex = list.getSelectedIndex() + 2;
					m.insertElementAt(listobject, newIndex);
					m.removeElementAt(list.getSelectedIndex());
					list.setSelectedIndex(newIndex - 1);
				}
			}
		});
		btnDown.setIcon(new ImageIcon(
				RBDGTgui.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-more-details@2x.png")));
		btnDown.setBounds(616, 159, 60, 80);
		frmRbdgt.getContentPane().add(btnDown);

		JButton btnOK = new JButton("");
		btnOK.setIcon(new ImageIcon(RBDGTgui.class.getResource("/icon/icon-32.png")));
		btnOK.setSelectedIcon(null);
		btnOK.setBounds(8, 392, 668, 41);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// InstructionObject[] ioArr = (InstructionObject[])
				// m.toArray();
				fileData[3] = txtOutputsuffix.getText();

				setFileData();

				for (String s : fileData) {
					//System.out.println(s);
				}

				for (Object o : m.toArray()) {
					((InstructionObject) o).setFileData(fileData);
					//System.out.println(o.toString());
				}

				// new PictureSketchV2().runSketch(m.toArray());
				pa = new PictureSketchV2();
				pa.runSketch(fileData);

				//PApplet.main(new String[] { "be.rbdgt.PictureSketchV2" });
				// pa.main(fileData);
				// pa.main(new String[] {"be.rbdgt.PictureSketchV2"});

			}
		});
		frmRbdgt.getContentPane().add(btnOK);

		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(
				RBDGTgui.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-error.png")));
		btnDelete.setBounds(616, 291, 60, 80);
		frmRbdgt.getContentPane().add(btnDelete);

		txtFile = new JTextField();
		txtFile.setBounds(8, 10, 547, 22);
		frmRbdgt.getContentPane().add(txtFile);
		txtFile.setColumns(10);

		JButton btnOpenImg = new JButton("Open");
		btnOpenImg
				.setIcon(new ImageIcon(RBDGTgui.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		btnOpenImg.setSelectedIcon(null);
		btnOpenImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				// D:\Documents\Eclipse_Workspace\RBDGTGUI
				fc.setCurrentDirectory(new File("D:/Documents/Eclipse_Workspace/RBDGTGUI/faces"));
				// Handle open button action.
				if (e.getSource() == btnOpenImg) {
					int returnVal = fc.showOpenDialog(frmRbdgt);

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						// This is where a real application would open the file.

						txtFile.setText(file.getAbsolutePath());

						fileData[0] = file.getParentFile().getAbsolutePath();
						fileData[1] = FilenameUtils.removeExtension(file.getName());
						fileData[2] = FilenameUtils.getExtension(file.getName());

						fileData[4] = "output_" + FilenameUtils.removeExtension(file.getName());

						// System.out.println(file.get);

					} else {
						System.out.println("Open command cancelled by user.");
					}
				}
			}
		});
		btnOpenImg.setBounds(567, 9, 107, 25);
		frmRbdgt.getContentPane().add(btnOpenImg);

		txtOutputsuffix = new JTextField();
		txtOutputsuffix.setBounds(99, 42, 575, 22);
		frmRbdgt.getContentPane().add(txtOutputsuffix);
		txtOutputsuffix.setColumns(10);

		JLabel lblOutputsuffix = new JLabel("Outputsuffix");
		lblOutputsuffix.setBounds(8, 45, 79, 16);
		frmRbdgt.getContentPane().add(lblOutputsuffix);
	}

	private void setFileData() {
		fileData[0] = "D:/Documents/Eclipse_Workspace/RBDGTGUI/faces";
		fileData[1] = "assad";
		fileData[2] = "jpg";
		fileData[3] = "";
		fileData[4] = "output_assad";
	}

}

class ProjectorSketch extends PApplet {
	public void setup() {
	    size(displayWidth>>1, displayHeight>>1, JAVA2D);
	    smooth(4);
	    frameRate(1);
	    strokeWeight(5);
	 
	    println("Inner's sketchPath: \t\"" + sketchPath("") + "\"");
	    println("Inner's dataPath: \t\"" + dataPath("") + "\"\n");
	  }

	public void draw() {
	    line(width, 0, 0, height);
	 
	    saveFrame( dataPath("screen-####.jpg") );
	  }
}
