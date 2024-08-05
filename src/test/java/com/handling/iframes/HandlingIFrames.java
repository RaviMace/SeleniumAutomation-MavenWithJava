package com.handling.iframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * driver.switchTo().frame(WebElement)
 * driver.switchTo().frame(name)
 * driver.switchTo().frame(id)
 * driver.switchTo().frame(index)
 * 
 * driver.switchTo().defaultContent() - Mandatory step - switch back to default content
 */

public class HandlingIFrames {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		// Frame 1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");

		// Mandatory step - switch back to default content
		// from previous frame to next frame
		driver.switchTo().defaultContent();
		
		// Frame 2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("selenium");
		
		driver.switchTo().defaultContent();
		
		// Frame 3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("java");
		
		//inner i-frame - part of frame 3
		driver.switchTo().frame(0);					// switching to frame using index, because only one frame available in frame 3
		
		//driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();
		
		// Using JavascriptExecutor
		WebElement radioButton = driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", radioButton);
		
		driver.switchTo().defaultContent();
		
		
		
	}

}
