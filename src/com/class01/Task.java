package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

//TC 1: Swag Lab Title and Login Verification
//
//@BeforeMethod should contain navigation to the URL and title verification
//
//@Test should contain steps to login and “Product” word verification
//
//@AfterMethod should logOut from the application and close the browser

public class Task extends CommonMethods{
	
	@BeforeMethod
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com/index.html");
	}
	
	@Test
	public void login() throws InterruptedException {
		sendText(driver.findElement(By.cssSelector("input.form_input")), "standard_user");
		Thread.sleep(2000);
		sendText(driver.findElement(By.cssSelector("input#password")), "secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.btn_action")).click();
		System.out.println("Test");
		WebElement word=driver.findElement(By.xpath("//div[@class='product_label']"));
		
		if(word.getText().equalsIgnoreCase("Products")) {
			System.out.println("Word product is displayed");
		}else {
			System.out.println("Word produst is not dispalyed");
		}
	}
	
	@AfterMethod
	public void close() {
	driver.close();
	}

}
