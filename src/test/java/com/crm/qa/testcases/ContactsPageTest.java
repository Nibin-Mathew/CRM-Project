package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	TestUtil util;
	ContactsPage contactspage;
	String sheetName="Contacts";

	public ContactsPageTest() {
		super();

	}
	@BeforeMethod
	public void setup() {
		initialization();
		util=new TestUtil();
		contactspage = new ContactsPage();
		loginPage = new LoginPage();
		homepage=	loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage=homepage.clickonContactslink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactspage.contactPageVerification(), "Contacts page missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactTest(){
		
		contactspage.selectContacts("NibinMathew");
	}
	
	@DataProvider
	public  Object[][] getCRMTestData(){
		
		Object data[][]=TestUtil.getTestData(sheetName);
		
		return data;
	}
	@Test(priority=3,dataProvider="getCRMTestData")
public void ValidatecreateNewContact(String fname,String Lname, String Company){
		
		contactspage.clickOnNewContactbutton();
		contactspage.createNewContact(fname, Lname, Company);
		
		
	}
		
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
