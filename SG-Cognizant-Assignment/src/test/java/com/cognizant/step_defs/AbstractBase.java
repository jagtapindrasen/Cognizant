package com.cognizant.step_defs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AbstractBase {
	WebDriver driver;
	Properties prop;
	String homePageURL, username, password;
	//WebDriverWait wait;
	
	@Before
	public void Setup()
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\cognizant\\config\\config.properties");
			prop.load(fis);
			String browserName = prop.getProperty("browser");
			homePageURL = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			//wait=new WebDriverWait(driver, 30);
			if(browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		} catch(IOException e)
		{
			e.getMessage();
		}
	}
	
	@After
	public void tearDown() {
		driver.quit();
		//System.out.println("Global After Hook Executed");
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	/*public WebDriverWait getWaitDriver()
	{
		return wait;
	}*/
	
	public String getLandingPageURL()
	{
		return homePageURL;
	}
	
	public String getPortalCredentials()
	{
		return username+":"+password;
	}

}
