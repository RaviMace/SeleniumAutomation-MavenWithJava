package com.handling.mouseaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* Mouse Actions:
 * - Mouse hover - moveToElement(element)
 * - Right click - contextClick(element)
 * - Double click - doubleClick(element)
 * - Drag and drop - 
 * 
* Actions / Action - pre defined class provided in selenium
 * 
 * Actions vs Action
 * 
 * Actions - class, will be used to perform mouse actions.
 * Action - interface, will be used to store created actions.
 * ex: Action actButton = act.contextClick(button).build
 * 	   act.actButton.perform()
 * 
 * .build().perform() is must, without that it will not perform
 *	build() - create an action
 *  perform() - complete an action - and also perform will be above to build the action and perform the action explicitly
 *  
 *  getAttribute(attribute)
 *  
 * To open new tab to use another site. and driver will be focused on second window/site
 * driver.switchTo().newWindow(WindowType.TAB);
 *  
 */

public class DoubleClickAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		WebElement box1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2 = driver.findElement(By.xpath("//input[@id='field2']"));
		
		box1.clear();
		box1.sendKeys("I gotcha job");
		
		// Double click action
		Actions act = new Actions(driver);
		
		act.doubleClick(button).perform();
		
		// Validation : box2 should contains "I gotcha job"
		
		String text = box2.getAttribute("value");
		
		System.out.println("Captureed value : "+text);
		
		if(text.equals("I gotcha job")) {
			System.out.println("Text copied");
		}else {
			System.out.println("Text not copied");
		}
		
		driver.quit();
	}

}
