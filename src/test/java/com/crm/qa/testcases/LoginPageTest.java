package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void testLoginPageTitle()
	{
		Assert.assertEquals(loginPage.getLoginPageTitle(), "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority=2)
	public void testCRMLogoInLoginPage()
	{
		Assert.assertEquals(loginPage.isCRMLogoDisplayed(), true);
	}
	
	@Test(priority=3)
	public void testLogin()
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.isUserNameDisplayedInHomePage());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}