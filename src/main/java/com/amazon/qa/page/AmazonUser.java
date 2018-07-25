package com.amazon.qa.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class AmazonUser extends TestBase {

	
	
	@FindBy(xpath="//div[text()='More to Explore']")
	WebElement userVerify;
	

	public AmazonUser() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
		}
	
	
	public boolean AmazonUserpage() {
		return userVerify.isDisplayed();
	}
	
	
	
	
}
