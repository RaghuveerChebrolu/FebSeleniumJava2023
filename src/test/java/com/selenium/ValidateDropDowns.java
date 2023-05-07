package com.selenium;

import org.testng.annotations.Test;

import com.pages.AlertsPOM;
import com.pages.DropDownsPOM;
import com.pages.FramesPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateDropDowns extends Library {
  @Test(priority= -1)
  public void VerifyTutorialsHutPageTitle() {
	  System.out.println("inside VerifyFramesPageTitle");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.get(objProperties.getProperty("DropDownUrl"));
	  PageLoadTimeOut();
	  Assert.assertEquals(driver.getTitle(), objProperties.getProperty("titleOfTutorialsHut"), "Title of tutorials hut page is not validated");
  }
  
  @Test(priority=1)
  public void ValidateDropDowninTutorialsHutWithSelectTag() {
	  System.out.println("inside  ValidateDropDowninTutorialsHutWithSelectTag");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  WebElement element = driver.findElement(DropDownsPOM.TestingDropDown);

	  Select objSelect = new Select(element);
	 // objSelect.selectByIndex(3);
	//  objSelect.selectByValue("Performance");
	  objSelect.selectByVisibleText("Functional Testing");
  }
  
  @Test(priority=2)
  public void ValidateNexteGenAIAcademyTitleANdDropDownValidations() {
	  System.out.println("inside ValidateNexteGenAIAcademyTitle");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.get(objProperties.getProperty("NextGenDropDown"));
	  PageLoadTimeOut();
	  System.out.println(driver.getTitle());
	  Assert.assertEquals(driver.getTitle(), objProperties.getProperty("NextGenTitle"), "Title of NexteGenAIAcademy is not validated");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,600)");
	  
	  driver.findElement(DropDownsPOM.CountryDropDown).click();
	  List<WebElement> AllCountries = driver.findElements(DropDownsPOM.AllCountries);
	  SelectValueFromDropDown(AllCountries,objProperties.getProperty("Country"));
	  
	  driver.findElement(DropDownsPOM.HH).click();
	  List<WebElement> AllHours = driver.findElements(DropDownsPOM.AllHours);
	  SelectValueFromDropDown(AllHours,objProperties.getProperty("ConvenientTimeHH"));
	  
	  driver.findElement(DropDownsPOM.MM).click();
	  List<WebElement> AllMin = driver.findElements(DropDownsPOM.AllMinutes);
	  SelectValueFromDropDown(AllMin,objProperties.getProperty("ConvenientTimeMM"));
	  
  }
  


@BeforeMethod
  public void beforeMethod() {
	  System.out.println("inside beforeMethod");
  }

  @AfterMethod
  public void afterMethod(ITestResult Result) throws IOException {
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
