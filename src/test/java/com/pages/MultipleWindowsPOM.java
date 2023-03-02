package com.pages;

import org.openqa.selenium.By;

public class MultipleWindowsPOM {
	public static final By NewBrowserWindowButoon = By.name("newbrowserwindow123");
	public static final By MenuOfnewBrowserWindow = By.xpath("//button[@type='button']");
	public static final By AboutMeOption = By.xpath("//a[text()='About Me']/following-sibling::span/i");
	public static final By TechTalk = By.xpath("//a[text()='TechTalk']");
	public static final By NewBrowserTabLink = By.xpath("//a[contains(text(),'Tab Link')]");
	
	
	

}
