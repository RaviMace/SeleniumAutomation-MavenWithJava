package com.handling.dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		
		System.out.println(list.size());
		
		for (WebElement l : list) {
			System.out.println(l.getText());
			if (l.getText().equals("selenium")) {
				l.click();
				break;
			}
		}
		driver.quit();

	}

}
