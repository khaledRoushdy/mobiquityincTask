package com.mobiquityinc.cafetownsend.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mobiquityinc.cafetownsend.utilities.Utilities;

public class EmployeesHomePage {

	private By createButtonLocator=By.id("bAdd");
	private By editButtonLocator=By.id("bEdit");
	private By deleteButtonLocator=By.id("bDelete");
	private By employeesLocator = By.cssSelector("ul#employee-list li");
	private By welcomeMessageLocator = By.id("greetings");
	private By logoutButtonLocator = By.cssSelector("p.main-button");
	private WebDriver driver;
	
	public EmployeesHomePage(WebDriver driver){
		this.driver = driver;
	}
	
	private WebElement create() {
		Utilities.waitUntilElementIsClickable(createButtonLocator, driver);
		return driver.findElement(createButtonLocator);
	}
	
	private WebElement edit() {
		return driver.findElement(editButtonLocator);
	}
	
	private WebElement delete() {
		return driver.findElement(deleteButtonLocator);
	}
	
	private List<WebElement> employees() {
		Utilities.waitUntilElementIsVisible(employeesLocator, driver);
		return driver.findElements(employeesLocator);
	}
	
	private WebElement welcomeMessage() {
		return driver.findElement(welcomeMessageLocator);
	}
	
	private WebElement signout() {
		return driver.findElement(logoutButtonLocator);
	}
	
	public void selectCreate() {
		create().click();
	}
	
	public void selectEdit() {
		edit().click();
	}
	
	public void selectDelete() {
		delete().click();
	}
	
	public String getFirstAndLastNameOfAnyEmployee() {
		List<WebElement> employeesElements = employees();
		return employeesElements.get(0).getText();
	}
	
	public List<String> getEmployees(){
		List<String> employeesNames = new ArrayList<String>();
		List<WebElement> employeesElements = employees();
		for (WebElement employee : employeesElements) {
			employeesNames.add(employee.getText());
		}
		return employeesNames;	
	}
	
	public void openEmployeeData(String name) {
		List<WebElement> employeesElements = employees();
		for (WebElement employee : employeesElements) {
			employee.click();
			employee.click();
		}
	}
	
	public void openAnyEmployee() {
		List<WebElement> employeesElements = employees();
		Utilities.doubleClickOnElementUsingActions(employeesElements.get(0), driver);
	}
	
	public void selectEmployee(String name) {
		List<WebElement> employeesElements = employees();
		for (WebElement employee : employeesElements) {
			employee.click();
		}
	}
	public void selectEmployee() {
		List<WebElement> employeesElements = employees();
		employeesElements.get(0).click();
	}

	public void deleteEmployee(String employeeName) {
		selectEmployee(employeeName);
		selectDelete();
	}
	
	public void deleteEmployee() {
		selectEmployee();
		selectDelete();
		driver.switchTo().alert().accept();
	}
	
	public String getWelcomeMessage() {
		return welcomeMessage().getText();
	}
	
	public void logout() {
		Utilities.waitUntilElementIsVisible(logoutButtonLocator, driver);
		Utilities.clickOnElementUsingActions(signout(), driver);
	}
}
