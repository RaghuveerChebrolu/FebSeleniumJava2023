package com.DataDriven;

import org.testng.annotations.Test;

import com.pages.DataDrivenPOM;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ValidateDataDriven extends Library {
	HashMap<String, String> HMap = new HashMap<String, String>();
	DataDrivenPOM objDataDrivenPOM;

	@Test(priority = 1)

	public void ValidateDataDtrivenPageTitle() {
		driver.get(objProperties.getProperty("AutomationRegister"));
		Assert.assertEquals(driver.getTitle(), objProperties.getProperty("TitleOfRegisterPage"),
				"Title Of Register page is not validated");
	}

	@Test(priority = 2)
	public void ValidateDataDrivenThroughExcel() throws IOException, InterruptedException {
		System.out.println("inside ValidateDataDrivenThroughExcel");
		objDataDrivenPOM = new DataDrivenPOM(driver);
		File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//AutomationDemoSite.xlsx");
		try {
			FileInputStream ObjFileInput = new FileInputStream(objFile);
			// if the excel file extension is .xlsx then we have to use XSSFWorkbook and
			// XSSFSheet
			// if the excel file extension is .xls then we have to use HSSFWorkbook and
			// HSSFSheet

			// HSSFWorkbook ObjHssfWorkBook = new HSSFWorkbook(ObjFileInput);
			// HSSFSheet ObjHssfSheet = ObjHssfWorkBook.getSheet("TestData");

			XSSFWorkbook objXssfWorkBook = new XSSFWorkbook(ObjFileInput);
			XSSFSheet ObjXssfSheet = objXssfWorkBook.getSheet("TestData");
			int NumberOfRows = ObjXssfSheet.getLastRowNum();
			System.out.println("NumberOfRows:" + NumberOfRows);

			for (int Row = 1; Row <= NumberOfRows; Row++) {
				HMap = ReadExcelFile(Row, ObjXssfSheet);
//			
//			System.out.println("------------------------------------");
//			for(Map.Entry map : HMap.entrySet()){    
//			    System.out.println(map.getKey()+":"+map.getValue());    
//			   }  

				if (HMap.get("RunMode").equalsIgnoreCase("yes")) {

					driver.findElement(DataDrivenPOM.FirstName).clear();
					driver.findElement(DataDrivenPOM.FirstName).sendKeys(HMap.get("FirstName"));
					Thread.sleep(2000);
					driver.findElement(DataDrivenPOM.LastName).clear();
					driver.findElement(DataDrivenPOM.LastName).sendKeys(HMap.get("LastName"));

					driver.findElement(DataDrivenPOM.Adress).clear();
					driver.findElement(DataDrivenPOM.Adress).sendKeys(HMap.get("Address"));

					driver.findElement(DataDrivenPOM.EMail).clear();
					driver.findElement(DataDrivenPOM.EMail).sendKeys(HMap.get("EmailAddress"));

					driver.findElement(DataDrivenPOM.Phone).clear();
					driver.findElement(DataDrivenPOM.Phone).sendKeys(HMap.get("PhoneNumber"));

					if (HMap.get("Gender").equalsIgnoreCase("male")) {
						driver.findElement(DataDrivenPOM.MaleRadio).click();
					} else {
						objDataDrivenPOM.clickFemaleButtoon();
					}

					if (HMap.get("Hobbies").equalsIgnoreCase("cricket")) {
						objDataDrivenPOM.clickHobbiesCricket();
					} else if (HMap.get("Hobbies").equalsIgnoreCase("movies")) {
						objDataDrivenPOM.clickHobbiesMovies();
					} else {
						objDataDrivenPOM.clickHobbiesHockey();
					}

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,200)");

					if (Row > 1) {
						objDataDrivenPOM.clickCloseIconLanguage();
					}

					objDataDrivenPOM.clickLanguageDropDown();
					SelectValueFromDropDown(objDataDrivenPOM.AllLanguages, HMap.get("Languages"));

					objDataDrivenPOM.clickSkillsField();

					objDataDrivenPOM.clickSkillsDropDown();
					SelectValueFromDropDown(objDataDrivenPOM.AllSkills, HMap.get("Skills"));

					objDataDrivenPOM.clickSelectCountryDropDown();
					objDataDrivenPOM.SendSelectCountryFromExcel();

					try {
						Robot objR = new Robot();
						objR.keyPress(KeyEvent.VK_ENTER);
						objR.keyRelease(KeyEvent.VK_ENTER);
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					objDataDrivenPOM.clickDOB_YYDropDown();
					SelectValueFromDropDown(objDataDrivenPOM.AllYears, HMap.get("DOB_YY"));

					objDataDrivenPOM.clickDOB_MMDropDown();
					SelectValueFromDropDown(objDataDrivenPOM.AllMonths, HMap.get("DOB_MM"));

					objDataDrivenPOM.clickDOB_DDropDown();
					SelectValueFromDropDown(objDataDrivenPOM.AllDays, HMap.get("DOB_DD"));

					objDataDrivenPOM.ClearPassowrd();
					objDataDrivenPOM.SendPassowrdFromExcel();

					objDataDrivenPOM.ClearConformpassword();
					objDataDrivenPOM.SendConformPassowrdFromExcel();

					FileOutputStream objFileOutput = new FileOutputStream(objFile);
					WriteToExcelFile(Row, ObjXssfSheet);
					objXssfWorkBook.write(objFileOutput);

				} else {
					Row=Row+1;
					System.out.println("RunMode is not marked as yes for row number:"+Row);
					Row=Row-1;
				}
			}

			objXssfWorkBook.close();
			ObjFileInput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
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
		LaunchBrower();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		try {
			ReadPropertiesFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
