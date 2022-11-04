package com.cognizant.step_defs;

import org.openqa.selenium.WebDriver;

import com.cognizant.pages.ApplicationFormPage;
import com.cognizant.pages.Common;
import com.cognizant.pages.HomePage;
import com.cognizant.pages.LandingPage;
import com.cognizant.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class GrantApplicationSteps {
	
	LandingPage dpLandingPage;
	LoginPage loginPage;
	HomePage homePage;
	Common page;
	ApplicationFormPage applicationForm;
	
	public GrantApplicationSteps(Common page, LandingPage dpLandingPage, LoginPage loginPage, HomePage homePage,ApplicationFormPage applicationForm) {
		this.dpLandingPage = dpLandingPage;
		this.loginPage = loginPage;
		this.homePage = homePage;
		this.applicationForm = applicationForm;
		this.page = page;
	}

	@Given("I am on business grant portal landing page")
	public void redirect_ToLandingPage() {
	    dpLandingPage.redirectToLandingPage();
	}
	
	@When("I click login with CorpPass to opt apply for a grant now option")
	public void click_LoginWithCorpPass() throws InterruptedException {
	    dpLandingPage.clickLoginWithCorpPass();
	}
	
	@Then("I login with own user details")
	public void login_WithUserDetails(DataTable dataTable) {	
		loginPage.loginWithOwnUserDetails(dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2),dataTable.row(0).get(3));
	}
	
	@Then("I select {string} on the {string} dashboard to enter the Grant Picker")
	public void select_dashboardOptions(String option, String dashboardName) {
	    // Write code here that turns the phrase above into concrete actions
	    homePage.selectDashboardOptions(option,dashboardName);
	}
	
	@Then("I select a sector {string} for my business")
	public void select_businessSector(String sectorName) {
	    // Write code here that turns the phrase above into concrete actions
	    homePage.selectBusinessSector(sectorName);
	}

	@Then("I select a development area {string}")
	public void select_developmentArea(String areaName) {
	    // Write code here that turns the phrase above into concrete actions
	    homePage.selectDevelopmentArea(areaName);
	}

	@Then("I select a functional area {string} and apply for a grant")
	public void select_functionalArea(String funcAreaName) {
	    homePage.selectFunctionalArea(funcAreaName);
	}
	
	@Then("I click {string} to enter the form")
	public void click_ProceedToEnterForm(String option) {
	    homePage.clickProceedToEnterForm(option);
	}
	
	@Then("I expect an application form should consists following sections")
	public void verify_applicationFormSections(DataTable dataTable) {
		applicationForm.verifyApplicationFormSections(dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2),dataTable.row(0).get(3),dataTable.row(0).get(4),dataTable.row(0).get(5));
	}

	@Then("I expect the {string} section should contain below questions")
	public void verify_contactDetailsQuestions(String sectionName, DataTable dataTable) {
		applicationForm.verifyQuestionsFromContactDetails(sectionName,dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2),dataTable.row(0).get(3));
	}
 
	@Then("I expect question {string} is present with below statements")
	public void verify_questionStatements(String question, DataTable dataTable) {
		applicationForm.verifyQuestionStatements(question,dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2));
	}
	
	@Then("I expect each question in {string} section should be answered Yes or No through radio buttons")
	public void verify_questionAnswers(String sectionName) {
		applicationForm.verifyQuestionAnswers(sectionName);
	}

	@Then("I expect a warning message {string} to be displayed if any question is answered as No")
	public void verify_warningMsg(String warningMsg) {
		applicationForm.verifyWarningMsg(warningMsg);
	}
	
	@Then("I expect clicking the link in the warning message should launch a website in another window tab with the url {string}")
	public void verify_linkInWarningMsg(String url) {
		applicationForm.verifyLinkInWarningMsg(url);
	}

	@Then("I expect clicking {string} should save applicant's input in {string} section and refreshing the page should reload the saved values")
	public void save_inputAndReload(String save,String sectionName) {
		applicationForm.saveInputAndReloadPage(save,sectionName);
	}

	@Then("I expect a {string} subsection with following inputs in {string} section")
	public void verify_inputsInContactDetails(String subSection, String section, DataTable dataTable) {
		if(subSection.equalsIgnoreCase("Main Contact Person"))
			applicationForm.verifyInputsInContactDetails(subSection,section,dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2),dataTable.row(0).get(3),dataTable.row(0).get(4),dataTable.row(0).get(5));
		else if(subSection.equalsIgnoreCase("Letter Of Offer Addressee"))
			applicationForm.verifyInputsInContactDetails(subSection,section,dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2),"","","");
	}

	@Then("I expect entering a valid postal code {string} should auto-populate {string} and {string} details with below valid values")
	public void verify_autoPopulateDetails(String postalCode, String blockNo, String streetName, DataTable dataTable) {
		applicationForm.verifyAutoPopulatedDetails(postalCode, blockNo, streetName,dataTable.row(0).get(0),dataTable.row(0).get(1));
	}
	
	@Then("I expect enabling a checkbox {string} should auto-populate {string} details with below values")
	public void verify_autoPopulatedMailingDetails(String whichCheckBox,String whichDetails, DataTable dataTable) {
			if(whichCheckBox.equalsIgnoreCase("Same as registered address in Company Profile"))
				applicationForm.verifyAutoPopulatedMailingDetails(whichCheckBox,whichDetails,dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2),dataTable.row(0).get(3),dataTable.row(0).get(4));
			else if(whichCheckBox.equalsIgnoreCase("Same as main contact person"))
				applicationForm.verifyAutoPopulatedMailingDetails(whichCheckBox,whichDetails,dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2),"","");		
	}
 
	@Then("I fill {string} subsection with following values")
	public void enter_mainContactPersonDetails(String subSection,DataTable dataTable) {
		applicationForm.enterContactPersonDetails(subSection,dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2),dataTable.row(0).get(3),dataTable.row(0).get(4));
	}
	
	@Then("I fill {string} section with following values")
	public void enter_requiredDetailsinGivenSection(String Section,DataTable dataTable) 
	{
		if(Section.equalsIgnoreCase("Proposal"))
			applicationForm.enterRequiredDetailsInGivenSection(Section,dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2),dataTable.row(0).get(3),dataTable.row(0).get(4),dataTable.row(0).get(5),dataTable.row(0).get(6),"","","","","","","");
		else if(Section.equalsIgnoreCase("Business Impact"))
			applicationForm.enterRequiredDetailsInGivenSection(Section,dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2),dataTable.row(0).get(3),dataTable.row(0).get(4),"","","","","","","","","");
		else if(Section.equalsIgnoreCase("Cost"))
			applicationForm.enterRequiredDetailsInGivenSection(Section,dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2),dataTable.row(0).get(3),dataTable.row(0).get(4),dataTable.row(0).get(5),dataTable.row(0).get(6),dataTable.row(0).get(7),dataTable.row(0).get(8),dataTable.row(0).get(9),dataTable.row(0).get(10),dataTable.row(0).get(11),dataTable.row(0).get(12),dataTable.row(0).get(13));
	}
	
	@Then("I acknowledge terms in {string} section and I expect {string} validation error and the form should redirect to the {string} section with the missing details if mandatory input {string} is missing with value {string}")
	public void declare_acknowledgeTerms(String sectionOne,String errorCnt, String sectionTwo,String fieldMissing, String fieldValue) {
		applicationForm.acknowledgeTermsAndValidateRequiredDetails(sectionOne,errorCnt,sectionTwo,fieldMissing,fieldValue);
	}

	@Then("I expect clicking {string} button in {string} section should redirect applicant to read-only summary page")
	public void redirect_ToSummaryPage(String reviewBtn, String Section) {
		applicationForm.redirectToSummaryPage(reviewBtn,Section);
	}
	
	/*@Then("I expect a validation error and the form should redirect to the {string} section with the missing details if mandatory input {string} is missing with value {string}")
	public void verify_ValidationForRequiredDetails(String section, String fieldMissing, String fieldValue) {
		applicationForm.verifyValidationForRequiredDetails(section,fieldMissing,fieldValue);
	}*/
	
	@Then("I expect read-only summary page should correctly contain all the details previously filled in each form section menioned below")
	public void verify_summaryPage(DataTable dataTable) {
		applicationForm.verifySummaryPage(dataTable.row(0).get(0),dataTable.row(0).get(1),dataTable.row(0).get(2),dataTable.row(0).get(3),dataTable.row(0).get(4),dataTable.row(0).get(5));
	}
	
	@Then("I expect a checkbox {string} at the bottom of read-only summary page")
	public void verify_checkboxInSummaryPage(String checkbox) {
		applicationForm.verifyCheckBoxInSummaryPage(checkbox);
	}
	
	@Then("On submission of an application form I expect a success message {string} with reference id and receiving agency should be {string}")
	public void verify_detailsOnFormSubmission(String successMsg, String agencyName) {
		applicationForm.verifyDetailsOnFormSubmission(successMsg,agencyName);
	}
	
	@Then("I expect {string} dashboard should show the application under the {string} tab with project title {string}")
	public void verify_applicationUnderProcessing(String dahsboardOption, String tabName, String projectTitle) {
		homePage.verifyApplicationUnderProcessing(dahsboardOption,tabName,projectTitle);
	}

}
