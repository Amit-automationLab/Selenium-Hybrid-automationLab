package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

//Login page factory-ObjectRepository
public class LoginPage extends TestBase {
	
	
	// driver.findelementbyName-write this syntax below is it's substitute

	@FindBy(name = "email")
	WebElement EmailTxtBx;

	@FindBy(name = "password")
	WebElement PwdTxtBx;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement LoginBtn2;

	@FindBy(xpath = "//main/section/h2")
	WebElement Label;
	
	@FindBy(xpath = "//*[text() = 'Log In']")
	WebElement LoginBtn1;

	// How to initialize PageFactory

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions on the page element

	public String validatePage() {

		return driver.getTitle();

	}
	
	public String validateLabel() {

		return Label.getText();

	}

	public HomePage login(String un, String pwd) {
		
		LoginBtn1.click();
		EmailTxtBx.sendKeys(un);
		PwdTxtBx.sendKeys(pwd);
		LoginBtn2.click();
		return new HomePage();

	}

}
 