package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	//HomePageTest homepagetest;
	ContactPage contactpage;
	LoginPage loginpage;
	HomePage homepage;
	String sheetName="Contacts";
	
	
	
	ContactPageTest() {
		super();// important to initialize, else intialize method will throw
				// NullPointerException
	}
	
	@BeforeMethod
	public void setup() {
		initialize();
		loginpage = new LoginPage();
		contactpage= new ContactPage();
		homepage=new HomePage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider="getCRMTestData")//priority=1,
	public void createContact(String fn,String ln){
		
		homepage.verifyContactPage();
		//contactpage.addContacts("Ajati", "Rawati");
		contactpage.addContacts(fn, ln);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}	

}
