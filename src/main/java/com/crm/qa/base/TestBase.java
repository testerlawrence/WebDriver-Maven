package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;

	public TestBase()
	{
		prop = new Properties();
		FileInputStream ip = null;
		
		try
		{
			ip = new FileInputStream("./src/main/java/com/crm/qa/config/config.properties");
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			prop.load(ip);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialize()
	{
		String browser = prop.getProperty("browser");		
		if(browser.equals("Chrome"))
		{
			// let the system know about the location of chrome driver
			//System.setProperty("webdriver.chrome.driver", "D:\\Lawrence\\Software\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome_driver_location"));
			
			// RemoteWebDriver implements WebDriver
			// ChromeDriver extends RemoteWebDriver
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("page_load_timeout")), TimeUnit.SECONDS);
		// This is dynamic wait.
		// Once the page is loaded within the specified time, remaining time will be ignored and next statement gets executed.
		// If the page is not loaded within the specified time, exception will be thrown.
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicit_wait_timeout")), TimeUnit.SECONDS);
		// This is dynamic wait.
		// System will wait for the specified time, before throwing ElementNotFoundException.
		// This is global timeout for all elements.
		// Example: Karnataka is selected in State drop box. The values in City drop box will take some time to load.
		// Once the element is found within the specified time, remaining time will be ignored and next statement gets executed.
		
		//driver.get("https://www.wikipedia.org/");
		driver.get(prop.getProperty("url"));
	}
}