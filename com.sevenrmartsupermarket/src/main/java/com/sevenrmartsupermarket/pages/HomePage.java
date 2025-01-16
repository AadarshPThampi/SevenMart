package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class HomePage {
	WebDriver driver;
	PageUtility pageutility;
	
	By profileLocator=By.xpath("//a[@class='d-block']");
	
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath = "//li[@class='nav-item dropdown']//a[@class='nav-link']")
	private WebElement userOptions;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement logoutOption;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProfileName() {
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.waitForVisibility(profileLocator, 10);
		return profileName.getText();
	}
	
	public void clickOnTile(String name) {
		pageutility=new PageUtility(driver);
		WebElement tileElement = driver.findElement(By.xpath("//div[@class='inner']//p[contains(text(),'"+name+"')]//following::a[1]"));
		pageutility.scrollAndClick(tileElement);
	}
	
	public void userLogout() {
		pageutility=new PageUtility(driver);
		pageutility.scrollAndClick(userOptions);
		pageutility.scrollAndClick(logoutOption);
	}
}
