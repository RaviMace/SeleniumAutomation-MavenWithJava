package com.testng.annotation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Annotations
 * @Test
 * 
 * @BeforeMethod
 * @AfterMethod
 * 
 * @BeforeClass
 * @AfterClass
 * 
 * @BeforeTest
 * @AfterTest
 * 
 * @BeforeSuite
 * @AfterSuite
 * 
 * TC1
 * - Login - @BeforeMethod
 * - Search - @Test
 * - Logout - @AfterMethod
 * - Login 
 * - Advanced search - @Test
 * - Logout
 * 
 */
public class AnnotationClassLevelDemo1 {
	
	@BeforeMethod
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
	
	@AfterMethod
	void logout() {
		System.out.println("This is logout");
	}
}
