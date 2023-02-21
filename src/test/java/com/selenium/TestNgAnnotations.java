package com.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgAnnotations {
  @Test(priority=-3)
  public void testcase1() {
	  System.out.println("inside testcase1");
  }
  
  @Test()
  public void testcase2() {
	  System.out.println("inside testcase2");
  }
  
  @Test(priority=3)
  public void testcase() {
	  System.out.println("inside testcase");
  }
  
  @Test(priority=-7)
  public void testcase4() {
	  System.out.println("inside testcase4");
  }
  
  @Test(priority=9)
  public void testcase5() {
	  System.out.println("inside testcase5");
  }
  
  @Test()
  public void testCase6() {
	  System.out.println("inside testcase6");
  }
  
  @Test(priority=3)
  public void testCase7() {
	  System.out.println("inside testcase7");
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("inside beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("inside afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("inside beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("inside afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside AfterSuite");
  }

}
