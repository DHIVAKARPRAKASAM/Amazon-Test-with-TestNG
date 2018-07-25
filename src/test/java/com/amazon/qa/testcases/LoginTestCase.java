package com.amazon.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.page.Loginpage;

public class LoginTestCase extends TestBase {
	Loginpage loginpage;
	
	public LoginTestCase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		Initialize();
		loginpage=new Loginpage();
		Thread.sleep(1000);
	}
	@Test
	public void titleTest() {
	String t=loginpage.title();
	Assert.assertEquals(t,"Amazon Sign In");
	}
	
	@Test
	public void BtnClick() throws IOException {
		loginpage.Button(prop.getProperty("username"));
		
	}
	
	@AfterMethod
	public void down() {
		driver.close();
	}
	
	
}
