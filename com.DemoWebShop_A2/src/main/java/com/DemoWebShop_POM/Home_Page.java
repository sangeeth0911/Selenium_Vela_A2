package com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement logOutBtn;

	@FindBy(xpath = "//a[text()='Addresses']")
	private WebElement addressesBtn;

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	public WebElement getAddressesBtn() {
		return addressesBtn;
	}

}
