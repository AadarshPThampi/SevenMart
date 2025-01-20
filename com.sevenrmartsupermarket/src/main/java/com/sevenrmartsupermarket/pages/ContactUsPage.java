package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class ContactUsPage {
	
	WebDriver driver;
	PageUtility pageutility; 
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editContactButton;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneNumField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "(//textarea[@id='content'])[1]")
	WebElement addressField;
	@FindBy(xpath = "(//textarea[@id='content'])[2]")
	WebElement delivTimeField;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement delivChargeField;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	
	public ContactUsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnEditContactButton() {
		editContactButton.click();
	}
	
	public void editContactDetails(String phone, String email, String address, String time, String charge) {
		clickOnEditContactButton();
		phoneNumField.clear();
		phoneNumField.sendKeys(phone);
		emailField.clear();
		emailField.sendKeys(email);
		addressField.clear();
		addressField.sendKeys(address);
		delivTimeField.clear();
		delivTimeField.sendKeys(time);
		delivChargeField.clear();
		delivChargeField.sendKeys(charge);
		clickUpdateContactButton();
	}
	
	public String getAlertMessage() {
		return alert.getText();
	}
	
	public void clickUpdateContactButton() {
		pageutility=new PageUtility(driver);
		pageutility.scrollAndClick(updateButton);
	}

}
