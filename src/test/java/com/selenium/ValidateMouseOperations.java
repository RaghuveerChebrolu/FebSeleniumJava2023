package com.selenium;

import org.testng.annotations.Test;

import com.pages.AlertsPOM;
import com.pages.FramesPOM;
import com.pages.MouseOperationsPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateMouseOperations extends Library {
  @Test(priority= -1)
  public void VerifyJqueryTitle() {
	  System.out.println("inside VerifyJqueryTitle");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.get(objProperties.getProperty("mouseOpeartionRightClick"));
	  PageLoadTimeOut();
	  Assert.assertEquals(driver.getTitle(), objProperties.getProperty("JQeryTitle"), "TitleOf JQuery Page is not validated");
  }
  
  @Test(priority=1)
  public void ValidatePerformingRightCickAction(){
	  System.out.println("inside ValidatePerformingRightCickAction");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  Actions objActions = new Actions(driver);
	  WebElement element = driver.findElement(MouseOperationsPOM.RightClickTextBox);
	  objActions.contextClick(element).build().perform();
	  String TextOfRightCLick = element.getText();
	  Assert.assertEquals(TextOfRightCLick, objProperties.getProperty("RightCLickText"), "Right Click Text is not validated");
  }

  
  @Test(priority=2)
  public void ValidateQuitAction() throws InterruptedException{
	  System.out.println("inside ValidateQuitAction");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  Actions objActions = new Actions(driver);
	  WebElement element = driver.findElement(MouseOperationsPOM.QuitAction);
	  Thread.sleep(3000);
	  objActions.click(element).build().perform();
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(3000);
	  String AlertTextQuitAction = objAlert.getText();
	  Assert.assertEquals(AlertTextQuitAction, objProperties.getProperty("mouseOpeartionRightclickQuitActionText"), "mouseOpeartionRightclickQuitActionText is not validated");
	  objAlert.accept();
  
  }
  
  @Test(priority=3)
  public void ValidateDoubleClickUsingActionClass() throws InterruptedException {
	  System.out.println("inside ValidateDoubleClickUsingActionClass");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.navigate().to(objProperties.getProperty("mouseOpeartionDoubleClick"));
//	  Actions action = new Actions(driver); 
//	  action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform(); //opening the URL saved. 
//	  driver.get(objProperties.getProperty("mouseOpeartionDoubleClick"));
	  
//	  String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
//      // open the link in new tab, Keys.Chord string passed to sendKeys
//      driver.findElement(By.xpath("//a[contains(text(),'Introduction')]")).sendKeys(clicklnk);
//     
	  
	  PageLoadTimeOut();
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,1450)");//this will scroll in downward direction by 450 pixels
//	  js.executeScript("window.scrollBy(0,-350)");//this will scroll in upward direction by 350 pixels
//	  js.executeScript("window.scrollBy(450,0");//this will scroll in right side direction by 450 pixels
//	  js.executeScript("window.scrollBy(-450,0)");//this will scroll in left side direction by 450 pixels
	  Thread.sleep(3000);
	  WebElement element = driver.findElement(MouseOperationsPOM.frame);
	  js.executeScript("arguments[0].scrollIntoView(true);", element);
	  driver.switchTo().frame(element);
	  Actions objActions = new Actions(driver);
	  Thread.sleep(3000);
	  WebElement DoubleClickElement = driver.findElement(MouseOperationsPOM.DoubleClickBox);
	  objActions.doubleClick(DoubleClickElement).build().perform();
  }
  
  
  @Test(priority=4)
  public void ValidateDragAndDropOperation() {
	  System.out.println("inside ValidateDragAndDropOperation");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.get(objProperties.getProperty("mouseOperationDragAndDrop"));
	  WebElement frameElement = driver.findElement(MouseOperationsPOM.frame);
	  driver.switchTo().frame(frameElement);
	  Actions objActions = new Actions(driver);
	  WebElement Source = driver.findElement(MouseOperationsPOM.Source);
	  WebElement Target = driver.findElement(MouseOperationsPOM.Target);
	//  objActions.clickAndHold(Source);
	//  objActions.moveToElement(Target).build().perform();
	  objActions.dragAndDrop(Source, Target).build().perform();
	  driver.switchTo().defaultContent();
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
