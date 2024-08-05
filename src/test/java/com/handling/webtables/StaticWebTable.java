package com.handling.webtables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// find total number of rows in table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		System.out.println("Number of rows : "+rows.size());
		
		// find total number of columns in table
		List<WebElement> columns = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		System.out.println("Number of rows : "+columns.size());
		
		// Read data from specific row and column (5th row and 1st column)
		String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println(data);
		
		// Read data from all the rows and columns
		for (int r = 2; r <=rows.size(); r++) {
			for (int c = 1; c <=columns.size(); c++) {
				String allData = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(allData+"\t");				// "\t" will give tab space for this table
			}
			System.out.println();
		}
		System.out.println();
		
		// Book names who's author written by Mukesh 
		for (int r = 2; r <=rows.size(); r++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(author.equals("Mukesh")) {
					String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
					System.out.print(bookName+"\t"+author);
			}
			System.out.println();
		}
		System.out.println();
		
		// Find the total price amount
		int totalAmount = 0;
		for (int r = 2; r <=rows.size(); r++) {
			String priceString = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			int priceInt = Integer.parseInt(priceString);
			totalAmount = totalAmount + priceInt;
		}
		System.out.println(totalAmount);
		
		driver.quit();
	}

}
