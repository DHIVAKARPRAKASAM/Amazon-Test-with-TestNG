package com.amazon.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.page.AmazonPay;
import com.amazon.qa.page.AmazonUser;
import com.amazon.qa.page.Homepage;
import com.amazon.qa.page.Loginpage;
import com.amazon.qa.page.SignInpage;
import com.amazon.qa.page.TodayDealPage;

public class HomePageTsetCase extends TestBase {

	Loginpage loginpage;
	SignInpage signin;
	Homepage homepage;
	AmazonUser amazonUser;
	TodayDealPage todayDeal;
	AmazonPay amazonPay;
	public HomePageTsetCase() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		Initialize();
		loginpage=new Loginpage();
	
		signin=loginpage.Button(prop.getProperty("username"));
		homepage=signin.passwordClick(prop.getProperty("password"));
		Thread.sleep(5000);
		}
	
	@Test(priority=1)
	public void verifyHomeTitle() {
		String homeTitle=driver.getTitle();
		Assert.assertEquals(homeTitle,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Home title not match");
	}
	
	@Test(priority=2)
	public void verifyAmazonUser() throws IOException {
	amazonUser=homepage.clickonAmazonUser();
		
	}
	
	@Test(priority=3)
	public void verifyTodaysDeal() throws IOException {
		todayDeal=homepage.clickonTodaysDeal();
		
	}
	
	@Test(priority=4)
	public void verifyAmazonPay() throws IOException {
		amazonPay=homepage.clickonAmazonPay();
		
	}
	
	@AfterMethod
	public void down() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}
	
	
	

}
