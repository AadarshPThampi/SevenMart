package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

public class LoginTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
		
	@Test(retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyAdminLogin()
	{
		loginpage = new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login();
		String actualProfileName=homepage.getProfileName();
		String expectedProfileName="Admins";
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}
	
	@Test(groups="smoke")
	public void verifyInvalidUserNameAlert() {
		loginpage = new LoginPage(driver);
		loginpage.login("user", "admin");
		Assert.assertTrue(loginpage.checkInvalidLoginAlert());
	}
	
	@Test(groups="smoke")
	public void verifyInvalidPasswordAlert() {
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "1234");
		Assert.assertTrue(loginpage.checkInvalidLoginAlert());
	}
	
	@Test(groups = {"smoke", "regression"})
	public void verifySignInButtonIsEnabled() {
		loginpage = new LoginPage(driver);
		Assert.assertTrue(loginpage.isSignInButtonEnabled());
	}
	
	@Test(groups = {"smoke", "regression"})
	public void verifyRememberMeCheckBoxIsEnabled() {
		loginpage = new LoginPage(driver);
		Assert.assertTrue(loginpage.isRememberMeCheckBoxEnabled());
	}
	
	@Test(groups = {"smoke", "regression"})
	public void verifySignInButtonIsDisplayed() {
		loginpage = new LoginPage(driver);
		Assert.assertTrue(loginpage.isSignInButtonDisplayed());
	}
	
	@Test(groups =  "regression")
	public void verifyRememberMeCheckBoxIsDisplayed() {			
		loginpage = new LoginPage(driver);
		Assert.assertTrue(loginpage.isRememberMeCheckBoxDisplayed());
	}
	
	@Test(groups = "regression")
	public void verifyLoginOptionsAreAvailable() {
		loginpage = new LoginPage(driver);
		Assert.assertTrue(loginpage.isLoginOptionsAvailable());
	}
	
}
