package com.cognizant.pages;

import static org.junit.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.elements.LandingPageElements;
import com.cognizant.step_defs.AbstractBase;

public class LandingPage {
	
	WebDriver driver;
	AbstractBase base;
	LandingPageElements homeElements;
	
	public LandingPage(AbstractBase base) {
		this.base = base;
		this.driver = base.getDriver();
		homeElements = new LandingPageElements(this.driver);
	}
	
	public void clickLoginWithCorpPass() throws InterruptedException
	{
		if(!homeElements.btn_loginCorpPass.isDisplayed())
			fail("Login with CorpPass button not displayed on home page");
		else
			homeElements.btn_loginCorpPass.click();
		Thread.sleep(20000);
	}
	
	public void redirectToLandingPage()
	{
//		String urlPart[] = base.getLandingPageURL().split("//");
//		String landingPageUrl = urlPart[0]+"//"+base.getPortalCredentials()+"@"+urlPart[1];
//		driver.get(landingPageUrl);
		

		driver.get(base.getLandingPageURL());
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		//identify element
//	      WebElement m = driver.findElement(By.xpath("(//*[@id=\"signInFormUsername\"])[1]"));
//	      //JavascriptExecutor to click element
//	      JavascriptExecutor jse = (JavascriptExecutor) driver;
//	      jse.executeScript("arguments[0].value='temp-cognizant';", m);
//	      
//	      WebElement m1 = driver.findElement(By.xpath("(//*[@id=\"signInFormPassword\"])[1]"));
//	      //JavascriptExecutor to click element
//	      JavascriptExecutor jse1 = (JavascriptExecutor) driver;
//	      jse1.executeScript("arguments[0].value='bgPB3Aw3SomeCogF@lk!';", m1);
//	      
//	      WebElement m2 = driver.findElement(By.xpath("(//*[@id=\"signInFormPassword\"])[1]"));
//	      //JavascriptExecutor to click element
//	      JavascriptExecutor jse2 = (JavascriptExecutor) driver;
//	      jse2.executeScript("arguments[0].click();", m2);
	
//		driver.findElement(By.xpath("(//*[@id=\"signInFormUsername\"])[1]")).click();
//		driver.findElement(By.xpath("(//*[@id=\"signInFormUsername\"])[1]")).clear();
//		driver.findElement(By.xpath("(//*[@id=\"signInFormUsername\"])[1]")).sendKeys("temp-cognizant");
//		driver.findElement(By.xpath("(//*[@id=\"signInFormPassword\"])[1]")).sendKeys("bgPB3Aw3SomeCogF@lk!");
//        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/input[3]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 60); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[1]/input")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[1]/input")).sendKeys("temp-cognizant");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[2]/input")).sendKeys("bgPB3Aw3SomeCogF@lk!");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/input[3]")).click();

	}
	
	public void enter_Text(String inputText) {
		homeElements.txtbx_enterText.sendKeys(inputText);
	}
	
	public void submit_Text() {
		homeElements.btn_Submit.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verify_Results(String expectedResult) {
		String actualResult = homeElements.lbl_ResultText.getText();
		if (!expectedResult.equals(actualResult)) {
			fail("Actual date parsing result is incorrect : " + actualResult);
		}
	}
	
	public void verifyKeys(String key, String value)
	{
		String errMsg = "";
		WebElement element = null;
		
		if(key.equalsIgnoreCase("title"))
		{
			element = homeElements.lbl_Title;
			errMsg = "Title : " + value + " is not displayed on the home page";			
		}
		else if(key.equalsIgnoreCase("informative-message"))
		{
			element = homeElements.lbl_Message;
			errMsg = "Informative message : " + value + " is not displayed on the home page";
		}

		String actualResult = element.getText();
		if (!value.equals(actualResult)) {
			fail(errMsg);
		}
	}
	
	public void verifyUIComponents(String comp1,String comp2,String comp3,String comp4)
	{
		if(comp1.equalsIgnoreCase("Date-label"))
		{
			if(!homeElements.lbl_Date.isDisplayed())
				fail("Label Date is not present on the home page");
		}
		if(comp2.equalsIgnoreCase("text-field"))
		{
			if(!homeElements.txtbx_enterText.isDisplayed())
				fail("Textfield to accept input is not present on the home page");
		}
		if(comp3.equalsIgnoreCase("submit-button"))
		{
			if(!homeElements.btn_Submit.isDisplayed())
				fail("Submit button is not present on the home page");
		}
		if(comp4.equalsIgnoreCase("Results-label"))
		{
			if(!homeElements.lbl_Results.isDisplayed())
				fail("Label Results is not present on the home page");
		}
	}
	
	public void verify_DefaultResult(String expectedResult)
	{
		if(!homeElements.lbl_ResultText.getText().equalsIgnoreCase(expectedResult))
			fail("Default Result is not 0 on the home page");
	}
}