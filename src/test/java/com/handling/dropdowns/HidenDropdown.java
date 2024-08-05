package com.handling.dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HidenDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		// Login steps 
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Clicking on PIM
		driver.findElement(By.xpath("//ul/descendant::span[text()='PIM']")).click();
		
		// Clicking on drop-down
		driver.findElement(By.xpath("//div/descendant::i[contains(@class,'arrow')][3]")).click();
		Thread.sleep(5000);
		
		// Count number of option
		List<WebElement> option = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println("Number of options in xpath : "+option.size());
		
		// Printing options
		for (WebElement op : option) {
			System.out.println(op.getText());
		}
		
		// Select single option
		driver.findElement(By.xpath("//div/descendant::span[text()='Account Assistant']")).click();
		
		driver.quit();
		
	}

}
