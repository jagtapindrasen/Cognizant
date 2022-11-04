package com.cognizant.pages;

import static org.junit.Assert.fail;  

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.elements.ApplicationFormElements;
import com.cognizant.elements.HomePageElements;
import com.cognizant.elements.LandingPageElements;
import com.cognizant.elements.LoginPageElements;
import com.cognizant.step_defs.AbstractBase;

import cucumber.api.java.it.Date;

public class ApplicationFormPage {
	
	WebDriver driver;
	AbstractBase base;
	Common page;
	ApplicationFormElements appFormElements;
	
	public ApplicationFormPage(AbstractBase base,Common page) {
		this.base = base;
		this.driver = base.getDriver();
		this.page = page;
		appFormElements = new ApplicationFormElements(this.driver);
	}		
	
	public void verifyApplicationFormSections(String eligibilitySec, String contactDetails, String proposal, String businessImpact, String cost, String declareAndReview)
	{
		if(!appFormElements.lnk_eligibility.getText().equalsIgnoreCase(eligibilitySec))
			fail("Eligibility section not present in an application form");

		if(!appFormElements.lnk_contactDetails.getText().equalsIgnoreCase(contactDetails))
			fail("Contact details section not present in an application form");

		if(!appFormElements.lnk_proposal.getText().equalsIgnoreCase(proposal))
			fail("Proposal section not present in an application form");

		if(!appFormElements.lnk_businessImpact.getText().equalsIgnoreCase(businessImpact))
			fail("Business impact section not present in an application form");

		if(!appFormElements.lnk_cost.getText().equalsIgnoreCase(cost))
			fail("Cost section not present in an application form");
		
		if(!appFormElements.lnk_declareAndReview.getText().equalsIgnoreCase(declareAndReview))
			fail("Declare & review section not present in an application form");
	}
	
	public void verifyQuestionsFromContactDetails(String sectionName, String ques1, String ques2, String ques3, String ques4)
	{
		if(appFormElements.lnk_eligibility.getText().equalsIgnoreCase(sectionName))
		{
			//String actualQ = appFormElements.lbl_questionOne.getText().replace("*","").trim(); 
			if(!appFormElements.lbl_questionOne.getText().replace("*","").trim().equalsIgnoreCase(ques1))
			{
				fail("Question : 'Is the applicant registered in Singapore?' is not present in Eligibility section");
			}
			if(!appFormElements.lbl_questionTwo.getText().replace("*","").trim().equalsIgnoreCase(ques2))
			{
				fail("Question : 'Is the applicant's group sales turnover less than or equal to S$100m or is the applicant's group employment size less than or equal to 200?'  is not present in Eligibility section");
			}
			if(!appFormElements.lbl_questionThree.getText().replace("*","").trim().equalsIgnoreCase(ques3))
			{
				fail("Question : 'Does the applicant have at least 30%  local equity?'  is not present in Eligibility section");
			}
			if(!appFormElements.lbl_questionFour.getText().replace("*","").trim().contains(ques4))
			{
				fail("Question : 'Are all the following statements true for this project?'  is not present in Eligibility section");
			}
		}
	}
	
	public void verifyQuestionStatements(String questionFour, String statement1, String statement2, String statement3) 
	{
		if(!appFormElements.lbl_questionFour.getText().replace("*","").trim().contains(questionFour))
		{
			if(!appFormElements.lbl_questionFour.getText().replace("*","").trim().contains(statement1))
			{
				fail("Statement : 'The applicant has not started work on this project'  is not present in Eligibility section");
			}
			if(!appFormElements.lbl_questionFour.getText().replace("*","").trim().contains(statement2))
			{
				fail("Statement : 'The applicant has not made any payment to any supplier, vendor, or third party prior to applying for this grant'  is not present in Eligibility section");
			}
			if(!appFormElements.lbl_questionFour.getText().replace("*","").trim().contains(statement3))
			{
				fail("Statement : 'The applicant has not signed any contractual agreement with any supplier, vendor, or third party prior to applying for this grant'  is not present in Eligibility section");
			}
		}			
	}
	
	public void verifyQuestionAnswers(String secName)
	{
		if(!appFormElements.lnk_eligibility.getText().equalsIgnoreCase(secName))
		{
			boolean flag=true;
			// Checking radio buttons for question-1
			if(!appFormElements.radioBtnTrue_questionOne.isDisplayed())
			{
				if(!appFormElements.radioBtnTrue_questionOneAnswer.getText().trim().equalsIgnoreCase("Yes"))
					flag=false;
			}
			if(!appFormElements.radioBtnFalse_questionOne.isDisplayed())
			{
				if(!appFormElements.radioBtnFalse_questionOneAnswer.getText().trim().equalsIgnoreCase("No"))
					flag=false;
			}
			if(!flag)
			{
				fail("Question : 'Is the applicant registered in Singapore?' is not answered through Yes or No radio button");
				flag=true;  // resetting to true so that same flag can be reuse for other questions
			}
			
			// Checking radio buttons for question-2
			if(!appFormElements.radioBtnTrue_questionTwo.isDisplayed())
			{
				if(!appFormElements.radioBtnTrue_questionTwoAnswer.getText().trim().equalsIgnoreCase("Yes"))
					flag=false;
			}
			if(!appFormElements.radioBtnFalse_questionTwo.isDisplayed())
			{
				if(!appFormElements.radioBtnFalse_questionTwoAnswer.getText().trim().equalsIgnoreCase("No"))
					flag=false;
			}
			if(!flag)
			{
				fail("Question : 'Is the applicant's group sales turnover less than or equal to S$100m or is the applicant's group employment size less than or equal to 200?' is not answered through Yes or No radio button");
				flag=true;  // resetting to true so that same flag can be reuse for other questions
			}

			// Checking radio buttons for question-3
			if(!appFormElements.radioBtnTrue_questionThree.isDisplayed())
			{
				if(!appFormElements.radioBtnTrue_questionThreeAnswer.getText().trim().equalsIgnoreCase("Yes"))
					flag=false;
			}
			if(!appFormElements.radioBtnFalse_questionThree.isDisplayed())
			{
				if(!appFormElements.radioBtnFalse_questionThreeAnswer.getText().trim().equalsIgnoreCase("No"))
					flag=false;
			}
			if(!flag)
			{
				fail("Question : 'Does the applicant have at least 30%  local equity?' is not answered through Yes or No radio button");
				flag=true;  // resetting to true so that same flag can be reuse for other questions
			}

			// Checking radio buttons for question-4
			if(!appFormElements.radioBtnTrue_questionFour.isDisplayed())
			{
				if(!appFormElements.radioBtnTrue_questionFourAnswer.getText().trim().equalsIgnoreCase("Yes"))
					flag=false;
			}
			if(!appFormElements.radioBtnFalse_questionFour.isDisplayed())
			{
				if(!appFormElements.radioBtnFalse_questionFourAnswer.getText().trim().equalsIgnoreCase("No"))
					flag=false;
			}
			if(!flag)
			{
				fail("Question : 'Are all the following statements true for this project?' is not answered through Yes or No radio button");
			}

		}
	}
	
	public void verifyLinkInWarningMsg(String url)
	{		
		Actions actions = new Actions(driver);
		actions.moveToElement(appFormElements.radioBtnFalse_questionOne).click().build().perform();
		
		if(appFormElements.radioBtnFalse_questionOne.isSelected())
		{
			if(appFormElements.lbl_questionOneWarning.isDisplayed())
			{
				appFormElements.lnk_questionOneWarningMsgLink.click();
				ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs.get(1));
			    if(!page.getCurrentPageUrl().equalsIgnoreCase(url))
			    {
			    		fail("URL launched through a warning message do not match with expected one");
			    }
			    driver.close();
			    driver.switchTo().window(tabs.get(0));
			    appFormElements.radioBtnTrue_questionOne.click();
			    try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void saveInputAndReloadPage(String btnToClick,String sectionName)
	{
		if(btnToClick.equalsIgnoreCase("Save"))
		{
			if(sectionName.equalsIgnoreCase("Eligibility"))
			{
				if(!appFormElements.btn_Save.isDisplayed())
					fail("Save button is not present in '"+sectionName+"' section");
				else
				{
					appFormElements.radioBtnTrue_questionFive.click();
					
					page.performAndWait("click", appFormElements.btn_Save, "", 5000);
					/*appFormElements.btn_Save.click();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					driver.navigate().refresh();
//					if((!appFormElements.radioBtnTrue_questionOne.isSelected()) || (!appFormElements.radioBtnTrue_questionTwo.isSelected()) || (!appFormElements.radioBtnTrue_questionThree.isSelected()) || (!appFormElements.radioBtnTrue_questionFour.isSelected()))
//						fail("Values not saved properly in "+sectionName+" section!");
				}
			}
			else if(sectionName.equalsIgnoreCase("Contact Details"))
			{
				if(!appFormElements.btn_Save.isDisplayed())
					fail("Save button is not present in '"+sectionName+"' section");
				else
				{
					page.performAndWait("click", appFormElements.btn_Save, "", 5000);
					driver.navigate().refresh();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if((appFormElements.txtbx_Name.getAttribute("value").trim().isEmpty()) || (appFormElements.txtbx_jobTitle.getAttribute("value").trim().isEmpty()) || (appFormElements.txtbx_contactNumber.getAttribute("value").trim().isEmpty()) || (appFormElements.txtbx_email.getAttribute("value").trim().isEmpty()) || (appFormElements.txtbx_secondaryEmail.getAttribute("value").trim().isEmpty()) || (!appFormElements.chkbx_mailingAddress.isSelected()) || (appFormElements.txtbx_mailingAddressPostalCode.getAttribute("value").trim().isEmpty()) || (appFormElements.txtbx_mailingAddressBlock.getAttribute("value").trim().isEmpty()) || (appFormElements.txtbx_mailingAddressStreet.getAttribute("value").trim().isEmpty()) || (appFormElements.txtbx_mailingAddressLevel.getAttribute("value").trim().isEmpty()) || (appFormElements.txtbx_mailingAddressUnit.getAttribute("value").trim().isEmpty()) || (!appFormElements.chkbx_letterofOffer.isSelected()) || (appFormElements.txtbx_letterofOfferName.getAttribute("value").trim().isEmpty()) || (appFormElements.txtbx_letterOfOfferJobTitle.getAttribute("value").trim().isEmpty()) || (appFormElements.txtbx_letterOfOfferEmail.getAttribute("value").trim().isEmpty()))  
					{
						System.out.println(appFormElements.txtbx_Name.getAttribute("value"));
						fail("Values not saved properly in "+sectionName+" section!");
					}
				}
			}
		}
	}

	public void verifyWarningMsg(String warningMsg)
	{
		//checking warning message for question-1
		
		appFormElements.radioBtnFalse_questionOne.click();
		
		if(appFormElements.radioBtnFalse_questionOne.isSelected())
		{
//			if(appFormElements.lbl_questionOneWarning.isDisplayed())
//			{
//				if(!appFormElements.lbl_questionOneWarning.getText().trim().equalsIgnoreCase(warningMsg))
//				{
//					System.out.println("Actual Warning:"+appFormElements.lbl_questionOneWarning.getText().trim());
//					fail("Warning message has been changed for question : 'Is the applicant registered in Singapore?'");
//				}
//			}
//			else
//				fail("Warning message not displayed for question : 'Is the applicant registered in Singapore?'");
//			appFormElements.radioBtnTrue_questionOne.click();
		}
		
		//checking warning message for question-2
		
		appFormElements.radioBtnTrue_questionTwo.click();
		
		if(appFormElements.radioBtnFalse_questionTwo.isSelected())
		{
//			if(appFormElements.lbl_questionTwoWarning.isDisplayed())
//			{
//				if(!appFormElements.lbl_questionTwoWarning.getText().trim().equalsIgnoreCase(warningMsg))
//				{
//					fail("Warning message has been changed for question : 'Is the applicant's group sales turnover less than or equal to S$100m or is the applicant's group employment size less than or equal to 200?'");
//				}
//			}
//			else
//				fail("Warning message not displayed for question : 'Is the applicant's group sales turnover less than or equal to S$100m or is the applicant's group employment size less than or equal to 200?'");
//			appFormElements.radioBtnTrue_questionTwo.click();
		}

		//checking warning message for question-3
		
		appFormElements.radioBtnFalse_questionThree.click();
		
		if(appFormElements.radioBtnFalse_questionThree.isSelected())
		{
//			if(appFormElements.lbl_questionThreeWarning.isDisplayed())
//			{
//				if(!appFormElements.lbl_questionThreeWarning.getText().trim().equalsIgnoreCase(warningMsg))
//				{
//					fail("Warning message has been changed for question : 'Does the applicant have at least 30%  local equity?'");
//				}
//			}
//			else
//				fail("Warning message not displayed for question : 'Does the applicant have at least 30%  local equity?'");
//			appFormElements.radioBtnTrue_questionThree.click();
		}
		
		//checking warning message for question-4
		
		//appFormElements.radioBtnTrue_questionFour.click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("react-eligibility-started_project_check-true"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		WebElement scanEle =new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("react-eligibility-started_project_check-true")));
		Actions action =new Actions(driver);
		action.moveToElement(scanEle).click().build().perform();

		
		//if(appFormElements.radioBtnFalse_questionFour.isSelected())
		//{
//			if(appFormElements.lbl_questionFourWarning.isDisplayed())
//			{
//				if(!appFormElements.lbl_questionFourWarning.getText().trim().equalsIgnoreCase(warningMsg))
//				{
//					fail("Warning message has been changed for question : 'Are all the following statements true for this project?'");
//				}
//			}
//			else
//				fail("Warning message not displayed for question : 'Are all the following statements true for this project?'");
//			appFormElements.radioBtnTrue_questionFour.click();
		//}
	}
	
	public void verifyInputsInContactDetails(String subSection,String section,String name,String jobTitle, String contactNo, String email, String alternateContactPersonEmail, String mailingAddress)
	{
		if(section.equalsIgnoreCase("Contact Details"))
		{
			
			if(subSection.equalsIgnoreCase("Main Contact Person"))
			{
				appFormElements.lnk_contactDetailsTab.click();
				if(!appFormElements.txtbx_Name.isDisplayed())
				{
					fail("Input 'Name' is not present in Contact Details section");
				}
				if(!appFormElements.txtbx_jobTitle.isDisplayed())
				{
					fail("Input 'Job Title' is not present in Contact Details section");
				}
				if(!appFormElements.txtbx_contactNumber.isDisplayed())
				{
					fail("Input 'Contact Number' is not present in Contact Details section");
				}
				if(!appFormElements.txtbx_email.isDisplayed())
				{
					fail("Input 'Email' is not present in Contact Details section");
				}
				if(!appFormElements.txtbx_secondaryEmail.isDisplayed())
				{
					fail("Input 'Secondary Email' is not present in Contact Details section");
				}
				if(!appFormElements.chkbx_mailingAddress.isDisplayed())
				{
					fail("Input 'Mailing Address' is not present in Contact Details section");
				}
				if(!appFormElements.txtbx_mailingAddressPostalCode.isDisplayed()) 
				{
					fail("Input 'Mailing Address Postal Code' is not present in Contact Details section");
				}
				if(!appFormElements.txtbx_mailingAddressBlock.isDisplayed())
				{
					fail("Input 'Mailing Address Block' is not present in Contact Details section");
				}
				if(!appFormElements.txtbx_mailingAddressStreet.isDisplayed())
				{
					fail("Input 'Mailing Address Street' is not present in Contact Details section");
				}
				if(!appFormElements.txtbx_mailingAddressLevel.isDisplayed())
				{
					fail("Input 'Mailing Address Level' is not present in Contact Details section");
				}
				if(!appFormElements.txtbx_mailingAddressUnit.isDisplayed())
				{
					fail("Input 'Mailing Address Unit' is not present in Contact Details section");
				}
				if(!appFormElements.txtbx_mailingAddressBuildingName.isDisplayed())
				{
					fail("Input 'Mailing Address Building Name' is not present in Contact Details section");
				}
			}
			else if(subSection.equalsIgnoreCase("Letter Of Offer Addressee"))
			{
				//page.performAndWait("click", appFormElements.txtbx_Name,name, 1000);

				//appFormElements.lnk_contactDetailsTab.click();
				
				if(!appFormElements.txtbx_letterofOfferName.isDisplayed())
				{
					fail("'Name' is not present in subsection 'Letter Of Offer Addressee' of Contact Details section");
				}
				if(!appFormElements.txtbx_letterOfOfferJobTitle.isDisplayed())
				{
					fail("'Job Title' is not present in subsection 'Letter Of Offer Addressee' of Contact Details section");
				}
				if(!appFormElements.txtbx_letterOfOfferEmail.isDisplayed())
				{
					fail("'Email' is not present in subsection 'Letter Of Offer Addressee' of Contact Details section");
				}
			}
		}
	}
	
	public void verifyAutoPopulatedDetails(String postalCode,String blockNo,String streetName, String expectedBlockNo, String expectedStreetName)
	{
		if(blockNo.equalsIgnoreCase("Blk/Hse No."))
		{
			if(streetName.equalsIgnoreCase("Street"))
			{
				appFormElements.txtbx_mailingAddressPostalCode.sendKeys(postalCode);
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!appFormElements.txtbx_mailingAddressBlock.getAttribute("value").trim().equalsIgnoreCase(expectedBlockNo))
					fail(blockNo+" not populated after entering valid postal code");
				if(!appFormElements.txtbx_mailingAddressStreet.getAttribute("value").trim().equalsIgnoreCase(expectedStreetName))
					fail(streetName+" not populated after entering valid postal code");
			}
		}
	}
	
	public void verifyAutoPopulatedMailingDetails(String whichCheckBox,String whichDetails, String expectedData1, String expectedData2, String expectedData3, String level, String unit)
	{
		if(whichCheckBox.equalsIgnoreCase("Same as registered address in Company Profile") && whichDetails.equalsIgnoreCase("mailing address"))
		{
			appFormElements.chkbx_mailingAddress.click();
			
			if(!appFormElements.txtbx_mailingAddressPostalCode.getAttribute("value").trim().equalsIgnoreCase(expectedData1))
				fail("Postal code input field not populated after selecting mailing address checkbox");
			if(!appFormElements.txtbx_mailingAddressBlock.getAttribute("value").trim().equalsIgnoreCase(expectedData2))
				fail("Blk/Hse No. input field not populated after selecting mailing address checkbox");
			if(!appFormElements.txtbx_mailingAddressStreet.getAttribute("value").trim().equalsIgnoreCase(expectedData3))
				fail("Street input field not populated after selecting mailing address checkbox");
			if(!appFormElements.txtbx_mailingAddressLevel.getAttribute("value").trim().equalsIgnoreCase(level))
				fail("Level input field not populated after selecting mailing address checkbox");
			if(!appFormElements.txtbx_mailingAddressUnit.getAttribute("value").trim().equalsIgnoreCase(unit))
				fail("Unit input field not populated after selecting mailing address checkbox");
			//appFormElements.chkbx_mailingAddress.click();
		}
		if(whichCheckBox.equalsIgnoreCase("Same as main contact person") && whichDetails.equalsIgnoreCase("Letter Of Offer Addressee"))
		{
			page.performAndWait("click", appFormElements.chkbx_letterofOffer,"", 2000);
			//appFormElements.chkbx_letterofOffer.click();
			
			if(!appFormElements.txtbx_letterofOfferName.getAttribute("value").trim().equalsIgnoreCase(expectedData1))
				fail("Name in 'Letter Of Offer Addressee' section not populated correctly");
			if(!appFormElements.txtbx_letterOfOfferJobTitle.getAttribute("value").trim().equalsIgnoreCase(expectedData2))
				fail("Job title in 'Letter Of Offer Addressee' section not populated correctly");
			if(!appFormElements.txtbx_letterOfOfferEmail.getAttribute("value").trim().equalsIgnoreCase(expectedData3))
				fail("Email in 'Letter Of Offer Addressee' section not populated correctly");
		}
	}
	
	public void enterContactPersonDetails(String subSection, String name, String jobTitle, String contactNo, String email, String alternateEmail)
	{
		if(subSection.equalsIgnoreCase("Main Contact Person"))
		{
			page.performAndWait("sendKeys", appFormElements.txtbx_Name,name, 1000);
			//appFormElements.txtbx_Name.sendKeys(name);
			page.performAndWait("sendKeys", appFormElements.txtbx_jobTitle,jobTitle, 1000);
			//appFormElements.txtbx_jobTitle.sendKeys(jobTitle);
			page.performAndWait("sendKeys", appFormElements.txtbx_contactNumber,contactNo, 1000);
			//appFormElements.txtbx_contactNumber.sendKeys(contactNo);
			page.performAndWait("sendKeys", appFormElements.txtbx_email,email, 2000);
			//appFormElements.txtbx_email.sendKeys(email);
			page.performAndWait("sendKeys", appFormElements.txtbx_secondaryEmail,alternateEmail, 2000);
			//appFormElements.txtbx_secondaryEmail.sendKeys(alternateEmail);
		}
	}
	
	public String checkAndFormatDate(String input)
	{
		//String res="";
		if(input.equalsIgnoreCase("TODAYS_DATE"))
		{
			input = page.getFormattedDate("dd MMM yyyy", "", 0);
		}
		else
		{
			String[] dateParts= input.split("DATE");
			String interval = dateParts[1].substring(dateParts[1].length()-1);
			int num = Integer.parseInt(dateParts[1].replace(interval, ""));
			input = page.getFormattedDate("dd MMM yyyy", interval, num);  // this function returns either todays date or future one in a given format
		}
		return input;
	}
	
	public void enterRequiredDetailsInGivenSection(String Section, String expectedInputOne, String expectedInputTwo, String expectedInputThree, String expectedInputFour, String expectedInputFive, String expectedInputSix, String expectedInputSeven, String expectedInputEight, String expectedInputNine, String expectedInputTen, String expectedInputEleven, String expectedInputTwelve, String expectedInputThirteen, String expectedInputFourteen)
	{
		if(Section.equalsIgnoreCase("Proposal"))
		{
			page.performAndWait("click", appFormElements.lnk_proposal,"", 1000);
			
			expectedInputTwo = checkAndFormatDate(expectedInputTwo); // check if given date is today's date or future date
			
			expectedInputThree = checkAndFormatDate(expectedInputThree);  // check if given date is today's date or future date
						
			page.performAndWait("sendKeys", appFormElements.txtbx_proposalProjectTitle,expectedInputOne, 2000);
			page.performAndWait("sendKeys", appFormElements.txtbx_proposalStartDate,expectedInputTwo, 2000);
			page.performAndWait("sendKeys", appFormElements.txtbx_proposalEndDate,expectedInputThree, 2000);
			page.performAndWait("sendKeys", appFormElements.txtArea_proposalProjectDesc,expectedInputFour, 2000);
			//page.performAndWait("click", appFormElements.drpDwn_proposalActivityDiv,"", 1000);
			page.performAndWait("sendKeys", appFormElements.drpDwn_proposalActivityInput,expectedInputFive, 1000);
			appFormElements.drpDwn_proposalActivityInput.sendKeys(Keys.TAB);
			//page.performAndWait("click", appFormElements.drpDwn_proposalTargetMarketDiv,"", 1000);
			page.performAndWait("sendKeys", appFormElements.drpDwn_proposalTargetMarketInput,expectedInputSix, 1000);
			appFormElements.drpDwn_proposalTargetMarketInput.sendKeys(Keys.TAB);
			if(expectedInputSeven.equalsIgnoreCase("Yes"))
				page.performAndWait("click", appFormElements.radioBtn_proposalExpandMarket,"", 1000);			
		}
		else if(Section.equalsIgnoreCase("Business Impact"))
		{	
			page.performAndWait("click", appFormElements.lnk_businessImpact,"", 1000);
			
			if(expectedInputOne.equalsIgnoreCase("TODAYS_DATE"))
			{
				expectedInputOne = page.getFormattedDate("dd MMM yyyy", "", 0);
				/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
				LocalDate localDate = LocalDate.now();
				expectedInputOne = dtf.format(localDate).toString();
				System.out.println(dtf.format(localDate));*/				
			}
			page.performAndWait("sendKeys",appFormElements.txtbx_biFyEndDate,expectedInputOne,1000);
			appFormElements.txtbx_biFyEndDate.sendKeys(Keys.TAB);
			
			String arr[] = expectedInputTwo.split("-");
			
			appFormElements.txtbx_biOverseasSalesOne.sendKeys(arr[0]);
			appFormElements.txtbx_biOverseasSalesTwo.sendKeys(arr[1]);
			appFormElements.txtbx_biOverseasSalesThree.sendKeys(arr[2]);
			appFormElements.txtbx_biOverseasSalesFour.sendKeys(arr[3]);
			
			String ovserseasInvestment[] = expectedInputThree.split("-");
			appFormElements.txtbx_biOverseasInvestmentOne.sendKeys(ovserseasInvestment[0]);
			appFormElements.txtbx_biOverseasInvestmentTwo.sendKeys(ovserseasInvestment[1]);
			appFormElements.txtbx_biOverseasInvestmentThree.sendKeys(ovserseasInvestment[2]);
			appFormElements.txtbx_biOverseasInvestmentFour.sendKeys(ovserseasInvestment[3]);
			
			page.performAndWait("sendKeys",appFormElements.txtbx_biRationaleProjection,expectedInputFour,1000);
			page.performAndWait("sendKeys",appFormElements.txtbx_biNonTangiableBenefits,expectedInputFive,1000);
		}
		else if(Section.equalsIgnoreCase("Cost"))
		{
			// ------ Third Party Vendors------------
			page.performAndWait("click", appFormElements.lnk_cost,"", 1000);
			page.performAndWait("click", appFormElements.arrDown_costThirdPartyArrowDown,"", 1000);
			page.performAndWait("click", appFormElements.btn_costThirdPartyAddItem,"", 1000);
			if(expectedInputOne.equalsIgnoreCase("Singapore"))
				page.performAndWait("click", appFormElements.radioBtn_costRegisteredVendorLocation,"", 1000);
			page.performAndWait("sendKeys", appFormElements.txtbx_costVendorName,expectedInputTwo, 1000);
			page.performAndWait("click", appFormElements.btn_costVendorSearch,"", 500);
			page.performAndWait("click", appFormElements.lbl_costVendorSelectFromList,"", 500);
			page.performAndWait("click", appFormElements.btn_costThirdPartySelectFiles,"", 1000);
			
			//upload file
			page.uploadFile(System.getProperty("user.dir")+"\\src\\test\\resources\\test-data\\"+expectedInputThree);
			
			page.performAndWait("sendKeys", appFormElements.txtbx_costThirdPartyEstimatedCost,expectedInputFour, 1000);
						
			// ------ Office Space Rental------------
			//page.performAndWait("click", appFormElements.lnk_cost,"", 1000);
			page.performAndWait("click", appFormElements.arrDown_costOfficeSpaceRentalArrowDown,"", 1000);
			page.performAndWait("click", appFormElements.btn_costAddItem,"", 1000);
			page.performAndWait("sendKeys", appFormElements.txtArea_costDesc,expectedInputFive, 1000);
			page.performAndWait("sendKeys", appFormElements.txtbx_costRentalDuration,expectedInputSix, 1000);
			page.performAndWait("sendKeys", appFormElements.txtbx_costMonthlyRental,expectedInputSeven, 1000);
			
			// ------ Salary ------------
			page.performAndWait("click", appFormElements.arrDown_costSalaryArrowDown,"", 1000);
			page.performAndWait("click", appFormElements.btn_costSalaryAddItem,"", 1000);
			page.performAndWait("sendKeys", appFormElements.txtbx_costSalaryName,expectedInputEight, 1000);
			page.performAndWait("sendKeys", appFormElements.txtbx_costSalaryDesignation,expectedInputNine, 1000);
			page.performAndWait("sendKeys", appFormElements.txtbx_costSalaryPassport,expectedInputTen, 1000);
			page.performAndWait("sendKeys", appFormElements.drpDwn_costSalaryNationality,expectedInputEleven, 1000);
			appFormElements.drpDwn_costSalaryNationality.sendKeys(Keys.TAB);
			page.performAndWait("sendKeys", appFormElements.txtArea_costSalaryRoleInProject,expectedInputTwelve, 1000);
			page.performAndWait("sendKeys", appFormElements.txtbx_costSalaryProjectInvolvement,expectedInputThirteen, 1000);
			page.performAndWait("sendKeys", appFormElements.txtbx_costSalaryMonthlySalary,expectedInputFourteen, 1000);
		}
		page.performAndWait("click", appFormElements.btn_Save,"", 5000);
	}
	
	public void acknowledgeTermsAndValidateRequiredDetails(String sectionOne, String errorCnt, String sectionTwo,String fieldMissing, String fieldValue)
	{
		if(sectionOne.equalsIgnoreCase("Declare & Review"))
		{
			page.performAndWait("click", appFormElements.lnk_declareAndReview,"", 5000);
			appFormElements.radioBtn_declareReviewApplicantInvestigated.click();
			appFormElements.radioBtn_declareReviewApplicantinCivilSuit.click();
			appFormElements.radioBtn_declareReviewApplicantinBankrupt.click();
			
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.id("react-declaration-project_incentives_check-false"));
			je.executeScript("arguments[0].scrollIntoView(true);", element);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			WebElement scanEle =new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("react-declaration-project_incentives_check-false")));
			Actions action =new Actions(driver);
			action.moveToElement(scanEle).click().build().perform();
			
			//appFormElements.radioBtn_declareReviewObtainGrants.click();

			
			appFormElements.radioBtn_declareReviewOherIncentives.click();
			appFormElements.radioBtn_declareReviewOtherSigningContract.click();
			appFormElements.radioBtn_declareReviewOtherRelationship.click();
			
			WebElement scanEle2 =new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("react-declaration-debarment_check-false")));
			Actions action2 =new Actions(driver);
			action2.moveToElement(scanEle2).click().build().perform();
			
			appFormElements.radioBtn_declareReviewSafeDistancing.click();
			appFormElements.radioBtn_declareReviewApplicableSDMs.click();
			appFormElements.chkBx_declareReviewAck.click();
			page.performAndWait("click", appFormElements.btn_Save,"", 1000);
			
			// Go to Proposal section and clear 'Project Title' contents and save
			page.performAndWait("click", appFormElements.lnk_cost,"", 5000);
			page.performAndWait("click", appFormElements.arrDown_costThirdPartyArrowDown,"", 1000);
			page.performAndWait("click", appFormElements.btn_costCloseVendorSearch,"", 1000);
			page.performAndWait("click", appFormElements.btn_Save,"", 4000);
			
			//page.performAndWait("sendKeys", appFormElements.txtbx_costVendorName,expectedInputTwo, 1000);
			//page.performAndWait("click", appFormElements.btn_costVendorSearch,"", 500);
			//page.performAndWait("click", appFormElements.lbl_costVendorSelectFromList,"", 500);
			
			
			/*page.performAndWait("click", appFormElements.lnk_proposal,"", 5000);
			page.performAndWait("clear", appFormElements.txtbx_proposalProjectTitle,"", 1000);
			page.performAndWait("sendKeys", appFormElements.txtbx_proposalProjectTitle,"", 2000);
			page.performAndWait("click", appFormElements.btn_Save,"", 4000);*/

			// Go to Declare & Review section and click Review
			page.performAndWait("click", appFormElements.lnk_declareAndReview,"", 5000);
			//page.performAndWait("click", appFormElements.btn_Save,"", 1000);
			page.performAndWait("click", appFormElements.btn_declareReview,"", 5000);
			if(appFormElements.lnk_errorSection.getText().trim().equalsIgnoreCase(sectionTwo))
			{
				if(appFormElements.lnk_errorCount.getText().trim().equalsIgnoreCase(errorCnt))
				{
					page.performAndWait("click", appFormElements.arrDown_costThirdPartyArrowDown,"", 1000);
					System.out.println("Actual Field:"+appFormElements.txtbx_missingField.getText().trim());
					String actualMissingField = appFormElements.txtbx_missingField.getText().trim().replace(" *", "");
					if(actualMissingField.trim().equalsIgnoreCase(fieldMissing))
					{
						
						page.performAndWait("sendKeys", appFormElements.txtbx_costVendorName,fieldValue, 1000);
						page.performAndWait("click", appFormElements.btn_costVendorSearch,"", 500);
						page.performAndWait("click", appFormElements.lbl_costVendorSelectFromList,"", 500);						
						//page.performAndWait("sendKeys", appFormElements.txtbx_proposalProjectTitle,fieldValue, 1000);
						page.performAndWait("click", appFormElements.btn_Save,"", 5000);
						page.performAndWait("click", appFormElements.lnk_declareAndReview,"", 2000);
					}
					else
						fail("Incorrect field highlighted for not entering input");
				}
				else
				{
					fail("Incorrect error count displayed for not entering input");
				}
			}
			else
			{
				fail("Section not highlighted for missing details");
			}
		}
	}
	
	public void redirectToSummaryPage(String reviewBtn,String Section)
	{
		if(Section.equalsIgnoreCase("Declare & Review"))
		{
			if(reviewBtn.equalsIgnoreCase("review"))
			{
				page.performAndWait("click", appFormElements.btn_declareReview,"", 10000);
//				if(!appFormElements.lbl_summaryPageReviewApp.isDisplayed())
//					fail("Applicant is not redirected to summary page after clicking review button");
			}
		}
	}
	
	public void verifySummaryPage(String sectionOne, String sectionTwo, String sectionThree, String sectionFour, String sectionFive, String sectionSix)
	{
		List<WebElement> listOfElements;
		if(sectionOne.equalsIgnoreCase("Eligibility"))
		{
			listOfElements = (List<WebElement>) appFormElements.list_eligibilityReadOnly;
			checkForEmptyTextInElementCollection(listOfElements,sectionOne);
		}
		if(sectionTwo.equalsIgnoreCase("Contact Details"))
		{
			listOfElements = (List<WebElement>) appFormElements.list_contactInfoReadOnly;
			checkForEmptyTextInElementCollection(listOfElements,sectionTwo);
		}
		if(sectionThree.equalsIgnoreCase("Proposal"))
		{
			listOfElements = (List<WebElement>) appFormElements.list_proposalReadOnly;
			checkForEmptyTextInElementCollection(listOfElements,sectionThree);
		}
		if(sectionFour.equalsIgnoreCase("Business Impact"))
		{
			listOfElements = (List<WebElement>) appFormElements.list_businessImpactReadOnly;
			checkForEmptyTextInElementCollection(listOfElements,sectionFour);
		}
		if(sectionFive.equalsIgnoreCase("Cost"))
		{
			listOfElements = (List<WebElement>) appFormElements.list_costReadOnly;
			checkForEmptyTextInElementCollection(listOfElements,sectionFive);
		}
		if(sectionSix.equalsIgnoreCase("Declare & Review"))
		{
			listOfElements = (List<WebElement>) appFormElements.list_declareReadOnly;
			checkForEmptyTextInElementCollection(listOfElements,sectionSix);
		}
	}
	
	public void checkForEmptyTextInElementCollection(List<WebElement> listOfElements, String section) 
	{
		for(WebElement element:listOfElements)
		{
			if(element.getText().isEmpty())
			{
				fail("Details mismatched on summary page for section "+section);
			}
		}
	}
	
	public void verifyCheckBoxInSummaryPage(String checkbox)
	{
		if(checkbox.equalsIgnoreCase("Consent and Acknowledgement"))
			if(!appFormElements.chkBx_declareConsent.isDisplayed())
				fail("checkbox "+checkbox+" is missing at the bottom of read-only summary page");
	}
	
	public void verifyDetailsOnFormSubmission(String successMsg, String agencyName)
	{
		page.performAndWait("click", appFormElements.chkBx_declareConsent, "", 1000);
		page.performAndWait("click", appFormElements.btn_submitForm, "", 10000);
		if(appFormElements.lbl_successMsg.getText().trim().equalsIgnoreCase(successMsg))
		{
			if(!appFormElements.lbl_refID.getText().isEmpty())
			{
				page.refID = appFormElements.lbl_refID.getText().trim();
				
				if(!appFormElements.lbl_agencyName.getText().trim().equalsIgnoreCase(agencyName))
				{
					fail("Agency name "+agencyName+" not displayed after submitting an application form");
				}
			}
			else
				fail("Ref ID not generated after submitting an application form.");
		}
		else
			fail("Success message "+successMsg+" not displayed after submitting an application form.");
	}
	
}