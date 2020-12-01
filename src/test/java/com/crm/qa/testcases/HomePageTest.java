package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	TestUtil util;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();

	}
//Test cases should be separated--independent with each other
	//before each Testcases--launch the browser and login
	//@test--execute test case
	//after each test case --close the browser
	
	@BeforeMethod
	public void setup() {
		initialization();
		contactspage = new ContactsPage();
		loginPage = new LoginPage();
		homepage=	loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));

	}
@Test(priority=1)
public void verifyHomePageTitleTest(){
	String HomepageTitle=homepage.verifyHomePageTitle();
	Assert.assertEquals(HomepageTitle, "Cogmento CRM","HomePage Title not matched");
	
}
@Test(priority=2)
public void verifyUserNameTest(){
	Assert.assertTrue(homepage.verifyUserName());
}

@Test(priority=3)
public void verifyContactlinkTest(){
	contactspage=homepage.clickonContactslink();
}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


