package com.handling.allChromeoptionMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomatedMessageOnScreen {

	public static void main(String[] args) {
		
		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});		
		
		WebDriver driver = new ChromeDriver(op);
		
		driver.get("https://vinothqaacademy.com/demo-site/");
		
		String actTitle = driver.getTitle();								
		String expTitle = "Demo Site – Registration Form – Vinoth Q.A Academy";
		
		if(actTitle.equals(expTitle)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		driver.quit();

	}

}
