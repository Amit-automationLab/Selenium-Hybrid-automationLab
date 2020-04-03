package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	@FindBy(xpath = "//button[text()='New']")
	WebElement NewBtn;
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement LastName;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement SaveBtn;
	
	@FindBy(xpath = "//i[@class='large user red icon']")
	WebElement UserIcn;
	
	
	/*
	@FindBy(xpath = "//a/button")
	WebElement NewBtn;
	
	@FindBy(xpath = "//a/button")
	WebElement NewBtn;*/

	// How to initialize PageFactory

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean addContacts(String FN,String LN){
		NewBtn.click();
		FirstName.sendKeys(FN);
		LastName.sendKeys(LN);
		SaveBtn.click();
		return UserIcn.isDisplayed();
		
	}
	
}
