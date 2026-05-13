package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandleDemo {

	public static void main(String[] args) {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://seenu4selenium.github.io/devices-management-Webpage/#login");
		driver.findElement(By.linkText("Sign Up")).click();

		new Select(driver.findElement(By.id("signUpRole"))).selectByVisibleText("Admin");
		
//		Select abc = new Select(driver.findElement(By.id("signUpRole")));
//		abc.selectByVisibleText("Normal User");
		
		
		
	}

}
