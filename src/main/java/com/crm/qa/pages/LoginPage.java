package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement crmLogoElement;
	
	@FindBy(name="username")
	WebElement usernameElement;
	
	@FindBy(name="password")
	WebElement passwordElement;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButtonElement;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isCRMLogoDisplayed()
	{
		return crmLogoElement.isDisplayed();
	}
	
	public HomePage login(String username, String password)
	{
		usernameElement.sendKeys(username);
		passwordElement.sendKeys(password);
		loginButtonElement.sendKeys(Keys.RETURN);
		return new HomePage();
	}
}