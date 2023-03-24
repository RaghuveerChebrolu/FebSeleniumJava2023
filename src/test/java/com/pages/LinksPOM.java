package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPOM {
	WebDriver driver;
	
	public @FindBy(tagName = "a")
	List<WebElement> AllLinksInDemoQABrokenPage;
	
	
	public LinksPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	

}
