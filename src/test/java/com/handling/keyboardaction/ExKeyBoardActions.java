package com.handling.keyboardaction;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ExKeyBoardActions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		Actions act = new Actions(driver);
		
		// Control+Reg-link
		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		
		// Switching to registration page
		// Set<String> id = driver.getWindowsHandles();
		// List<String> idList = new ArrayList<String>(id);
		// instead of using two statement, we can use it in one statement
		List<String> ids = new ArrayList<String>(driver.getWindowHandles());
		
		// Again combining into one statement
		driver.switchTo().window(ids.get(1));		// switching to registration page
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Mace");
		
		// Switching back to previous window
		driver.switchTo().window(ids.get(0));		// switching to home page

	}

}
