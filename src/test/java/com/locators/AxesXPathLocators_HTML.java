package com.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
	Axes in XPath define a node-set relative to the current node. It allows navigation through the nodes in various directions, 
	such as selecting children, parents, siblings, and more. Axes XPath can be considered part of dynamic XPath due to its flexibility 
	and adaptability in navigating through complex XML or HTML structures.

	HTML Example
	Here's a sample HTML structure to demonstrate different axes in XPath:
	
	<!DOCTYPE html>
		<html>
		<head>
		    <title>XPath Axes Example</title>
		</head>
		<body>
		    <div id="container">
		        <h1>Main Title</h1>
		        <div class="section">
		            <h2>Subsection 1</h2>
		            <p class="para">Paragraph 1 in Subsection 1</p>
		            <p class="para">Paragraph 2 in Subsection 1</p>
		        </div>
		        <div class="section">
		            <h2>Subsection 2</h2>
		            <p class="para">Paragraph 1 in Subsection 2</p>
		            <p class="para">Paragraph 2 in Subsection 2</p>
		        </div>
		        <footer>
		            <p>Footer information</p>
		        </footer>
		    </div>
		</body>
		</html>

	Axes in XPath
		1.Ancestor
		2.Ancestor-or-self
		3.Child
		4.Descendant
		5.Descendant-or-self
		6.Following
		7.Following-sibling
		8.Namespace
		9.Parent
		10.Preceding
		11.Preceding-sibling
		12.Self

	Explanation with Examples
	
	1.Ancestor: Selects all ancestors (parent, grandparent, etc.) of the current node.
		//p[@class='para']/ancestor::div
		From a p element with class para to all ancestor div elements.
	
	2.Ancestor-or-self: Selects all ancestors (parent, grandparent, etc.) of the current node and the current node itself.
		//p[@class='para']/ancestor-or-self::div
		From a p element with class para to all ancestor div elements including the div itself if it's a match.
	
	3.Child: Selects all children of the current node.
		//div[@id='container']/child::h1
		From the div with id container to its h1 child.
	
	4.Descendant: Selects all descendants (children, grandchildren, etc.) of the current node.
		//div[@id='container']/descendant::p
		From the div with id container to all p elements that are its descendants.
	
	5.Descendant-or-self: Selects all descendants (children, grandchildren, etc.) of the current node and the current node itself.
		//div[@id='container']/descendant-or-self::p
		From the div with id container to all p elements that are its descendants including the div itself if it's a match.
	
	6.Following: Selects everything in the document after the closing tag of the current node.
		//h2/following::p
		From an h2 element to all p elements that follow it in the document.
	
	7.Following-sibling: Selects all siblings after the current node.
		//h2/following-sibling::p
		From an h2 element to all p elements that are its following siblings.
	
	8.Namespace: Selects all namespace nodes of the current node. (Not typically used in HTML)
		//div/namespace::*
		From a div element to all its namespaces.
	
	9.Parent: Selects the parent of the current node.
		//p[@class='para']/parent::div
		From a p element with class para to its parent div.
	
	10.Preceding: Selects all nodes that appear before the current node in the document.
		//h2/preceding::p
		From an h2 element to all p elements that precede it in the document.
	
	11.Preceding-sibling: Selects all siblings before the current node.
		//p[@class='para']/preceding-sibling::h2
		From a p element with class para to all h2 elements that are its preceding siblings.
	
	12.Self: Selects the current node.
		//h2/self::h2
		From an h2 element to itself.
	
 */

public class AxesXPathLocators_HTML {

	public static void main(String[] args) {
		
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open a webpage
        //file:///C:/Users/RaviGayu/Documents/Workspace/SeleniumLearning/SeleniumAutomation-MavenWithJava/HTML_File/xpath_axes_example.html
        driver.get("file:///C:/Users/RaviGayu/Documents/Workspace/SeleniumLearning/SeleniumAutomation-MavenWithJava/HTML_File/xpath_axes_example.html");
        driver.manage().window().maximize();
        
        // Parent
        WebElement parent = driver.findElement(By.xpath("//p[@class='para']/parent::div"));
        System.out.println("Parent XPath Text			: " + parent.getTagName());
        System.out.println();

        // Child
        WebElement child = driver.findElement(By.xpath("//div[@id='container']/child::h1"));
        System.out.println("Child XPath Text			: " + child.getText());
        System.out.println();

        // Ancestor
        WebElement ancestor = driver.findElement(By.xpath("//p[@class='para']/ancestor::div"));
        System.out.println("Ancestor XPath Text			: " + ancestor.getTagName());
        System.out.println();

        // Ancestor-or-self
        WebElement ancestorOrSelf = driver.findElement(By.xpath("//p[@class='para']/ancestor-or-self::div"));
        System.out.println("Ancestor-or-self XPath Text		: " + ancestorOrSelf.getTagName());
        System.out.println();

        // Descendant
        WebElement descendant = driver.findElement(By.xpath("//div[@id='container']/descendant::p[1]"));
        System.out.println("Descendant XPath Text			: " + descendant.getText());
        System.out.println();

        // Descendant-or-self
        WebElement descendantOrSelf = driver.findElement(By.xpath("//div[@id='container']/descendant-or-self::p[2]"));
        System.out.println("Descendant-or-self XPath Text		: " + descendantOrSelf.getText());
        System.out.println();

        // Following
        WebElement following = driver.findElement(By.xpath("//h2/following::p"));
        System.out.println("Following XPath Text			: " + following.getText());
        System.out.println();

        // Following-sibling
        WebElement followingSibling = driver.findElement(By.xpath("//h2/following-sibling::p[2]"));
        System.out.println("Following-sibling XPath Text		: " + followingSibling.getText());
        System.out.println();
        
        // Preceding
        WebElement preceding = driver.findElement(By.xpath("//h2/preceding::p[1]"));
        System.out.println("Preceding XPath Text			: " + preceding.getText());
        System.out.println();

        // Preceding-sibling
        WebElement precedingSibling = driver.findElement(By.xpath("//p[@class='para']/preceding-sibling::h2[text()='Subsection 2']"));
        System.out.println("Preceding-sibling XPath Text		: " + precedingSibling.getText());
        System.out.println();

        // Namespace (Typically not used in HTML, shown here for completeness)
        // WebElement namespace = driver.findElement(By.xpath("//div/namespace::*"));
        // System.out.println("Namespace XPath Text: " + namespace.getText());

        // Self
        WebElement self = driver.findElement(By.xpath("//h2/self::h2[text()='Subsection 2']"));
        System.out.println("Self XPath Text				: " + self.getText());
        System.out.println();

        // Close the browser
        driver.quit();

	}

}
