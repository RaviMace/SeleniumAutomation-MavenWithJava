package com.handling.shadowdom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * ShadowDOM
 * - XPath cannot handle shadow DOM elements
 * - only CSS can handle shadow DOM elements
 * 
 * ex: "https://dev.automationtesting.in/shadow-dom"
 * 
 * where you can see the single, inner and nested shadow DOM
 * 
 * //This Element is inside single shadow DOM.
 * String cssSelectorForHost1 = "#shadow-root";
 * Thread.sleep(1000);
 * SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
 * Thread.sleep(1000);
 * shadow.findElement(By.cssSelector("#shadow-element"));
 * 
 * //This Element is inside 2 nested shadow DOM.
 * String cssSelectorForHost1 = "#shadow-root";
 * String cssSelectorForHost2 = "#inner-shadow-dom";
 * Thread.sleep(1000);
 * SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
 * Thread.sleep(1000);
 * SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
 * Thread.sleep(1000);
 * shadow1.findElement(By.cssSelector("#nested-shadow-element"));
 * 
 * //This Element is inside 3 nested shadow DOM.
 * String cssSelectorForHost1 = "#shadow-root";
 * String cssSelectorForHost2 = "#inner-shadow-dom";
 * String cssSelectorForHost3 = "#nested-shadow-dom";
 * Thread.sleep(1000);
 * SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
 * Thread.sleep(1000);
 * SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
 * Thread.sleep(1000);
 * SearchContext shadow2 = shadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
 * Thread.sleep(1000);
 * shadow2.findElement(By.cssSelector("#multi-nested-shadow-element"));
 * 
 */

public class ShadowDOMElements {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://books-pwakit.appspot.com/explore?q=");
		driver.manage().window().maximize();
		
		// Trying directly 
		//driver.findElement(By.cssSelector("#input")).sendKeys("selenium");  // This will throw NoSuchElementException
		
		// This is copies from SelectorHub - which makes easier to use
		//This Element is inside single shadow DOM.
		//String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
		//Thread.sleep(1000);
		
		// This is enough to Handle shadowDOM element
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#input")).sendKeys("Selenium");
				
		// Opening the New tab
		driver.switchTo().newWindow(WindowType.TAB);
		
		// 2nd Tab (by opening new tab, we can input new URL, where it will switch to this tab automatically)
		driver.get("https://dev.automationtesting.in/shadow-dom");
		
		//This Element is inside 3 nested shadow DOM.
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow2 = shadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		String shadow2Text = shadow2.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
		System.out.println(shadow2Text);
		
	}

}
