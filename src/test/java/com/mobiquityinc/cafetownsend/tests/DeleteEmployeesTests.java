package com.mobiquityinc.cafetownsend.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mobiquityinc.cafetownsend.baseTest.CafeTownsendBaseTest;
import com.mobiquityinc.cafetownsend.pages.EditEmployeePage;
import com.mobiquityinc.cafetownsend.pages.EmployeesHomePage;
import com.mobiquityinc.cafetownsend.pages.LoginPage;

public class DeleteEmployeesTests extends CafeTownsendBaseTest{

	private LoginPage loginPage;
	private EmployeesHomePage employeesHomePage;
	private EditEmployeePage editEmployeePage;
	
	@Test
	public void shouldDeleteAnExistingEmployeeFromEditingAnEmployee() {
		loginPage = new LoginPage(driver);
		employeesHomePage = new EmployeesHomePage(driver);
		editEmployeePage = new EditEmployeePage(driver);
		loginPage.logintoCafeTownsend(username, password);
		int employeesSizeBeforeDeletion = employeesHomePage.getEmployees().size();
		employeesHomePage.openAnyEmployee();
		editEmployeePage.deleteEmployee();
		int employeesSizeAfterDeletion = employeesHomePage.getEmployees().size();
		Assert.assertEquals(employeesSizeBeforeDeletion-1, employeesSizeAfterDeletion,"The employee is not deleted successfully");
	}
	
	@Test
	public void shouldDeleteAnExistingEmployeeFromHomePage() {
		loginPage = new LoginPage(driver);
		employeesHomePage = new EmployeesHomePage(driver);
		editEmployeePage = new EditEmployeePage(driver);
		loginPage.logintoCafeTownsend(username, password);
		int employeesSizeBeforeDeletion = employeesHomePage.getEmployees().size();
		employeesHomePage.deleteEmployee();
		int employeesSizeAfterDeletion = employeesHomePage.getEmployees().size();
		Assert.assertEquals(employeesSizeBeforeDeletion-1, employeesSizeAfterDeletion,"The employee is not deleted successfully");
		
	}
}
