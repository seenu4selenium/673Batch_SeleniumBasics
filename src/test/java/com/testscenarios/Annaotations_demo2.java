package com.testscenarios;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Annaotations_demo2 {
	@Test//Actual functional test script
	public void a() {
		System.out.println("test a");
	}

	@BeforeClass//Pre-condition script
	public void beforeClass() {
		System.out.println("BeforeClass");
	}

	@Test
	public void f() {
		System.out.println("test f");
	}

	@AfterClass//Post-condition script
	public void afterClass() {
		System.out.println("AfterClass");
	}

}
