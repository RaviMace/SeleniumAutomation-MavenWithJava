package com.handling.alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// 1) Normal Alert with OK button
		driver.findElement(By.xpath("//button[@onclick='myFunctionAlert()']")).click();
		
		Thread.sleep(2000);
		Alert myAlert =  driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.accept();
		
		// 2) Confirmation Alert - OK & cancel
		driver.findElement(By.xpath("//button[@onclick='myFunctionConfirm()']")).click();
		
		Thread.sleep(2000);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		// 3) Prompt Alert - 
		driver.findElement(By.xpath("//button[@onclick='myFunctionPrompt()']")).click();
		
		Thread.sleep(2000);
		myAlert.sendKeys("Ravi");
		myAlert.accept();
		
		driver.quit();
	}

}
