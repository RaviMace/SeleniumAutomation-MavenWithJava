package com.waitmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

/* 
 * fluent wait
 * 	
 * 
 */

public class WaitMethods_FluentWait_WebDriverAndWebElements {

	public static void main(String[] args) throws InterruptedException {

// Wait Methods
		System.out.println("Wait Methods : Fluent wait");
		System.out.println();
				
		WebDriver driver = new ChromeDriver();
		
		// Fluent Wait - Declaration 
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
               .withTimeout(Duration.ofSeconds(10))
               .pollingEvery(Duration.ofSeconds(2))
               .ignoring(NoSuchElementException.class);
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
        // Fluent Wait - Usage
        WebElement userName = fluentWait.until(new Function<WebDriver, WebElement>() {
        		public WebElement apply(WebDriver driver) {
        		return driver.findElement(By.xpath("//input[@placeholder='Username']"));
        		}
        });
        userName.sendKeys("Admin");
		
		//driver.quit();
	}

}
