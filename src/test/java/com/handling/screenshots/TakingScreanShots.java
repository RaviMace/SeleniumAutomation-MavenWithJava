package com.handling.screenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *  we will create captureScreenshot() method separately to capture screenshot. If the particular test case failed, we call this method.
 *  
 *  we will create if condition for failure and passed cases. failed - take screenshot / passed - report file
 */

public class TakingScreanShots {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
	// 1) Full page screenshot
		TakesScreenshot ts = (TakesScreenshot) driver; 	// creating object, up casting to TakesScreenshot from ChromeDriver, to take screenshot
		
		// Creating user defined File class to take screen shot and store in file format, where we are calling from TakesScreenshot interface
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		// To get the project location dynamically, we are using 'System.getProperty("user.dir")' 
		File targetFile = new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
		
		sourceFile.renameTo(targetFile); // this will copy the sourceFile to targetFile
		
	// 2) capture the screen shot of specific section of the WebElement
		WebElement featuredProduct = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		
		// Creating user defined File class to take screen shot and store in file format, where we are calling from WebElement interface 
		File sFile = featuredProduct.getScreenshotAs(OutputType.FILE); // where getScreenshotAs is implemented in WebElement interface
		
		// To get the project location dynamically, we are using 'System.getProperty("user.dir")'
		File tFile = new File(System.getProperty("user.dir")+"\\screenshots\\featuredProduct.png");
		
		sFile.renameTo(tFile); // this will copy the sourceFile to targetFile
		
	// 3) Capture the screenshot of a WebElement
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
		// Creating user defined File class to take screen shot and store in file format, where we are calling from WebElement interface 
		File sfile = logo.getScreenshotAs(OutputType.FILE); // where getScreenshotAs is implemented in WebElement interface
		
		// To get the project location dynamically, we are using 'System.getProperty("user.dir")'
		File tfile = new File(System.getProperty("user.dir")+"\\screenshots\\logo.png");
		
		sfile.renameTo(tfile); // this will copy the sourceFile to targetFile
		
		driver.quit();
	}

}
