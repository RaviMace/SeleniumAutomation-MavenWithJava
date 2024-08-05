package com.testng.annotation;

import org.testng.annotations.*;

/*
 * Annotations
 * In Class level
 * @Test			- test code 
 * 
 * @BeforeMethod	- code to set up preconditions
 * @AfterMethod		- code to clean up postconditions
 * 
 * @BeforeClass		- code to run before any test methods in this class
 * @AfterClass		- code to run after all test methods in this class
 * 
 * In XML level
 * @BeforeTest		- code to run before any test methods in the <test> tag
 * @AfterTest		- code to run after all test methods in the <test> tag
 * 
 * @BeforeSuite		- code to run before all tests in this suite
 * @AfterSuite		- code to run after all tests in this suite
 * 
 * TC5
 * - bs - @BeforeSuite
 * - bt - @BeforeTest
 * - bc - @BeforeClass
 * - bm - @BeforeMethod
 * - Method1 - @Test
 * - am - @AfterMethod
 * - bm - @BeforeMethod
 * - Method2 - @Test
 * - am - @AfterMethod
 * - ac - @AfterClass
 * - at - @AfterTest
 * - as - @AfterSuite
 */

public class AllAnnotationXMLlevel {

	@BeforeSuite
	  public void bs() {
		  System.out.println("This is Before Suite");
	  }
	
	  @AfterSuite
	  public void as() {
		  System.out.println("This is After Suite");
	  }

	  @BeforeTest
	  public void bt() {
		  System.out.println("This is Before Test");
	  }

	  @AfterTest
	  public void at() {
		  System.out.println("This is After Test");
	  }

	  @BeforeClass
	  public void bc() {
		  System.out.println("This is Before Class");
	  }

	  @AfterClass
	  public void ac() {
		  System.out.println("This is After Class");
	  }

	  @BeforeMethod
	  public void bm() {
		  System.out.println("This is Before Method");
	  }

	  @AfterMethod
	  public void am() {
		  System.out.println("This is After Method");
	  }
	  @Test(priority = 1)
	  public void TestMethod1() {
		  System.out.println("This is Test Method 1");
	  }
	  @Test(priority = 2)
	  public void TestMethod2() {
		  System.out.println("This is Test Method 2");
	  }
    
}
