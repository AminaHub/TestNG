package com.class4;

//Identify Priority of Test Cases
//https://www.saucedemo.com/
//
//TC 1: Saucedemo Username1(tag the groups - Smoke)
//Step 1: Open browser and navigate to Saucedemo
//Step 2: Enter username standard_user and enter password secret_sauce and click login button
//Step 3: Verify user successfully logged in
//
//TC 2: Saucedemo Username2(tag the groups - Regression)
//Step 1: Open browser and navigate to Saucedemo
//Step 2: Enter username problem_user and enter password secret_sauce and click login button
//Step 3: Verify user successfully logged in


//Note: Create BeforeMethod and AfterMethod annotations to open browser and logout from the application. Create a xml file and include smoke.
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class Task1 extends CommonMethods{
	
	@BeforeMethod (alwaysRun= true, groups= "Smoke")
	public void setUP() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
		//driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
	}

	@Test(groups = "Smoke")
	public void userName1() {
		sendText(driver.findElement(By.xpath("//input[@id='user-name']")), "standard_user");
		sendText(driver.findElement(By.xpath("//input[@id='password']")), "secret_sauce");
		//sendText(driver.findElement(By.cssSelector("//input[@id='password']")), "passtest");
		driver.findElement(By.xpath("//input[@class='btn_action']")).click();
		String prodLogo=driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
//		if(prodLogo.equals("Products")) {
//			System.out.println("User loged in successfully");
//		}else {
//			System.out.println("User did not loged in successfully");
//		}
	}

	@Test(groups = "Regression")
	public void userName2() {
		sendText(driver.findElement(By.xpath("//input[@id='user-name']")), "standard_user");
		sendText(driver.findElement(By.xpath("//input[@id='password']")), "secret_sauce");
		//sendText(driver.findElement(By.cssSelector("//input[@id='password']")), "passtest");
		driver.findElement(By.xpath("//input[@class='btn_action']")).click();
		String prodLogo=driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
//		if(prodLogo.equals("Products")) {
//			System.out.println("User loged in successfully");
//		}else {
//			System.out.println("User did not loged in successfully");
//		}
	}

	@AfterGroups(alwaysRun= true, groups= "Smoke")
	public void tearDown() {
		driver.close();
	}
}
