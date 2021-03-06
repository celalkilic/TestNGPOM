package com.siliconelabs.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.siliconelabs.qa.base.BasePage;
import com.siliconelabs.qa.pages.HomePage;
import com.siliconelabs.qa.pages.LoginPage;

public class LoginPageTest extends BasePage {

	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initializeDriver();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualTitle = loginPage.verifyLoginPageTitle();
		String expectedTitle = "OrangeHRM";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 2)
	public void loginTest() {
		String user = properties.getProperty("username");
		String pass = properties.getProperty("password");
		HomePage homePage = loginPage.doLogin(user, pass);
		String actualHeader = homePage.verifyHeader();
		String expectedHeader = "Dashboard";
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	@DataProvider
	public Object[][] invalidLoginData() {
		Object invalidData [][] = {
				{"Fatih", " "},
				{" ", "test123"},
				{"$#test", "6473"},
				{"123134", ".4&^32"},
				{" ", " "}
		};
		return invalidData;
	}
	
	@Test(priority = 3, dataProvider = "invalidLoginData")
	public void invalidLoginTest(String user, String pass) {
		loginPage.doLogin(user, pass);
		String actualMessage = loginPage.verifyInvalidLogin();
		Assert.assertEquals(actualMessage, "Invalid credentials");
	}

}
