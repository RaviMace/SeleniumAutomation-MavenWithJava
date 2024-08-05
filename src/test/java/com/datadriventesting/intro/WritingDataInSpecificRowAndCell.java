package com.datadriventesting.intro;
  
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInSpecificRowAndCell {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\writingrandomdata.xlsx");
		
		XSSFWorkbook wBook = new XSSFWorkbook();
		
		XSSFSheet sheet = wBook.createSheet("Data");
		
		// By mentioning the row and cell, we can store the value where we wanted
		XSSFRow row = sheet.createRow(3);
		XSSFCell cell = row.createCell(4);
		
		cell.setCellValue("Welcome");
		
		wBook.write(file);
		wBook.close();
		file.close();
		
		System.out.println("File is created");

	}

}
