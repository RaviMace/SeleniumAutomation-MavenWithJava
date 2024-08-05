package com.intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Test case
 * - Launch browser (Chrome)
 * - open URL https://demo.opencart.com/     - this site is not working in automation
 * - validate title should be "Your Store"
 * - Close browser
 */

public class LaunchApplication {

	public static void main(String[] args) {
		
		// Launch browser (chrome)
		WebDriver driver = new ChromeDriver();
		
		// open URL
		driver.get("https://vinothqaacademy.com/demo-site/");				// Selenium notes - WebDriver - 2) get()
		
		// Validate title
		String actTitle = driver.getTitle();								// Selenium notes - WebDriver - 5) getTitle()
		String expTitle = "Demo Site – Registration Form – Vinoth Q.A Academy";
		
		if(actTitle.equals(expTitle)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		
		// Closing the browser //Closing a single browser window
		driver.close();														// Selenium notes - WebDriver - 1) close()
		
		// Quitting the browser // Quitting the entire browser session
		driver.quit();														// Selenium notes - WebDriver - 10) quit()
	}

}
