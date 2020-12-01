package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
	
//page Factory -OR;
	
	@FindBy(css="body > div.page > header > div > nav > div.rd-navbar-inner > div > div.rd-navbar-nav-wrap.toggle-original-elements > ul > a")
	/* @CacheLookup //WebElement will be stored in the cache memory and improves script performance*/
	WebElement WelcomeLogin;
	
	@FindBy(name="email")

	WebElement username;
	
	@FindBy(name="password")

	WebElement Password;
	
	@FindBy(css="#ui > div > div > form > div > div.ui.fluid.large.blue.submit.button")
	@CacheLookup
	WebElement Loginbutton;
	
	@FindBy(linkText="https://api.cogmento.com/register")

	WebElement SignUplink;
	
	@FindBy(css="a.brand-name")

	WebElement Headerlogo;
	
	//initializing the constructor of page objects(driver)
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String ValidateLoginTitle(){
		return driver.getTitle();
	}
	
	public boolean ValidateCRMImage(){
		return Headerlogo.isDisplayed();
	}
	
	//Return Home Page object **Chaining of pages
	public HomePage Login(String us, String pwd){
		WelcomeLogin.click();
		if(username.isDisplayed()){
			username.clear();
			username.sendKeys(us);
			username.clear();
			Password.sendKeys(pwd);
			Loginbutton.click();	
		}
		return new HomePage();
		
	}
	
}
