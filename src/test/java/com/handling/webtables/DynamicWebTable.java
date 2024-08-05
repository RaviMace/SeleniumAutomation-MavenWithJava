package com.handling.webtables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo-opencart.com/admin/index.php?route=common/login");
		driver.manage().window().maximize();
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
		userName.clear();
		userName.sendKeys("demo");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
		password.clear();
		password.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		
		driver.findElement(By.xpath("//ul[@id='collapse-5']/preceding-sibling::a")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		// Showing 1 to 10 of 29 (4 Pages)
		//s.substring(22,23) - but numbers get changes, so using indexOf
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		int totalPages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		System.out.println(totalPages);
		
		// Repeating pages
		for(int p=1;p<=totalPages;p++) {
			if(p>1) {
				WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()='"+p+"']"));
				activePage.click();
				Thread.sleep(5000);
			}
			System.out.println("Page"+p);
			// Reading data form the page
			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			
			for(int r=1;r<=rows;r++) {
				String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[2]")).getText();
				String email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[3]")).getText();
				String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[5]")).getText();
				System.out.println(customerName+"\t"+email+"\t"+status);
				System.out.println();
			}
		}
	}

}
