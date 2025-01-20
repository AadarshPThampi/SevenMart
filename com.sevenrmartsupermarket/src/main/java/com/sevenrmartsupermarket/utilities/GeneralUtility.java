package com.sevenrmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.github.javafaker.Number;

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
	
	public static String getRandomFirstName() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}
	
	public static String getRandomLastName() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}
	
	public static String getRandomAddress() {
		Faker faker = new Faker();
		String city=faker.address().city();
		String state= faker.address().state();
		String bNo=faker.address().buildingNumber();
		String zip=faker.address().zipCode();
		String address = bNo + city + state + zip;
		return address;
	}
	
	public static String getRandomPhoneNumber() {
		Faker faker = new Faker();
		return faker.phoneNumber().cellPhone();
	}
	
	public static String getRandomEmailId() {
		Faker faker = new Faker();
		return faker.name().lastName() + "@gmail.com";
	}
	
	

}
