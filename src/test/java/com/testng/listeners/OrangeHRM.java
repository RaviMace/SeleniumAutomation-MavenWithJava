package com.testng.listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
 * TestNG Listeners
 * - Create test case
 * - Create listener case
 * - Create XML file and include both test case & listener class
 * 
 * 2 way to implement listener class
 * - Method 1 - class MyListener implements ITestListener
 * - Method 2 - class MyListener extends TestListenerAdapter
 * 
 */

//@Listeners(com.testng.listeners.MyListeners.class) // This method is not preferable, using listener in XML is preferred
public class OrangeHRM {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	void setup() throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void testLogo() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}

	@Test(priority = 2)
	void testURL() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/");
	}
	
	@Test(priority = 3, dependsOnMethods = {"testURL"})
	void testTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
