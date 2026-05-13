package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HyperLinkDemo {

	public static void main(String[] args) {
		
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("https://seenu4selenium.github.io/devices-management-Webpage/#login");
		// Click on Sign Up link
		driver.findElement(By.linkText("Sign Up")).click();
		//driver.findElement(By.partialLinkText("Res")).click();

	}

}
