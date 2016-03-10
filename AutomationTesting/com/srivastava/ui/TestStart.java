package com.srivastava.ui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.srivastava.excel.ExcelReaderWriter;
import com.srivastava.excel.TestCase;
import com.srivastava.test.Tester;

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
		
		JButton btnTestreport = new JButton("TestReport");
		btnTestreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showReport();
			}
		});
		btnTestreport.setBounds(165, 42, 89, 23);
		getContentPane().add(btnTestreport);
		
	}
	private void openExcelFile(){
		JFileChooser fileChooser = new JFileChooser("e:");
		fileChooser.showOpenDialog(this);
		File file  = fileChooser.getSelectedFile();
		try {
			System.out.println(file);
			ArrayList<TestCase> testList = ExcelReaderWriter.readExcel(file);
			System.out.println(testList);
			Tester tester = new Tester();
			tester.doTest(testList,file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void showReport(){
		Desktop desktop = Desktop.getDesktop();
		File file = new File("D:\\Java2-5WS\\first.pdf");
		try {
			if(file.exists()){
			desktop.open(file);
			}
			else{
				JOptionPane.showMessageDialog(this, "File Not Exist");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
