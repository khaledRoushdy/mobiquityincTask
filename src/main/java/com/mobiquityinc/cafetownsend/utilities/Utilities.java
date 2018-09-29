package com.mobiquityinc.cafetownsend.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	public static String generateRandomChars(int length) {
		String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
		}

		return sb.toString();
	}

	public static void waitUntilElementIsVisible(By locator,WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void waitUntilElementIsClickable(By locator,WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static String isAlertApperared(WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert().getText();
	}
	
	public static void clickOnElementUsingActions(WebElement element,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
	
	public static void doubleClickOnElementUsingActions(WebElement element,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).doubleClick().build().perform();
	}
	
	public static String executeScriptUsingJavascript(String script,WebDriver driver) {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
	     String text = (String) js.executeScript(script);
	     return text;
	}
	
	public static Map<String, String> getApplicationData() {
		Map<String,String> applicationData = new HashMap<String, String>();
		Properties prop = new Properties();
		InputStream input = null;
		String url = null,browserName = null,username= null,password = null;
		try {
			input = new FileInputStream("src/main/resources/conf/application.properties");
			prop.load(input);
			// get the property value and print it out
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			browserName = prop.getProperty("browser");
			applicationData.put("Browser", browserName);
			applicationData.put("Url", url);
			applicationData.put("Username", username);
			applicationData.put("Password", password);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return applicationData;
	}
}
