package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;

	LoginPageTest() {
		super();// important to initialize, else intialize method will throw
				// NullPointerException
	}

	@BeforeMethod
	public void setup() {
		initialize();
		loginPage = new LoginPage();
	}

	@Test()
	public void titleTest() {
		String title = loginPage.validatePage();

		Assert.assertEquals("Free CRM #1 cloud software for any business large or small", title);
	}

	@Test()
	public void labelTest() {
		String label = loginPage.validateLabel();

		Assert.assertEquals("Free Customer Relationship Management", label);
	}

	@Test()
	public void loginTest() {

		// Assert.assertEquals(homepage, homepage);
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		homepage = loginPage.login(username, password);

	}

	@AfterMethod
	public void tearDow() {
		driver.quit();
	}

}