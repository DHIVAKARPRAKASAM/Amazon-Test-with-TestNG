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


public class AmazonPayPageTestcase extends TestBase {

	Loginpage loginpage;
	SignInpage signin;
	Homepage homepage;
	AmazonUser amazonUser;
	AmazonPay amazonPay;
	public AmazonPayPageTestcase() throws IOException {
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
		amazonPay=new AmazonPay();
		Thread.sleep(5000);
		homepage.clickonAmazonPay();
		
	}
	
	
	@Test
	public void VerifyAmazonpayTitle() throws InterruptedException {
		Thread.sleep(2000);
		String title=amazonPay.verifyPayTitle();
		Assert.assertEquals(title,"Amazon.in: Amazon Pay","AmazonPay page title not match");
		
	}
	@Test
	public void VerifyAmazonPayPage() {
		boolean f=amazonPay.AmazonPaypage();
		Assert.assertTrue(f);
	}
	
	@AfterMethod
	public void drop() {
		driver.close();
		
	}
	
	
}
