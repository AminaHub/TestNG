package com.class2;

import org.testng.annotations.Test;

public class Priority {
	@Test()
	public void first() {
		System.out.println("first test annotation");
	}
	@Test()
	public void second() {
		System.out.println("second test annotation");
	}
	@Test(priority=2)
	public void third() {
		System.out.println("third test annotation");
	}
	@Test(priority=3)
	public void forth() {
		System.out.println("forth test annotation");
	}
}
