package com.mobiquityinc.cafetownsend.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mobiquityinc.cafetownsend.baseTest.CafeTownsendBaseTest;
import com.mobiquityinc.cafetownsend.pages.EmployeesHomePage;
import com.mobiquityinc.cafetownsend.pages.LoginPage;

public class LoginTests extends CafeTownsendBaseTest {

	private LoginPage loginPage;
	private EmployeesHomePage employeesHomePage;
	
	@Test
	public void shouldLoginWithValidCredentials() {
		
		loginPage = new LoginPage(driver);
		employeesHomePage = new EmployeesHomePage(driver);
		loginPage.logintoCafeTownsend(username, password);
		String actualWelcomeMessage = employeesHomePage.getWelcomeMessage();
		String expectedWelcomeMessage= String.format("Hello %s", username);
		Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage,"The message is not correct");
	}
	
	@Test
	public void shouldNotLoginWithInvalidCredentials() {
		loginPage = new LoginPage(driver);
		employeesHomePage = new EmployeesHomePage(driver);
		loginPage.logintoCafeTownsend("khaled", "khaled");
		String actualErrorMessage= loginPage.getErrorMessage();
		String expectedErrorMessage = "Invalid username or password!";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"The message is not correct");
		
	}
}
