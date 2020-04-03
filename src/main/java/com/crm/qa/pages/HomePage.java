package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@id='main-nav']/a/i[@class='home icon']")
	WebElement HomeIcn;

	@FindBy(xpath = "//div[@id='main-nav']/a/i[@class='calendar icon']")
	WebElement CalendarIcn;

	@FindBy(xpath = "//div[@id='main-nav']/a/i[@class='users icon']")
	WebElement ContactIcn;
	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement ContactHeader;

	@FindBy(xpath = "//div[@id='main-nav']/a/i[@class='building icon']")
	WebElement CompaniesIcn;

	@FindBy(xpath = "//div[@id='main-nav']/a/i[@class='money icon']")
	WebElement DealsIcn;

	@FindBy(xpath = "//div[@id='main-nav']/a/i[@class='tasks icon']")
	WebElement TasksIcn;

	@FindBy(xpath = "//div[@id='main-nav']/a/i[@class='comments icon']")
	WebElement CasesIcn;
	
	@FindBy(xpath = "//span[@class='user-display']")
	WebElement UserName;

	// How to initialize PageFactory

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions on the page element

	public String validatePage() {

		return driver.getTitle();
		// Cogmento CRM

	}
	
	public String getUsername() {

		return UserName.getText();
		// Cogmento CRM

	}

	public CalendarPage verifyCalendarPage() {
		CalendarIcn.isDisplayed();
		CalendarIcn.click();
		return new CalendarPage();
		
		//return new CalendarPage();
		// Cogmento CRM

	}
	public String verifyContactPage() {
		
		ContactIcn.isDisplayed();
		ContactIcn.click();
		ContactHeader.isDisplayed();
		String head=ContactHeader.getText();
		return head;
	}
	public CompaniesPage verifyCompaniesPage() {

		CompaniesIcn.click();
		return new CompaniesPage();
		// Cogmento CRM

	}
	public DealsPage verifyDealsPage() {

		DealsIcn.click();
		return new DealsPage();
		// Cogmento CRM

	}
	public TasksPage verifyTasksPage() {

		TasksIcn.click();
		return new TasksPage();
		// Cogmento CRM

	}
	public CasesPage verifyCasesPage() {

		CasesIcn.click();
		return new CasesPage();
		// Cogmento CRM

	}

}
