package com.webdriversandwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods_WebDriver {

	public static void main(String[] args) throws InterruptedException {
		
// Browser Methods
		System.out.println("Browser Methods");
		System.out.println();
				
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); // this will opens new browser window/tab
		
		Thread.sleep(3000);
		driver.close();											// close current window only/where ever the driver is focused 
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();	// again opening the new browser window/tab
		
		Thread.sleep(2000);
		driver.quit();												// close all the browser windows


	}

}
