package com.testng.assertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {
	 @Test
	public void softAssertTest() {
	SoftAssert softAssert = new SoftAssert();
	String actualString = "hello";
	String expectedString = "hello";
	int actualValue = 10;
	int expectedValue = 20;
	
	softAssert.assertEquals(actualString, expectedString, "Strings are not equal");
	softAssert.assertEquals(actualValue, expectedValue, "Values are not equal");
	
	// If the below statement is not used, the result will show as pass
	softAssert.assertAll(); // This will throw an exception if any assertions failed
	}
}
