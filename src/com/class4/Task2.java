package com.class4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.CommonMethods;


//Identify Priority of Test Cases
//
//https://www.saucedemo.com/
//
//TC 1: Saucedemo Username1(parameters - username and password)
//Step 1: Open browser and navigate to Saucedemo
//Step 2: Enter username standard_user and enter password secret_sauce and click login button
//Step 3: Verify user successfully logged in
//
//TC 2: Saucedemo Username2(parameters - username and password)
//Step 1: Open browser and navigate to Saucedemo
//Step 2: Enter username problem_user and enter password secret_sauce and click login button
//Step 3: Verify user successfully logged in
//
//
//Note: Create BeforeMethod and AfterMethod annotations to open browser and logout from the application. Create a xml file with parameters username and password .

public class Task2 extends CommonMethods {
	
	@BeforeMethod (alwaysRun= true)
	public void setUP() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
		
	}
	
	@Parameters({"userName","pass"})
	@Test
	public void userName1(String userName, String pass) {
		sendText(driver.findElement(By.xpath("//input[@id='user-name']")), userName);
		sendText(driver.findElement(By.xpath("//input[@id='password']")), pass);
		driver.findElement(By.xpath("//input[@class='btn_action']")).click();
		String prodLogo=driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);

	}
	
	@AfterMethod(alwaysRun= true)
	public void tearDown() {
		driver.close();
	}
	
}
