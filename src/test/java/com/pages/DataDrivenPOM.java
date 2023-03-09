package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataDrivenPOM {
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
	 
	 public @FindBy(xpath="//div[@id='msdd']/following-sibling::div/ul/li/a")
	 List<WebElement> AllLanguages;
	 
	 public @FindBy(xpath="//span[@class='ui-icon ui-icon-close']")
	 WebElement CloseIconLanguage;
	 
	

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

}
