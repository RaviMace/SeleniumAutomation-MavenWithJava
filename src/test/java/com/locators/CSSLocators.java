package com.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// CSS Selector
/*
 * CSS - cascading style sheets
 * 
 * tag id				- tag#id								- # represents id
 * tag class			- tag.classname							- . represents classname
 * tag attribute 		- tag[attribute='value']				- [] represents attributes
 * tag class attribute 	- tag.classname[attribute='value']
 * 
 */

public class CSSLocators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// tag id - tag#id
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("HTC");
		
		// tag class - tag.classname - in here if we found "button-1 search-box-button", we can take only "button-1" or "search-box-button"
		driver.findElement(By.cssSelector("button.search-box-button")).click();	// in here i can use "button-1", because there were 2 elements
		
		// tag attribute - tag[attribute='value']
		driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Nike");
		
		//tag class attribute - tag.class[attribute='value']
		driver.findElement(By.cssSelector("button.button-1[type='submit']")).click(); // but we can use "button-1"
	}

}
