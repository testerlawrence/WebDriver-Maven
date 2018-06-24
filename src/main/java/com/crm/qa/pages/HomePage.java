package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Util;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(), 'Lawrence')]")
	WebElement userNameLabelElement;

	@FindBy(xpath="//td[@class='headertable']//a[contains(text(), 'Home')]")
	WebElement homeMenuElement;
	
	@FindBy(xpath="//td[@class='headertable']//a[contains(text(), 'Calendar')]")
	WebElement calendarMenuElement;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactsMenuElement;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement dealsMenuElement;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isUserNameDisplayedInHomePage()
	{
		//driver.switchTo().frame("mainpanel");
		Util.switchToMainPanelFrame();
		return userNameLabelElement.isDisplayed();
	}
	
	public ContactsPage clickContactsLink()
	{
		//driver.switchTo().frame("mainpanel");
		Util.switchToMainPanelFrame();
		contactsMenuElement.click();
		
		return new ContactsPage();
	}
	
	public DealsPage clickDealsLink()
	{
		//driver.switchTo().frame("mainpanel");
		Util.switchToMainPanelFrame();
		dealsMenuElement.click();
		
		return new DealsPage();
	}
}