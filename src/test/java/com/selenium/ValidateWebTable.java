package com.selenium;

import org.testng.annotations.Test;

import com.pages.AlertsPOM;
import com.pages.FramesPOM;
import com.pages.WebTablePOM;
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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ValidateWebTable extends Library {
  @Test(priority= -1)
  public void VerifyWebTablePageTitle() {
	  System.out.println("inside VerifyWebTablePageTitle");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.get(objProperties.getProperty("WebTableURL"));
	  PageLoadTimeOut();
	  Assert.assertEquals(driver.getTitle(), objProperties.getProperty("TitleOfWebTable"), "Title of Web Table Page is not validated");
  }
  

  @Test(priority= 1)
  public void ValidateWebTableContents() {
	  System.out.println("inside VerifyWebTablePageTitle");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,600)");
	  
	  String expectedSalary = "$86,000";
	  
	  List<WebElement>  AllSalaries =  driver.findElements(WebTablePOM.AllSalaries);
	  for(int i=0 ; i<=AllSalaries.size()-1 ;i++ ) {
		  System.out.println(AllSalaries.get(i).getText());
		  String IndividualSalary = AllSalaries.get(i).getText();
		  if(IndividualSalary.equalsIgnoreCase(expectedSalary)) {
			  i=i+1;
			  String FirstName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText();
			  String LastName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[3]")).getText();
			  String Position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[4]")).getText();
			  String Office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[5]")).getText();
			  String StartDate = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[6]")).getText();
			  String Salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[7]")).getText();
			  System.out.println("FirstName:"+FirstName);
			  System.out.println("LastName:"+LastName);
			  System.out.println("Position:"+Position);
			  System.out.println("Office:"+Office);
			  System.out.println("StartDate:"+StartDate);
			  System.out.println("Salary:"+Salary);
		  }
	  }
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
