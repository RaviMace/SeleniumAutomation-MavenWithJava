package com.handling.mouseaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		// dragAndDropBy(Element, x, y)
		// Minimum Slider
		WebElement minSlider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		System.out.println("Default location of min slider : "+minSlider.getLocation()); //(59, 250) = (x,y) - 59+100 (+/- will be there)
		act.dragAndDropBy(minSlider, 100, 250).perform();
		System.out.println("Default location of min slider : "+minSlider.getLocation()); //(161, 250) = (x,y)
		
		// Maximum Slider
		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Default location of min slider : "+maxSlider.getLocation()); //(544, 250) = (x,y) - 544-150 (+/- will be there)
		act.dragAndDropBy(maxSlider, -150, 250).perform();
		System.out.println("Default location of min slider : "+maxSlider.getLocation()); //(394, 250) = (x,y)
		
		driver.quit();

	}

}
