package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageNewsPage {
	
	WebDriver driver;
	PageUtility pageutility;
	
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
	@FindBy(xpath = "//table//tbody//tr[1]//td[1]")
	private WebElement tableNews;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement newsSearchBox;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	private WebElement newsDeleteButton;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	private WebElement newsEditButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement newsEditField;
	@FindBy(xpath = "//button[@name='update']")
	private WebElement newsUpdateButton;
	
	
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
	
	public String getAlertMessage() {
		return alert.getText();
	}
	
	public String getNewsTextFromTable() {
		return tableNews.getText();
	}
	
	public void deleteNewsFromTable() {
		mainSearchButton.click();
		newsSearchBox.sendKeys(getNewsTextFromTable());
		subSearchButton.click();
		newsDeleteButton.click();
		pageutility=new PageUtility(driver);
		pageutility.acceptAlert();
	}
	
	public void editNewsInTable(String news) {
		mainSearchButton.click();
		newsSearchBox.sendKeys(getNewsTextFromTable());
		subSearchButton.click();
		newsEditButton.click();
		newsEditField.clear();
		newsEditField.sendKeys(news);
		newsUpdateButton.click();
	}

}
