package com.j2msi.main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.*;

import com.j2msi.logic.Comandrun;

public class UIEntry implements ActionListener {
	private static String labelPrefix = "Number of button clicks: ";
	private int numClicks = 0;
	final JLabel label = new JLabel(labelPrefix + "0    ");
	static JFrame frame = new JFrame("j2msi");
	JTextField f1;
	JTextField f2;
	JTextField f3;
	JTextField f4;
	JTextField f5;
	JTextField f6;
	JTextField f7;
	private Comandrun cmdrun;
 
	// Specify the look and feel to use by defining the LOOKANDFEEL constant
	// Valid values are: null (use the default), "Metal", "System", "Motif",
	// and "GTK"
	final static String LOOKANDFEEL = "System";

	// If you choose the Metal L&F, you can also choose a theme.
	// Specify the theme to use by defining the THEME constant
	// Valid values are: "DefaultMetal", "Ocean", and "Test"
	final static String THEME = "Test";

	public Component createComponents() {

		// JButton button1 = new JButton("I'm a Swing button1 !");
		// button1.setMnemonic(KeyEvent.VK_I);
		// button1.setSize(10, 10);
		//
		// //button1.setBounds(10, 2, 20, 20);
		// button1.addActionListener(this);
		// label.setLabelFor(button1);
		//

		GridBagLayout gl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		JPanel pane = new JPanel();
		pane.setLayout(gl);

		// pane.setBounds(234, 200,1000, 300);
		// pane.setMinimumSize(new Dimension(500, 500));
		// pane.setMaximumSize(new Dimension(200, 200));

		// line 1----------------------
		JLabel l1 = new JLabel("AppName(exe name)");
		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(l1, c);
		l1.setBackground(Color.red);
		pane.add(l1);

		f1 = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 160;
		c.ipady = 10;

		gl.setConstraints(f1, c);
		pane.add(f1);

		JButton b1 = new JButton("  ..... ");
		b1.setName("appname");
		b1.addActionListener(this);
		b1.setMnemonic(KeyEvent.VK_I);
		b1.setSize(10, 10);

		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(b1, c);
		pane.add(b1);

		// line 2----------------------
		JLabel l2 = new JLabel("SourceBase");
		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(l2, c);
		l2.setBackground(Color.red);
		pane.add(l2);

		f2 = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 160;
		c.ipady = 10;

		gl.setConstraints(f2, c);
		pane.add(f2);

		JButton b2 = new JButton("  ..... ");
		b2.setName("sourcebase");
		b2.addActionListener(this);
		b2.setMnemonic(KeyEvent.VK_I);
		b2.setSize(10, 10);

		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 3;
		c.gridy = 1;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(b2, c);
		pane.add(b2);

		// line 3----------------------
		JLabel l3 = new JLabel("TagerBase");
		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(l3, c);

		pane.add(l3);

		f3 = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 160;
		c.ipady = 10;

		gl.setConstraints(f3, c);
		pane.add(f3);

		JButton b3 = new JButton("  ..... ");
		b3.setName("tagerbase");
		b3.addActionListener(this);
		b3.setMnemonic(KeyEvent.VK_I);
		b3.setSize(10, 10);

		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 3;
		c.gridy = 2;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(b3, c);
		pane.add(b3);

		// line 4----------------------
		JLabel l4 = new JLabel("IconName (48x48)");
		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(l4, c);

		pane.add(l4);

		f4 = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 160;
		c.ipady = 10;

		gl.setConstraints(f4, c);
		pane.add(f4);

		JButton b4 = new JButton("  ..... ");
		b4.setName("iconname");
		b4.addActionListener(this);
		b4.setMnemonic(KeyEvent.VK_I);
		b4.setSize(10, 10);

		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 3;
		c.gridy = 3;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(b4, c);
		pane.add(b4);

		// line 5----------------------
		JLabel l5 = new JLabel("InstallFolderName");
		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 4;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(l5, c);

		pane.add(l5);

		f5 = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 160;
		c.ipady = 10;

		gl.setConstraints(f5, c);
		pane.add(f5);

		JButton b5 = new JButton("  ..... ");
		b5.setName("installfoldername");
		b5.addActionListener(this);
		b5.setMnemonic(KeyEvent.VK_I);
		b5.setSize(10, 10);

		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 3;
		c.gridy = 4;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(b5, c);
		pane.add(b5);

		// line 6----------------------
		JLabel l6 = new JLabel("StandloneJre");
		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 5;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(l6, c);

		pane.add(l6);

		f6 = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 160;
		c.ipady = 10;

		gl.setConstraints(f6, c);
		pane.add(f6);

		JButton b6 = new JButton("  ..... ");
		b6.setName("standlonejre");
		b6.addActionListener(this);
		b6.setMnemonic(KeyEvent.VK_I);
		b6.setSize(10, 10);

		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 3;
		c.gridy = 5;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(b6, c);
		pane.add(b6);

		// line 7----------------------
		JLabel l7 = new JLabel("Jdkpath(JDK bin)");
		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 6;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(l7, c);

		pane.add(l7);

		f7 = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 160;
		c.ipady = 10;

		gl.setConstraints(f7, c);
		pane.add(f7);

		JButton b7 = new JButton("  ..... ");
		b7.setName("jdkpath");
		b7.addActionListener(this);
		b7.setMnemonic(KeyEvent.VK_I);
		b7.setSize(10, 10);

		c.fill = GridBagConstraints.LINE_START;
		c.gridx = 3;
		c.gridy = 6;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(b7, c);
		pane.add(b7);

		// line 8 executor
		JButton brun = new JButton("  Run ");
		brun.setName("run");
		brun.addActionListener(this);
		brun.setMnemonic(KeyEvent.VK_I);
		brun.setSize(10, 10);

		c.fill = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 2;
		c.weightx = 0;
		c.weighty = 0;

		c.insets = new Insets(10, 10, 10, 10);
		c.ipadx = 5;
		c.ipady = 10;

		gl.setConstraints(brun, c);
		pane.add(brun);

		pane.setBorder(BorderFactory.createEmptyBorder(20, // top
				20, // left
				20, // bottom
				20) // right
		);
		// pane.setBackground(Color.lightGray);

		return pane;
	}

	public void actionPerformed(ActionEvent event) {

		JButton bt = (JButton) event.getSource();

		String pubName = bt.getName().toLowerCase();
		System.out.println(" pubName   ----> " + pubName);

		if (pubName.equals("appname")) {
		}
		if (pubName.equals("sourcebase")) {
			f2.setText(getPahtbySelectFolder());
		}
		if (pubName.equals("tagerbase")) {
			f3.setText(getPahtbySelectFolder());
		}
		if (pubName.equals("iconname")) {
			f4.setText(getPahtbySelectFile());
		}
		if (pubName.equals("installfoldername")) {

		}
		if (pubName.equals("standlonejre")) {
			f6.setText(getPahtbySelectFolder());
		}
		if (pubName.equals("jdkpath")) {
			f7.setText(getPahtbySelectFolder());
		}
		if (pubName.equals("run")) {
			ontoInstaller();
		}

	}

	public String getPahtbySelectFile() {
		String path = "";
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setName("Open Resource File");

		FileNameExtensionFilter filter = new FileNameExtensionFilter("png",
				"ico");
		fileChooser.setFileFilter(filter);

		int returnVal = fileChooser.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile().getAbsolutePath();
			// System.out.println("path:" + path);
		}
		return path;
	}

	public String getPahtbySelectFolder() {

		String path = "";
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setName("Open Resource ");

		int returnVal = fileChooser.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile().getAbsolutePath();
			// System.out.println("path:" + path);
		}
		return path;
	}

	public boolean checkEmpty() {
		boolean flag = false;
		if (f1.getText().equals("")) {
			flag = true;
			JOptionPane.showMessageDialog(null, " Appname is NULL ! ");
			
		}
		if (f2.getText().equals("")) {
			flag = true;
			JOptionPane.showMessageDialog(null, " sourcebase is NULL ! ");
		}
		if (f3.getText().equals("")) {
			flag = true;
			JOptionPane.showMessageDialog(null, " tagerbase is NULL ! ");
		}
		if (f4.getText().equals("")) {
			flag = true;
			JOptionPane.showMessageDialog(null, " iconname is NULL ! ");
		}
		if (f5.getText().equals("")) {
			flag = true;
			JOptionPane
					.showMessageDialog(null, " installfoldername is NULL ! ");
		}
		if (f6.getText().equals("")) {
			//flag = true;
			//JOptionPane.showMessageDialog(null, " standlonejre is NULL ! ");
		}
		if (f7.getText().equals("")) {
			//flag = true;
			//JOptionPane.showMessageDialog(null, " jdkpath is NULL ! ");
		}

		return flag;
	}

	public void ontoInstaller() {
		
		String tips="Frist: need install \"WiX Toolset v3.9.\"\n"
				+"Second: need add \"C:\\Program Files\\WiX Toolset v3.9\\bin\" to System path.\n"
				+"Third: \"jdkpath\" must be sign.";
		
		//JOptionPane.showMessageDialog(null,	tips);
		
		if (checkEmpty()) {
			return;
		}
		// cmdrun=new Comandrun();

		cmdrun = new Comandrun();
	
		cmdrun.copyWixtotemp();
		System.out.println(" copyWixtotemp finish !");
		
		cmdrun.setP_APPname(f1.getText());
		// source folder
		// String p_sourcebase =
		// "C:\\Documents and Settings\\xxx\\Desktop\\formfragment\\";
		cmdrun.setP_sourcebase(f2.getText() + "\\");
		cmdrun.setInstallfolderName(f5.getText());
		// // C:\Documents and Settings\xxx\Desktop\formfragment\wixscript
		cmdrun.setP_targetbase(f3.getText() + "\\");
		cmdrun.Cleantargetbase();

		cmdrun.setEXEappicofile(f4.getText());

		// cmdrun.setAppclass(MainClass.getText());
		// cmdrun.setBjvmOptions_Xmx(Xmxmem.getText());
		// cmdrun.setBjvmOptions_Xms(Xmsmem.getText());
		cmdrun.setP_jdkpath(f7.getText());
		cmdrun.setStandloneJre(f6.getText());

		cmdrun.initComandrun();

		cmdrun.Createexefolder();
		cmdrun.copyIco();
		// use standloneJre
		if (!f6.getText().equals("") && f6.getText() != null) {
			cmdrun.replaceJRE();
		}
		cmdrun.copySource();

		cmdrun.productHeatfiles("");
		cmdrun.productludeVariables("");
		cmdrun.copymainwxs();
		cmdrun.writerludeVariablestoTagetfiles(cmdrun.getMain_wxsName());
		cmdrun.writerludeVariablestoTagetfiles(cmdrun.getHeatfile_AppwxsName());
		cmdrun.copyUidll();

		cmdrun.productInstaller("");
		// cmdrun.ShowDialogbox("Installer has formed!  folder is: " +
		// cmdrun.getP_targetbase() + cmdrun.getWixscript());
		JOptionPane.showMessageDialog(null,
				"Installer has formed!  folder is: " + cmdrun.getP_targetbase()
						+ cmdrun.getWixscript());
		
		cmdrun.CleanTempWix();
	}

	private static void initLookAndFeel() {
		String lookAndFeel = null;

		if (LOOKANDFEEL != null) {
			if (LOOKANDFEEL.equals("Metal")) {
				lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
				// an alternative way to set the Metal L&F is to replace the
				// previous line with:
				// lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";

			}

			else if (LOOKANDFEEL.equals("System")) {
				lookAndFeel = UIManager.getSystemLookAndFeelClassName();
			}

			else if (LOOKANDFEEL.equals("Motif")) {
				lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
			}

			else if (LOOKANDFEEL.equals("GTK")) {
				lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
			}

			else {
				System.err
						.println("Unexpected value of LOOKANDFEEL specified: "
								+ LOOKANDFEEL);
				lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
			}

			try {

				UIManager.setLookAndFeel(lookAndFeel);

				if (LOOKANDFEEL.equals("Metal")) {
					if (THEME.equals("DefaultMetal"))
						MetalLookAndFeel
								.setCurrentTheme(new DefaultMetalTheme());
					else if (THEME.equals("Ocean"))
						MetalLookAndFeel.setCurrentTheme(new OceanTheme());

					// else MetalLookAndFeel.setCurrentTheme(new TestTheme());

					UIManager.setLookAndFeel(new MetalLookAndFeel());
				}

			}

			catch (ClassNotFoundException e) {
				System.err
						.println("Couldn't find class for specified look and feel:"
								+ lookAndFeel);
				System.err
						.println("Did you include the L&F library in the class path?");
				System.err.println("Using the default look and feel.");
			}

			catch (UnsupportedLookAndFeelException e) {
				System.err.println("Can't use the specified look and feel ("
						+ lookAndFeel + ") on this platform.");
				System.err.println("Using the default look and feel.");
			}

			catch (Exception e) {
				System.err.println("Couldn't get specified look and feel ("
						+ lookAndFeel + "), for some reason.");
				System.err.println("Using the default look and feel.");
				e.printStackTrace();
			}
		}
	}

	private static void createAndShowGUI() {

		// Set the look and feel.
		initLookAndFeel();

		// Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);

		JLabel labeltitle = new JLabel(" title j2msi");
		// Create and set up the window.

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		UIEntry app = new UIEntry();
		Component contents = app.createComponents();
		contents.setLocation(300, 300);
		frame.getContentPane().add(contents, null);

		frame.setSize(700, 400);
		frame.setLocation(300, 300);
		// frame.validate();
		// frame.pack();
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
