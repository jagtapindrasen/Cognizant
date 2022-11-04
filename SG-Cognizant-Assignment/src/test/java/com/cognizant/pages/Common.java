package com.cognizant.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cognizant.step_defs.AbstractBase;

public class Common {

	WebDriver driver;
	AbstractBase base;
	
	static int PAGE_LOAD_TIMEOUT = 20;
	static int IMPLICIT_WAIT = 30;
	
	String refID;
	
	public Common(AbstractBase base) {
		this.base = base;
		this.driver = base.getDriver();
	}

	public void navigateToPage(String url) {
		driver.get(url);
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
	
	public void performAndWait(String operation, WebElement element,String input, long ms) 
	{
		switch(operation.toLowerCase())
		{
			case "sendkeys": 
				element.sendKeys(input);
				break;
			case "click":
				element.click();
				break;
			case "clear":
				element.clear();
				break;
		}
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getTodaysDate(String format)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		LocalDate localDate = LocalDate.now();
		return dtf.format(localDate).toString();				
	}
	
	public String getFormattedDate(String format, String interval, int num) 
	{
	    Calendar cal = Calendar.getInstance();		 
		cal.setTime(new Date());
		if(!interval.isEmpty())
		{
			if(interval.equalsIgnoreCase("d"))
				cal.add(Calendar.DATE, num); // increment the days
			else if(interval.equalsIgnoreCase("m"))
				cal.add(Calendar.MONTH, num); //increment the months
			else if(interval.equalsIgnoreCase("y"))
				cal.add(Calendar.YEAR, num); //increment the year
		}
	    SimpleDateFormat format1 = new SimpleDateFormat(format);
	    return format1.format(cal.getTime()); 
	}
	
	public void uploadFile(String file)
	{
		StringSelection ss = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
