package com.amazon.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.page.AmazonUser;
import com.amazon.qa.page.Homepage;
import com.amazon.qa.page.Loginpage;
import com.amazon.qa.page.SignInpage;
import com.amazon.qa.page.TodayDealPage;

public class TodaysDealPageTestCase extends TestBase {

	Loginpage loginpage;
	SignInpage signin;
	Homepage homepage;
	AmazonUser amazonUser;
	TodayDealPage todayDeal;
	public TodaysDealPageTestCase() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		Initialize();
		homepage=new Homepage();
		amazonUser=new AmazonUser(); 
		loginpage=new Loginpage();
		Thread.sleep(2000);
		signin=loginpage.Button(prop.getProperty("username"));
		signin.passwordClick(prop.getProperty("password"));
		todayDeal=new TodayDealPage();
		Thread.sleep(5000);
		homepage.clickonTodaysDeal();
		
	}
	
	@Test
	public void VerifyTodayDealTitle() throws InterruptedException {
		Thread.sleep(2000);
		String title=todayDeal.verifyTitle();
		Assert.assertEquals(title,"Amazon.in Today's Deals: Great Savings. Every Day.","Today's Deal page title not match");
		
	}
	@Test
	public void VerifyTodaysDealsPage() {
		boolean f=todayDeal.TodaysDealpage();
		Assert.assertTrue(f);
	}
	
	
	@AfterMethod
	public void drop() {
		driver.close();
		
	}
	
	
	
	
	
	
	
}
