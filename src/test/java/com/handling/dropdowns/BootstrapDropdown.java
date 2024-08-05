package com.handling.dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click(); // opens dropdown options
		
		// Approach 1
		// Select single option - selecting the option one by one 
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		// Approach 2
		// Capture the options from the drop-down - it's used to get all the options and test weather all the options are working in loop
		List<WebElement> dropdownOptions =  driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		System.out.println("Number of options available : "+dropdownOptions.size());
		
		// Printing options from dropdown
		for (WebElement op : dropdownOptions) {
			System.out.println(op.getText());
		}
		
		// Select multiple options 
		for (int i = 1; i < dropdownOptions.size(); i++) {		// can't use 0 or 6 or 10, so am going to start with 1 and avoid selecting 6 & 10
			WebElement op = dropdownOptions.get(i);
			String opTxt= op.getText();
			if(opTxt.equals("C#") || opTxt.equals("Python") || opTxt.equals("MySQL")) {
				op.click();
			}
		}

	}

}
