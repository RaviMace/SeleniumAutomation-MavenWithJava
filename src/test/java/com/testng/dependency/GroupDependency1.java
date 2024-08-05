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
 * 
 * - all sanity tests - include=sanity
 * - all regression tests - include=regression
 * - all sanity but not regression - include=sanity, exclude=regression
 * - all regression but not sanity - include=regression, exclude=sanity
 * - all methods which are belongs to both sanity & regression - include=functional
 * 
 * commenting in xml file - staring "<!--" & in ending "-->"
 * 
 */

public class GroupDependency1 {
  @Test(priority = 1, groups= {"sanity"})
  public void loginByEmail() {
	  System.out.println("This is login by email");
  }
  
  @Test(priority = 2, groups= {"sanity"})
  public void loginByFacebook() {
	  System.out.println("This is login by facebook");
  }
  
  @Test(priority = 3, groups= {"sanity"})
  public void loginByX() {
	  System.out.println("This is login by X platform");
  }


}
