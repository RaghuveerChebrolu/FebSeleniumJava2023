package com.selenium;

import org.testng.annotations.Test;

import com.pages.AlertsPOM;
import com.pages.FramesPOM;
import com.pages.MultipleWindowsPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
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

public class ValidateMultipleWindows extends Library {
  @Test(priority= -1)
  public void VerifyMultipleWindowTitle() {
	  System.out.println("inside VerifyMultipleWindowTitle");
	  ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.get(objProperties.getProperty("nxtgenaiacademyURL"));
	  PageLoadTimeOut();
	  Assert.assertEquals(driver.getTitle(), objProperties.getProperty("nxtgenaiacademyTitle"), "TitleOfMultipleWindow is not validated");
  }
  
  
  @Test(priority=1)
  public void ValidateMultipleWindows() throws InterruptedException {
		System.out.println("inside ValidateMultipleWindows");
		ExtTest = ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		String ParentWindow =driver.getWindowHandle();
		System.out.println("parent Window HashCode:"+ParentWindow.hashCode());
		WebElement elment = driver.findElement(MultipleWindowsPOM.NewBrowserWindowButoon);
		elment.click();
//		Actions objActions = new Actions(driver);
//		objActions.click(elment).build().perform();
		Set<String> AllWindows = driver.getWindowHandles();
		for(String SingleWindow :AllWindows) {
			driver.switchTo().window(SingleWindow);
			String title = driver.getTitle();
			System.out.println("title:"+title);
			if(title.equalsIgnoreCase(objProperties.getProperty("newBrowserWindowTitle"))) {
				driver.findElement(MultipleWindowsPOM.MenuOfnewBrowserWindow).click();
				Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,300)");
				driver.findElement(MultipleWindowsPOM.AboutMeOption).click();
				Thread.sleep(3000);
				boolean Flag =driver.findElement(MultipleWindowsPOM.TechTalk).isDisplayed();
				System.out.println("Flag:"+Flag);
				Assert.assertTrue(Flag);
				driver.close();//will close the window where the driver control is currently available
				//driver.quit();//will close the all the windows 
			}
		}
		driver.switchTo().window(ParentWindow);
		driver.findElement(MultipleWindowsPOM.NewBrowserTabLink).click();
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
