package com.srivastava.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReaderWriter {
	public static void writeExcel(File file, String result, int rowNo) throws Exception{
		
		FileInputStream fi = new FileInputStream(file); 
		HSSFWorkbook workBook = new HSSFWorkbook(fi);
		HSSFSheet sheet = workBook.getSheetAt(0);
		sheet.getRow(rowNo).getCell(5).setCellValue(result);
		fi.close();
		FileOutputStream out = 
		        new FileOutputStream(file);
		workBook.write(out);
		workBook.close();
		
		out.close();
	}
	public static ArrayList<TestCase> readExcel(File file) throws IOException{
		ArrayList<TestCase> testList = new ArrayList<>();
		FileInputStream fi = new FileInputStream(file);  // read file in bytes
		HSSFWorkbook workBook = new HSSFWorkbook(fi);  // bytes convert into workbook
		HSSFSheet sheet = workBook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		int cellCounter =1;
		boolean isFirstRowPassed = false;
		while(rows.hasNext()){
			Row currentRow = rows.next(); // Give Current Row and Move to the Next Row
			if(!isFirstRowPassed){
				isFirstRowPassed = true;
				continue;
			}
			Iterator<Cell> cells= currentRow.cellIterator();
			TestCase testCase = new TestCase();
			// Cell Loop
			while(cells.hasNext()){
				Cell currentCell = cells.next();
				System.out.println("Counter "+cellCounter+" "+currentCell.getCellType());
				if(currentCell.getCellType()==Cell.CELL_TYPE_STRING || currentCell.getCellType()==Cell.CELL_TYPE_NUMERIC){
					if(cellCounter==1){
						testCase.setName(currentCell.getStringCellValue());
					}
					else
					if(cellCounter==2){
						testCase.setClassName(currentCell.getStringCellValue());
					}
					else
					if(cellCounter==3){
						testCase.setMethodName(currentCell.getStringCellValue());
					}
					else
					if(cellCounter==4){
						testCase.setInputArgs(currentCell.getStringCellValue());
					}
					else
					if(cellCounter==5){
						testCase.setExpected(currentCell.getStringCellValue());
					}
					else
					if(cellCounter==6){
						testCase.setStatus(currentCell.getStringCellValue());
					}
					else
					if(cellCounter==7){
						testCase.setRemarks(currentCell.getStringCellValue());
					}
				}
				cellCounter++;
			} // Cell Loop Ends
			testList.add(testCase);
			cellCounter=1;
		} // Row Loop Ends
		workBook.close();
		fi.close();
		return testList;
		
	}

	public static void main(String[] args) {
		//ExcelReaderWriter.readExcel(file);

	}

}
