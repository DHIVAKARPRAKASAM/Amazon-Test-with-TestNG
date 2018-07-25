package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.qa.util.TimeOut;
import com.amazon.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver event;
	public static WebEventListener webevent;
	
	public TestBase() throws IOException {
		
		prop =new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\dhiva\\eclipse-workspace\\TestAutomation\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
		prop.load(ip);
	}
	
	public static void Initialize() throws IOException {
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			 driver=new ChromeDriver();
		}
		event=new EventFiringWebDriver(driver);
		webevent=new WebEventListener();
		event.register(webevent);
		driver=event;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeOut.PageLoadTimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOut.ImplicitWait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
}
