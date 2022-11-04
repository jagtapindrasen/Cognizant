package com.cognizant.elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements {
	WebDriver driver;
	
	public HomePageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='dashboard-container']/div/h2") 
	 public WebElement lbl_MyGrants;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"dashboard-action-text-wrapper\"]/h4[contains(text(),'Get new grant')]") 
	 public WebElement lnk_getNewGrant;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"item\"]/div[contains(text(),'IT')]") 
	 public WebElement lnk_businessSector;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"item\"]/div[contains(text(),'Bring my business overseas or establish a stronger international presence')]") 
	 public WebElement lnk_developmentArea;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"item\"]/div[contains(text(),'Market Readiness Assistance')]") 
	 public WebElement lnk_functionalArea;
	
	@FindBy(how = How.ID, using = "go-to-grant") 
	 public WebElement btn_Apply;
	
	@FindBy(how = How.ID, using = "keyPage-form-button") 
	 public WebElement btn_Proceed;
	
	@FindBy(how = How.XPATH, using = "//h3[@class='actiontitle' and text()='Application Form']") 
	 public WebElement lbl_applicationForm;
	
//	@FindBy(how = How.XPATH, using = "//div[@id=\"helptext\"]/following-sibling::section[@class=\"dashboard-tab-container\"]/ul/descendant::a[contains(text(),\"Processing\")]") 
//	 public WebElement tab_processing;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"grants\"]/div[3]/section[1]/ul/li[3]/a") 
	 public WebElement tab_processing;
	
	@FindBy(how = How.XPATH, using = "//div[@id=\"helptext\"]/following-sibling::section[@class=\"dashboard-tab-container\"]/ul/descendant::a[contains(text(),\"Drafts\")]") 
	 public WebElement tab_drafts;

	@FindBy(how = How.XPATH, using = "//table[@id=\"db-apps-processing\"]/tbody/tr/td[1]") 
	 public List<WebElement> table_collectionOfRows;
	
	@FindBy(how = How.XPATH, using = "//table[@id=\"db-apps-drafts\"]/tbody/tr/td[2]") 
	 public List<WebElement> table_collectionOfRowsInDrafts;
	
	@FindBy(how = How.XPATH, using = "//table[@id=\"db-apps-drafts\"]/tbody/tr/td[3]") 
	 public List<WebElement> table_collectionOfLastEdited;

	@FindBy(how = How.XPATH, using = "//table[@id=\"db-apps-processing\"]/tbody/tr/td[4]") 
	 public List<WebElement> table_collectionOfProjectTitles;

	@FindBy(how = How.ID, using = "sgds-nav-start") 
	 public WebElement tab_myGrants;
	
}
