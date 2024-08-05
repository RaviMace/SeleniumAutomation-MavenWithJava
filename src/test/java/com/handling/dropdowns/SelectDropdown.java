package com.handling.dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * Drop-down box
 * 
 * - select 
 * - bootstrap
 * - hidden
 */

public class SelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// Select drop-down
		WebElement selectDropdown = driver.findElement(By.xpath("//select[@id='country']"));
		Select dropdownCountry = new Select(selectDropdown);
		
		// Approach 1
		dropdownCountry.selectByVisibleText("France");
		//Thread.sleep(3000);
		dropdownCountry.selectByValue("japan");
		//Thread.sleep(3000);
		dropdownCountry.selectByIndex(9);
		
		// Approach 2
		// Capture the options from the drop-down - it's used to get all the options and test weather all the options are working in loop
		List<WebElement> options = dropdownCountry.getOptions();
		System.out.println("Number of options available : "+options.size());
		
		// Printing the options
		for (WebElement printSize : options) {
			System.out.println(printSize.getText());
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

}
