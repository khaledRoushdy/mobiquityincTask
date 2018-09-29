package com.mobiquityinc.cafetownsend.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mobiquityinc.cafetownsend.baseTest.CafeTownsendBaseTest;
import com.mobiquityinc.cafetownsend.pages.EmployeesHomePage;
import com.mobiquityinc.cafetownsend.pages.LoginPage;

public class LogoutTests extends CafeTownsendBaseTest {

	private LoginPage loginPage;
	private EmployeesHomePage employeesHomePage;
	@Test
	public void shouldLogoutSuccessfully() {
		
		loginPage = new LoginPage(driver);
		employeesHomePage = new EmployeesHomePage(driver);
		loginPage.logintoCafeTownsend(username, password);
		employeesHomePage.logout(); 
		boolean isOnloginPage = loginPage.isOnLoginPage();
		Assert.assertTrue(isOnloginPage, "The user has not been navigated to login page");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"),"The url is not correct");
	}
}
