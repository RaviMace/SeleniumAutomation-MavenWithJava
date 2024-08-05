package com.handling.keyboardaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/*
 * Keyboard actions - Actions
 * 
 * keyDown(Keys.CONTROL/TAB/SHIFT/ALT) - pressing
 * KeyUp(Keys.CONTROL/TAB/SHIFT/ALT) - releasing
 * 
 * To open new tab to use another site. and driver will be focused on second window/site
 * driver.switchTo().newWindow(WindowType.TAB);
 */

public class KeyBoardActions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome");
		
		Actions act = new Actions(driver);
		
		// CTRL+A - selection of all the texts
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		// CTRL+C - copy the text into clip-board
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		// TAB - shift to 2nd box
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		// CTRL+V - paste the text
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		// Opening the New tab
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.google.com");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		// Method 1 : using actions calls
		/*	action.moveToElement(searchBox)
				.keyDown(searchBox, Keys.SHIFT)
				.sendKeys(searchBox, "selenium")
				.keyUp(searchBox, Keys.SHIFT)
				.pause(3000)
				.sendKeys(Keys.ENTER)
				.perform();*/
			
			// Method 2 : Using Action Interface
			Action seriesOfActions = act
					.moveToElement(searchBox)
					.keyDown(searchBox, Keys.SHIFT)
					.sendKeys(searchBox, "selenium")
					.keyUp(searchBox, Keys.SHIFT)
					.pause(3000)
					.sendKeys(Keys.ENTER)
					.build();
			
			seriesOfActions.perform();

	}

}
