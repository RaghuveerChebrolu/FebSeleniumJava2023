package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WellsFargoSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("inside main method");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wellsfargo.com/");
		driver.manage().window().maximize();
		
		driver.quit();
		

	}

	
			}


