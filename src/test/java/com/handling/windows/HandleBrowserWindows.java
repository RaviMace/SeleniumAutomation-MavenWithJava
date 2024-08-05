package com.handling.windows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * To open new tab to use another site. and driver will be focused on second window/site
 * driver.switchTo().newWindow(WindowType.TAB);
 */

public class HandleBrowserWindows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='nopCommerce']")).click();
		
		Set<String> windowsID = driver.getWindowHandles();
		
		List<String> windowList = new ArrayList<String>(windowsID);
		//String parentID = windowList.get(0);
		String childID = windowList.get(1);
		
		//before switching
		System.out.println(driver.getTitle());
		
		//after switching
		driver.switchTo().window(childID);
		System.out.println(driver.getTitle());
		
		for (String id : windowsID) {
			String title = driver.switchTo().window(id).getTitle();
			if (title.equals("Free and open-source eCommerce platform. ASP.NET Core based shopping cart. - nopCommerce")) {
				driver.close();
			}
		}
		
		
		driver.quit();
	}

}
