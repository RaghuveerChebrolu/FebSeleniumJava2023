package com.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.GmoOnlineAppPOM;
import com.utility.Library;

public class ValidateGmoOnline2 extends Library{
	

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
		ReadPropertiesFile();
		LaunchBrower();
		driver.get(objProperties.getProperty("GmoOnlineURL"));
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("title:"+title);
		driver.findElement(GmoOnlineAppPOM.EntergmoOnline).click();
		driver.findElement(GmoOnlineAppPOM.QTY_Glasses).clear();
		driver.findElement(GmoOnlineAppPOM.QTY_Glasses).sendKeys("3");
		driver.findElement(GmoOnlineAppPOM.EntergmoOnline).click();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().forward();
		driver.navigate().to("https://www.amazon.in/");
	}



}
