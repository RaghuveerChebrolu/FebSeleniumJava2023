package com.selenium;

import org.testng.annotations.Test;

import com.pages.AlertsPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateAlertsInSelenium extends Library {
  @Test(priority= -1,groups= {"sanity"})
  public void VerifyAlertPageTitle() {
	  System.out.println("inside VerifyAlertPageTitle");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.get(objProperties.getProperty("AlertURL"));
	  PageLoadTimeOut();
	  Assert.assertEquals(driver.getTitle(), objProperties.getProperty("TitleOFAlertsPage"), "TitleOFAlertsPage is not validated");
  }
  
  
  @Test(groups= {"sanity"})
  public void VerifyNormalAlert() {
	  System.out.println("inside VerifyNormalAlert");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.findElement(AlertsPOM.NormalAlert).click();
	  Alert ObjAlert = driver.switchTo().alert();
	  String NormalAlertText=  ObjAlert.getText();
	  Assert.assertEquals(NormalAlertText, objProperties.getProperty("AlertPopUpText"));
	  ObjAlert.accept();
  }
  
  @Test(priority= 1)
  public void VerifyTimerAlert() {
	  System.out.println("inside VerifyTimerAlert");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.findElement(AlertsPOM.TimerAlert).click();
	  WebDriverWait wait = new WebDriverWait(driver,60);
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert ObjAlert = driver.switchTo().alert();
	  ObjAlert.accept();
  }
  
  
  @Test(priority=2)
  public void VerifyConfirmAlert() {
	  System.out.println("inside VerifyConfirmAlert");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.findElement(AlertsPOM.ConfromAlert).click();
	  Alert objALert = driver.switchTo().alert();
	  objALert.dismiss();
	  String CoformAlertResult = driver.findElement(AlertsPOM.ConfromResult).getText();
	  Assert.assertEquals(CoformAlertResult, Constants.ConformBoxCancelResult);
  }
  
  @Test(priority=3)
  
  public void ValidatePromptBoxAlert() {
	  System.out.println("inside ValidatePromptBoxAlert");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.findElement(AlertsPOM.PromptAlert).click();
	  Alert objAlert = driver.switchTo().alert();
	  objAlert.sendKeys(Constants.PromptBoxTextBoxInfo);
	  objAlert.accept();
	  String PromptBoxResult = driver.findElement(AlertsPOM.PromptResult).getText();
	  Assert.assertEquals(PromptBoxResult, Constants.PromptBoxAlertResult,"PromptBoxAlert is not validated");
	  
  }
  
  
  @BeforeMethod(groups= {"sanity"})
  public void beforeMethod() {
	  System.out.println("inside beforeMethod");
  }

  @AfterMethod(groups= {"sanity"})
  public void afterMethod(ITestResult Result) throws IOException {
	  System.out.println("inside afterMethod");
	  UpdatingResultInExtentReport(Result);
  }

  @BeforeClass(groups= {"sanity"})
  public void beforeClass() {
	  System.out.println("inside beforeClass");
	  StartExtentReport();
	  
  }

  @AfterClass(groups= {"sanity"})
  public void afterClass() {
	  System.out.println("inside afterClass");
  }

  @BeforeTest(groups= {"sanity"})
  public void beforeTest() {
	  System.out.println("inside beforeTest");
	  Library.LaunchBrower();
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside afterTest");
  }

  @BeforeSuite(groups= {"sanity"})
  public void beforeSuite() throws IOException {
	  System.out.println("inside beforeSuite");
	  ReadPropertiesFile();
  }

  @AfterSuite(groups= {"sanity"})
  public void afterSuite() {
	  System.out.println("inside AfterSuite");
	  FlushReport();
	  
  }

}
