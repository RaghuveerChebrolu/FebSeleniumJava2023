package com.pages;

import org.openqa.selenium.By;

public class DropDownsPOM {
public static final By TestingDropDown = By.id("testingDropdown");
public static final By CountryDropDown = By.xpath("//label[contains(text(),'State / Province / Region')]/../following-sibling::span[2]/span");
public static final By AllCountries = By.xpath("//ul[@id='select2-vfb-13-country-results']/li");
public static final By HH = By.xpath("//label[contains(text(),'Convenient Time ')]/following-sibling::span[1]/span");
public static final By AllHours = By.xpath("//ul[@id='select2-vfb-16-hour-results']/li");
public static final By MM=By.xpath("//label[contains(text(),'Convenient Time ')]/following-sibling::span[2]/span");
public static final By AllMinutes = By.xpath("//ul[@id='select2-vfb-16-min-results']/li");


}
