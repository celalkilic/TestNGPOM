package com.siliconelabs.qa.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.siliconelabs.qa.base.BasePage;

public class ElementUtil extends BasePage{
	
	WebDriverWait wait;
	
	public ElementUtil() {
		wait = new WebDriverWait(driver, 15);
	}
	
	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void doSendText(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some exception happened while sending keys " + element);
		}
	}
	
	public void doClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("Some exception happened while clicking " + element);
		}
	}
	
	public String doGetText(WebElement element) {
		try {
			return element.getText();
		} catch (Exception e) {
			System.out.println("Some exception happened while getting text from " + element);
			return null;
		}
	}
	
}
