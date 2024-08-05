package com.handling.allChromeoptionMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * SSL Certificates - Handling
 * 
 * 		ChromeOptions op = new ChromeOptions();
 *		op.setAcceptInsecureCerts(true);
 * 
 */

public class HandlingSSLwebsite {

	public static void main(String[] args) {
		
		ChromeOptions op = new ChromeOptions();
		op.setAcceptInsecureCerts(true);		// accepts SSL certificates of the page
		
		WebDriver driver = new ChromeDriver(op);
		
		driver.get("https://expired.badssl.com");
		
		System.out.println("title of the page: "+driver.getTitle());
		
		driver.quit();
	}

}
