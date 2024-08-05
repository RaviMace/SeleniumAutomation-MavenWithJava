package com.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * XPath
 * 
 * XPath is an address of the element
 * DOM- Document Object Model
 * 
 * Two Types of XPath
 * - Relative XPath (Partial XPath)	- ex: //*[@id="search"]/input
 *  	- Automatic XPath - by directly copying the XPath from DOM, Dev-tools and selectorHUB
 * 		- Manually (own XPath)
 * 
 * - Absolute XPath (Full XPath) 	- ex: /html/body/header/div/div/div[2]/div/input
 * 
 * Relative XPath: 
 * - It starts from the current node and uses a double slash (//) to search for the target element anywhere in the document.
 * - It works with attribute
 * - It directly jump and find the element by using attribute
 * 
 * Absolute XPath: 
 * - It starts from the root node and traverses through each node in the document to reach the target element. 
 * - It is represented by a single slash (/).
 * - It do not use attribute
 * - It traverse through each node till it finds element
 * 
 * Why Relative XPath is Preferred Over Absolute XPath
 * - Maintainability	: Relative XPath is more robust to changes in the structure of the webpage. If the structure of the page changes, 
 * 	 the relative XPath is less likely to break compared to absolute XPath.
 * - Readability		: Relative XPath is easier to read and understand.
 * - Flexibility		: Relative XPath allows for more flexible selection criteria, making it easier to locate elements based on attributes 
 *   and partial matches.
 * 
 * Issues with Absolute XPath
 * - Fragile		: Absolute XPath is very fragile. Any change in the structure of the HTML (such as adding or removing elements) can break 
 *   the locator.
 * - Complexity		: Absolute XPath can become very long and complex, making it difficult to maintain and debug.
 * - Specificity	: Absolute XPath is too specific. It ties the test to a particular structure, reducing the flexibility and 
 *   robustness of the tests.
 * 
 * Using relative XPath locators in Selenium tests provides more flexibility, maintainability, and robustness compared to absolute XPath. 
 * Absolute XPath locators are more likely to break when the structure of the webpage changes, making them less reliable for automation testing. 
 * By using relative XPath, tests can adapt to changes more gracefully, ensuring higher stability and reliability in test automation.
 */

public class XPathLocators {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo-opencart.com/");
		driver.manage().window().maximize();
		
		// Absolute XPath example
        driver.findElement(By.xpath("/html/body/main/div[1]/nav/div[2]/ul/li[4]/a")).click();

        // Relative XPath with single attribute
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Nikon");
        
        Thread.sleep(3000);
        
        // Relative XPath with multiple attributes
        driver.findElement(By.xpath("//button[@type='button'][@data-lang='en-gb']")).click();
        
        Thread.sleep(3000);
        
        // Relative XPath with "AND" & "OR" operator
        driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).clear();
        driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("HTC");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button' or @data-lang='en-gb']")).click();
        Thread.sleep(3000);
        
        // to go to home page
     	driver.findElement(By.id("logo")).click();
     	Thread.sleep(2000);
        
		// Relative XPath with text()
        driver.findElement(By.xpath("//*[text()='MacBook']")).click();
        Thread.sleep(3000);
        
        // Relative XPath contains()
        driver.findElement(By.xpath("//input[contains(@placeholder,'ear')]")).sendKeys("IPhone");
        
        // Relative XPath starts-with()
        driver.findElement(By.xpath("//button[starts-with(@data-lang,'en')]")).click();
        Thread.sleep(3000);
        
        // to go to home page
     	driver.findElement(By.id("logo")).click();
     	Thread.sleep(2000);
        
        driver.close();
	}

}
