package com.sevenrmartsupermarket.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;


public class AdminUsersPage {

	WebDriver driver;
	PageUtility pageutility;
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeSelectDropdown;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement userSearchButton;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement userSearchField;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement subSearchButton;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	private WebElement userDeleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteSuccessAlert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;
	
	public  AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewUserButton() {
		newButton.click();
	}
	
	public void clickOnUserSearchButton() {
		userSearchButton.click();
	}
	
	public String createNewUser(String user, String password, String userType) {
		clickOnNewUserButton();
		userNameField.sendKeys(user);
		passwordField.sendKeys(password);
		pageutility=new PageUtility(driver);
		pageutility.selectByValue(userTypeSelectDropdown, userType);
		saveButton.click();
		return  successAlert.getText();
	}
	
	public String deleteExistingUser(String user) {
		clickOnUserSearchButton();
		userSearchField.sendKeys(user);
		subSearchButton.click();
		userDeleteButton.click();
		pageutility=new PageUtility(driver);
		pageutility.acceptAlert();
		return deleteSuccessAlert.getText();
	}
	
}
