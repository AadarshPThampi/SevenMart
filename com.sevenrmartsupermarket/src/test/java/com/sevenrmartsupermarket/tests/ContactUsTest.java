package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.ContactUsPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ContactUsTest extends Base{

	LoginPage loginpage;
	HomePage homepage;
	ContactUsPage contactuspage;
	PageUtility pageutility;
	
	@Test
	public void verifyContactEditAlert() {
		loginpage = new LoginPage(driver);
		homepage=new HomePage(driver);
		contactuspage=new ContactUsPage(driver);
		loginpage.login();
		homepage.clickOnTile("Manage Contact");
		String phone = GeneralUtility.getRandomPhoneNumber();
		String email = GeneralUtility.getRandomEmailId();
		String address = GeneralUtility.getRandomAddress();
		String time="25";
		String charge="400";		
		contactuspage.editContactDetails(phone, email, address, time, charge);
		String resultMessage=contactuspage.getAlertMessage();
		String s[]=resultMessage.split("\n");
		String actualResult=s[2];
		String expectedResult ="Contact Updated Successfully";
		Assert.assertEquals(actualResult, expectedResult);
	}
	
}
