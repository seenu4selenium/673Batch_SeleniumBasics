package com.testscenarios;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Annaotations_demo3 {
	@Test
	public void b() {
		System.out.println("@test b");
	}

	@Test
	public void f() {
		System.out.println("@test f");
	}

	@Test
	public void a() {
		System.out.println("@test a");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
	}

}
