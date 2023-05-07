package com.selenium;

import org.testng.annotations.Test;

import com.pages.AlertsPOM;
import com.pages.FileDownloadPOM;
import com.pages.FileUploadPOM;
import com.pages.FramesPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
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
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class ValidateFileDownload extends Library {
	
	FileDownloadPOM objFileDownload;

	@Test(priority = -1)
	public void VerifyFileDownloadPageTitle() {
		System.out.println("inside VerifyFileDownloadPageTitle");
		ExtTest = ExtReports.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.get(objProperties.getProperty("FileDownload"));
		PageLoadTimeOut();
		Assert.assertEquals(driver.getTitle(), objProperties.getProperty("titleOfFileDownloadPage"),
				"Title Of File Download Page is not validated");
	}

	@Test(priority = 2)
	public void ValidateFileDownloadIsSuccessfull() throws InterruptedException {
		ExtTest = ExtReports.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		
		objFileDownload = new FileDownloadPOM(driver);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		objFileDownload.click100kbDownlodSampleDoc();
		Thread.sleep(8000);
		File objFile = new File(System.getProperty("user.dir"));
		File[] AllFiles = objFile.listFiles();
		for(File IndividualFile:AllFiles) {
			String FileName = IndividualFile.getName();
			System.out.println("FileName:"+FileName);
			boolean flagFileDownloadSuccessfull = false;
			if(FileName.contains("100kB")) {
				flagFileDownloadSuccessfull =true;
				Assert.assertTrue(flagFileDownloadSuccessfull, "File Donwload is not successfull");
				IndividualFile.deleteOnExit();
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
