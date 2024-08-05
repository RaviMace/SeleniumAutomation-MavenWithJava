package com.handling.checkbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Check box and radio buttons are similar, below script work well with radio button also
 */

public class HandlingCheckBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// To select specific check-box
		// driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		// To select all the check-boxs 
		//driver.findElement(By.xpath("//label[@for='days']/following::input[@class='form-check-input']"));
		List<WebElement> checkBoxs = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		/*for (WebElement checkBox : checkBoxs) {
			checkBox.click();
		}*/
		
		// To select last 3 check-boxs
		/*for (int i = 4; i < checkBoxs.size(); i++) {
			checkBoxs.get(i).click();
		}*/
		
		// To select first 3 check-boxs
		/*for (int i = 0; i < 3; i++) {
			checkBoxs.get(i).click();
		}*/
		
		// To un-select check-boxs if there selected
		for (int i = 0; i < 3; i++) {
			checkBoxs.get(i).click();
		}
		
		Thread.sleep(5000);
		
		for (int i = 0; i < checkBoxs.size(); i++) {
			
			if(checkBoxs.get(i).isSelected())
				checkBoxs.get(i).click();
		}
		

		driver.close();
	}

}
