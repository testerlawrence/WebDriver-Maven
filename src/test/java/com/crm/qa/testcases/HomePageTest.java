package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void testHomePageTitle()
	{
		Assert.assertEquals(homePage.getHomePageTitle(), "CRMPRO");
	}
	
	@Test(priority=2)
	public void testUserNameLabel()
	{
		Assert.assertEquals(homePage.isUserNameDisplayedInHomePage(), true);
	}
	
	@Test(priority=3)
	public void testContactsLink()
	{
		contactsPage = homePage.clickContactsLink();
		Assert.assertTrue(contactsPage.isContactsLabelAvailable());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}