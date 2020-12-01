package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.Assert;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;

	public LoginPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();

	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String Title = loginPage.ValidateLoginTitle();
	Assert.assertEquals(Title, driver.getTitle().contains("Free CRM customer"));
	}

	@Test(priority=2)
	public void crmLogoImageTest() {

		boolean flag = loginPage.ValidateCRMImage();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void LoginTest() {
//Transfer control to Login function in Login page
		homepage=	loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
