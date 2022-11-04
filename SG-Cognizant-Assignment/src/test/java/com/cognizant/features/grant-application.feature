Feature: Grant application process through Business Grant Portal

Background:
	Given I am on business grant portal landing page 
	And I click login with CorpPass to opt apply for a grant now option
	
   
Scenario: Submit an application to apply for grant
	When I login with own user details
	| S1234567A | Tan Ah Kow | BGPQEDEMO | Acceptor |
	And I select "Get New Grant" on the "My Grants" dashboard to enter the Grant Picker
	And I select a sector "IT" for my business
	And I select a development area "Bring my business overseas"
	And I select a functional area "Market Readiness Assistance" and apply for a grant
	And I click "Proceed" to enter the form 
	Then I expect an application form should consists following sections
	| Eligibility | Contact Details | Proposal | Business Impact | Cost | Declare & Review |
	# User Story 1 – Eligibility Section
	# AC 1: The section should contain questions:
	And I expect the "Eligibility" section should contain below questions
	| Is the applicant registered in Singapore? | Is the applicant's group sales turnover less than or equal to S$100m or is the applicant's group employment size less than or equal to 200? | Does the applicant have at least 30% local equity? | Are all the following statements true for this project? |
	And I expect question "Are all the following statements true for this project?" is present with below statements
	| The applicant has not started work on this project | The applicant has not made any payment to any supplier, vendor, or third party prior to applying for this grant | The applicant has not signed any contractual agreement with any supplier, vendor, or third party prior to applying for this grant |
	# AC 2: Each question can be answered Yes or No through radio buttons.
	And I expect each question in "Eligibility" section should be answered Yes or No through radio buttons
	# AC 4: Clicking the link in the warning message in AC 3 will launch a website in another window tab to the url
	# And I expect clicking the link in the warning message should launch a website in another window tab with the url "https://www.gobusiness.gov.sg/business-grants-portal-faq/get-a-grant/"	
	# AC 3: Answering No for any of the questions should display a warning message
	And I expect a warning message "The applicant may not meet the eligibility criteria for this grant. Visit FAQ page for more information on other government grants." to be displayed if any question is answered as No
	# AC 5: Clicking ‘Save’ will save the Applicant’s inputs and refreshing the page should reload the saved values.
	And I expect clicking "Save" should save applicant's input in "Eligibility" section and refreshing the page should reload the saved values
	# User Story 2 – Contact Details Section
	# AC 1: The page contains a ‘Main Contact Person’ subsection with the following inputs: Name, Job Title, Contact Number, Email, Alternate Contact Person’s Email, Mailing Address
	And I expect a "Main Contact Person" subsection with following inputs in "Contact Details" section
	| Name | Job Title | Contact No | Email | Alternate Contact Person’s Email | Mailing Address |
	#AC 2: The Mailing Address input should be able to take in a valid postal code which auto-populates the ‘Blk/Hse No.’ and ‘Street details’ from an external API (One-map).
	And I expect entering a valid postal code "542299" should auto-populate "Blk/Hse No." and "Street" details with below valid values
	| 299B | COMPASSVALE STREET |
	# AC 3: Alternatively, there should be a checkbox ‘Same as registered address in Company Profile’ which will auto-populate Mailing Address details from the Applicant’s Company Profile.
	And I expect enabling a checkbox "Same as registered address in Company Profile" should auto-populate "mailing address" details with below values
	| 650320 | 320 | BUKIT BATOK STREET 33 | 03 | 33 |
	# AC 4: The page also contains a ‘Letter of Offer Addressee’ subsection with the following inputs: Name, Job Title, Email
	And I expect a "Letter Of Offer Addressee" subsection with following inputs in "Contact Details" section
	| Name | Job Title | Email |
	And I fill "Main Contact Person" subsection with following values
	| Tan Ah Kow | Test Engineer | 12345678 | jagtapindrasen@gmail.com | indrasen.jagtap@gmail.com |
	# AC 5: There should be an option ‘ Same as main contact person’ which will populate the subsection in AC 4 with details from the ‘Main Contact Person’ in AC 1.	
	And I expect enabling a checkbox "Same as main contact person" should auto-populate "Letter Of Offer Addressee" details with below values
	| Tan Ah Kow | Test Engineer | jagtapindrasen@gmail.com |
	# AC 6: Clicking ‘Save’ will save the Applicant’s inputs and refreshing the page should reload the saved values.
	And I expect clicking "Save" should save applicant's input in "Contact Details" section and refreshing the page should reload the saved values
	# User Story 3 ( EPIC ) – Form Submission
	And I fill "Proposal" section with following values
	| Participate in Trade Fair | TODAYS_DATE | TODAYS_DATE+360d | Promoting IT services | Overseas Marketing and PR activities | Brazil | Yes |	
	And I fill "Business Impact" section with following values
	| TODAYS_DATE | 100000-1300000-2500000-3500000 | 100000-1300000-2500000-3500000 | Increase overseas sales | Publicity |
	And I fill "Cost" section with following values
	| Singapore | INTEST PTE. LTD. | download.jpg | 200000 | Rental Expenses for business | 12 | 20000 | TBC | Test Engineer | K3588417 | Foreigner | Manager | 12 | 15000 |
	# AC 2: If there are any mandatory inputs missing, a validation error should trigger and the form should redirect to the section with the missing details. An error number should also be shown in the sidebar next to the offending section.
	And I acknowledge terms in "Declare & Review" section and I expect "1" validation error and the form should redirect to the "Cost" section with the missing details if mandatory input "Name of Vendor" is missing with value "INTEST PTE. LTD."	
	# AC 1: Upon filling all mandatory inputs in all 6 form sections and clicking the ‘Review’ button in the ‘Declare and Review’ section, the Applicant should be taken to a read-only summary page.
	And I expect clicking "Review" button in "Declare & Review" section should redirect applicant to read-only summary page
	# AC 3: The read-only summary page should correctly contain all the details previously filled in each form section.
	And I expect read-only summary page should correctly contain all the details previously filled in each form section menioned below
	| Eligibility | Contact Details | Proposal | Business Impact | Cost | Declare & Review |
	# AC 4: At the bottom of the read-only summary page is a final ‘Consent and Acknowledgement’ checkbox.
	And I expect a checkbox "Consent and Acknowledgement" at the bottom of read-only summary page
	# AC 5: Once checked, the Applicant can submit the entire Application and a Success message box should be shown. The Success message box should contain an Application Ref ID and Agency details should display the receiving Agency as ‘Enterprise Singapore’.
	And  On submission of an application form I expect a success message "Your application has been submitted." with reference id and receiving agency should be "Enterprise Singapore"
	# AC 6: Upon submission, the main ‘My Grants’ dashboard should show the Application under the ‘Processing’ tab.
	And I expect "My Grants" dashboard should show the application under the "Processing" tab with project title "Participate in Trade Fair"
	