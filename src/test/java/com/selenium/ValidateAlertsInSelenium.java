package com.selenium;

import org.testng.annotations.Test;

import com.pages.AlertsPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateAlertsInSelenium extends Library {
  @Test(priority= -1)
  public void VerifyAlertPageTitle() {
	  System.out.println("inside VerifyNormalAlert");
	  driver.get(objProperties.getProperty("AlertURL"));
	  PageLoadTimeOut();
	  Assert.assertEquals(driver.getTitle(), objProperties.getProperty("TitleOFAlertsPage"), "TitleOFAlertsPage is not validated");
  }
  
  
  @Test()
  public void VerifyNormalAlert() {
	  System.out.println("inside VerifyNormalAlert");
	  driver.findElement(AlertsPOM.NormalAlert).click();
	  Alert ObjAlert = driver.switchTo().alert();
	  String NormalAlertText=  ObjAlert.getText();
	  Assert.assertEquals(NormalAlertText, objProperties.getProperty("AlertPopUpText"));
	  ObjAlert.accept();
  }
  
  @Test(priority= 1)
  public void VerifyTimerAlert() {
	  System.out.println("inside VerifyTimerAlert");
	  driver.findElement(AlertsPOM.TimerAlert).click();
	  WebDriverWait wait = new WebDriverWait(driver,60);
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert ObjAlert = driver.switchTo().alert();
	  ObjAlert.accept();
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
	  Library.LaunchBrower();
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside afterTest");
  }

  @BeforeSuite
  public void beforeSuite() throws IOException {
	  System.out.println("inside beforeSuite");
	  ReadPropertiesFile();
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside AfterSuite");
  }

}
