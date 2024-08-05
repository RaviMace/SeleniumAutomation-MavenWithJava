package com.testng.assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Assertion - Validation point
 * 
 * 2 Kinds of assertions are there
 * - Hard assertions
 * - Soft assertions
 * 
 */

public class AssertionDemo1 {
	
	@Test
	void testTitle() {
		String expTitle = "Opencart";
		String actTitle = "Opencart";

		// This validation will fail the case but test will pass
		if (expTitle.equals(actTitle)) {
			System.out.println("Test Passed");
			Assert.assertTrue(true);
		} else {
			System.out.println("Test Failed");
			Assert.assertTrue(false);
		}
		
		// In Assert method will fail the case and also fail the test
		//Assert.assertEquals(expTitle, actTitle);
		
		// Using in if condition
		if (expTitle.equals(actTitle)) {
			System.out.println("Test Passed");
			Assert.assertTrue(true);
		} else {
			System.out.println("Test Failed");
			Assert.assertTrue(false);
		}
		
		
	}

}
