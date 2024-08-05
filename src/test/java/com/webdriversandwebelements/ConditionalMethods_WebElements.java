package com.webdriversandwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods_WebElements {

	public static void main(String[] args) throws InterruptedException {
		
// Conditional Methods
		System.out.println("Conditional Methods");
		System.out.println();

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
				
		// isDisplayed() - we can check display status of the element
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Display status of logo: "+logo.isDisplayed());
		
		// isEnables() - mainly used to check weather it is enables or not -  mainly for input box, check box, drop-down and radio box
		boolean textBox = driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		System.out.println("Enable status :"+textBox);
		
		// isSelected() - we can use to check the element is selected or not
		WebElement maleRadio = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement femaleRadio = driver.findElement(By.xpath("//input[@id='gender-female']"));
		femaleRadio.click();
		
		System.out.println(maleRadio.isSelected());
		System.out.println(femaleRadio.isSelected());
		
		Thread.sleep(2000);
		driver.quit();
	}

}
