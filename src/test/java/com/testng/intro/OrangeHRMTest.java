package com.testng.intro;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	
	FileInputStream file; 
	Properties prObj;
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void openApp() throws IOException {
		// Location of the properties file
		file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\orangehrm.properties");
		
		// Loading properties file
		prObj = new Properties();
		prObj.load(file);
		
		// Reading the data from properties file
		String url = prObj.getProperty("url");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		driver.get(url);
		driver.manage().window().maximize();
		
		file.close();
		prObj.clone();
	}
	
	@Test(priority = 2)
	public void testLogo() throws IOException {
		// Location of the properties file
		file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\orangehrm.properties");
		
		// Loading properties file
		prObj = new Properties();
		prObj.load(file);
		
		// Reading the data from properties file
		String logoXpath = prObj.getProperty("logoXpath");
		
		// Using explicit wait as needed
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logoXpath)));
		boolean status = driver.findElement(By.xpath(logoXpath)).isDisplayed();
		System.out.println("Logo dispalyed  "+status);
		
		file.close();
		prObj.clone();  
	}
	
	@Test(priority = 3)
	public void login() throws IOException {
		// Location of the properties file
		file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\orangehrm.properties");
		
		// Loading properties file
		prObj = new Properties();
		prObj.load(file);
		
		// Reading the data from properties file
		String username = prObj.getProperty("username");
		String usxpath = prObj.getProperty("usXpath");
		String password = prObj.getProperty("password");
		String passxpath = prObj.getProperty("passXpath");
		String loginBtn = prObj.getProperty("loginbutton");
		
		driver.findElement(By.xpath(usxpath)).sendKeys(username);
		driver.findElement(By.xpath(passxpath)).sendKeys(password);
		driver.findElement(By.xpath(loginBtn)).click();
		
		file.close();
		prObj.clone();
	}
	
	@Test(priority = 4)
	public void logout() throws IOException {
		// Location of the properties file
		file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\orangehrm.properties");
		
		// Loading properties file
		prObj = new Properties();
		prObj.load(file);
		
		// Reading the data from properties file
		String logoutdrop = prObj.getProperty("logoutdrop");
		String logoutbtn = prObj.getProperty("logoutbtn");
		
		driver.findElement(By.xpath(logoutdrop)).click();
		driver.findElement(By.xpath(logoutbtn)).click();
		
		file.close();
		prObj.clone();
		driver.quit();
	}
}
