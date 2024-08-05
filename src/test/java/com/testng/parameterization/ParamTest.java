package com.testng.parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
 * Parallel testing using XML file
 * - Created test case
 * - Created XML file to run the test case
 * - Passed browser name parameter from XML file and received in setup() method
 * - Executed test case on chrome & edge(we can add as many browser, but i had only two) (serial execution)
 * - Executed test case on chrome & edge(we can add as many browser, but i had only two) (parallel execution)
 */

public class ParamTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	@Parameters({"browser","url"})
	void setup(String br, String url) throws InterruptedException {
		
		switch (br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default:System.out.println("Invalid browser"); return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
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
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority = 3)
	void testTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
