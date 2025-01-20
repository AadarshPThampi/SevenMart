package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.dataproviders.DataProviders;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUsersTest extends Base{
	
	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminuserspage;
	PageUtility pageutility;
	
	@Test(dataProvider = "New User Credentials",dataProviderClass = DataProviders.class)
	public void verifyNewUserCreationAlert(String user, String password, String userType) {
		loginpage = new LoginPage(driver);
		homepage=new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login();
		homepage.clickOnTile("Admin Users");
		String alert= adminuserspage.createNewUsers(user, password, userType);
		String s[]=alert.split("\n");
		String actualAlert= s[2];
		String expectedAlert="User Created Successfully";
		Assert.assertEquals(actualAlert, expectedAlert);
	}
	
	@Test(dataProvider = "Delete User Credentials",dataProviderClass = DataProviders.class, dependsOnMethods= "verifyNewUserCreationAlert")
	public void verifyUserDeleteAlert(String users) {
		loginpage = new LoginPage(driver);
		homepage=new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login();
		homepage.clickOnTile("Admin Users");
		String alert=adminuserspage.deleteExistingUsers(users);
		String s[]=alert.split("\n");
		String actualAlert= s[2];
		String expectedAlert="User Deleted Successfully";
		Assert.assertEquals(actualAlert, expectedAlert);
	}
	
	@Test
	public void verifyAdminUserCreation() {					
		loginpage = new LoginPage(driver);
		homepage=new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		pageutility=new PageUtility(driver);
		loginpage.login();
		homepage.clickOnTile("Admin Users");
		String user=GeneralUtility.getRandomFirstName();
		String password=GeneralUtility.getRandomLastName();
		String userType="admin";
		adminuserspage.createNewAdminUser(user, password, userType);
		homepage.userLogout();
		loginpage.login(user, password);
		Assert.assertEquals(homepage.getProfileName(), user);
	}
}
