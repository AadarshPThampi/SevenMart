package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageNewsPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class ManageNewsTest extends Base{

	LoginPage loginpage;
	HomePage homepage;
	ManageNewsPage managenewspage;
	ExcelReader excelreader= new ExcelReader();
			
	@Test(groups = "smoke")
	public void verifyNewNewsInput() {
		loginpage = new LoginPage(driver);
		homepage=new HomePage(driver);
		managenewspage=new ManageNewsPage(driver);
		loginpage.login();
		homepage.clickOnTile("Manage News");
		excelreader.setExcelFile("NewsData", "newsSheet");
		String data =excelreader.getCellData(1, 0);
		managenewspage.sendNews(data);
		String resultMessage=managenewspage.getAlertMessage();
		String s[]=resultMessage.split("\n");
		String actualResult=s[2];
		String expectedResult ="News Created Successfully";
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void verifyNewsDeleteFromTable() {
		loginpage = new LoginPage(driver);
		homepage=new HomePage(driver);
		managenewspage=new ManageNewsPage(driver);
		loginpage.login();
		homepage.clickOnTile("Manage News");
		managenewspage.deleteNewsFromTable();
		String resultMessage= managenewspage.getAlertMessage();
		String s[]=resultMessage.split("\n");
		String actualResult=s[2];
		String expectedResult ="News Deleted Successfully";
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Test
	public void verifyNewsEditInTable() {
		loginpage = new LoginPage(driver);
		homepage=new HomePage(driver);
		managenewspage=new ManageNewsPage(driver);
		loginpage.login();
		homepage.clickOnTile("Manage News");
		managenewspage.editNewsInTable("New news of 2025");
		String resultMessage= managenewspage.getAlertMessage();
		String s[]=resultMessage.split("\n");
		String actualResult=s[2];
		String expectedResult ="News Updated Successfully";
		Assert.assertEquals(actualResult, expectedResult);
	}
}
