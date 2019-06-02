package com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task2 {
	
	@Test
	public void aTest() {
		System.out.println("This is a Test annotation");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Before Method Annotation");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is After Mothod Annotation");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is Before Class Annotation");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is After Class Annotation");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is Before Test Annotation");
		
	}

	@AfterTest
	public void afterTest() {
		System.out.println("This is After Test Annotation");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is Before Suite Annotation");
		
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("This is After Suite Annotation");
	}
}
