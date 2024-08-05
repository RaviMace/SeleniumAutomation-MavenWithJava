package com.handling.datepicker;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 {
	
	// User defined method for converting month from string --> Month
	static Month convertMonth(String month) {
		
		HashMap<String, Month> monthMap = new HashMap<String, Month>();
		
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);
		
		Month vmonth = monthMap.get(month);
		
		if (vmonth == null) {
			System.out.println("Invalid Month");
		}
		return vmonth;
	}
	
	static void selectDate(WebDriver driver, String expYear, String expMonth, String expDate) {
		
		// Select year
		WebElement yearDropdown = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select selectYear = new Select(yearDropdown);
		selectYear.selectByVisibleText(expYear);
	
		// Select Month
		while(true) {
			
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			// Convert expMonth & currentMonth into Month objects
			Month eMonth = convertMonth(expMonth);
			Month cMonth = convertMonth(currentMonth);
			
			// Compare
			int resultMonth = eMonth.compareTo(cMonth);
			
			// <0 past month
			if (resultMonth<0) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
			// >0 future month
			else if(resultMonth>0) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
			// 0 months are equal
			else {
				break;
			}	
		}	
		
		// Select date - taking all dates and comparing and clicking the date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));
		for (WebElement dt : allDates) {
			if(dt.getText().equals(expDate)) {
				dt.click();
				break;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// Input Date
		String inputYear = "2021";
		String inputMonth = "March";
		String inputDate = "22";
		
		// To switch to frame
		driver.switchTo().frame("frame-one796456169");
		
		// To scroll down to the date visibility 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//label[@id='q4_label']"));
		js.executeScript("arguments[0].scrollIntoView()",element);
		System.out.println(js.executeScript("return window.pageYOffset"));
		
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		
		selectDate(driver, inputYear, inputMonth, inputDate);
		
		driver.quit();
	}
}
