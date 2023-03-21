package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadPOM {
	WebDriver driver;
	
	public @FindBy(xpath="//table[@id='table-files']/tbody/tr[1]/td[5]/a")
	WebElement FileDpwnload100Kb;
	
	
	public FileDownloadPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void click100kbDownlodSampleDoc() {
		FileDpwnload100Kb.click();
	}

}
