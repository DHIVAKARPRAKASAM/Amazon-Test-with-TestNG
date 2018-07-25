package com.amazon.qa.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class TodayDealPage extends TestBase {

	@FindBy(xpath="//div[@class='gbh1-bold']")
	WebElement todayDeal;
	
	public TodayDealPage() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
		}
	
	
	public boolean TodaysDealpage() {
		return todayDeal.isDisplayed();
	}
	
	
	
}
