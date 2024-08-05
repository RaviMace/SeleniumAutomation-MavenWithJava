package com.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Dynamic XPath: 
 * - This is a technique for creating XPaths that can adapt to changes in the HTML structure. 
 * - It achieves this by incorporating functions like contains or starts-with along with relative XPath elements. 
 * - These functions allow you to target elements based on parts of their attributes or text content, which might change dynamically.
 */

public class DynamicXPathLocators {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo-opencart.com/");
		
		 // Relative XPath - Dynamic XPath with "AND" & "OR" operator
        driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("HTC");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button' or @data-lang='en-gb']")).click();
        Thread.sleep(3000);
		
        // to go to home page
     	driver.findElement(By.id("logo")).click();
     	Thread.sleep(2000);
        
		// Relative XPath - Dynamic XPath with text()
        driver.findElement(By.xpath("//*[text()='MacBook']")).click();
        Thread.sleep(3000);
        
        // Relative XPath - Dynamic XPath contains()
        driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).clear();
        driver.findElement(By.xpath("//input[contains(@placeholder,'ear')]")).sendKeys("IPhone");
        
        // Relative XPath - Dynamic XPath starts-with()
        driver.findElement(By.xpath("//button[starts-with(@data-lang,'en')]")).click();
        Thread.sleep(3000);
        
        // Dynamic XPath - chained XPath 
        /*
         * <div id="logo">						// so we traversing from div - a - img
         * 		<a href="url">
         * 			<img src"url" ....>			// we want to take this "img"
         * 		</a>
         * </div>
         */
     	driver.findElement(By.xpath("//div[@id='logo']/a/img")).click();
     	Thread.sleep(2000);
		
     	driver.close();
	}

}
