package com.handling.mouseaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* Mouse Actions:
 * - Mouse hover - moveToElement(element)
 * - Right click
 * - Double click
 * - Drag and drop
 * 
 * Action - pre defined class provided in selenium
 * 
 * .build().perform() is must, without that it will not perform
 *	build() - create an action
 *  perform() - complete an action - and also perform will be above to build the action and perform the action explicitly
 *  
 *  
 * To open new tab to use another site. and driver will be focused on second window/site
 * driver.switchTo().newWindow(WindowType.TAB);
 */

public class MouseHoverAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo-opencart.com/index.php?route=common/home&language=en-gb");
		driver.manage().window().maximize();
		
		WebElement desktops = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (2)']"));

		Actions act = new Actions(driver);
		
		// Mouse Hover
		//act.moveToElement(desktops).moveToElement(mac).click().build().perform(); // .build().perform() is must, without that it will not perform
		// or
		act.moveToElement(desktops).moveToElement(mac).click().perform();	// - and also perform will be above to build the action and perform the action explicitly

	}

}
