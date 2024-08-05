package com.testng.annotation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
 * TC3
 * - bt - @BeforeTest
 * - Method1 - @Test
 * - Method2 - @Test
 * - at - @AfterClass
 * 
 */

public class AnnotationXMLlevelDemo1 {
  @Test
  public void Method1() {
	  System.out.println("This is Method1 from Demo1");
  }
  
  @BeforeTest
  public void bt() {
	  System.out.println("This is BeforeTest Method");
  }
}
