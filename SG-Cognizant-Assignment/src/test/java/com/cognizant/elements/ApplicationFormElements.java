package com.cognizant.elements;

import java.util.List; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApplicationFormElements {
	WebDriver driver;
	
	public ApplicationFormElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//------------ Eligibility --------------------------------------------------------------------------------------
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"form-horizontal bgp-radio-group\"]/descendant::label[@class=\"control-label bgp-label\" and contains(text(),'Is the applicant registered in Singapore?')]")
	 public WebElement lbl_questionOne;   

	@FindBy(how = How.XPATH, using = "//div[@class=\"form-horizontal bgp-radio-group\"]/descendant::label[@class=\"control-label bgp-label\" and contains(text(),\"Is the applicant's group sales turnover less than or equal to S$100m or\")]") 
	 public WebElement lbl_questionTwo;

	@FindBy(how = How.XPATH, using = "//div[@class=\"form-horizontal bgp-radio-group\"]/descendant::label[@class=\"control-label bgp-label\" and contains(text(),\"Does the applicant have at least 30%\")]") 
	 public WebElement lbl_questionThree;

	@FindBy(how = How.XPATH, using = "//div[@class=\"form-horizontal bgp-radio-group\"]/descendant::label[contains(text(),'Are') and ./b[contains(text(),'all')]]") 
	 public WebElement lbl_questionFour;
	
	@FindBy(how = How.ID, using = "react-eligibility-sg_registered_check-true") 
	 public WebElement radioBtnTrue_questionOne;
	
	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-sg_registered_check-true\"]/following-sibling::span[@class=\"bgp-label\"]") 
	 public WebElement radioBtnTrue_questionOneAnswer;
	
	@FindBy(how = How.ID, using = "react-eligibility-sg_registered_check-false") 
	 public WebElement radioBtnFalse_questionOne;

	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-sg_registered_check-false\"]/following-sibling::span[@class=\"bgp-label\"]") 
	 public WebElement radioBtnFalse_questionOneAnswer;

	@FindBy(how = How.ID, using = "react-eligibility-turnover_check-true") 
	 public WebElement radioBtnTrue_questionTwo;
	
	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-turnover_check-true\"]/following-sibling::span[@class=\"bgp-label\"]") 
	 public WebElement radioBtnTrue_questionTwoAnswer;

	@FindBy(how = How.ID, using = "react-eligibility-turnover_check-false") 
	 public WebElement radioBtnFalse_questionTwo;

	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-turnover_check-false\"]/following-sibling::span[@class=\"bgp-label\"]") 
	 public WebElement radioBtnFalse_questionTwoAnswer;
	
	@FindBy(how = How.ID, using = "react-eligibility-global_hq_check-true") 
	 public WebElement radioBtnTrue_questionThree;
	
	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-global_hq_check-true\"]/following-sibling::span[@class=\"bgp-label\"]") 
	 public WebElement radioBtnTrue_questionThreeAnswer;

	@FindBy(how = How.ID, using = "react-eligibility-global_hq_check-false") 
	 public WebElement radioBtnFalse_questionThree;

	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-global_hq_check-false\"]/following-sibling::span[@class=\"bgp-label\"]") 
	 public WebElement radioBtnFalse_questionThreeAnswer;

	@FindBy(how = How.ID, using = "react-eligibility-started_project_check-true") 
	 public WebElement radioBtnTrue_questionFour;
	
	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-started_project_check-true\"]/following-sibling::span[@class=\"bgp-label\"]") 
	 public WebElement radioBtnTrue_questionFourAnswer;

	@FindBy(how = How.ID, using = "react-eligibility-started_project_check-false") 
	 public WebElement radioBtnFalse_questionFour;

	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-started_project_check-false\"]/following-sibling::span[@class=\"bgp-label\"]") 
	 public WebElement radioBtnFalse_questionFourAnswer;
		
//	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-sg_registered_check-false\"]/ancestor::div[@class=\"form-horizontal bgp-radio-group\"]/following-sibling::span/div/span") 
//	 public WebElement lbl_questionOneWarning;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[5]/div/span") 
	 public WebElement lbl_questionOneWarning;

//	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-turnover_check-false\"]/ancestor::div[@class=\"form-horizontal bgp-radio-group\"]/following-sibling::span/div/span") 
//	 public WebElement lbl_questionTwoWarning;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[7]/div/span") 
	 public WebElement lbl_questionTwoWarning;

	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-global_hq_check-false\"]/ancestor::div[@class=\"form-horizontal bgp-radio-group\"]/following-sibling::span/div/span") 
	 public WebElement lbl_questionThreeWarning;

	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-started_project_check-false\"]/ancestor::div[@class=\"form-horizontal bgp-radio-group\"]/following-sibling::span/div/span") 
	 public WebElement lbl_questionFourWarning;
		
	@FindBy(how = How.XPATH, using = "//input[@id=\"react-eligibility-sg_registered_check-false\"]/ancestor::div[@class=\"form-horizontal bgp-radio-group\"]/following-sibling::span/div/span/a") 
	 public WebElement lnk_questionOneWarningMsgLink;
	
	@FindBy(how = How.ID, using = "save-btn") 
	 public WebElement btn_Save;
	
	@FindBy(how = How.ID, using = "react-eligibility-new_target_market_check-true") 
	 public WebElement radioBtnTrue_questionFive;

	//------------ Contact Details --------------------------------------------------------------------------------------	
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"bgp-sidebar\"]/ul/li/a/span[contains(text(),'Contact Details')]") 
	 public WebElement lnk_contactDetailsTab;

	@FindBy(how = How.ID, using = "react-contact_info-name") 
	 public WebElement txtbx_Name;
	
	@FindBy(how = How.ID, using = "react-contact_info-designation") 
	 public WebElement txtbx_jobTitle;

	@FindBy(how = How.ID, using = "react-contact_info-phone") 
	 public WebElement txtbx_contactNumber;
	
	@FindBy(how = How.ID, using = "react-contact_info-primary_email") 
	 public WebElement txtbx_email;
	
	@FindBy(how = How.ID, using = "react-contact_info-secondary_email") 
	 public WebElement txtbx_secondaryEmail;

	@FindBy(how = How.ID, using = "react-contact_info-correspondence_address-copied") 
	 public WebElement chkbx_mailingAddress;

	@FindBy(how = How.ID, using = "react-contact_info-correspondence_address-postal") 
	 public WebElement txtbx_mailingAddressPostalCode;

	@FindBy(how = How.ID, using = "react-contact_info-correspondence_address-block") 
	 public WebElement txtbx_mailingAddressBlock;

	@FindBy(how = How.ID, using = "react-contact_info-correspondence_address-street") 
	 public WebElement txtbx_mailingAddressStreet;

	@FindBy(how = How.ID, using = "react-contact_info-correspondence_address-level") 
	 public WebElement txtbx_mailingAddressLevel;

	@FindBy(how = How.ID, using = "react-contact_info-correspondence_address-unit") 
	 public WebElement txtbx_mailingAddressUnit;

	@FindBy(how = How.ID, using = "react-contact_info-correspondence_address-building_name") 
	 public WebElement txtbx_mailingAddressBuildingName;

	@FindBy(how = How.ID, using = "react-contact_info-copied") 
	 public WebElement chkbx_letterofOffer;

	@FindBy(how = How.ID, using = "react-contact_info-offeree_name") 
	 public WebElement txtbx_letterofOfferName;

	@FindBy(how = How.ID, using = "react-contact_info-offeree_designation") 
	 public WebElement txtbx_letterOfOfferJobTitle;

	@FindBy(how = How.ID, using = "react-contact_info-offeree_email") 
	 public WebElement txtbx_letterOfOfferEmail;

	//------------ Form Sections --------------------------------------------------------------------------------------
		
	@FindBy(how = How.XPATH, using = "//div[@class=\"bgp-sidebar\"]/ul/li/a/span[contains(text(),'Contact Details')]") 
	 public WebElement lnk_contactDetails;

	@FindBy(how = How.XPATH, using = "//div[@class=\"bgp-sidebar\"]/ul/li/a/span[contains(text(),'Eligibility')]") 
	 public WebElement lnk_eligibility;

	@FindBy(how = How.XPATH, using = "//div[@class=\"bgp-sidebar\"]/ul/li/a/span[contains(text(),'Proposal')]") 
	 public WebElement lnk_proposal;

	@FindBy(how = How.XPATH, using = "//div[@class=\"bgp-sidebar\"]/ul/li/a/span[contains(text(),'Business Impact')]") 
	 public WebElement lnk_businessImpact;

	@FindBy(how = How.XPATH, using = "//div[@class=\"bgp-sidebar\"]/ul/li/a/span[contains(text(),'Cost')]") 
	 public WebElement lnk_cost;

	@FindBy(how = How.XPATH, using = "//div[@class=\"bgp-sidebar\"]/ul/li/a/span[contains(text(),'Declare & Review')]") 
	 public WebElement lnk_declareAndReview;
	
	//------------ Proposal Section--------------------------------------------------------------------------------------
	
	@FindBy(how = How.ID, using = "react-project-title") 
	 public WebElement txtbx_proposalProjectTitle;

	@FindBy(how = How.ID, using = "react-project-start_date") 
	 public WebElement txtbx_proposalStartDate;

	@FindBy(how = How.ID, using = "react-project-end_date") 
	 public WebElement txtbx_proposalEndDate;
	
	@FindBy(how = How.ID, using = "react-project-description") 
	 public WebElement txtArea_proposalProjectDesc;

	@FindBy(how = How.XPATH, using = "//span[@id=\"react-select-project-activity--value\"]/div[@class=\"Select-placeholder\"]") 
	 public WebElement drpDwn_proposalActivityDiv;

	@FindBy(how = How.XPATH, using = "//span[@id=\"react-select-project-activity--value\"]/div/input") 
	 public WebElement drpDwn_proposalActivityInput;
	
	@FindBy(how = How.XPATH, using = "//span[@id=\"react-select-project-primary_market--value\"]/div") 
	 public WebElement drpDwn_proposalTargetMarketDiv;

	@FindBy(how = How.XPATH, using = "//span[@id=\"react-select-project-primary_market--value\"]/div/input") 
	public WebElement drpDwn_proposalTargetMarketInput;
	
	@FindBy(how = How.ID, using = "react-project-is_first_time_expand-true") 
	public WebElement radioBtn_proposalExpandMarket;
	
	//------------ Business Impact --------------------------------------------------------------------------------------
	
	@FindBy(how = How.ID, using = "react-project_impact-fy_end_date_0") 
	 public WebElement txtbx_biFyEndDate;

	@FindBy(how = How.ID, using = "react-project_impact-overseas_sales_0") 
	 public WebElement txtbx_biOverseasSalesOne;

	@FindBy(how = How.ID, using = "react-project_impact-overseas_sales_1") 
	 public WebElement txtbx_biOverseasSalesTwo;

	@FindBy(how = How.ID, using = "react-project_impact-overseas_sales_2") 
	 public WebElement txtbx_biOverseasSalesThree;

	@FindBy(how = How.ID, using = "react-project_impact-overseas_sales_3") 
	 public WebElement txtbx_biOverseasSalesFour;
	
	@FindBy(how = How.ID, using = "react-project_impact-overseas_investments_0") 
	 public WebElement txtbx_biOverseasInvestmentOne;

	@FindBy(how = How.ID, using = "react-project_impact-overseas_investments_1") 
	 public WebElement txtbx_biOverseasInvestmentTwo;

	@FindBy(how = How.ID, using = "react-project_impact-overseas_investments_2") 
	 public WebElement txtbx_biOverseasInvestmentThree;

	@FindBy(how = How.ID, using = "react-project_impact-overseas_investments_3") 
	 public WebElement txtbx_biOverseasInvestmentFour;
	
	@FindBy(how = How.ID, using = "react-project_impact-rationale_remarks") 
	 public WebElement txtbx_biRationaleProjection;
	
	@FindBy(how = How.ID, using = "react-project_impact-benefits_remarks") 
	 public WebElement txtbx_biNonTangiableBenefits;

	//------------ Cost --------------------------------------------------------------------------------------
	
	//------------ Office Space Rental -----------------
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"col-md-6 col-xs-10\" and text()=\"Office Space Rental\"]//following::div[@class=\"col-md-1 col-xs-2\"]/div") 
	 public WebElement arrDown_costOfficeSpaceRentalArrowDown;
	
	@FindBy(how = How.ID, using = "react-project_cost-office_rentals-add-item") 
	 public WebElement btn_costAddItem;
	
	@FindBy(how = How.ID, using = "react-project_cost-office_rentals-0-description") 
	 public WebElement txtArea_costDesc;

	@FindBy(how = How.ID, using = "react-project_cost-office_rentals-0-rental_duration") 
	 public WebElement txtbx_costRentalDuration;

	@FindBy(how = How.ID, using = "react-project_cost-office_rentals-0-amount_in_billing_currency") 
	 public WebElement txtbx_costMonthlyRental;

	//------------ Third Party Vendors -----------------
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"col-md-6 col-xs-10\" and text()=\"Third Party Vendors\"]//following::div[@class=\"col-md-1 col-xs-2\"]/div") 
	 public WebElement arrDown_costThirdPartyArrowDown;

	@FindBy(how = How.ID, using = "react-project_cost-vendors-add-item") 
	 public WebElement btn_costThirdPartyAddItem;
	
	@FindBy(how = How.ID, using = "react-project_cost-vendors-0-local_vendor-true") 
	 public WebElement radioBtn_costRegisteredVendorLocation;
	
	@FindBy(how = How.ID, using = "react-project_cost-vendors-0-vendor_name") 
	 public WebElement txtbx_costVendorName;
	
	@FindBy(how = How.ID, using = "react-project_cost-vendors-0-vendor_name-vendor") 
	 public WebElement btn_costVendorSearch;

	@FindBy(how = How.ID, using = "vendor-row-sub") 
	 public WebElement lbl_costVendorSelectFromList;

	
	@FindBy(how = How.ID, using = "react-project_cost-vendors-0-attachments-btn") 
	 public WebElement btn_costThirdPartySelectFiles;
	
	@FindBy(how = How.ID, using = "react-project_cost-vendors-0-amount_in_billing_currency") 
	 public WebElement txtbx_costThirdPartyEstimatedCost;

	//------------ Salary -----------------
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"col-md-6 col-xs-10\" and text()=\"Salary\"]//following::div[@class=\"col-md-1 col-xs-2\"]/div") 
	 public WebElement arrDown_costSalaryArrowDown;
	
	@FindBy(how = How.ID, using = "react-project_cost-salaries-add-item") 
	 public WebElement btn_costSalaryAddItem;
	
	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-name") 
	 public WebElement txtbx_costSalaryName;
	
	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-designation") 
	 public WebElement txtbx_costSalaryDesignation;

	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-nric") 
	 public WebElement txtbx_costSalaryPassport;

	@FindBy(how = How.XPATH, using = "//span[@id=\"react-select-project_cost-salaries-0-nationality--value\"]/div/input") 
	 public WebElement drpDwn_costSalaryNationality;
	
	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-project_role") 
	 public WebElement txtArea_costSalaryRoleInProject;
	
	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-involvement_months") 
	 public WebElement txtbx_costSalaryProjectInvolvement;
	
	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-salary_in_billing_currency") 
	 public WebElement txtbx_costSalaryMonthlySalary;
	
	@FindBy(how = How.ID, using = "react-declaration-criminal_liability_check-false") 
	 public WebElement radioBtn_declareReviewApplicantInvestigated;

	@FindBy(how = How.ID, using = "react-declaration-civil_proceeding_check-false") 
	 public WebElement radioBtn_declareReviewApplicantinCivilSuit;
	
	@FindBy(how = How.ID, using = "react-declaration-insolvency_proceeding_check-false") 
	 public WebElement radioBtn_declareReviewApplicantinBankrupt;

	@FindBy(how = How.ID, using = "react-declaration-project_incentives_check-false") 
	 public WebElement radioBtn_declareReviewObtainGrants;
	
//	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[4]/div/div[2]/label[1]/input") 
//	 public WebElement radioBtn_declareReviewObtainGrants;

	@FindBy(how = How.ID, using = "react-declaration-other_incentives_check-false") 
	 public WebElement radioBtn_declareReviewOherIncentives;

	@FindBy(how = How.ID, using = "react-declaration-project_commence_check-false") 
	 public WebElement radioBtn_declareReviewOtherSigningContract;

	@FindBy(how = How.ID, using = "react-declaration-related_party_check-false") 
	 public WebElement radioBtn_declareReviewOtherRelationship;

	@FindBy(how = How.ID, using = "react-declaration-covid_safe_check-true") 
	 public WebElement radioBtn_declareReviewSafeDistancing;

	@FindBy(how = How.ID, using = "react-declaration-covid_safe_ques_check-true") 
	 public WebElement radioBtn_declareReviewApplicableSDMs;
	
	@FindBy(how = How.ID, using = "react-declaration-consent_acknowledgement_check") 
	 public WebElement chkBx_declareReviewAck;
	
	@FindBy(how = How.ID, using = "review-btn") 
	 public WebElement btn_declareReview;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"main summary-page\"]/div/h3[text()=\"Review Your Application\"]") 
	 public WebElement lbl_summaryPageReviewApp;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"bgp-sidebar\"]/ul/li[@class=\"active\"]/a/span[@class=\"menu-text\"]") 
	 public WebElement lnk_errorSection;

	@FindBy(how = How.XPATH, using = "//div[@class=\"bgp-sidebar\"]/ul/li[@class=\"active\"]/a/div[@class=\"sidebar-label\"]/span") 
	 public WebElement lnk_errorCount;
	
	//@FindBy(how = How.XPATH, using = "//p[@id=\"react-project-title-alert\"]/ancestor::div[@class=\"form-group\"]/descendant::label[@id=\"react-project-title-label\"]") 
	 //public WebElement txtbx_missingField;
	
	@FindBy(how = How.XPATH, using = "//p[@id=\"react-project_cost-vendors-0-vendor_name-alert\"]/ancestor::div[@class=\"form-group\"]/descendant::label[@id=\"react-project_cost-vendors-0-vendor_name-label\"]") 
	 public WebElement txtbx_missingField;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"form-group\"]/descendant::span[@class=\"Select-clear-zone vendorsearch-clearbtn\"]") 
	 public WebElement btn_costCloseVendorSearch;

	//------------------ Summary Page ----------------------------
	
	@FindBy(how = How.XPATH, using = "//div[@id=\"eligibility\"]//div[contains(@class,'bgp-radio-readonly')]") 
	 public List<WebElement> list_eligibilityReadOnly;

	@FindBy(how = How.XPATH, using = "//div[@id=\"contact_info\"]//div[contains(@class,'bgp-readonly')]") 
	 public List<WebElement> list_contactInfoReadOnly;

	@FindBy(how = How.XPATH, using = "//div[@id=\"project\"]//div[contains(@class,'bgp-readonly')]") 
	 public List<WebElement> list_proposalReadOnly;

	@FindBy(how = How.XPATH, using = "//div[@id=\"project_impact\"]//div[contains(@class,'bgp-readonly')]") 
	 public List<WebElement> list_businessImpactReadOnly;

	@FindBy(how = How.XPATH, using = "//div[@id=\"project_cost\"]//div[contains(@class,'bgp-readonly')]") 
	 public List<WebElement> list_costReadOnly;

	@FindBy(how = How.XPATH, using = "//div[@id=\"declaration\"]//div[contains(@class,'bgp-radio-readonly')]") 
	 public List<WebElement> list_declareReadOnly;

	@FindBy(how = How.ID, using = "react-declaration-info_truthfulness_check") 
	 public WebElement chkBx_declareConsent;
	
	@FindBy(how = How.ID, using = "submit-btn") 
	 public WebElement btn_submitForm;
	
	@FindBy(how = How.XPATH, using = "//section[@class=\"card\"]/descendant::h3") 
	 public WebElement lbl_successMsg;
	
	@FindBy(how = How.XPATH, using = "//td[text()=\"Ref ID:\"]/following-sibling::td") 
	 public WebElement lbl_refID;

	@FindBy(how = How.XPATH, using = "//td[text()=\"Agency Details:\"]/following-sibling::td/span") 
	 public WebElement lbl_agencyName;
	
}
