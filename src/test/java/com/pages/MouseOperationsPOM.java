package com.pages;

import org.openqa.selenium.By;

public class MouseOperationsPOM {
	public static final By RightClickTextBox = By.xpath("//span[text()='right click me']");
	public static final By QuitAction = By.xpath("//span[text()='Quit']");
	
	public static final By frame = By.xpath("//iframe");
	public static final By DoubleClickBox = By.xpath("//span[contains(text(),'click the block')]/preceding-sibling::div");

}
