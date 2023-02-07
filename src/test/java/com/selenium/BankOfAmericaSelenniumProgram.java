package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BankOfAmericaSelenniumProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("inside main method");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.bankofamerica.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='User ID']")).sendKeys("987654321");
		
	}

}
