package com.testscenarios;

import org.testng.annotations.Test;

public class Annaotations_demo1 {
	@Test(priority = 0)
	public void c() {
		System.out.println("test c");
	}

	@Test(priority = 2) // (enabled = false)
	public void a() {
		System.out.println("test a");
	}

	@Test(priority = 1)
	public void b() {
		System.out.println("test b");
	}
}
