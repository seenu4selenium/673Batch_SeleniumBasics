package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertDemo {
	@Test
	public void f() throws Exception {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/alerts");

		// click on First Click me button
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(3000);

		// Get the alert text and print into console
		String alertText = driver.switchTo().alert().getText();
		System.out.println("alertText is: " + alertText);

		// To click on OK button on Alert
		driver.switchTo().alert().accept();

		// Click on third click me button
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(3000);

		// Get the Confirmation alert text and print into console
		String confirmationAlertText = driver.switchTo().alert().getText();
		System.out.println("confirmationAlertText is: " + confirmationAlertText);
		
		
		//To click on Cancle button on confirmationAlert
		driver.switchTo().alert().dismiss();
		
	}
}
