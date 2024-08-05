package com.webdriversandwebelements;

import java.net.MalformedURLException;
//import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethods_WebDriver {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://demo.nopcommerce.com/");			// accepts URL only in the string format
		
		//URL url = new URL("https://testautomationpractice.blogspot.com/");		// accepts URL as the object format and also
		//driver.navigate().to(url);
		
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
        String title = driver.getTitle();
        System.out.println(title);
        
        //Back
        driver.navigate().back();
        title = driver.getTitle();
        System.out.println(title);
        
        //Forward
        driver.navigate().forward();
        title = driver.getTitle();
        System.out.println(title);

        //Refresh
        driver.navigate().refresh();
        title = driver.getTitle();
        System.out.println(title);
		
        driver.close();
	}

}
