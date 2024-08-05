package com.handling.newtabs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Keyboard actions - Actions
 * 
 * keyDown(Keys.CONTROL/TAB/SHIFT/ALT) - pressing
 * KeyUp(Keys.CONTROL/TAB/SHIFT/ALT) - releasing
 * 
 * To open new tab to use another site. and driver will be focused on second window/site
 * driver.switchTo().newWindow(WindowType.TAB);
 */

public class CreatingNewTab {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// 1st Tab 
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		// Opening the New tab
		driver.switchTo().newWindow(WindowType.TAB);
		
		// 2nd Tab (by opening new tab, we can input new URL, where it will switch to this tab automatically)
		driver.get("https://www.google.com");
		
		

	}

}
