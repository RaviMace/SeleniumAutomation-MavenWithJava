package com.handling.brokensites;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * 1) Link should have  href="https://abc.com"
 * 2) https://abc.com -> server -> status code
 * 3) status code >=400 	broken link
 * 	  status code < 400 	not a broken link
 */

public class BrokenLinks {

	public static void main(String[] args) {
		
		// Creating ChromeOptions to execute in headless mode
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--headless=new");	// setting for headless mode of execution "--headless=new"
		
		// Every thing will be executed in background. Browser will not be visible. we only get test results		
		WebDriver driver = new ChromeDriver(cOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		// 1) Capture all the links from website
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: "+links.size());
		
		// 2) Check all the links, is it empty or not and also hitting the URL to the server
		int noOfBrokenLinks=0;
		for (WebElement linkElement : links) {
			String hrefAttValue = linkElement.getAttribute("href");
			if (hrefAttValue==null || hrefAttValue.isEmpty()) {
				System.out.println("href attribute value is null or empty. So not possible to check");
				continue;
			}
			
			// 2&3) hit URL to the server
			try {
				@SuppressWarnings("deprecation")
				URL linkURL = new URL(hrefAttValue);				// converted href value from string to URL format
				HttpURLConnection connlinkURL = (HttpURLConnection) linkURL.openConnection();				// open connectionto the server
				connlinkURL.connect(); 			// connect to server and sent request to the server
				
				if(connlinkURL.getResponseCode()>=400) {
					System.out.println(hrefAttValue+" ->Broken link");
					noOfBrokenLinks++;
				} else {
					System.out.println(hrefAttValue+" ->Not a broken link");
				}
			}	
			catch (Exception e) {
			}
		}
		
		System.out.println("Number of broken links : "+noOfBrokenLinks);
		driver.quit();
		
	}

}
