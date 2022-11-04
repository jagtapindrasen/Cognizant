package com.cognizant.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {
	WebDriver driver;
	
	public LoginPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "entityId") 
	 public WebElement txtbx_Nric;
	
	@FindBy(how = How.ID, using = "userFullName") 
	 public WebElement txtbx_Name;

	@FindBy(how = How.ID, using = "userId") 
	 public WebElement txtbx_Uen;
	
	@FindBy(how = How.ID, using = "userRole") 
	 public WebElement drpDown_Role;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary sticky-top float-right']") 
	 public WebElement btn_Login;

}
