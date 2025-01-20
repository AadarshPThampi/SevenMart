package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

public class HomeTest extends Base{

	HomePage homepage;
	LoginPage loginpage;
	
	@Test(groups = "smoke")
	public void verifyUserLogout() {			
		loginpage = new LoginPage(driver);
//		homepage=new HomePage(driver);
		homepage=loginpage.login();
		homepage.userLogout();
		Assert.assertTrue(loginpage.isSignInButtonDisplayed());
	}
	
	
}
