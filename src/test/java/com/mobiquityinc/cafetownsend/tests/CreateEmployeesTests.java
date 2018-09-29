package com.mobiquityinc.cafetownsend.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mobiquityinc.cafetownsend.baseTest.CafeTownsendBaseTest;
import com.mobiquityinc.cafetownsend.domains.Employee;
import com.mobiquityinc.cafetownsend.pages.CreateEmployeePage;
import com.mobiquityinc.cafetownsend.pages.EmployeesHomePage;
import com.mobiquityinc.cafetownsend.pages.LoginPage;
import com.mobiquityinc.cafetownsend.utilities.Utilities;

public class CreateEmployeesTests extends CafeTownsendBaseTest {
	
	
	private LoginPage loginPage;
	private EmployeesHomePage employeesHomePage;
	private CreateEmployeePage createEmployeePage;
	
	@Test
	public void shouldCreateNewEmployeeSuccessfully() {
	
		loginPage = new LoginPage(driver);
		employeesHomePage = new EmployeesHomePage(driver);
		createEmployeePage = new CreateEmployeePage(driver);
		loginPage.logintoCafeTownsend(username, password);
		employeesHomePage.selectCreate();
		Employee employee = new Employee();
		employee.firstName = "khaled"+Utilities.generateRandomChars(4);
		employee.lastName = "khaled"+ Utilities.generateRandomChars(4);
		employee.startDate = "2008-12-27";
		employee.email = employee.firstName+"@yahoo.com";
		String employeeFullName = employee.firstName +" "+ employee.lastName;
		createEmployeePage.addEmployee(employee);
		List<String> allEmployees = employeesHomePage.getEmployees();
		Assert.assertTrue(allEmployees.contains(employeeFullName),"The employee is not created");		
	}
	
	@Test
	public void shouldCancelAddingNewEmployee() {
		
		loginPage = new LoginPage(driver);
		employeesHomePage = new EmployeesHomePage(driver);
		createEmployeePage = new CreateEmployeePage(driver);
		loginPage.logintoCafeTownsend(username, password);
		int employeesBeforeAdding = employeesHomePage.getEmployees().size();
		employeesHomePage.selectCreate();
		createEmployeePage.cancelAddingEmployee(new Employee());
		int employeesAfterCancelAdding = employeesHomePage.getEmployees().size();
		Assert.assertEquals(employeesBeforeAdding, employeesAfterCancelAdding);	
	}
	
	@Test
	public void shouldnotAddEmployeeWithInvalidDateFormat() {
		loginPage = new LoginPage(driver);
		employeesHomePage = new EmployeesHomePage(driver);
		createEmployeePage = new CreateEmployeePage(driver);
		loginPage.logintoCafeTownsend(username, password);
		employeesHomePage.selectCreate();
		Employee employee = new Employee();
		employee.firstName = "khaled"+Utilities.generateRandomChars(4);
		employee.lastName = "khaled"+ Utilities.generateRandomChars(4);
		employee.startDate = "27-12-2008";
		employee.email = employee.firstName+"@yahoo.com";
		createEmployeePage.addEmployee(employee);
		String actualAlertText = createEmployeePage.getAlertText();
		String expectedAlertText = "Error trying to create a new employee: {\"start_date\":[\"can't be blank\"]})";
		Assert.assertEquals(actualAlertText, expectedAlertText,"The error message is not correct");
	}
}
