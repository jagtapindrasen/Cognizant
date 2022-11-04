package com.cognizant.pages;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.elements.HomePageElements;
import com.cognizant.elements.LandingPageElements;
import com.cognizant.elements.LoginPageElements;
import com.cognizant.step_defs.AbstractBase;


public class LoginPage {
	
	WebDriver driver;
	//WebDriverWait wait;
	AbstractBase base;
	LoginPageElements loginElements;
	HomePageElements homeElements;
	
	public LoginPage(AbstractBase base) {
		this.base = base;
		this.driver = base.getDriver();
		//this.wait = base.getWaitDriver();
		loginElements = new LoginPageElements(this.driver);
		homeElements = new HomePageElements(this.driver);
	}
			
	public void loginWithOwnUserDetails(String nric,String name,String uen,String role) {
		//homeElements.txtbx_enterText.sendKeys(inputText);
		loginElements.txtbx_Nric.clear();
		loginElements.txtbx_Nric.sendKeys(nric);
		loginElements.txtbx_Name.clear();
		loginElements.txtbx_Name.sendKeys(name);
		loginElements.txtbx_Uen.clear();
		loginElements.txtbx_Uen.sendKeys(uen);
		loginElements.drpDown_Role.clear();
		loginElements.drpDown_Role.sendKeys("Acceptor");

		loginElements.btn_Login.click();
		driver.manage().timeouts().pageLoadTimeout(Common.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Common.IMPLICIT_WAIT, TimeUnit.SECONDS);
		/*
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if(!homeElements.lbl_MyGrants.isDisplayed())
		{
			fail("CorpPass login failed");
		}
	}
}