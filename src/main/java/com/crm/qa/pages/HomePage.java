package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@id='top-header-menu']/div[3]/span[1]")

	WebElement UsernameLabel;

	@FindBy(xpath = "//*[@id='main-nav']/a[3]/span")

	WebElement Contactslink;

	@FindBy(xpath = "//*[@id='main-nav']/a[5]/span")

	WebElement Dealslink;

	@FindBy(xpath = "//*[@id='main-nav']/a[6]/span")

	WebElement Tasklink;

	// initializing the constructor of page objects(driver)
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {

		return driver.getTitle();
	}
	public boolean verifyUserName(){
		return UsernameLabel.isDisplayed();
	}
	public ContactsPage clickonContactslink() {
		Contactslink.click();
		return new ContactsPage();
	}
	
	

	public DealsPage clickonDealslink() {
		Dealslink.click();
		return new DealsPage();
	}

	public TasksPage clickonTaskslink() {
		Tasklink.click();
		return new TasksPage();
	}
	
	
}
