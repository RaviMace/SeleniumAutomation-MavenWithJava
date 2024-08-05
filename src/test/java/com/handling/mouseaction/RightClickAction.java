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
 * - Double click - 
 * - Drag and drop
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
 * To open new tab to use another site. and driver will be focused on second window/site
 * driver.switchTo().newWindow(WindowType.TAB);
 *  
 */

public class RightClickAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions act = new Actions(driver);
		
		// Right click action
		act.contextClick(button).perform();
		
		// click on copy
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
		
		// close alert box - only OK alert box
		driver.switchTo().alert().accept();
		
	}

}
