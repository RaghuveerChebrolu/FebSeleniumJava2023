package com.pages;

import org.openqa.selenium.By;

public class FramesPOM {
	public static final By SingleFrame = By.xpath("//iframe[@id='singleframe']");
	public static final String singleFrame= "singleframe";
	public static final By TextBox = By.xpath("//input[@type='text']");
	public static final By IFrameWithInIframe = By.xpath("//a[contains(text(),'with in')]");
	public static final By OuterIframe = By.xpath("//iframe[@src='MultipleFrames.html']");
	public static final By InnerFrame = By.xpath("//iframe[@src='SingleFrame.html']");
	

}
