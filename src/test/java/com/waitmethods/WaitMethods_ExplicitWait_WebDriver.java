package com.waitmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Thread.sleep(): 
 * 	Adv: 
 * 	- easy to use
 * 	DisAdv: 
 * 	- if the time is not sufficient then you will get exception
 * 	- it will wait for maximum time out. this will reduce the performance of the script
 * 	- multiple times
 * 
 * implicit wait:
 * 	driver.manage().timeouts().implicityWait(Duration.ofSeconds(10))
 * 	Adv:
 * 	- single time/one statement
 * 	- it will not wait till maximum time if teh element is available
 * 	- Applicable for all the elements
 * 	- easy to use 
 * 	DisAdv:
 * 	- if the time is not sufficient then you will get exception
 * 
 * explicit wait
 * 	Declaration	- WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
 * 	Use			- WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
 * 	- Conditional based, it will work more effectively
 * 	- finding element is inclusive(for some conditions)
 * 	- it will wait for condition to be true, then consider the time
 * 	- we need to write multiple statements for multiple elements
 * 
 * explicit wait - conditions
 * 
 * 1.alertIsPresent() 				- Waits until an alert is present on the page.
 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 * wait.until(ExpectedConditions.alertIsPresent());
 * 
 * 2.elementSelectionStateToBe()	- This condition waits until the specified element's selection state (checked/selected) is as expected (either true or false).
 * wait.until(ExpectedConditions.elementSelectionStateToBe(By.id("checkboxId"), true));
 * 
 * 3.elementToBeClickable()			- Waits until an element is visible and clickable.
 * WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("clickableElement")));
 * 
 * 4.elementToBeSelected()			- Waits until an element is selected.
 * WebElement element = wait.until(ExpectedConditions.elementToBeSelected(By.id("selectableElement")));
 * 
 * 5.frameToBeAvailableAndSwitchToIt()- Waits until a frame is available and switches to it.
 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frameId")));
 * 
 * 6.invisibilityOf()					- Waits until an element is no longer visible.
 * wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("invisibleElement"))));
 * 
 * 7.invisibilityOfElementLocated()	- Waits until an element located by a locator is no longer visible.
 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("invisibleElement")));
 * 
 * 8.preseceOfAllElementsLocatedBy() - This condition waits until all elements located by the specified locator are present in the DOM.
 * List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("someClassName")));
 * 
 * 9.presenceOfElementLocated()		- Waits until an element is present in the DOM.
 * WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("elementId")));
 * 
 * 10.textToBePresentInElement() 		- Waits until the specified text is present in the specified element.
 * wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("elementId")), "expectedText"));
 * 
 * 11.textToBePresentInElementLocated()	- Waits until the specified text is present in the element located by a locator.
 * wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("elementId"), "expectedText"));
 * 
 * 12.textToBePresentInElementValue()	- This condition waits until the specified text is present in the specified element's value attribute.
 * wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("inputFieldId"), "expectedText"));
 * 
 * 13.titleContains()					- Waits until the title contains the specified text.
 * wait.until(ExpectedConditions.titleContains("expectedTitle"));
 * 
 * 14.titleIs()						- Waits until the title is exactly the specified text.
 * wait.until(ExpectedConditions.titleIs("exactTitle"));
 * 
 * 15.visibilityOf()					- Waits until an element is visible.
 * WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("visibleElement"))));
 * 
 * 16.visibilityOfElementLocated()		- Waits until an element located by a locator is visible.
 * WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleElement")));
 * 
 * 17.visibilityOfAllElements()		- Waits until all elements are visible.
 * List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.className("elementsClassName"))));
 * 
 * 18.visibilityOfAllElementsLocatedBy()- Waits until all elements located by a locator are visible.
 * List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
 */

public class WaitMethods_ExplicitWait_WebDriver {

	public static void main(String[] args) throws InterruptedException {

// Wait Methods
		System.out.println("Wait Methods : Explicit wait");
		System.out.println();
				
		WebDriver driver = new ChromeDriver();
		
		//10sec is maximum time in real project-performance issue
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //declaration
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin"); // this is not needed, if we use explicit wait
		WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		userName.sendKeys("Admin");
		
		WebElement userPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		userPassword.sendKeys("admin123");
		
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		login.click();
		
		//WebElement logoVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='client brand banner']")));
		
		driver.quit();
	}

}
