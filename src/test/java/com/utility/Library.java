package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {
	
	public static WebDriver driver;
	public static Properties objProperties;

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
			driver= new ChromeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			break;
		default:
			System.out.println("please choose any one bowser from chrome,ie,firefox,edge");
		}
		}
		

}
