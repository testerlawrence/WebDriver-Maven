package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class Util extends TestBase {
	
	public static void switchToMainPanelFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
}