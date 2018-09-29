package com.mobiquityinc.cafetownsend.baseTest;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.mobiquityinc.cafetownsend.driver.Browser;
import com.mobiquityinc.cafetownsend.utilities.Utilities;


public class CafeTownsendBaseTest {

	protected WebDriver driver;
	private String browserName;
	protected String url,username,password;
	private Browser browser = new Browser();

	@BeforeMethod
	public void setup() {
		Map<String, String> applicationData = Utilities.getApplicationData();
		browserName = applicationData.get("Browser");
		url = applicationData.get("Url");
		username = applicationData.get("Username");
		password = applicationData.get("Password");
		driver = browser.getDriver(browserName);
		driver.get(url);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
