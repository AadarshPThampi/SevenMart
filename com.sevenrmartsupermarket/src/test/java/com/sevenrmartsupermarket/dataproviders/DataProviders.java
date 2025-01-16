package com.sevenrmartsupermarket.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class DataProviders {
	ExcelReader excelreader = new ExcelReader();

	@DataProvider(name="New User Credentials")	
	public Object[][] newLoginCredentials()
	{
		excelreader.setExcelFile("LoginData", "logSheet");
		return excelreader.getMultiDimentionalData(4, 3);
	
	}
	
	@DataProvider(name="Delete User Credentials")	
	public Object[][] deleteLoginCredentials()
	{
		return new Object [][] {{"Staff01"},{"Admin02"},{"Partner03"},{"Boy04"}}; 
	
	}
}