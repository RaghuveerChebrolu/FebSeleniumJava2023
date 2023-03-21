package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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
	public static HashMap<String,String> hmap = new HashMap<String,String>();
	
	
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
		System.out.println("UserDir:"+System.getProperty("user.dir"));
		File ObjFile = new File (System.getProperty("user.dir")+"//src//test//resources//Config.Properties");
		FileInputStream ObjFileInput = new FileInputStream(ObjFile);
		objProperties = new Properties();
		objProperties.load(ObjFileInput);
		System.out.println("GMOOnlineUrl:"+objProperties.getProperty("GmoOnlineURL"));
	}
	
	public static void LaunchBrower(){
		String BorwserFromPropFile = objProperties.getProperty("browser");
		switch(BorwserFromPropFile) {
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
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
			
			driver= new ChromeDriver(options);
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			break;
		default:
			System.out.println("please choose any one bowser from chrome,ie,firefox,edge");
		}
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Constants.implicitWaitDuration, TimeUnit.SECONDS);
		//Implicit wait is a global waiting mechanism applicable for all webElements declare under it.
		}
		
	
	public void PageLoadTimeOut() {
		driver.manage().timeouts().pageLoadTimeout(Constants.PageLodTimeOutDuration, TimeUnit.SECONDS);
	}
	
	
	public static void StartExtentReport() {
		File ObjFile = new File (System.getProperty("user.dir")+"//test-output//ExtentReportV4.html");
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

	public void UpdatingResultInExtentReport(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==ITestResult.SUCCESS) {
			ExtTest.log(Status.PASS, "Test Case Passed is "+result.getName());
		}else if(result.getStatus()==ITestResult.FAILURE) {
			ExtTest.log(Status.FAIL, "Test Case Failed is "+result.getName());
			ExtTest.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
			try {
				ExtTest.addScreenCaptureFromPath(TakeScreenShot(result.getName()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(result.getStatus()==ITestResult.SKIP) {
			ExtTest.log(Status.SKIP, "Test Case Skipped is "+result.getName());
		}
	}
	
	public static String TakeScreenShot(String testcaseName) throws IOException {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "//ScreenShots//" + dateName + testcaseName+"captured.jpeg";
		FileUtils.copyFile(src, new File(destination));
		return destination;
		
	}
	
	public void FlushReport() {
		ExtReports.flush();
	}
	
	
	public void SelectValueFromDropDown(List<WebElement> AllValues, String RequiredValue) {
			// TODO Auto-generated method stub
		System.out.println("NumberOfDropDownItems:"+AllValues.size());
			for(int i=0; i<AllValues.size();i++) {
				String IndividualDropDownValue = AllValues.get(i).getText();
				if(IndividualDropDownValue.equalsIgnoreCase(RequiredValue)) {
					AllValues.get(i).click();
					break;
				}
			}
	}
	
	public HashMap<String, String> ReadExcelFile(int row, XSSFSheet objXssfSheet) {
			// TODO Auto-generated method stub
		DataFormatter objDF = new DataFormatter();
		hmap.put("RunMode", objXssfSheet.getRow(row).getCell(0).getStringCellValue());
		hmap.put("TestCaseName",  objXssfSheet.getRow(row).getCell(1).getStringCellValue());
		hmap.put("FirstName",  objXssfSheet.getRow(row).getCell(2).getStringCellValue());
		hmap.put("LastName",  objXssfSheet.getRow(row).getCell(3).getStringCellValue());
		hmap.put("Address",  objXssfSheet.getRow(row).getCell(4).getStringCellValue());
		hmap.put("EmailAddress",  objXssfSheet.getRow(row).getCell(5).getStringCellValue());
		
		hmap.put("PhoneNumber",  objDF.formatCellValue(objXssfSheet.getRow(row).getCell(6)));
		
		hmap.put("Gender",  objXssfSheet.getRow(row).getCell(7).getStringCellValue());
		hmap.put("Hobbies",  objXssfSheet.getRow(row).getCell(8).getStringCellValue());
		hmap.put("Languages",  objXssfSheet.getRow(row).getCell(9).getStringCellValue());
		hmap.put("Skills",  objXssfSheet.getRow(row).getCell(10).getStringCellValue());
		hmap.put("Country",  objXssfSheet.getRow(row).getCell(11).getStringCellValue());
		hmap.put("SelectCountry",  objXssfSheet.getRow(row).getCell(12).getStringCellValue());
		hmap.put("DOB_YY",  objDF.formatCellValue(objXssfSheet.getRow(row).getCell(13)));
		hmap.put("DOB_MM",  objXssfSheet.getRow(row).getCell(14).getStringCellValue());
		hmap.put("DOB_DD",  objDF.formatCellValue(objXssfSheet.getRow(row).getCell(15)));
		hmap.put("Password",  objXssfSheet.getRow(row).getCell(16).getStringCellValue());
		hmap.put("confirmPassword",  objXssfSheet.getRow(row).getCell(17).getStringCellValue());													

		return hmap;
		}
	
	public void WriteToExcelFile(int row, XSSFSheet objXssfSheet) {
		// TODO Auto-generated method stub
		objXssfSheet.getRow(row).createCell(18).setCellValue("Pass");
	}
	
	  
	  
	  public void TakeScreenShot() throws IOException {
		// TODO Auto-generated method stub
		  File ObjFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File DestFile = new File(System.getProperty("user.dir")+"//ScreenShots+");
		  FileUtils.copyFile(ObjFile, DestFile);
		
	}
	
	
}
