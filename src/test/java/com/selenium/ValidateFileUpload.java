package com.selenium;

import org.testng.annotations.Test;

import com.pages.AlertsPOM;
import com.pages.FileUploadPOM;
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

public class ValidateFileUpload extends Library {

	@Test(priority = -1)
	public void VerifyFileUploadPageTitle() {
		System.out.println("inside VerifyFileUploadPageTitle");
		ExtTest = ExtReports.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.get(objProperties.getProperty("FileUpload"));
		PageLoadTimeOut();
		Assert.assertEquals(driver.getTitle(), objProperties.getProperty("TiTleOfFileupload"),
				"Title Of FileUpload Page is not validated");
	}

	@Test(priority = 2)
	public void ValidateFileUploadIsSuccessfull() throws InterruptedException {
		ExtTest = ExtReports.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		Thread.sleep(5000);
		Actions objActions = new Actions(driver);
		WebElement element = driver.findElement(FileUploadPOM.BrowseButton);
		objActions.click(element).build().perform();
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
