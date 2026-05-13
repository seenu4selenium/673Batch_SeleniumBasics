package com.testscenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Waits_Demo {
	@Test
	public void f() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/nalla/OneDrive/Desktop/Selenium/Exam_14Oct2022/QE%20-%20index.html");
		// scroll into element
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"test-4-div\"]/h1")));

		// Thread.sleep(15000);

		// Implicitly wait: Wait until Current Page has loaded
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Check Test4 first button is enabled state?
		if (driver.findElement(By.xpath("//*[@id=\"test-4-div\"]/button[1]")).isEnabled()) {
			System.out.println("Test4 first button is enable state");
		} else {
			System.out.println("Test4 first button is disable state");
		}

		// Second button
		if (driver.findElement(By.xpath("//*[@id=\"test-4-div\"]/button[2]")).isEnabled()) {
			System.out.println("Test4 second button is enable state");
		} else {
			System.out.println("Test4 second button is disable state");
		}
		// Implicitly wait: Wait until Current Page has loaded
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Explicitly wait:
		// Check every 0.5 second, system will check the given locator is displayed on
		// current screen
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("test5-button")));

		// Wait until test5 button is displayed
		driver.findElement(By.id("test5-button")).click();

//		//Verify element is displayed
//		if (driver.findElement(By.id("test5-button")).isDisplayed()) {
//			System.out.println("test5 button is displayed");
//		} else {
//			System.out.println("test5 button is NOT displayed");
//		}
//		

	}
}
