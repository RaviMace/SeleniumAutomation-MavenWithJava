package com.testng.intro;

import org.testng.annotations.Test;

/*
 * 1) Open application
 * 2) Login
 * 3) Logout
 * 
 * In TestNG its always preferred to use void method which doesn't return anything. Where it can focus on test execution
 * When to Consider Non-Void Methods:
 * - Data-Driven Testing: If you're returning data from a test method to be used in subsequent tests, a non-void method might be suitable.
 * - Complex Calculations: For methods involving intricate calculations, returning a value can improve code readability and maintainability.
 * 
 * Annotation
 * @Test
 * - TestNG execute test methods bases on alphabetical order
 * - @Test(priority = n) controls the order of the execution
 * - Once you provide priority to the test methods, then order of methods is not considered
 * - Priorities can be random (no need to have consecutive numbers)
 * - If you don't provide priority then default value is zero(0)
 * - If the priorities are same then again it will execute in alphabetical order
 * - Negative values are allowed in priority
 * - TestNG execute test methods only if they are having @Test annotation
 * 
 */

public class TestNGIntro {
	
	@Test(priority = 1)   
	void openapp() {
		System.out.println("Opening application");
	}
	
	@Test(priority = 2)
	void login() {
		System.out.println("Login to application");
	}
	
	@Test(priority = 3)
	void logout() {
		System.out.println("Logout from application");
	}
}
