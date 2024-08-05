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


public class GroupDependency3 {
  
  @Test(priority = 1, groups= {"sanity","regression","functional"})
  public void paymentInRupees() {
	  System.out.println("Payment in Rupees");
  }
  
  @Test(priority = 2, groups= {"sanity","regression","functional"})
  public void paymentInDollors() {
	  System.out.println("Payment in Dollors");
  }
}
