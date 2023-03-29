package com.selenium;

import org.testng.annotations.Test;

import com.pages.AlertsPOM;
import com.pages.FramesPOM;
import com.pages.LinksPOM;
import com.pages.WebTablePOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
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

public class ValidateLinks extends Library {

	String IndividualLink;
	int statusCode;

	@Test(priority = 1)
	public void ValidateWebLinksinDemoQABrokenPage_https_demoqacom() throws IOException, MalformedURLException {
		System.out.println("inside ValidateWebLinksinDemoQABrokenPage");
		driver.get(objProperties.getProperty("BrokenlinksImages"));
		PageLoadTimeOut();
		Assert.assertEquals(driver.getTitle(), objProperties.getProperty("TileOfBrokenlinks"),
				"Title of DEMO QA Page is not validated");
		ExtTest = ExtReports.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		LinksPOM objLinksPOM = new LinksPOM(driver);
		List<WebElement> AllLinks = objLinksPOM.AllLinksInDemoQABrokenPage;

		for (int i = 1; i < AllLinks.size(); i++) {
			IndividualLink = AllLinks.get(i).getAttribute("href");
			System.out.println("IndividualLink:" + IndividualLink);
			try {
				URL objUrl = new URL(IndividualLink);
				HttpURLConnection objHUC = (HttpURLConnection) objUrl.openConnection();
				objHUC.connect();
				statusCode = objHUC.getResponseCode();

				if (IndividualLink.equalsIgnoreCase("https://demoqa.com/")) {
					LinksMap.put("individualLink", IndividualLink);
					LinksMap.put("statusCode", String.valueOf(statusCode));
					break;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
	@Test
	public void ValidateWebLinksinDemoQABrokenPage_http_demoqacom() throws IOException, MalformedURLException {
		System.out.println("inside ValidateWebLinksinDemoQABrokenPage");
		driver.get(objProperties.getProperty("BrokenlinksImages"));
		PageLoadTimeOut();
		Assert.assertEquals(driver.getTitle(), objProperties.getProperty("TileOfBrokenlinks"),
				"Title of DEMO QA Page is not validated");
		ExtTest = ExtReports.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		LinksPOM objLinksPOM = new LinksPOM(driver);
		List<WebElement> AllLinks = objLinksPOM.AllLinksInDemoQABrokenPage;

		for (int i = 1; i < AllLinks.size(); i++) {
			IndividualLink = AllLinks.get(i).getAttribute("href");
			System.out.println("IndividualLink:" + IndividualLink);
			try {
				URL objUrl = new URL(IndividualLink);
				HttpURLConnection objHUC = (HttpURLConnection) objUrl.openConnection();
				objHUC.connect();
				statusCode = objHUC.getResponseCode();

				 if (IndividualLink.equalsIgnoreCase("http://demoqa.com/")) {
					LinksMap.put("individualLink", IndividualLink);
					LinksMap.put("statusCode", String.valueOf(statusCode));
					break;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	@Test
	public void ValidateWebLinksinDemoQABrokenPage_httptheInternet() throws IOException, MalformedURLException {
		System.out.println("inside ValidateWebLinksinDemoQABrokenPage");
		driver.get(objProperties.getProperty("BrokenlinksImages"));
		PageLoadTimeOut();
		Assert.assertEquals(driver.getTitle(), objProperties.getProperty("TileOfBrokenlinks"),
				"Title of DEMO QA Page is not validated");
		ExtTest = ExtReports.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		LinksPOM objLinksPOM = new LinksPOM(driver);
		List<WebElement> AllLinks = objLinksPOM.AllLinksInDemoQABrokenPage;

		for (int i = 1; i < AllLinks.size(); i++) {
			IndividualLink = AllLinks.get(i).getAttribute("href");
			System.out.println("IndividualLink:" + IndividualLink);
			try {
				URL objUrl = new URL(IndividualLink);
				HttpURLConnection objHUC = (HttpURLConnection) objUrl.openConnection();
				objHUC.connect();
				statusCode = objHUC.getResponseCode();

				 if (IndividualLink.equalsIgnoreCase("http://the-internet.herokuapp.com/status_codes/500")) {
					LinksMap.put("individualLink", IndividualLink);
					LinksMap.put("statusCode", String.valueOf(statusCode));
					break;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

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
