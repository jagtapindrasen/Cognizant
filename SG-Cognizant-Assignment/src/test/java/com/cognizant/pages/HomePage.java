package com.cognizant.pages;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.elements.HomePageElements;
import com.cognizant.elements.LandingPageElements;
import com.cognizant.elements.LoginPageElements;
import com.cognizant.step_defs.AbstractBase;

public class HomePage {
	
	WebDriver driver;
	AbstractBase base;
	Common page;
	HomePageElements homeElements;
	
	public HomePage(AbstractBase base,Common page) {
		this.base = base;
		this.driver = base.getDriver();
		this.page = page;
		homeElements = new HomePageElements(this.driver);
	}		
	
	public void selectDashboardOptions(String optionName, String dashboardName) 
	{
		if(dashboardName.equalsIgnoreCase("My Grants"))
		{
			if(optionName.equalsIgnoreCase("Get new grant"))
			{
				homeElements.lnk_getNewGrant.click();
			}
		}
	}
	
	public void selectBusinessSector(String sectorName)
	{
		if(sectorName.equalsIgnoreCase("IT"))
			homeElements.lnk_businessSector.click();
	}
	
	public void selectDevelopmentArea(String developmentArea)
	{
		if(developmentArea.equalsIgnoreCase("Bring my business overseas"))
			homeElements.lnk_developmentArea.click();		
	}
	
	public void selectFunctionalArea(String functionalAreaName)
	{
		if(functionalAreaName.equalsIgnoreCase("Market Readiness Assistance"))
			page.performAndWait("click",homeElements.lnk_functionalArea,"",2000);
			//homeElements.lnk_functionalArea.click();			
		homeElements.btn_Apply.click();
	}
	
	public void clickProceedToEnterForm(String option)
	{
		if(option.equalsIgnoreCase("Proceed"))
		{
			if(homeElements.lbl_applicationForm.isDisplayed())
			{
				homeElements.btn_Proceed.click();
			}
		}
	}
	
	public void verifyApplicationUnderProcessing(String dahsboardOption,String tabName, String projectTitle)
	{
		int rowCnt=0;
		boolean flag = false;
		if(dahsboardOption.equalsIgnoreCase("My Grants"))
		{
			page.performAndWait("click", homeElements.tab_myGrants, "", 15000);
			
			if(tabName.equalsIgnoreCase("Processing"))
			{
				System.out.println("REF ID from Common page:"+page.refID);
				rowCnt=0;
				flag = false;
				page.performAndWait("click", homeElements.tab_processing, "", 2000);
				
				List<WebElement> listOfRows = homeElements.table_collectionOfRows;				
				List<WebElement> listOfProjectTitles = homeElements.table_collectionOfProjectTitles;
				
				for(WebElement refID:listOfRows)
				{
					if(refID.getText().trim().equalsIgnoreCase(page.refID))
					{
						if(projectTitle.equalsIgnoreCase(listOfProjectTitles.get(rowCnt).getText().trim()))							
							page.performAndWait("click", listOfProjectTitles.get(rowCnt), "", 5000);
						else
							fail("Project title "+projectTitle+" is different for processed application");
						
						flag=true;
						break;
					}
					rowCnt++;
				}
				if(flag==false)
					fail("Ref ID '"+page.refID+"' is not present under Processing tab");
			}
		}
		else if(tabName.equalsIgnoreCase("Drafts"))
		{
			rowCnt=0;
			flag=false;
			page.performAndWait("click", homeElements.tab_drafts, "", 2000);
			
			List<WebElement> listOfRowsInDrafts = homeElements.table_collectionOfRowsInDrafts;				
			List<WebElement> listOfLastEdited = homeElements.table_collectionOfLastEdited;
			
			for(WebElement projTitle:listOfRowsInDrafts)
			{
				if(projTitle.getText().trim().equalsIgnoreCase(projectTitle))
				{
					String today = page.getFormattedDate("dd MMM yyyy", "", 0);
					if(listOfLastEdited.get(rowCnt).getText().trim().contains(today))
					{
						page.performAndWait("click", projTitle, "", 15000);						
						flag=true;
						break;
					}
					else
						fail("There is no unsubmitted application in Drafts tab against today's date "+today);
				}
				rowCnt++;
			}
			if(flag==false)
				fail("Application with project title '"+projectTitle+"' is not present under Drafts tab");
		}
	}
}