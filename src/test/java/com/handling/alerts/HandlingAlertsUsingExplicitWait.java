package com.handling.alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAlertsUsingExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// 1) Normal Alert with OK button
		driver.findElement(By.xpath("//button[@onclick='myFunctionAlert()']")).click();
		Thread.sleep(2000);
		
		// Using Explicit Wait
		Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
				
		System.out.println(myAlert.getText());
		myAlert.accept();


	}

}
