package com.amazon.qa.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class Homepage extends TestBase{


	@FindBy(id="nav-your-amazon-text")
	WebElement AmazonUserLink;
	
	@FindBy(xpath="//a[contains(text(),\"Today's Deals\")]")
	WebElement TodaysDealLink;
	
	@FindBy(xpath="//a[text()='Amazon Pay']")
	WebElement AmazonPayLink;
	
	@FindBy(xpath="//a[text()='Sell']")
	WebElement SellLink;
	
	@FindBy(xpath="//a[text()='Customer Service']")
	WebElement CustomerServiceLink;

	public Homepage() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
		}
	
	public AmazonUser clickonAmazonUser() throws IOException {
		AmazonUserLink.click();
		return new AmazonUser();
		}
	
	public TodayDealPage clickonTodaysDeal() throws IOException {
		TodaysDealLink.click();
		return new TodayDealPage();
		}
	
	public AmazonPay clickonAmazonPay() throws IOException {
		AmazonPayLink.click();
		return new AmazonPay();
		}
	
	public Sell clickonSell() {
		SellLink.click();
		return new Sell();
	}
	
	public CustomerService clickonCustomerService() {
		CustomerServiceLink.click();
		return new CustomerService();
	}
	
}
