package com.webdriversandwebelements;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods_WebDriver {

	public static void main(String[] args) throws InterruptedException {
		
// Get Methods
		System.out.println("Get Methods");
		System.out.println();
 
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
			
		//get()					- opens the URL on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// getTitle()			- returns title of the page
		System.out.println(driver.getTitle());
		
		// getCurrentUrl()		- returns URL of the page
		System.out.println(driver.getCurrentUrl());
		
		// getPageSource()		- returns source code of the page
		//System.out.println(driver.getPageSource());											// not important one
		
		// getWindowHandle()	- returns ID of the single browser window						// Important one
		String windowID = driver.getWindowHandle();
		System.out.println(windowID);
		
		Thread.sleep(5000);
		
		//Opening another window to perform WindowHandles
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		// getWindowHandles()	- returns ID's of the multiple browser windows					// Important one
		Set<String> windowsID = driver.getWindowHandles();
		windowsID.size();
		System.out.println(windowsID);
		
		Thread.sleep(2000);
		driver.quit();
	}

}
