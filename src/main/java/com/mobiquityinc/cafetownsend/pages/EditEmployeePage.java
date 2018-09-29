package com.mobiquityinc.cafetownsend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mobiquityinc.cafetownsend.domains.Employee;
import com.mobiquityinc.cafetownsend.utilities.Utilities;

public class EditEmployeePage extends EmployeeDataPage{

	private By updateButtonLocator = By.cssSelector("button[type='submit'][ng-hide='isCreateForm']");
	private By deleteButtonLocator = By.cssSelector("p.main-button[ng-click=\"deleteEmployee()\"]");
	private By backButtonLocator = By.cssSelector("a.subButton.bBack");
	private String firstNameText = "return document.getElementsByTagName('input')[0].value";
	private String lastNameText = "return document.getElementsByTagName('input')[1].value";
	private String startDateText = "return document.getElementsByTagName('input')[2].value";
	private String emailText = "return document.getElementsByTagName('input')[3].value";
	
	public EditEmployeePage(WebDriver driver) {
		super(driver);
	}
	
	private WebElement update() {
		return driver.findElement(updateButtonLocator);
	}
	
	private WebElement delete() {
		Utilities.waitUntilElementIsVisible(deleteButtonLocator, driver);
		return driver.findElement(deleteButtonLocator);
	}
	
	private WebElement back() {
		Utilities.waitUntilElementIsVisible(backButtonLocator, driver);
		return driver.findElement(backButtonLocator);
	}
	
	public Employee getEmployeeData() {
		firstName();
		Employee employee = new Employee();
		employee.firstName = Utilities.executeScriptUsingJavascript(firstNameText, driver);
		employee.lastName = Utilities.executeScriptUsingJavascript(lastNameText, driver);
		employee.startDate = Utilities.executeScriptUsingJavascript(startDateText, driver);
		employee.email = Utilities.executeScriptUsingJavascript(emailText, driver);
		return employee;
	}
	
	public void updateEmployeesData(Employee employee) {
		if(employee.firstName != null && !employee.firstName.isEmpty()) {
			firstName().clear();
			firstName().sendKeys(employee.firstName);
		}
		
		if(employee.lastName !=null && !employee.lastName.isEmpty()) {
			lastName().clear();
			lastName().sendKeys(employee.lastName);
		}
		
		if(employee.startDate != null && !employee.startDate.isEmpty()) {
			startDate().clear();
			startDate().sendKeys(employee.startDate);
		}
		
		if(employee.email != null && !employee.email.isEmpty()) {
			email().clear();
			email().sendKeys(employee.email);
		}
		update().click();
	}
	
	public void selectBack() {
		back().click();
	}
	
	public void deleteEmployee() {
		delete().click();
		driver.switchTo().alert().accept();
	}
	
	public String getAlertText() {
		return Utilities.isAlertApperared(driver);
	}
}