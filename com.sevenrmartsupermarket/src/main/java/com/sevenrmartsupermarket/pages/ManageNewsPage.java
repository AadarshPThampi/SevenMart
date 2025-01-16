package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement newsPageField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement mainSearchButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement mainResetButton;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement subSearchButton;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	private WebElement subResetButton;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewNewsButton() {
		newButton.click();
	}
	
	public void sendNews(String news) {
		clickOnNewNewsButton();
		newsPageField.sendKeys(news);
		saveButton.click();
	}
	
	public String getAlert() {
		return alert.getText();
	}

}
