package com.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Locators - id, name, linkText, partialLinkText, className, tagName
 * Custom Locators - CSS Selector, x-path
 */

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo-opencart.com/");
		driver.manage().window().maximize();
		
		// id
		boolean logoDisplaystatus = driver.findElement(By.id("logo")).isDisplayed();	// Selenium notes - WebElements - 10) isDiplayed()
		System.out.println("Logo is displayed or not : "+logoDisplaystatus);
		
		// name
		driver.findElement(By.name("search")).sendKeys("Mac");							// Selenium notes - WebElements - 13) sendKeys()
		
		//linkText - <a href="url">Title</a>, we have to look for anchor in HTML. we have to take to Title and use that
		driver.findElement(By.linkText("Tablets")).click();								// Selenium notes - WebElements - 2) click()
		Thread.sleep(2000);
		
		// partialLinkText - the title is "Phones & PDAs", in we can partial text from this and still this will perform.
		// But it will not work, if it has two title with same title, ex: Table and Tables. in here we can use partialLinkText
		driver.findElement(By.partialLinkText("& PDAs")).click();
		
		Thread.sleep(2000);
		
		// to go to home page
		driver.findElement(By.id("logo")).click();
		Thread.sleep(2000);
		
// findElement(locator) -> WebElement			- this returns only one single web element		- NoSuchElementException(if there is no elements)
// findElemtns(locator) -> List<WebElement>		- this returns single or multiple web elements		- it will returns 0 (if there is no elements)
		
		// className - we use findElements instead of findElement, because we are finding group of elements.
		List<WebElement> headerLinks =  driver.findElements(By.className("list-inline-item"));
		System.out.println("total number of header links: "+ headerLinks.size());
		
		// tagName
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("total number of links: "+links.size());
		
		links = driver.findElements(By.tagName("img"));
		System.out.println("total number of image: "+links.size());
	}

}
