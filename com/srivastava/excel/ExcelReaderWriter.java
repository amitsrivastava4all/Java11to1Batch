package com.srivastava.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReaderWriter {
	
	public static void readExcel(File file) throws IOException{
		ArrayList<TestCase> testList = new ArrayList<>();
		FileInputStream fi = new FileInputStream(file);  // read file in bytes
		HSSFWorkbook workBook = new HSSFWorkbook(fi);  // bytes convert into workbook
		HSSFSheet sheet = workBook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		int cellCounter =1;
		while(rows.hasNext()){
			Row currentRow = rows.next(); // Give Current Row and Move to the Next Row
			Iterator<Cell> cells= currentRow.cellIterator();
			TestCase testCase = new TestCase();
			// Cell Loop
			while(cells.hasNext()){
				Cell currentCell = cells.next();
				if(currentCell.getCellType()==Cell.CELL_TYPE_STRING){
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
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
