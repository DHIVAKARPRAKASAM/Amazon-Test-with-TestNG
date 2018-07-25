package com.amazon.qa.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class AmazonPay extends TestBase{

	
	@FindBy(xpath="//span[contains(text(),'Amazon Pay balance')]")
	WebElement payBalance;
	
	public AmazonPay() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyPayTitle() {
		return driver.getTitle();
		}
	
	
	public boolean AmazonPaypage() {
		return payBalance.isDisplayed();
	}
	
	
}
