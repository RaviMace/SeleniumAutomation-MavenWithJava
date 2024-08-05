package com.datadriventesting.intro;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Data Driven Testing
 * 
 * Excel File -> Workbook -> sheets -> rows -> cells
 * 
 * FileInputStream - reading
 * FileOutputStream - writing
 * 
 * XSSFWorkbook - workbook
 * XSSFSheet - sheet
 * XSSFRow - row
 * XSSFCell - cell
 * 
 */

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\readingdata.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("ReadingData");
		
		int totalRows = sheet.getLastRowNum();
		
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println(totalRows);
		System.out.println(totalCells);
		
		for (int r = 1; r <=totalRows; r++) {
			XSSFRow currentRow = sheet.getRow(r);
			
			for (int c = 0; c < totalCells; c++) {
				XSSFCell currentCell =currentRow.getCell(c);
				System.out.print(currentCell.toString()+"\t");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
		
	}
}
