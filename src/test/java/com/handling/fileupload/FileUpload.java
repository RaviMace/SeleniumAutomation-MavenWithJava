package com.handling.fileupload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php/");
		driver.manage().window().maximize();
		
		// Single file upload
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\RaviGayu\\Desktop\\XPath.docx"); // this is file1
	
		// Validation 
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("XPath.docx")) {
			System.out.println("File is sucessfully uploaded ");
		} else {
			System.out.println("File Upload failed");
		}
		
		Thread.sleep(3000);
		
		// Multiple file uploaded
		String file2 = "C:\\Users\\RaviGayu\\Desktop\\MouseAction.HTML";
		String file3 = "C:\\Users\\RaviGayu\\Desktop\\GitHub.docx";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file2+"\n"+file3); // "\n" is new line
		
		// Validation - Number of files
		int noOfFilesUploaded = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		if(noOfFilesUploaded == 3) {
			System.out.println("All Files are sucessfully uploaded ");
		} else {
			System.out.println("File are not uploaded or incorrect files uploaded");
		}
		
		// Validation file names
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("XPath.docx") && 
				driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("MouseAction.HTML") && 
				driver.findElement(By.xpath("//ul[@id='fileList']//li[3]")).getText().equals("GitHub.docx")) {
			System.out.println("All Files names are matching");
		} else {
			System.out.println("File names are not matching");
		}
		
		

	}

}
