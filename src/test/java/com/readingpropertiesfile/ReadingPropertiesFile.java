package com.readingpropertiesfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		// Location of the properties file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\orangehrm.properties");
		
		// Loading properties file
		Properties prObj = new Properties();
		prObj.load(file);
		
		// Reading the data from properties file
		String url = prObj.getProperty("url");
		String username = prObj.getProperty("username");
		String usxpath = prObj.getProperty("usXpath");
		String password = prObj.getProperty("password");
		String passxpath = prObj.getProperty("passXpath");
		String loginBtn = prObj.getProperty("loginbutton");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		
		driver.findElement(By.xpath(usxpath)).sendKeys(username);
		driver.findElement(By.xpath(passxpath)).sendKeys(password);
		driver.findElement(By.xpath(loginBtn)).click();
		
		driver.quit();
		System.out.println(url+" "+username+" "+password);
		
		// Reading all the keys from properties files
		
		Set<String> keys = prObj.stringPropertyNames();
		System.out.println(keys);
		
		Set<Object> key = prObj.keySet();
		System.out.println(key);
		
		// Reading all the values from properties file
		Collection<Object> values = prObj.values();
		System.out.println(values);
		
		file.close();

	}

}
