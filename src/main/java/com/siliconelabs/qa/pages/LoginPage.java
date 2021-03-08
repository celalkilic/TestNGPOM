package com.siliconelabs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.siliconelabs.qa.base.BasePage;
import com.siliconelabs.qa.utilities.ElementUtil;

public class LoginPage extends BasePage {
	
	ElementUtil elementUtil;
	
	// locators
	@FindBy(id = "txtUsername")
	WebElement username;

	@FindBy(id = "txtPassword")
	WebElement password;

	@FindBy(id = "btnLogin")
	WebElement loginBtn;

	@FindBy(id = "spanMessage")
	WebElement invalidMessage;

	// Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
		elementUtil = new ElementUtil();
	}

	// Page actions
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}

	public String verifyInvalidLogin() {
		return elementUtil.doGetText(invalidMessage);
	}
	
	public HomePage doLogin(String user, String pass) {
		elementUtil.doSendText(username, user);
		elementUtil.doSendText(password, pass);
		elementUtil.doClick(loginBtn);
		return new HomePage();
	}
	

}
