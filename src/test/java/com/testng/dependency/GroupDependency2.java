package com.testng.dependency;

import org.testng.annotations.Test;

/*
 * class1 - m1,m2,m3...
 * class2 - m4,m5,m6...
 * class3 - m7,m8,m9...
 * 
 * sanity
 * regression
 * functional
 * 
 * loginByEmail - sanity
 * loginByFacebook - sanity
 * loginByX - sanity
 * 
 * signupByEmail - regression
 * signupByFacebook - regression
 * signupByX - regression
 * 
 * paymentInRupees - sanity, regression (functional)
 * paymentInDollors - sanity, regression (functional)
 */


public class GroupDependency2 {
  @Test(priority = 1, groups= {"regression"})
  public void signupByEmail() {
	  System.out.println("This is signup by email");
  }
  
  @Test(priority = 2, groups= {"regression"})
  public void signupByFacebook() {
	  System.out.println("This is signup by facebook");
  }
  
  @Test(priority = 3, groups= {"regression"})
  public void signupByX() {
	  System.out.println("This is signup by X platform");
  }
}
