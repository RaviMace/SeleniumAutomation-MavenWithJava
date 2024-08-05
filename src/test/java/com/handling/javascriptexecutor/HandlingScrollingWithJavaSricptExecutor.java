package com.handling.javascriptexecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingScrollingWithJavaSricptExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// 1) scroll down page by pixel number
		js.executeScript("window.scrollBy(0,1500)","");
		System.out.println(js.executeScript("return window.pageYOffset"));	// 1500
		
		// 2) scroll down page till element is displayed
		WebElement element = driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
		js.executeScript("arguments[0].scrollIntoView()",element);
		System.out.println(js.executeScript("return window.pageYOffset"));	//1881
		
		// 3) scroll down page till end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));		//2017
		
		Thread.sleep(5000);
		
		// 4) scroll up page to intial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		
		driver.quit();
	}

}
