package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[1]/div")
	WebElement Contactlabel;

	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[2]/div/a/button/i")
	WebElement NewContactbutton;

	// Create New Contact page
	@FindBy(name = "first_name")
	WebElement Firstname;
	
	@FindBy(name = "last_name")
	WebElement Lastname;
	
	@FindBy(xpath = "//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement Company;
	
	@FindBy(css = "#dashboard-toolbar > div.ui.right.secondary.pointing.menu.toolbar-container > div > button.ui.linkedin.button")
	WebElement SaveButton;
	// initializing the constructor of page objects(driver)
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean contactPageVerification() {
		return Contactlabel.isDisplayed();
	}

	public void selectContacts(String name) {

		System.out.println(name);

	}

	public void clickOnNewContactbutton() {
		NewContactbutton.click();
	}

	public void createNewContact(String fname, String lname, String comp) {

		Firstname.sendKeys(fname);
		Lastname.sendKeys(lname);
		Company.sendKeys(comp);
		SaveButton.click();
	}
}
