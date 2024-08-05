package com.handling.javascriptexecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * JavascriptExecutor - interface that is implemented to RemoteWebDriver class. not to the WebDriver interface
 * 
 * executeScript() - we can execute java script statements
 * 
 */


public class HandlingWithJavaSricptExecutor {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));

		// We can create object here, because its an interface
		// So we are type-casting(up-casting) into the object 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// instead of sendKeys, we can do with java script to pass the text into textbox/inputbox
		js.executeScript("arguments[0].setAttribute('value','Mace')",name);
		
		WebElement radiobtn = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()",radiobtn);
		
		driver.quit();
	}

}
