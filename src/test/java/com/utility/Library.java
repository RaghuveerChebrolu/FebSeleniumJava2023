package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {

	public static WebDriver driver;
	public static Properties objProperties;

	public static ExtentHtmlReporter ExtHtmlReptr;
	public static ExtentReports ExtReports;
	public static ExtentTest ExtTest;
	public static HashMap<String, String> hmap = new HashMap<String, String>();
	public static HashMap<String, String> LinksMap = new HashMap<String, String>();

	/*
	 * ExtentHtmlReporter : responsible for look and feel of the report ,we can
	 * specify the report name , document title , theme of the report
	 * 
	 * ExtentReports : used to create entries in your report , create test cases in
	 * report , who executed the test case, environment name , browser
	 * 
	 * ExtentTest : update pass fail and skips and logs the test cases results
	 */

	public void ReadPropertiesFile() throws IOException {
		System.out.println("UserDir:" + System.getProperty("user.dir"));
		File ObjFile = new File(System.getProperty("user.dir") + "//src//test//resources//Config.Properties");
		FileInputStream ObjFileInput = new FileInputStream(ObjFile);
		objProperties = new Properties();
		objProperties.load(ObjFileInput);
		System.out.println("GMOOnlineUrl:" + objProperties.getProperty("GmoOnlineURL"));
	}

	public static void LaunchBrower() {
		String BorwserFromPropFile = objProperties.getProperty("browser");
		switch (BorwserFromPropFile) {
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();

			File objFile = new File(System.getProperty("user.dir"));
			String downloadFilepath = objFile.toString();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
//			DesiredCapabilities cap = DesiredCapabilities.chrome();
//			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			cap.setCapability(ChromeOptions.CAPABILITY, options);
//			

			driver = new ChromeDriver(options);
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("please choose any one bowser from chrome,ie,firefox,edge");
		}

		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Constants.implicitWaitDuration,
		// TimeUnit.SECONDS);
		// Implicit wait is a global waiting mechanism applicable for all webElements
		// declare under it.
	}

	public void PageLoadTimeOut() {
		driver.manage().timeouts().pageLoadTimeout(Constants.PageLodTimeOutDuration, TimeUnit.SECONDS);
	}

	public static void StartExtentReport() {
		File ObjFile = new File(System.getProperty("user.dir") + "//test-output//ExtentReportV4.html");
		ExtentHtmlReporter objExtentHtmlReporter = new ExtentHtmlReporter(ObjFile);
		objExtentHtmlReporter.config().setDocumentTitle("Automation Report");
		objExtentHtmlReporter.config().setReportName("Automation Results In Extent Report");
		objExtentHtmlReporter.config().setTheme(Theme.DARK);
		ExtReports = new ExtentReports();
		ExtReports.attachReporter(objExtentHtmlReporter);

		ExtReports.setSystemInfo("TesterName", "Raghuveer");
		ExtReports.setSystemInfo("Broswer", objProperties.getProperty("browser"));
		ExtReports.setSystemInfo("Environment", "UAT");

	}

	public void UpdatingResultInExtentReport(ITestResult result) throws IOException {
		// TODO Auto-generated method stub
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtTest.log(Status.PASS, "Test Case Passed is " + result.getName());
			ExtTest.addScreenCaptureFromPath(TakeScreenShot());
//			int statuscode = Integer.valueOf(LinksMap.get("statusCode"));
//			String Link = LinksMap.get("individualLink");
//			if (statuscode>=200 && statuscode<=229){
//				System.out.println("Valid Link :"+Link +" with status code :"+statuscode);
//				ExtTest.log(Status.PASS, "Valid Link :"+Link +" with status code :"+statuscode);
//			}else if (statuscode>=300 && statuscode<=308){
//				System.out.println("Redirection Link :"+Link +" with status code :"+statuscode);
//				ExtTest.log(Status.INFO, "Redirection Link :"+Link +" with status code :"+statuscode);
//			}else if (statuscode>=400 && statuscode<=499){
//				System.out.println("InValid Client Error Link :"+Link +" with status code :"+statuscode);
//				ExtTest.log(Status.FAIL, "InValid Client Error Link :"+Link +" with status code :"+statuscode);
//			}else if (statuscode>=500 && statuscode<=599){
//				System.out.println("InValid Server Error Link :"+Link +" with status code :"+statuscode);
//				ExtTest.log(Status.FAIL, "InValid Server Error Link :"+Link +" with status code :"+statuscode);
//			}
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ExtTest.log(Status.FAIL, "Test Case Failed is " + result.getName());
			ExtTest.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
			try {
				ExtTest.addScreenCaptureFromPath(TakeScreenShot());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtTest.log(Status.SKIP, "Test Case Skipped is " + result.getName());
		}
	}

	public static String TakeScreenShot(String testcaseName) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "//ScreenShots//" + dateName + testcaseName
				+ "captured.jpeg";
		FileUtils.copyFile(src, new File(destination));
		return destination;

	}

	public String TakeScreenShot() throws IOException {
		// TODO Auto-generated method stub
		File ObjFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String DestFile = System.getProperty("user.dir") + "//ScreenShots//"+dateName+"captured.jpg";
		FileUtils.copyFile(ObjFile, new File(DestFile));
		return DestFile;

	}

	public void FlushReport() {
		ExtReports.flush();
	}

	public void SelectValueFromDropDown(List<WebElement> AllValues, String RequiredValue) {
		// TODO Auto-generated method stub
		System.out.println("NumberOfDropDownItems:" + AllValues.size());
		for (int i = 0; i < AllValues.size(); i++) {
			String IndividualDropDownValue = AllValues.get(i).getText();
			if (IndividualDropDownValue.equalsIgnoreCase(RequiredValue)) {
				AllValues.get(i).click();
				break;
			}
		}
	}

	public HashMap<String, String> ReadExcelFile(int row, XSSFSheet objXssfSheet) {
		// TODO Auto-generated method stub
		DataFormatter objDF = new DataFormatter();
		hmap.put("RunMode", objXssfSheet.getRow(row).getCell(0).getStringCellValue());
		hmap.put("TestCaseName", objXssfSheet.getRow(row).getCell(1).getStringCellValue());
		hmap.put("FirstName", objXssfSheet.getRow(row).getCell(2).getStringCellValue());
		hmap.put("LastName", objXssfSheet.getRow(row).getCell(3).getStringCellValue());
		hmap.put("Address", objXssfSheet.getRow(row).getCell(4).getStringCellValue());
		hmap.put("EmailAddress", objXssfSheet.getRow(row).getCell(5).getStringCellValue());

		hmap.put("PhoneNumber", objDF.formatCellValue(objXssfSheet.getRow(row).getCell(6)));

		hmap.put("Gender", objXssfSheet.getRow(row).getCell(7).getStringCellValue());
		hmap.put("Hobbies", objXssfSheet.getRow(row).getCell(8).getStringCellValue());
		hmap.put("Languages", objXssfSheet.getRow(row).getCell(9).getStringCellValue());
		hmap.put("Skills", objXssfSheet.getRow(row).getCell(10).getStringCellValue());
		hmap.put("Country", objXssfSheet.getRow(row).getCell(11).getStringCellValue());
		hmap.put("SelectCountry", objXssfSheet.getRow(row).getCell(12).getStringCellValue());
		hmap.put("DOB_YY", objDF.formatCellValue(objXssfSheet.getRow(row).getCell(13)));
		hmap.put("DOB_MM", objXssfSheet.getRow(row).getCell(14).getStringCellValue());
		hmap.put("DOB_DD", objDF.formatCellValue(objXssfSheet.getRow(row).getCell(15)));
		hmap.put("Password", objXssfSheet.getRow(row).getCell(16).getStringCellValue());
		hmap.put("confirmPassword", objXssfSheet.getRow(row).getCell(17).getStringCellValue());

		return hmap;
	}

	public void WriteToExcelFile(int row, XSSFSheet objXssfSheet) {
		// TODO Auto-generated method stub
		objXssfSheet.getRow(row).createCell(18).setCellValue("Pass");
	}

	public void ValidateLinks(List<WebElement> allLinks, String individualLink, int statusCode) {
		for (int i = 1; i < allLinks.size(); i++) {
			individualLink = allLinks.get(i).getAttribute("href");
			System.out.println("IndividualLink:" + individualLink);
			try {
				URL objUrl = new URL(individualLink);
				HttpURLConnection objHUC = (HttpURLConnection) objUrl.openConnection();
				objHUC.connect();
				statusCode = objHUC.getResponseCode();

				if (individualLink.equalsIgnoreCase("https://demoqa.com/")) {
					LinksMap.put("individualLink", individualLink);
					LinksMap.put("statusCode", String.valueOf(statusCode));
					break;
				} else if (individualLink.equalsIgnoreCase("http://demoqa.com/")) {
					LinksMap.put("individualLink", individualLink);
					LinksMap.put("statusCode", String.valueOf(statusCode));
					break;
				} else if (individualLink.equalsIgnoreCase("http://the-internet.herokuapp.com/status_codes/500")) {
					LinksMap.put("individualLink", individualLink);
					LinksMap.put("statusCode", String.valueOf(statusCode));
					break;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static WebDriver getBrowserCapabilities(String driverParameter) {
		DesiredCapabilities capabilities = null;
		if (driverParameter == null || driverParameter.equalsIgnoreCase("FIREFOX")) {
			capabilities = DesiredCapabilities.firefox();
			FirefoxOptions options = new FirefoxOptions();
			// options.setHeadless(headless);
			capabilities.merge(options);
		} else if (driverParameter.equalsIgnoreCase("IE")) {
			capabilities = DesiredCapabilities.internetExplorer();
			// capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
			// true);
			// capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,
			// true);
			InternetExplorerOptions options = new InternetExplorerOptions();
			capabilities.merge(options);
		} else if (driverParameter.equalsIgnoreCase("CHROME")) {
			capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			// options.setHeadless(headless);
			capabilities.merge(options);
		} else if (driverParameter.equalsIgnoreCase("EDGE")) {
			capabilities = DesiredCapabilities.edge();
			EdgeOptions options = new EdgeOptions();
			capabilities.merge(options);
		}

		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;

	}

	public WebDriver initializeBrowser(String broswerName) {
		DesiredCapabilities dc = new DesiredCapabilities();
		if (broswerName.equals("chrome")) {
			dc.setBrowserName("chrome");
		} else if (broswerName.equals("firefox")) {
			dc.setBrowserName("firefox");
		} else if (broswerName.equals("safari")) {
			dc.setBrowserName("safari");
		} else if (broswerName.equals("Edge")) {
			dc.setBrowserName("Edge");
		} else if (broswerName.equals("ie")) {
			dc.setBrowserName("ie");
		}
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

}
