package com.mobiquityinc.cafetownsend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mobiquityinc.cafetownsend.utilities.Utilities;

public class EmployeeDataPage {

	private By firstNameTextboxLocator=By.cssSelector("input[ng-model='selectedEmployee.firstName']");
	private By lastNameTextboxLocator=By.cssSelector("input[ng-model='selectedEmployee.lastName']");
	private By startDateTextboxLocator=By.cssSelector("input[ng-model='selectedEmployee.startDate']");
	private By emailTextboxLocator = By.cssSelector("input[ng-model='selectedEmployee.email']");
	protected WebDriver driver;
	
	public EmployeeDataPage(WebDriver driver) {
		this.driver = driver;
	}
	protected WebElement firstName() {
		Utilities.waitUntilElementIsVisible(firstNameTextboxLocator, driver);
		return driver.findElement(firstNameTextboxLocator);
	}
	
	protected WebElement lastName() {
		return driver.findElement(lastNameTextboxLocator);
	}
	
	protected WebElement startDate() {
		Utilities.waitUntilElementIsVisible(startDateTextboxLocator, driver);
		return driver.findElement(startDateTextboxLocator);
	}
	
	protected WebElement email() {
		return driver.findElement(emailTextboxLocator);
	}
}
