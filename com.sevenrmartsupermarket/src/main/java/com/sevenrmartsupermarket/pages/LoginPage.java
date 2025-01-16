package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {

	WebDriver driver;
	WaitUtility waitutility;

	Properties properties = new Properties();

	@CacheLookup
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signInButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement invalidLoginAlert;
	@FindBy(xpath = "//input[@id='remember']")
	private WebElement rememberMeBox;
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement rememberMeOption;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream input = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSignInButton() {
		waitutility = new WaitUtility(driver);
		waitutility.waitForElementToClick(signInButton, 30);
		signInButton.click();
	}

	public boolean isSignInButtonDisplayed() {
		return signInButton.isDisplayed();
	}

	public boolean isSignInButtonEnabled() {
		return signInButton.isEnabled();
	}

	public void clickRememberMeBox() {
		rememberMeBox.click();
	}

	public boolean isRememberMeCheckBoxDisplayed() {
		return rememberMeOption.isDisplayed();
	}

	public boolean isRememberMeCheckBoxEnabled() {
		return rememberMeBox.isEnabled();
	}

	/** parameterized login */
	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}

	public void login() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}

	public boolean checkInvalidLoginAlert() {
		return invalidLoginAlert.isDisplayed();
	}

	public boolean isLoginOptionsAvailable() {				//change name
		boolean userDisplay = userNameField.isDisplayed();
		boolean userEnabled = userNameField.isEnabled();
		boolean passwordDisplay = passwordField.isDisplayed();
		boolean passworsEnabled = passwordField.isEnabled();
		boolean userStatus = false;
		boolean passwordStatus = false;
		if (userDisplay == true && userEnabled == true) {
			userStatus = true;
		} else
			userStatus = false;
		if (passwordDisplay == true && passworsEnabled == true) {
			passwordStatus = true;
		} else
			passwordStatus = false;
		if (userStatus == true && passwordStatus == true) {
			return true;
		} else
			return false;
	}
}
