package com.selenium;

import org.testng.annotations.Test;

import com.pages.AlertsPOM;
import com.pages.FramesPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateFrames extends Library {
  @Test(priority= -1)
  public void VerifyFramesPageTitle() {
	  System.out.println("inside VerifyFramesPageTitle");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.get(objProperties.getProperty("FramesURL"));
	  PageLoadTimeOut();
	  Assert.assertEquals(driver.getTitle(), objProperties.getProperty("TitleOfFrames"), "TitleOFFramesPage is not validated");
  }
  
  @Test(priority=1)
  public void ValidateSingleFrame() {
	  System.out.println("insideValidateSingleFrame");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	 // WebElement FrameSingle = driver.findElement(FramesPOM.SingleFrame);
	  driver.switchTo().frame(FramesPOM.singleFrame);
	  driver.findElement(FramesPOM.TextBox).sendKeys(objProperties.getProperty("SingleFrameText"));
	  driver.switchTo().defaultContent(); //control will come out of frame to mail html document
	  driver.findElement(FramesPOM.IFrameWithInIframe).click();
  }
  
  
  @Test(priority=2,dependsOnMethods = {"ValidateSingleFrame"})
  public void ValidateFrameInsideAnotherFrame() {
	  System.out.println("ValidateFrameInsideAnotherFrame");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  WebElement OuterFrame = driver.findElement(FramesPOM.OuterIframe);
	  driver.switchTo().frame(OuterFrame);
	  WebElement InnerFrame = driver.findElement(FramesPOM.InnerFrame);
	  driver.switchTo().frame(InnerFrame);
	  driver.findElement(FramesPOM.TextBox).sendKeys(objProperties.getProperty("IframeWithinIFrameText"));
	  driver.switchTo().defaultContent(); //control will come out of frame to mail html document
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("inside beforeMethod");
  }

  @AfterMethod
  public void afterMethod(ITestResult Result) {
	  System.out.println("inside afterMethod");
	  UpdatingResultInExtentReport(Result);
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("inside beforeClass");
	  StartExtentReport();
	  
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
	  FlushReport();
	  
  }

}
