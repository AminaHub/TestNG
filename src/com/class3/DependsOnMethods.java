package com.class3;

import org.testng.annotations.Test;

public class DependsOnMethods {
	
	@Test
	public void one() {
		System.out.println("Test one");
		
	}
	
	@Test(dependsOnMethods="one")
	public void two() {
		System.out.println("Test two");

		
	}
	
	@Test(dependsOnMethods="two")
	public void othree() {
		System.out.println("Test three");
	
	}

}
