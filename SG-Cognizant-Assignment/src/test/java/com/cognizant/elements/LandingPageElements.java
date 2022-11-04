package com.cognizant.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPageElements {
	WebDriver driver;
	
	public LandingPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'loginCorpPass')]") 
	 public WebElement btn_loginCorpPass;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"col-md-6\"]//following::label") 
	 public WebElement lbl_Date;

	@FindBy(how = How.XPATH, using = "//div[@class=\"col-md-6\"]/h3") 
	 public WebElement lbl_Results;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"jumbotron text-center\"]//following::p") 
	 public WebElement lbl_Message;
	
	@FindBy(how = How.XPATH, using = "//div[@class='container']/h1[1]") 
	 public WebElement lbl_Title;
	
	@FindBy(how = How.NAME, using = "date") 
	 public WebElement txtbx_enterText;

	@FindBy(how = How.XPATH, using = "//input[@class='btn btn-default']") 
	 public WebElement btn_Submit;
		
	@FindBy(how = How.XPATH, using = "//div[@class='col-md-6']/div[1]") 
	 public WebElement lbl_ResultText;

}
