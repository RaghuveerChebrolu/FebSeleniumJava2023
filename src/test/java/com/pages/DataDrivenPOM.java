package com.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Library;

public class DataDrivenPOM extends Library {
	
	WebDriver driver;
	public static final By FirstName = By.xpath("//input[@placeholder='First Name']");
	public static final By LastName = By.xpath("//input[@placeholder='Last Name']");
	public static final By Adress = By.xpath("//textarea[@ng-model='Adress']");
	public static final By Phone = By.xpath("//input[@type='email']");
	public static final By EMail = By.xpath("//input[@type='tel']");
	public static final By MaleRadio = By.xpath("//input[@value='Male']");

	 @FindBy(xpath = "//input[@value='FeMale']") 
	WebElement FemaleRadio;
	
	 @FindBy(id="checkbox1")
	 WebElement HobbiesCricket;
	 
	 @FindBy(id="checkbox2")
	 WebElement HobbiesMovies;
	 
	 @FindBy(id="checkbox3")
	 WebElement HobbiesHockey;
	 
	 @FindBy(id="msdd")
	 WebElement Language;
	 
	 @FindBy(id="Skills")
	 WebElement Skills;
	 
	 @FindBy(id="countries")
	 WebElement Country;
	 
	 @FindBy(id="yearbox")
	 WebElement DOB_YY;
	 
	 public @FindBy(xpath="//select[@id='yearbox']/option")
	 List<WebElement> AllYears;
	 
	 @FindBy(xpath="//select[@ng-model='monthbox']")
	 WebElement DOB_MM;
	 
	 public @FindBy(xpath="//select[@ng-model='monthbox']/option")
	 List<WebElement> AllMonths;
	 
	 @FindBy(xpath="//select[@ng-model='daybox']")
	 WebElement DOB_DD;
	 
	 public @FindBy(xpath="//select[@ng-model='daybox']/option")
	 List<WebElement> AllDays;
	 
	 public @FindBy(xpath="//div[@id='msdd']/following-sibling::div/ul/li/a")
	 List<WebElement> AllLanguages;
	 
	 public @FindBy(xpath="//span[@class='ui-icon ui-icon-close']")
	 WebElement CloseIconLanguage;
	 
	 public @FindBy(xpath="//label[contains(text(),'Skills')]")
	 WebElement SkillsField;
	 
	 public @FindBy(xpath="//select[@id='Skills']/option")
	 List<WebElement> AllSkills;
	 
	 public @FindBy(xpath="//span[@role='combobox']")
	 WebElement SelectCountry;

	 public @FindBy(xpath="//input[@type='search']")
	 WebElement TextBoxOfSelectcountry;
	 

	 public @FindBy(id="firstpassword")
	 WebElement Password;
	 

	 public @FindBy(id="secondpassword")
	 WebElement Conformpassword;
	 
	 
	public DataDrivenPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void clickFemaleButtoon() {
		FemaleRadio.click();
	}
	
	public void clickHobbiesCricket() {
		HobbiesCricket.click();
	}
	
	public void clickHobbiesMovies() {
		HobbiesMovies.click();
	}
	
	public void clickHobbiesHockey() {
		HobbiesHockey.click();
	}
	
	public void clickLanguageDropDown() {
		Language.click();
	}
	
	public void clickCloseIconLanguage() {
		CloseIconLanguage.click();
	}
	
	public void clickSkillsField() {
		SkillsField.click();
	}
	
	public void clickSkillsDropDown() {
		Skills.click();
	}
	
	public void clickCountryDropDown() {
		Country.click();
	}
	
	
	public void clickSelectCountryDropDown() {
		SelectCountry.click();
	}
	

	public void SendSelectCountryFromExcel() {
		TextBoxOfSelectcountry.sendKeys(Library.hmap.get("SelectCountry"));
	}
	
	public void clickDOB_MMDropDown() {
		DOB_MM.click();
	}
	
	public void clickDOB_YYDropDown() {
		DOB_YY.click();
	}
	
	public void clickDOB_DDropDown() {
		DOB_DD.click();
	}
	
	public void SendPassowrdFromExcel() {
		Password.sendKeys(Library.hmap.get("Password"));
	}
	
	public void ClearPassowrd() {
		Password.clear();;
	}
	
	public void ClearConformpassword() {
		Conformpassword.clear();
	}
	
	public void SendConformPassowrdFromExcel() {
		Conformpassword.sendKeys(Library.hmap.get("confirmPassword"));
	}
}
