package com.handling.alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedAlert {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// 4) Authenticated Alert
		 String username = "admin";
	     String password = "admin";
	     String url = "https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth";
	     
	     // or
	     // String url = "admin:admin@https://the-internet.herokuapp.com/basic_auth"
	     
	     driver.get(url);
	}

}
