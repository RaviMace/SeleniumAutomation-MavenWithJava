package com.testng.annotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
 * TC2
 * - Login - @BeforeClass
 * - Search - @Test
 * - Advanced search - @Test
 * - Logout - @AfterClass
 * 
 */
public class AnnotationClassLevelDemo2 {
	
	@BeforeClass
	void login() {
		System.out.println("This is login");
	}
	
	@Test(priority = 1)
	void search() {
		System.out.println("This is Search");
	}
	
	@Test(priority = 2)
	void advancedSearch() {
		System.out.println("This is Advanced search");
	}
	
	@AfterClass
	void logout() {
		System.out.println("This is logout");
	}
}
