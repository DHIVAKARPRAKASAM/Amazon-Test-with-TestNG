package com.amazon.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.page.Loginpage;
import com.amazon.qa.page.SignInpage;

public class SignInTestCase extends TestBase {
	Loginpage loginpage;
	SignInpage signin;
	
	public SignInTestCase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		Initialize();
		loginpage=new Loginpage();
		
		signin=loginpage.Button(prop.getProperty("username"));
		Thread.sleep(5000);
	}
	
	@Test
	public void PassWord() throws InterruptedException {
		Thread.sleep(2000);
		String signintitle=signin.VerifyTitle();
		Assert.assertEquals(signintitle,"Amazon Sign In","Sigin page incoorect");
	}
	@Test
	public void passwordButton() throws InterruptedException, IOException {
		Thread.sleep(2000);
		signin.passwordClick(prop.getProperty("password"));
	}
	
	@AfterMethod
	public void drown() {
		driver.close();
	}

	
	
}
