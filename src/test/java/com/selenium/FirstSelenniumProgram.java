package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSelenniumProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("inside main method");
		WebDriverManager.iedriver().setup();
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("rich dad poor bad");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.id("twotabsearchtextbox")).clear();
	}

}
