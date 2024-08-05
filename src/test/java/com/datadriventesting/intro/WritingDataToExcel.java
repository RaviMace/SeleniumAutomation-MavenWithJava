package com.datadriventesting.intro;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataToExcel {

	public static void main(String[] args) throws IOException {
	/*	
		// Writing the data statically
		XSSFWorkbook workbook = new XSSFWorkbook();
		 
		XSSFSheet sheet = workbook.createSheet("WritingData");
		
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("From Place");
		row1.createCell(1).setCellValue("To Place");
		row1.createCell(2).setCellValue("Fair");
		  
		XSSFRow row2 = sheet.createRow(1); 
		row2.createCell(0).setCellValue("Italy");
		row2.createCell(1).setCellValue("France");
		row2.createCell(2).setCellValue("$200");
		  
		XSSFRow row3 = sheet.createRow(2); 
		row3.createCell(0).setCellValue("London");
		row3.createCell(1).setCellValue("Spain");
		row3.createCell(2).setCellValue("$350");
		  
		XSSFRow row4 = sheet.createRow(3); 
		row4.createCell(0).setCellValue("Norway");
		row4.createCell(1).setCellValue("Sweden");
		row4.createCell(2).setCellValue("$275");
		  
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\writingdata.xlsx");
*/		 		
		
		// Writing the data Dynamically
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\writingdynamicdata.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		 
		
		XSSFSheet sheet = workbook.createSheet("WritingDynamicData");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter how many rows?");
		int noOfRows = sc.nextInt();
		
		System.out.println("Enter how many cells?");
		int noOfCells = sc.nextInt();
		
		for (int r = 0; r <=noOfRows; r++) {
			XSSFRow currentRow = sheet.createRow(r);
			
			for (int c = 0; c < noOfCells; c++) {
				XSSFCell currentCell = currentRow.createCell(c);
				currentCell.setCellValue(sc.next());
			}
		}	
		
		System.out.println("File got created");
		
		workbook.write(file);
		workbook.close();
		file.close();
		sc.close();
		
	}

}
