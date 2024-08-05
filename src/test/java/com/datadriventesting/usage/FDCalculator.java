package com.datadriventesting.usage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		// Ad close
		if(driver.findElement(By.xpath("//*[@id='wzrk-cancel']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='wzrk-cancel']")).click();
		}
		
		String filePath = System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		
		for (int r = 1; r <=rows; r++) {
			
			// Read data from excel
			String principle = ExcelUtils.getCellData(filePath, "Sheet1", r, 0);
			String rateOfInterest = ExcelUtils.getCellData(filePath, "Sheet1", r, 1);
			String period1 = ExcelUtils.getCellData(filePath, "Sheet1", r, 2);
			String period2 = ExcelUtils.getCellData(filePath, "Sheet1", r, 3);
			String freq = ExcelUtils.getCellData(filePath, "Sheet1", r, 4);
			
			String expValue = ExcelUtils.getCellData(filePath, "Sheet1", r, 5);
			// Pass above data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
			
			Select preDrop = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			preDrop.selectByVisibleText(period2);
			Select freqDrop = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			freqDrop.selectByVisibleText(freq);
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
			
			// Validation
			String actValue = driver.findElement(By.xpath("//div[@class='cal_bg_head']/descendant::strong[2]")).getText();
			
			if(Double.parseDouble(expValue)==Double.parseDouble(actValue)) {
				System.out.println("Test Passed");
				ExcelUtils.setCellData(filePath, "Sheet1", r, 7, "Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", r, 7);
			} else {
				System.out.println("Test Failed");
				ExcelUtils.setCellData(filePath, "Sheet1", r, 7, "Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", r, 7);

			}
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
		}
		driver.quit();
	}
}
