package com.mobiquityinc.cafetownsend.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mobiquityinc.cafetownsend.baseTest.CafeTownsendBaseTest;
import com.mobiquityinc.cafetownsend.domains.Employee;
import com.mobiquityinc.cafetownsend.pages.EditEmployeePage;
import com.mobiquityinc.cafetownsend.pages.EmployeesHomePage;
import com.mobiquityinc.cafetownsend.pages.LoginPage;
import com.mobiquityinc.cafetownsend.utilities.Utilities;

public class EditEmployeesTests extends CafeTownsendBaseTest{

	private LoginPage loginPage;
	private EmployeesHomePage employeesHomePage;
	private EditEmployeePage editEmployeePage;
	
	@Test
	public void shouldUpdateEmployeesDataSuccessfully() {
		
		loginPage = new LoginPage(driver);
		employeesHomePage = new EmployeesHomePage(driver);
		editEmployeePage = new EditEmployeePage(driver);
		loginPage.logintoCafeTownsend(username, password);
		employeesHomePage.selectEmployee();
		employeesHomePage.selectEdit();
		Employee employee = new Employee();
		employee.firstName = "khaled"+Utilities.generateRandomChars(4);
		employee.lastName = "Mohamed"+Utilities.generateRandomChars(4);
		employee.startDate = "2008-12-27";
		employee.email = employee.firstName+"@yahoo.com";
		String employeeFullName = employee.firstName +" "+ employee.lastName;
		editEmployeePage.updateEmployeesData(employee);
		List<String> allEmployees = employeesHomePage.getEmployees();
		Assert.assertTrue(allEmployees.contains(employeeFullName),"The employee is not updated");		
	}
	
	@Test
	public void shouldnotUpdateEmployeesWithInvalidStartDate() {
		
		loginPage = new LoginPage(driver);
		employeesHomePage = new EmployeesHomePage(driver);
		editEmployeePage = new EditEmployeePage(driver);
		loginPage.logintoCafeTownsend(username, password);
		employeesHomePage.selectEmployee();
		employeesHomePage.selectEdit();
		Employee employee = new Employee();
		employee.startDate = "22-12-2000";
		editEmployeePage.updateEmployeesData(employee);
		String actualAlertMessage= editEmployeePage.getAlertText();
		String expectedAlertMessage = "Error trying to update an employee (error: [object Object])";
		Assert.assertEquals(actualAlertMessage,expectedAlertMessage,"The message is not correct");
	}
}
