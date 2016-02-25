import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class NotePadDemo extends JFrame {
private JTextArea textArea = new JTextArea();
JScrollPane scrollPane = new JScrollPane();
	
	public static void main(String[] args) {
		
					NotePadDemo frame = new NotePadDemo();
					frame.setVisible(true);
				
	}
	private void resizeNotePad(){
		textArea.setSize(this.getWidth()-30,this.getHeight()-70);
		scrollPane.setSize(this.getWidth()-30,this.getHeight()-70);
	}
	private void notePadClosing(boolean isNew){
		if(textArea.getText().trim().length()>0){
		Object[] options = { "Save", "Don't Save","Cancel" };
		int choice = JOptionPane.showOptionDialog(this, 
				"Do you want to Save the Changes to "+this.getTitle(),
				"NotePad",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
		if(choice==JOptionPane.YES_OPTION){
			JFileChooser saveChooser = new JFileChooser(new File("c:"));
			saveChooser.showSaveDialog(this);
		}
		else
		if(choice==JOptionPane.NO_OPTION){
			if(!isNew){
			this.setVisible(false);
			this.dispose();
			}
			else{
				textArea.setText("");
				return ;
			}
		}
		else{
			return;
		}
		}
		else{
			this.setVisible(false);
			this.dispose();
		}
	}
	
	private void openFile(){
		JFileChooser openChooser = new JFileChooser(new File("c:"));
		openChooser.showOpenDialog(this);
		File filePath = openChooser.getSelectedFile();
		try {
			String result = FileOperations.readOperation(filePath.getPath());
			this.setTitle(filePath.getName());
			textArea.setText(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	private void saveFile(){
		JFileChooser saveChooser = new JFileChooser(new File("c:"));
		saveChooser.showSaveDialog(this);
		try {
			FileOperations.writeOperation(saveChooser.getSelectedFile().getPath(), textArea.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void foreColor(){
		Color color= JColorChooser.showDialog(this, "Notepad Colors", Color.RED);
		textArea.setForeground(color);
		
	}
	/**
	 * Create the frame.
	 */
	public NotePadDemo() {
		setTitle("Untitled");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				notePadClosing(false);
			}
		});
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				resizeNotePad();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 603, 423);
		getContentPane().setLayout(null);
		
		
		scrollPane.setBounds(5, 7, 556, 323);
		getContentPane().add(scrollPane);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		
		
		scrollPane.setViewportView(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notePadClosing(true);
			}
		});
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmPrint = new JMenuItem("Print");
		mnFile.add(mntmPrint);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JMenu mnColor = new JMenu("Color");
		mnEdit.add(mnColor);
		
		JMenuItem mntmFontcolor = new JMenuItem("FontColor");
		mntmFontcolor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foreColor();
			}
		});
		mnColor.add(mntmFontcolor);
		
		JMenuItem mntmBackgroundcolor = new JMenuItem("BackGroundColor");
		mnColor.add(mntmBackgroundcolor);
		
		JMenuItem mntmColor = new JMenuItem("Color");
		mnEdit.add(mntmColor);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAboutus = new JMenuItem("AboutUs");
		mnHelp.add(mntmAboutus);
		
	}
}
