package com.testng.assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {
  //@Test
  public void testHardAssertions() {
	  System.out.println("Testing");
	  System.out.println("Testing");
	 
	  Assert.assertEquals(1, 2); // Hard assertions
	  
	  // If above assert fails, execution exists and below statements will not be executed
	  System.out.println("Testing");
	  System.out.println("Testing");
	  
	  // So we have keep the hard assertions at last of the method or execution itself
  }
  
  @Test
  public void testSoftAsstions() {
	  System.out.println("Testing");
	  System.out.println("Testing");
	  
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(1, 2); // soft assertions
	  
	  // If above assert fails, execution will continue and below statement gets executed 
	  System.out.println("Testing");
	  System.out.println("Testing");
	 
	  // So at the end of the method, we have give mandatory statement
	  sa.assertAll();
	  
  }
  
}
