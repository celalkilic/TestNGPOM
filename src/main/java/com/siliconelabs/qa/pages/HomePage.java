package com.siliconelabs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.siliconelabs.qa.base.BasePage;
import com.siliconelabs.qa.utilities.ElementUtil;

public class HomePage extends BasePage{
	
	ElementUtil elementUtil;
	
	@FindBy(xpath = "//*[@id='content']//h1")
	WebElement dashboard;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		elementUtil = new ElementUtil();
	}
	
	public String verifyHeader() {
		elementUtil.waitForElementVisible(dashboard);
		return elementUtil.doGetText(dashboard);
	}
	
}
