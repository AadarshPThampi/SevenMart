package com.sevenrmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

public class GeneralUtility {

	public String getAttribute(WebElement element, String attribute)
	{
		return element.getAttribute(attribute);
	}
		
	public String getCSSValue(WebElement element, String property)
	{
		return element.getCssValue(property);
	}

	public List<String> getTextOfAllElements(List<WebElement> elements)
	{
		List<String> data = new ArrayList<String>();	//declaring List to store String returned by gettext() method.
		
		for(WebElement element: elements)
		{
			data.add(element.getText());
		}
		return data;
	}
	
	public static String getTimeStamp() {
		String timeStamp =new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
	}
}
