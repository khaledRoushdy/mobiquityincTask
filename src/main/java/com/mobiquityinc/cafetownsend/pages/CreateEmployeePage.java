package com.mobiquityinc.cafetownsend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mobiquityinc.cafetownsend.domains.Employee;
import com.mobiquityinc.cafetownsend.utilities.Utilities;

public class CreateEmployeePage extends EmployeeDataPage{


	private By addButtonLocator = By.cssSelector("div.formFooter >button:nth-child(2)");
	private By cancelButtonLocator = By.cssSelector("a.subButton.bCancel");
	
	public CreateEmployeePage(WebDriver driver){
		super(driver);
	}
	
	private WebElement add() {
		return driver.findElement(addButtonLocator);
	}
	
	private WebElement cancel() {
		Utilities.waitUntilElementIsVisible(cancelButtonLocator, driver);
		return driver.findElement(cancelButtonLocator);
	}
	
	public void addEmployee(Employee employee) {
		if(employee.firstName != null && !employee.firstName.isEmpty())
			firstName().sendKeys(employee.firstName);
		
		if(employee.lastName !=null && !employee.lastName.isEmpty())
			lastName().sendKeys(employee.lastName);
		
		if(employee.startDate != null && !employee.startDate.isEmpty())
			startDate().sendKeys(employee.startDate);
		
		if(employee.email != null && !employee.email.isEmpty())
			email().sendKeys(employee.email);
		
		add().click();
	}
	
	public void cancelAddingEmployee(Employee employee) {
		if(employee.firstName != null && !employee.firstName.isEmpty())
			firstName().sendKeys(employee.firstName);
		
		if(employee.lastName !=null && !employee.lastName.isEmpty())
			lastName().sendKeys(employee.lastName);
		
		if(employee.startDate != null && !employee.startDate.isEmpty())
			startDate().sendKeys(employee.startDate);
		
		if(employee.email != null && !employee.email.isEmpty())
			email().sendKeys(employee.email);
		
		cancel().click();
	}
	
	public void cancelAddingEmployee() {
		cancel().click();
	}
	
	public String getAlertText() {
		return Utilities.isAlertApperared(driver);
	}
}
