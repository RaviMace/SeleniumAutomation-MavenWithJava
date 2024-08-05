package com.waitmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Thread.sleep(): 
 * 	Adv: 
 * 	- easy to use
 * 	DisAdv: 
 * 	- if the time is not sufficient then you will get exception
 * 	- it will wait for maximum time out. this will reduce the performance of the script
 * 	- multiple times
 * 
 * implicit wait:
 * 	driver.manage().timeouts().implicityWait(Duration.ofSeconds(10))
 * 	Adv:
 * 	- single time/one statement
 * 	- it will not wait till maximum time if teh element is available
 * 	- Applicable for all the elements
 * 	- easy to use 
 * 	DisAdv:
 * 	- if the time is not sufficient then you will get exception
 * 
 * explicit wait
 * 	
 * 
 */

public class WaitMethods_ImplicitWait_WebDriverAndWebElements {

	public static void main(String[] args) throws InterruptedException {

// Wait Methods
		System.out.println("Wait Methods : Implicit wait");
		System.out.println();
				
		WebDriver driver = new ChromeDriver();
		
		//10sec is maximum time in real project-performance issue
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 					// we can also use this
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
		driver.quit();
	}

}
