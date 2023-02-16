package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateGmoOnline {
	

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("title:"+title);
		
		driver.findElement(By.name("bSubmit")).click();
		driver.findElement(By.name("QTY_GLASSES")).clear();
		driver.findElement(By.name("QTY_GLASSES")).sendKeys("3");
		driver.findElement(By.name("bSubmit")).click();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().forward();
		driver.navigate().to("https://www.amazon.in/");
	}

}
