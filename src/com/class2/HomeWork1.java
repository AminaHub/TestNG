package com.class2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.CommonMethods;

//Identify Priority of Test Cases
//
//TC 1: OrangeHRM Verify Successful Login
//Step 1: Open browser and navigate to OrangeHRM
//Step 2: Enter valid UID and valid PWD and click login button
//Step 3: Verify user successfully logged in
//
//TC 2: OrangeHRM Add Employee
//	Step 1: Click on PIM link and Add Employee
//	Step 2: Provide Details and Save
//	Step 3: Verify Employee is added 
//
//TC 3: OrangeHRM Verify Employee Details
//	Step 1: Click on PIM link and Employee List
//	Step 2: Search for employee by it id
//	Step 3: Verify Employee details are displayed 
//
//Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application

public class HomeWork1 extends CommonMethods{

	@BeforeClass
	public void setUp(){
		setUpDriver("chrome","https://opensource-demo.orangehrmlive.com/");
		boolean isDisplayed=driver.findElement(By.xpath("//title[text()='OrangeHRM']")).isDisplayed();
		if(isDisplayed=true) {
			System.out.println("page title is displayed");
		}else {
			System.out.println("page title is not displayed");
		}
		
	}
	
	@Test
	public void logIn() {
		WebElement userName= driver.findElement(By.xpath("//input[@id='txtUsername']"));
		sendText(userName, "Admin");
		WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));
		sendText(password, "admin123");
		WebElement logInBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		click(logInBtn);
		boolean displayed=driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed();
		if(displayed==true) {
			System.out.println("User successfully loged in");
		}else {
			System.out.println("User did not log in");
		}
	}
	
	@Test(priority=2)
	public void addEmployee() {
		WebElement pim=driver.findElement(By.xpath("//a[contains(@id,'viewPimModule')]/b"));
		click(pim);
		WebElement addEmp= driver.findElement(By.xpath("//a[contains(@id,'addEmployee')]"));
		click(addEmp);
		WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
		sendText(firstName, "Adam");
		WebElement lastName=driver.findElement(By.xpath("//input[@id='lastName']"));
		sendText(lastName, "Brown");
		WebElement saveBtn=driver.findElement(By.xpath("//input[@id='btnSave']"));
		click(saveBtn);
		WebElement empList=driver.findElement(By.xpath("//a[contains(@id,'viewEmployeeList')]"));
		click(empList);
		
		
		//driver.findElement(By.xpath("//input[@class='duplexBox']")).click();
//		
////		String filePath="C:\\Users\\NZeki\\Desktop\\Upload.UploadImage.jpg";
////		driver.findElement(By.id("photofile")).sendKeys(filePath);
		
		//driver.findElement(By.id("file-submit")).click();
//		boolean isDisplayed=driver.findElement(By.xpath("h3[tet()='File Uploaded!']")).isDisplayed();
//		if(isDisplayed) {
//			System.out.println("File uploaded successfully");
//		}else {
//			System.out.println("File did not upload successfully");
//		}
		
	}
	
	@Test(priority=3)
	public void verifyEmp() {
		String name="Adam";
		List<WebElement> rows=driver.findElements(By.xpath("//form[contains(@id,'frmList_ohrmListComponent')]"));
		for(int i=1; i<=rows.size(); i++) {  
		    String rowText=driver.findElement(By.xpath("//*[contains(@id, 'resultTable')]/tbody/tr/td["+i+"]")).getText();
		    System.out.println("inside the loop");
		    if(rowText.contains(name)) {
		    	verify(rowText, name);
		    	System.out.println("inside the if after verify");
		    }
		}    
		
		
	}

	
	@AfterClass
	public void closePage() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}	
}
