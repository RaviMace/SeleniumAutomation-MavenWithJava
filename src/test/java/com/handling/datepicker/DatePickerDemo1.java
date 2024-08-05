package com.handling.datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {

	static void SelectFutureDate(WebDriver driver,String month, String year, String date) {
		
		// Select Month & Year
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(currentMonth.equals(month)&&currentYear.equals(year)) {
				break;
			} 
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();	//Next
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //Previous
		}
		
		// Select date - directly using the date
		//WebElement selectDate = driver.findElement(By.xpath("//a[normalize-space()='"+date+"']"));
		//selectDate.click();
		
		// Select date - taking all dates and comparing and clicking the date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));
		for (WebElement dt : allDates) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}
	
	static void SelectPastDate(WebDriver driver,String month, String year, String date) {
		
		// Select Month & Year
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(currentMonth.equals(month)&&currentYear.equals(year)) {
				break;
			} 
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();	//Next
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //Previous
		}
		
		// Select date - directly using the date
		//WebElement selectDate = driver.findElement(By.xpath("//a[normalize-space()='"+date+"']"));
		//selectDate.click();
		
		// Select date - taking all dates and comparing and clicking the date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));
		for (WebElement dt : allDates) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		// Switch to frame
		driver.switchTo().frame(0);
		
		// Method 1 - using sendKeys
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("04/05/2024"); // dd/mm/yyyy
		
		// Method 2 -  using date picker
		// expected date
		String year = "2025";
		String month = "March";
		String date = "22";
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		SelectFutureDate(driver, month, year, date);
		//SelectPastDate(driver, month, year, date);
		
		driver.quit();
	}

}
