package com.class3;

import org.testng.annotations.Test;

public class DependOnGroups {
	
	@Test(groups="Smoke1")
	public void one() {
		System.out.println("Test one");
		
	}
	
	@Test(groups ="Smoke2",dependsOnGroups="Smoke1")
	public void two() {
		System.out.println("Test two");

		
	}
	
	@Test(groups="Smoke3",dependsOnGroups="Smoke2")
	public void othree() {
		System.out.println("Test three");
	
	}

}
