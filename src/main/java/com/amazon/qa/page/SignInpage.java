package com.amazon.qa.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class SignInpage extends TestBase {

	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement passwrdBtn;
	
	public SignInpage() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	public String VerifyTitle() {
		return driver.getTitle();
	}
	
	public Homepage passwordClick(String pass) throws IOException {
		password.sendKeys(pass);
		passwrdBtn.click();
		return new Homepage();
	}
	
	
}
