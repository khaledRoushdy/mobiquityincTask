package com.mobiquityinc.cafetownsend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mobiquityinc.cafetownsend.utilities.Utilities;


public class LoginPage {

	private By usernameTextBoxLocator=By.cssSelector("input[ng-model='user.name']");
	private By passwordTextBoxLocator=By.cssSelector("input[ng-model='user.password']");
	private By loginButtonLocator=By.cssSelector("button[type='submit']");
	private By errorMessageLocator = By.cssSelector("p.error-message.ng-binding");
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	private WebElement username() {
		return driver.findElement(usernameTextBoxLocator);
	}
	
	private WebElement password() {
		return driver.findElement(passwordTextBoxLocator);
	}
	
	private WebElement login() {
		return driver.findElement(loginButtonLocator);
	}
	private WebElement errorMessage() {
		return driver.findElement(errorMessageLocator);
	}
	
	public void logintoCafeTownsend(String username,String password) {
		username().sendKeys(username);
		password().sendKeys(password);
		login().click();
	}	
	
	public String getErrorMessage() {
		Utilities.waitUntilElementIsVisible(errorMessageLocator,driver);
		return errorMessage().getText();
	}
	
	public boolean isOnLoginPage() {
		if(username().isDisplayed() && password().isDisplayed() && login().isDisplayed())
			return true;
		
		return false;
	}
}
