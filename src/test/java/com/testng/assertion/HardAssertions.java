package com.testng.assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
  @Test
  public void test() {
	  
	  //Assert.assertEquals("xyz", "xyz");	// Pass
	  //Assert.assertEquals(123, 123);		// Pass
	  //Assert.assertEquals("xyz", 123);		// Fail
	  //Assert.assertEquals(123, "123");		// Fail
	  
	  //Assert.assertNotEquals("xyz", "xyz");	// Fail
	  //Assert.assertNotEquals("xyz", "123"); // Pass
	  
	  //Assert.assertTrue(true);				// Pass
	  //Assert.assertTrue(false);				// Fail
	  //Assert.assertFalse(false);			// Pass
	  //Assert.assertFalse(true); 			// Fail
	  
	  //Assert.assertTrue(1==1);				// Pass
	  //Assert.assertTrue(1==2);				// Fail
	  //Assert.assertFalse(1==2);				// Pass
	  //Assert.assertFalse(1==1);				// Fail
	  
	  Assert.fail();
  }
}
