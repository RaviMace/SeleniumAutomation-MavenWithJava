package com.testng.annotation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

/*
 * Annotations
 * In Class level
 * @Test
 * 
 * @BeforeMethod
 * @AfterMethod
 * 
 * @BeforeClass
 * @AfterClass
 * 
 * In XML level
 * @BeforeTest
 * @AfterTest
 * 
 * @BeforeSuite
 * @AfterSuite
 * 
 * TC5
 * - bs - @BeforeSuite
 * - bt - @BeforeTest
 * - Method1 - @Test
 * - Method2 - @Test
 * - at - @AfterClass
 * - bt - @BeforeTest
 * - Method1 - @Test
 * - Method2 - @Test
 * - at - @AfterTest
 * - as - @AfterSuite
 */

public class AnnotationXMLlevelDemo3 {
  @Test
  public void Mehtod3() {
	  System.out.println("This is Method3 from Demo3");
  }
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is BeforeSuite Method");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is AfterSuite Method");
  }

}
