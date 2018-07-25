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

public class AmazonUserPageTestCase extends TestBase{
	Loginpage loginpage;
	SignInpage signin;
	Homepage homepage;
	AmazonUser amazonUser;
	
	public AmazonUserPageTestCase() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		Initialize();
		homepage=new Homepage();
		amazonUser=new AmazonUser(); 
		loginpage=new Loginpage();
		
		signin=loginpage.Button(prop.getProperty("username"));
		signin.passwordClick(prop.getProperty("password"));
		Thread.sleep(5000);
		homepage.clickonAmazonUser();
		
	}
	
	@Test(priority=1)
	public void VerifyTitleAmazonUser() throws InterruptedException, IOException {
		
		Thread.sleep(3000);
		String b=amazonUser.verifyTitle();
		Assert.assertEquals(b,"Your Amazon.in","Amazon page title is not match");
	}
	@Test(priority=2)
	public void VerifyAmazonuserpage() throws InterruptedException {
		Thread.sleep(3000);
	boolean s=amazonUser.AmazonUserpage();
	Assert.assertTrue(s);
	}
	
	@AfterMethod
	public void down() {
		driver.close();
		
	}
	
	
	

}
