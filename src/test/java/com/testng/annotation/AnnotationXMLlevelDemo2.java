package com.testng.annotation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

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
 * TC4
 * - bt - @BeforeTest
 * - Method1 - @Test
 * - Method2 - @Test
 * - at - @AfterClass
 * - bt - @BeforeTest
 * - Method1 - @Test
 * - Method2 - @Test
 * - at - @AfterClass
 */

public class AnnotationXMLlevelDemo2 {
  @Test
  public void Method2() {
	  System.out.println("This is Method2 from Demo2");
  }
  
  @AfterTest
  public void afterTest() {
	  System.out.println("This is AfterTest Method");
  }

}
