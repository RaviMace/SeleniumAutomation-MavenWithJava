package com.handling.headlesstesing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * ChromeOptions
 * 1) Headless Testing
 * syntax : ChromeOptions cOptions = new ChromeOptions();
 *			cOptions.addArguments("--headless=new");
 * 
 * Advantage:
 * - we can do multiple tasks(since execution happened back-end)
 * - faster execution
 * 
 * Disadvantage:
 * - user cannot see the actions on the page. so he cannot understand flow/functionality of the test.
 * 
 *
 *	When you execute a Selenium test in headless mode, the browser operates in the background without a graphical user interface. 
 *  This means that your system resources are free to handle other tasks while the test is running.
 *	
 *	However, there are some important considerations: Keyboard and Mouse Actions in Headless Mode
 *	Limitations: Since there's no physical display, actions like mouse hover, drag-and-drop, or specific keyboard combinations might 
 *	not work as expected.
 *	Alternatives: Consider using JavaScript or Actions class to simulate these interactions within the browser context. For example, 
 *	you can use JavaScript to trigger hover events or Actions class for more complex mouse movements.
 *	Test Design: Design your tests to minimize reliance on visual elements and interactions. Focus on functional testing and API interactions 
 *	where possible.
 *
 *	Resource Consumption
 *	CPU and Memory: Headless execution generally consumes fewer resources than a full browser, but resource usage will still depend on the 
 *	complexity of your tests and the website you're testing.
 *	Performance Impact: While you can perform other tasks, be mindful of the potential impact on test execution speed and reliability. 
 */ 
public class HeadlessTestingUsingChromeOptions {

	public static void main(String[] args) {
		
		// Creating ChromeOptions to execute in headless mode
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--headless=new");	// setting for headless mode of execution "--headless=new"
		
		// Every thing will be executed in background. Browser will not be visible. we only get test results
		WebDriver driver = new ChromeDriver(cOptions); // for implementation, we have mention the ChromOptions 'variable' into ChromeDriver("variable")
		
		driver.get("https://vinothqaacademy.com/demo-site/");
		
		String actTitle = driver.getTitle();								
		String expTitle = "Demo Site – Registration Form – Vinoth Q.A Academy";
		
		if(actTitle.equals(expTitle)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		
		driver.quit();					

	}

}
