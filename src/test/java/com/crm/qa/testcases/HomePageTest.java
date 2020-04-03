package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	CalendarPage calendarpage;
	
	//String un=TestBase.prop.getProperty("username");
	//String pwd=TestBase.prop.getProperty("password");
	
	
	Logger log=Logger.getLogger(HomePageTest.class);
	
	HomePageTest() {
		super();// important to initialize, else intialize method will throw
				// NullPointerException
	}
	
	
	
	@BeforeMethod
	public void setup() {
		initialize();
		loginPage = new LoginPage();
		homepage = new HomePage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test()//priority=1
	public void verifyHomePage() {
		String title=homepage.validatePage();
		log.info("verifyHomePage");
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	@Test()
	public void navCalendarPage() {
		homepage.verifyCalendarPage();
		
	}
	@Test()
	public void verifyUserName() {
		String un=homepage.getUsername();
		Assert.assertEquals("Amit Singh", un);
		
	}
	@Test()
	public void navContactPage() {
		String header=homepage.verifyContactPage();
		Assert.assertEquals(header, "Contacts");
		//return new ContactPage();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
}
