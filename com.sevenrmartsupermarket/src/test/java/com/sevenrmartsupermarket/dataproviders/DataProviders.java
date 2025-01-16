package com.sevenrmartsupermarket.dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="New User Credentials")	
	public Object[][] newLoginCredentials()
	{
		return new Object [][] {{"Staff01","passw01","staff"},{"Admin02","passw02","admin"},{"Partner03","passw03","partner"}}; 
	
	}
	
	@DataProvider(name="Delete User Credentials")	
	public Object[][] deleteLoginCredentials()
	{
		return new Object [][] {{"Staff01"},{"Admin02"},{"Partner03"}}; 
	
	}
}