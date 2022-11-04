$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/cognizant/features/grant-application.feature");
formatter.feature({
  "name": "Grant application process through Business Grant Portal",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on business grant portal landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "GrantApplicationSteps.redirect_ToLandingPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click login with CorpPass to opt apply for a grant now option",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.click_LoginWithCorpPass()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Submit an application to apply for grant",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I login with own user details",
  "rows": [
    {
      "cells": [
        "S1234567A",
        "Tan Ah Kow",
        "BGPQEDEMO",
        "Acceptor"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "GrantApplicationSteps.login_WithUserDetails(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select \"Get New Grant\" on the \"My Grants\" dashboard to enter the Grant Picker",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.select_dashboardOptions(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select a sector \"IT\" for my business",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.select_businessSector(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select a development area \"Bring my business overseas\"",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.select_developmentArea(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select a functional area \"Market Readiness Assistance\" and apply for a grant",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.select_functionalArea(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click \"Proceed\" to enter the form",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.click_ProceedToEnterForm(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect an application form should consists following sections",
  "rows": [
    {
      "cells": [
        "Eligibility",
        "Contact Details",
        "Proposal",
        "Business Impact",
        "Cost",
        "Declare \u0026 Review"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_applicationFormSections(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect the \"Eligibility\" section should contain below questions",
  "rows": [
    {
      "cells": [
        "Is the applicant registered in Singapore?",
        "Is the applicant\u0027s group sales turnover less than or equal to S$100m or is the applicant\u0027s group employment size less than or equal to 200?",
        "Does the applicant have at least 30% local equity?",
        "Are all the following statements true for this project?"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_contactDetailsQuestions(String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect question \"Are all the following statements true for this project?\" is present with below statements",
  "rows": [
    {
      "cells": [
        "The applicant has not started work on this project",
        "The applicant has not made any payment to any supplier, vendor, or third party prior to applying for this grant",
        "The applicant has not signed any contractual agreement with any supplier, vendor, or third party prior to applying for this grant"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_questionStatements(String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect each question in \"Eligibility\" section should be answered Yes or No through radio buttons",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_questionAnswers(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect a warning message \"The applicant may not meet the eligibility criteria for this grant. Visit FAQ page for more information on other government grants.\" to be displayed if any question is answered as No",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_warningMsg(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect clicking \"Save\" should save applicant\u0027s input in \"Eligibility\" section and refreshing the page should reload the saved values",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.save_inputAndReload(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect a \"Main Contact Person\" subsection with following inputs in \"Contact Details\" section",
  "rows": [
    {
      "cells": [
        "Name",
        "Job Title",
        "Contact No",
        "Email",
        "Alternate Contact Person�s Email",
        "Mailing Address"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_inputsInContactDetails(String,String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect entering a valid postal code \"542299\" should auto-populate \"Blk/Hse No.\" and \"Street\" details with below valid values",
  "rows": [
    {
      "cells": [
        "299B",
        "COMPASSVALE STREET"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_autoPopulateDetails(String,String,String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect enabling a checkbox \"Same as registered address in Company Profile\" should auto-populate \"mailing address\" details with below values",
  "rows": [
    {
      "cells": [
        "650320",
        "320",
        "BUKIT BATOK STREET 33",
        "03",
        "33"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_autoPopulatedMailingDetails(String,String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect a \"Letter Of Offer Addressee\" subsection with following inputs in \"Contact Details\" section",
  "rows": [
    {
      "cells": [
        "Name",
        "Job Title",
        "Email"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_inputsInContactDetails(String,String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I fill \"Main Contact Person\" subsection with following values",
  "rows": [
    {
      "cells": [
        "Tan Ah Kow",
        "Test Engineer",
        "12345678",
        "jagtapindrasen@gmail.com",
        "indrasen.jagtap@gmail.com"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.enter_mainContactPersonDetails(String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect enabling a checkbox \"Same as main contact person\" should auto-populate \"Letter Of Offer Addressee\" details with below values",
  "rows": [
    {
      "cells": [
        "Tan Ah Kow",
        "Test Engineer",
        "jagtapindrasen@gmail.com"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_autoPopulatedMailingDetails(String,String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect clicking \"Save\" should save applicant\u0027s input in \"Contact Details\" section and refreshing the page should reload the saved values",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.save_inputAndReload(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I fill \"Proposal\" section with following values",
  "rows": [
    {
      "cells": [
        "Participate in Trade Fair",
        "TODAYS_DATE",
        "TODAYS_DATE+360d",
        "Promoting IT services",
        "Overseas Marketing and PR activities",
        "Brazil",
        "Yes"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.enter_requiredDetailsinGivenSection(String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I fill \"Business Impact\" section with following values",
  "rows": [
    {
      "cells": [
        "TODAYS_DATE",
        "100000-1300000-2500000-3500000",
        "100000-1300000-2500000-3500000",
        "Increase overseas sales",
        "Publicity"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.enter_requiredDetailsinGivenSection(String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I fill \"Cost\" section with following values",
  "rows": [
    {
      "cells": [
        "Singapore",
        "INTEST PTE. LTD.",
        "download.jpg",
        "200000",
        "Rental Expenses for business",
        "12",
        "20000",
        "TBC",
        "Test Engineer",
        "K3588417",
        "Foreigner",
        "Manager",
        "12",
        "15000"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.enter_requiredDetailsinGivenSection(String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I acknowledge terms in \"Declare \u0026 Review\" section and I expect \"1\" validation error and the form should redirect to the \"Cost\" section with the missing details if mandatory input \"Name of Vendor\" is missing with value \"INTEST PTE. LTD.\"",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.declare_acknowledgeTerms(String,String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect clicking \"Review\" button in \"Declare \u0026 Review\" section should redirect applicant to read-only summary page",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.redirect_ToSummaryPage(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect read-only summary page should correctly contain all the details previously filled in each form section menioned below",
  "rows": [
    {
      "cells": [
        "Eligibility",
        "Contact Details",
        "Proposal",
        "Business Impact",
        "Cost",
        "Declare \u0026 Review"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_summaryPage(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect a checkbox \"Consent and Acknowledgement\" at the bottom of read-only summary page",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_checkboxInSummaryPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "On submission of an application form I expect a success message \"Your application has been submitted.\" with reference id and receiving agency should be \"Enterprise Singapore\"",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_detailsOnFormSubmission(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect \"My Grants\" dashboard should show the application under the \"Processing\" tab with project title \"Participate in Trade Fair\"",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_applicationUnderProcessing(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on business grant portal landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "GrantApplicationSteps.redirect_ToLandingPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click login with CorpPass to opt apply for a grant now option",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.click_LoginWithCorpPass()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify non submitted application in Drafts tab",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I login with own user details",
  "rows": [
    {
      "cells": [
        "S1234567A",
        "Tan Ah Kow",
        "BGPQEDEMO",
        "Acceptor"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "GrantApplicationSteps.login_WithUserDetails(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select \"Get New Grant\" on the \"My Grants\" dashboard to enter the Grant Picker",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.select_dashboardOptions(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select a sector \"IT\" for my business",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.select_businessSector(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select a development area \"Bring my business overseas\"",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.select_developmentArea(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select a functional area \"Market Readiness Assistance\" and apply for a grant",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.select_functionalArea(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click \"Proceed\" to enter the form",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.click_ProceedToEnterForm(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I fill \"Proposal\" section with following values",
  "rows": [
    {
      "cells": [
        "Participate in Murex Fair",
        "TODAYS_DATE",
        "TODAYS_DATE+360d",
        "Promoting marketing services",
        "Overseas Marketing and PR activities",
        "Brazil",
        "Yes"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.enter_requiredDetailsinGivenSection(String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect \"My Grants\" dashboard should show the application under the \"Drafts\" tab with project title \"Participate in Murex Fair\"",
  "keyword": "And "
});
formatter.match({
  "location": "GrantApplicationSteps.verify_applicationUnderProcessing(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});