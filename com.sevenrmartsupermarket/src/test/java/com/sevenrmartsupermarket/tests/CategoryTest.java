package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.CategoryPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class CategoryTest extends Base{

	LoginPage loginpage;
	HomePage homepage;
	CategoryPage categorypage;
	
	@Test
	public void verifyCategoryDeleteFromTable() {
		loginpage = new LoginPage(driver);
		homepage=new HomePage(driver);
		categorypage=new CategoryPage(driver);
		loginpage.login();
		homepage.clickOnTile("Category");
		String resultMessage=categorypage.deleteCategoryFromTable();
		String s[]=resultMessage.split("\n");
		String actualResult=s[2];
		String expectedResult ="Category Deleted Successfully";
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void verifyNewCategoryEntry() {
		loginpage = new LoginPage(driver);
		homepage=new HomePage(driver);
		categorypage=new CategoryPage(driver);
		loginpage.login();
		homepage.clickOnTile("Category");
		String categoryName="iphone Series"+ GeneralUtility.getTimeStamp();
		String path= "E:\\OBSQURA\\Iphone_Image.jpg";
		String resultMessage=categorypage.addNewCategory(categoryName,path);
		String s[]=resultMessage.split("\n");
		String actualResult=s[2];
		String expectedResult ="Category Created Successfully";
		Assert.assertEquals(actualResult, expectedResult);
	}
	
}
