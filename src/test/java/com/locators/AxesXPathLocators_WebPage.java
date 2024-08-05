package com.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AxesXPathLocators_WebPage {

	public static void main(String[] args) {
		
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open a webpage
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
        driver.manage().window().maximize();

        // Self
        WebElement self = driver.findElement(By.xpath("//a[contains(text(),'L&T Tech')]/self::a"));
        System.out.println("Self XPath Text				: " + self.getText());
        System.out.println();

        // Parent
        WebElement parent = driver.findElement(By.xpath("//a[contains(text(),'L&T Tech')]/parent::td"));
        System.out.println("Parent XPath Text			: " + parent.getText());
        System.out.println();

        // Child
        WebElement child = driver.findElement(By.xpath("//td/child::a[contains(text(),'L&T Tech')]"));
        // we can also use "a[contains(text(),'L&T Tech')]/ancestor::tr/child::td" - this will give size (kind of array index/int value)
        System.out.println("Child XPath Text			: " + child.getText());
        System.out.println();

        // Ancestor - is kind of taking sizes
        WebElement ancestor = driver.findElement(By.xpath("//a[contains(text(),'L&T Tech')]/ancestor::tr"));
        System.out.println("Ancestor XPath Text			: " + ancestor.getText());
        System.out.println();

        // Ancestor-or-self - is kind of taking sizes
        WebElement ancestorOrSelf = driver.findElement(By.xpath("//a[contains(text(),'L&T Tech')]/ancestor-or-self::tr"));
        System.out.println("Ancestor-or-self XPath Text		: " + ancestorOrSelf.getText());
        System.out.println();

        // Descendant
        WebElement descendant = driver.findElement(By.xpath("//tr/descendant::a[contains(text(),'L&T Tech')]"));
        // we can also use "a[contains(text(),'L&T Tech')]/ancestor::tr/descendant::*" - this will give size (kind of array index/int value)
        System.out.println("Descendant XPath Text			: " + descendant.getText());
        System.out.println();

        // Descendant-or-self
        WebElement descendantOrSelf = driver.findElement(By.xpath("//tr/descendant-or-self::a[contains(text(),'L&T Tech')]"));
        System.out.println("Descendant-or-self XPath Text		: " + descendantOrSelf.getText());
        System.out.println();

        // Following
        WebElement following = driver.findElement(By.xpath("//tr/following::a[contains(text(),'L&T Tech')]"));
        // we can also use "a[contains(text(),'L&T Tech')]/ancestor::tr/following::tr" - this will give size (kind of array index/int value)
        System.out.println("Following XPath Text			: " + following.getText());
        System.out.println();

        // Following-sibling
        List<WebElement> followingSibling = driver.findElements(By.xpath("//a[contains(text(),'L&T Tech')]/ancestor::tr/following-sibling::tr"));
        System.out.println("Following-sibling XPath Text		: " + followingSibling.size());
        System.out.println();
        
        // Preceding
        WebElement preceding = driver.findElement(By.xpath("//tr/preceding::a[contains(text(),'L&T Tech')]"));
        // we can also use "a[contains(text(),'L&T Tech')]/ancestor::tr/preceding::tr" - this will give size (kind of array index/int value)
        System.out.println("Preceding XPath Text			: " + preceding.getText());
        System.out.println();

        // Preceding-sibling
        List<WebElement> precedingSibling = driver.findElements(By.xpath("//a[contains(text(),'L&T Tech')]/ancestor::tr/preceding-sibling::tr"));
        System.out.println("Preceding-sibling XPath Text		: " + precedingSibling.size());
        System.out.println();

        // Namespace (Typically not used in HTML, shown here for completeness)
        // WebElement namespace = driver.findElement(By.xpath("//div/namespace::*"));
        // System.out.println("Namespace XPath Text: " + namespace.getText());

        // Close the browser
        driver.quit();

	}

}
