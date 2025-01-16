package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	/** driver declaration */
	public WebDriver driver;
	ScreenshotCapture screenshotcapture = new ScreenshotCapture();

	/** Aggregation */
	Properties properties = new Properties();

	public Base() {
		try {
			FileInputStream input = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** initialize browser */
	public void intialize(String browser, String url) {
		if (browser.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}

		else if (browser.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("remote-allow-origins=*");
			driver = new EdgeDriver(options);
		}

		else if (browser.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_SEC));
		driver.manage().deleteAllCookies();
	}

	@BeforeMethod(enabled =true, alwaysRun = true)
	public void launchApplication() {
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		intialize(browser, url);
	}
	
	@BeforeMethod(enabled =false, alwaysRun = true)
	@Parameters("browser")
	public void launchApplication(String browser) {
		String url = properties.getProperty("url");
		intialize(browser, url);
	}
	
	@AfterMethod (alwaysRun = true)
	public void terminateSession(ITestResult itestresult) {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			screenshotcapture.takeScreenshot(driver, itestresult.getName()); 
		}
	//	driver.close();
	}
	
}
