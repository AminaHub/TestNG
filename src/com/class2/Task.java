package com.class2;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class Task extends CommonMethods{
	
//	TC 1: OrangeHRM Title Validation
//
//	TC 2: OrangeHRM Successful Login 
//	https://opensource-demo.orangehrmlive.com/
//	Please make sure to use the following:
//	 annotations:
//		@BeforeMethod
//		@AfterMethod
//		@Test
//
//	What would you do if you do not want to execute any specific test case?
//	What would you do if you want to execute any specific test case first?
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
		boolean swagLabs = driver.findElement(By.xpath("//title[text()='OrangeHRM']")).isDisplayed();
		  if(swagLabs=true) {        
			  System.out.println("This is the right title");    
		  }else {        
			  System.out.println("This is the wrong title");    
		  }
		  Thread.sleep(2000);
	}
	
	@Test()
	public void login(){
	sendText(driver.findElement(By.xpath("//input[@id='txtUsername']")), "Admin");
	sendText(driver.findElement(By.xpath("//input[@id='txtPassword']")), "admin123");
	driver.findElement(By.cssSelector("input.button")).click();
		
	}
//	@Test
//	public void testOrange () throws InterruptedException {
//		System.out.println("This is the test body");
//		
//		Thread.sleep(2000);
//	}
	
	@AfterMethod
	public void closePage() {
		driver.close();
	}

}
