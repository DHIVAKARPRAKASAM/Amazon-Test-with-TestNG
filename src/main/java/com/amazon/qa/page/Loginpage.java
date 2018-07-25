package com.amazon.qa.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class Loginpage extends TestBase {

	@FindBy(id="ap_email")
	WebElement username;
	
	@FindBy(id="continue")
	WebElement btn;
	@FindBy(name="email")
	WebElement email;

	public Loginpage() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	public String title() {
		return driver.getTitle();
	}
	
	public SignInpage Button(String un) throws IOException {
		username.sendKeys(un);
		btn.click();
		return new SignInpage();
	}
	
	

}
