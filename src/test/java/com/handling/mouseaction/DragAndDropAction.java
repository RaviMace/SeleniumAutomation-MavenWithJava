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
 * - Drag and drop - dragAndDrop(source, target) 
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
 * 	build().perform() is must, without that it will not perform
 *	build() - create an action
 *  perform() - complete an action - and also perform will be above to build the action and perform the action explicitly
 *  
 *  getAttribute(attribute)
 *  
 * To open new tab to use another site. and driver will be focused on second window/site
 * driver.switchTo().newWindow(WindowType.TAB);
 *  
 */

public class DragAndDropAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		// Drag
		WebElement rome = driver.findElement(By.xpath("//div[@id='box6']"));
		
		// Drop
		WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
		
		// Drag and Drop
		act.dragAndDrop(rome, italy).perform();
		
		WebElement oslo = driver.findElement(By.xpath("//div[@id='box1']"));
		WebElement norway = driver.findElement(By.xpath("//div[@id='box101']"));
		act.dragAndDrop(oslo, norway).perform();
		 		
		WebElement seoul = driver.findElement(By.xpath("//div[@id='box5']"));
		WebElement southkoera = driver.findElement(By.xpath("//div[@id='box105']"));
		act.dragAndDrop(seoul, southkoera).perform(); 
		  
		WebElement madrid = driver.findElement(By.xpath("//div[@id='box7']"));
		WebElement spain = driver.findElement(By.xpath("//div[@id='box107']"));
		act.dragAndDrop(madrid, spain).perform(); 
		  
		WebElement copenhagen = driver.findElement(By.xpath("//div[@id='box4']"));
		WebElement denmark = driver.findElement(By.xpath("//div[@id='box104']"));
		act.dragAndDrop(copenhagen, denmark).perform(); 
		  
		WebElement washington = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement unitedstates = driver.findElement(By.xpath("//div[@id='box103']"));
		act.dragAndDrop(washington, unitedstates).perform(); 
		  
		WebElement stockholm = driver.findElement(By.xpath("//div[@id='box2']"));
		WebElement sweden = driver.findElement(By.xpath("//div[@id='box102']"));
		act.dragAndDrop(stockholm, sweden).perform();
		 
		driver.quit();
	}

}
