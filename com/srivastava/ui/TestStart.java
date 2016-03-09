package com.srivastava.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.srivastava.excel.ExcelReaderWriter;

public class TestStart extends JFrame {

	
	public static void main(String[] args) {
		
					TestStart frame = new TestStart();
					frame.setVisible(true);
				
	}

	
	public TestStart() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(null);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openExcelFile();
			}
		});
		btnBrowse.setBounds(34, 42, 89, 23);
		getContentPane().add(btnBrowse);
		
	}
	private void openExcelFile(){
		JFileChooser fileChooser = new JFileChooser("e:");
		fileChooser.showOpenDialog(this);
		File file  = fileChooser.getSelectedFile();
		try {
			System.out.println(file);
			ExcelReaderWriter.readExcel(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
