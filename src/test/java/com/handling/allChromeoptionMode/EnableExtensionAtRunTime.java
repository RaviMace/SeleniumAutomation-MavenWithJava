package com.handling.allChromeoptionMode;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Enable extensions in browser
 * - Add CRX Extractor/Downloader to chrome browser (manually)
 * - Add SelectorsHub plug-in to Chrome browser (manually)
 * - Capture CRX file for SelectorsHub extension
 * - Pass CRS file path in automation script in Chrome Options
 */

public class EnableExtensionAtRunTime {

	public static void main(String[] args) {
		
		ChromeOptions option= new ChromeOptions();
		
		File file = new File("C:\\Users\\RaviGayu\\Documents\\Workspace\\AdBlocke.crx");
		
		option.addExtensions(file);
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://text-compare.com");
		
		driver.quit();
	}

}
