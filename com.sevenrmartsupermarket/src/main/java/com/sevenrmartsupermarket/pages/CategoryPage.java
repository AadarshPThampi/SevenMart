package com.sevenrmartsupermarket.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class CategoryPage {
	
	WebDriver driver;
	PageUtility pageutility;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchField;
	@FindBy(xpath = "//table//tbody//tr[1]//td[1]")
	WebElement category;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement subSearchButton;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement categoryField;
	@FindBy(xpath = "(//span[contains(text(),'discount')])[1]")
	WebElement categoryGroup;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imgInputButton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	
	
	public CategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public String getNameOfCategory() {
		return category.getText();
	}
	
	public String getAlertText() {
		return alert.getText();
	}
	
	public String deleteCategoryFromTable() {
		clickOnSearchButton();
		searchField.sendKeys(getNameOfCategory());
		subSearchButton.click();
		deleteButton.click();
		pageutility=new PageUtility(driver);
		pageutility.acceptAlert();
		return getAlertText();
	}
	
	public String addNewCategory(String categoryName, String filePath) {
		clickOnNewButton();
		categoryField.sendKeys(categoryName);
		categoryGroup.click();
		pageutility=new PageUtility(driver);
		pageutility.uploadFile(imgInputButton, filePath);
		clickSaveButton();
		return getAlertText();
	}
	
	public void clickSaveButton() {
		pageutility=new PageUtility(driver);
		pageutility.scrollAndClick(saveButton);
	}

}
