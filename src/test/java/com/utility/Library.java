package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Library {
	
	public static WebDriver driver;

	public static void LaunchBrower(){
		driver = new ChromeDriver();;
	}
	

}
