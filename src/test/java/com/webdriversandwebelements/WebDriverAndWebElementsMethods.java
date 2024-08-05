package com.webdriversandwebelements;

/* 
 * Methods of WebDriver and WebElements 
 * 	- get methods
 * 	- conditional methods
 * 	- browser methods
 * 	- navigational methods
 * 	- wait methods
 * 
 * get methods - we can access these methods through webdriver instance
 * 
 * get()						- opens the URL on the browser	
 * getTitle()					- returns title of the page
 * getCurrentUrl()				- returns URL of the page
 * getPageSource()				- returns source code of the page
 * getWindowHandle()			- returns ID of the single browser window
 * getWindowHandles()			- returns ID's of the multiple browser windows
 * 
 * conditional methods - access these commands through WebElement, which returns boolean value
 * 
 * isDisplayed()				- we cab check display status of the elements
 * isEnables()					- we can check enable/disable status for the element/operational element
 * isSelected()					- we can use to check the element is selected or not
 * 
 * browser methods
 * 
 * close()						- close current window only/where ever the driver is focused 
 * quit()						- close all the browser windows
 * 
 * wait methods 
 * 
 * implicit wait				- Assign one time after WebDriver, throughout the program the wati statement will take care of it
 * explicit wait/fluent wait	- 
 * 
 * NoSuchElementException - element is not present on the page. sync
 * ElementNotFoundException - Locator is incorrect
 * 
 * navigation methods
 * 
 * navigate().to(URL)
 * navigate().back()
 * navigate().forward()
 * navigate().refresh()
 * 
 * 
 * 
 * WebDriver Methods:
 * - get(String url)			: Opens the specified URL in the browser.
 * - getCurrentUrl()			: Retrieves the URL of the current page.
 * - getTitle()					: Retrieves the title of the current page.
 * - findElement(By by)			: Locates an element on the web page.			- this is conjunction for both WebDriver & WebElement
 * - findElements(By by)		: Locates multiple elements on the web page.	- this is conjunction for both WebDriver & WebElement
 * - getPageSource()			: Retrieves the source code of the current page.
 * - close()					: Closes the current window.
 * - quit()						: Closes the browser and ends the session.
 * - getWindowHandles()			: Retrieves all window handles.
 * - getWindowHandle()			: Retrieves the current window handle.
 * - switchTo()					: Switches to another frame, window, or alert.
 * - navigate()					: Provides methods for navigating the web page (to, back, forward, refresh).
 * - manage()					: Provides methods for managing browser settings (cookies, timeouts).
 * 
 * WebElement Methods:
 * - clear()					: Clears the content of the element (useful for input fields).
 * - click()					: Clicks the element.
 * - sendKeys(String)			: Types the specified text into the element.
 * - getAttribute(String name)	: Retrieves the value of the specified attribute.
 * - getCssValue(String name)	: Retrieves the value of the specified CSS property.
 * - getSize()					: Retrieves the size of the element.
 * - getLocation()				: Retrieves the location of the element.
 * - getText()					: Retrieves the text of the element.
 * - isDisplayed()				: Checks if the element is displayed.
 * - isEnabled()				: Checks if the element is enabled.
 * - isSelected()				: Checks if the element is selected.
 * - submit()					: Submits the form element.
 * 
 * 
 */

public class WebDriverAndWebElementsMethods {

	public static void main(String[] args) {	
	

		
	}

}
