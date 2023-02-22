package com.selenium;

import org.testng.annotations.Test;

import com.pages.GmoOnlineAppPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateGmoOnileApp extends Library {
  @Test(priority=1)
  public void ValidateGmoOnlineTitle() {
	  System.out.println("inside tes case1");
	  driver.get(Library.objProperties.getProperty("GmoOnlineURL"));
	  String title = Library.driver.getTitle();
	  System.out.println("title:"+title);
	  Assert.assertEquals(title, objProperties.getProperty("TitleOfGmoOnlineWebApp"));
  }
  
  
  @Test(dependsOnMethods= {"ValidateGmoOnlineTitle"},priority=2)
  public void VerifyEnterGmoOnline() {
	  driver.findElement(GmoOnlineAppPOM.EntergmoOnline).click();
	  PageLoadTimeOut();
	  driver.findElement(GmoOnlineAppPOM.QTY_Glasses).clear();
	  driver.findElement(GmoOnlineAppPOM.QTY_Glasses).sendKeys(Constants.QTY_Glasses);
	  
  }
  
  
  @Test(priority=3,dependsOnMethods= {"ValidateGmoOnlineTitle","VerifyEnterGmoOnline"})
  public void ValidatePlaceOrderPage() {
	  System.out.println("inside tes case2");
	  driver.findElement(GmoOnlineAppPOM.EntergmoOnline).click();
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  String UnitPriceFromApp= driver.findElement(GmoOnlineAppPOM.UnitPrice).getText();
	  System.out.println("UnitPriceFromApp:"+UnitPriceFromApp);
	  String QTY= driver.findElement(GmoOnlineAppPOM.QTY).getText();
	  System.out.println("QTY:"+QTY);
	  Float CalculatedValue =  Float.parseFloat(QTY)*Float.parseFloat(UnitPriceFromApp.substring(2).trim());
	  System.out.println("CalculatedValue:"+CalculatedValue);
	  
	  String TotalPriceFromApp = driver.findElement(GmoOnlineAppPOM.TotalPrice).getText();
	  System.out.println("TotalPriceFromApp:"+TotalPriceFromApp.substring(2).trim());
	  Float TotalPriceFromAppinFloat = Float.parseFloat(TotalPriceFromApp.substring(2).trim());
	  Assert.assertEquals(CalculatedValue,TotalPriceFromAppinFloat);
  }
  
  @Test
  public void testcase() {
	  System.out.println("inside tes case");
  }
  
  @Test(invocationCount=5)
  public void testcase4() {
	  System.out.println("inside tes case4");
  }
  
  @Test(invocationCount=8)
  public void testcase7() {
	  System.out.println("inside tes case4");
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
	  LaunchBrower();
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside beforeSuite");
	  try {
		ReadPropertiesFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside AfterSuite");
  }

}
