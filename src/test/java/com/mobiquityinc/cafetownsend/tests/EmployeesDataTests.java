package com.mobiquityinc.cafetownsend.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mobiquityinc.cafetownsend.baseTest.CafeTownsendBaseTest;
import com.mobiquityinc.cafetownsend.domains.Employee;
import com.mobiquityinc.cafetownsend.pages.EditEmployeePage;
import com.mobiquityinc.cafetownsend.pages.EmployeesHomePage;
import com.mobiquityinc.cafetownsend.pages.LoginPage;

public class EmployeesDataTests extends CafeTownsendBaseTest{

	private LoginPage loginPage;
	private EmployeesHomePage employeesHomePage;
	private EditEmployeePage editEmployeePage;
	@Test
	public void shouldTheApplicationGoToHomePageAfterSelectingBackButton() {
		
		loginPage = new LoginPage(driver);
		employeesHomePage = new EmployeesHomePage(driver);
		editEmployeePage = new EditEmployeePage(driver);
		loginPage.logintoCafeTownsend(username, password);
		employeesHomePage.openAnyEmployee();
		editEmployeePage.selectBack();
		int employeesSize = employeesHomePage.getEmployees().size();
		Assert.assertNotEquals(employeesSize, 0,"The employees are not loaded");
		Assert.assertTrue(driver.getCurrentUrl().endsWith("employees"),"The page is not correct");
	}
	
	@Test
	public void shouldTheDataOfTheEmployeeIsShownCorrectly() {
		loginPage = new LoginPage(driver);
		employeesHomePage = new EmployeesHomePage(driver);
		editEmployeePage = new EditEmployeePage(driver);
		loginPage.logintoCafeTownsend(username, password);
		String employeesData = employeesHomePage.getFirstAndLastNameOfAnyEmployee();
		employeesHomePage.openAnyEmployee();
		Employee employee = editEmployeePage.getEmployeeData();
		Assert.assertTrue(employeesData.contains(employee.firstName), "The first name is not shown");
		Assert.assertTrue(employeesData.contains(employee.lastName), "The last name is not shown");
		Assert.assertTrue(!employee.startDate.isEmpty(), "The date is empty");
		Assert.assertTrue(!employee.email.isEmpty(), "The email is empty");
	}
}
