package com.testscenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class XpathDemo_Harika {

	public WebDriver driver;

	@BeforeClass
	public void beforeClass(@Optional("Chrome") String browserName) {
		if (browserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox browser opened Successfully****");
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			System.out.println("Edge browser opened Successfully****");
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			System.out.println("Chrome browser opened Successfully****");
		} else {
			System.out.println("Please provide proper browser name****");
		}
		driver.manage().window().maximize();
	}

	@AfterClass
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		// driver.quit();
		System.out.println("Browser closed successfully****");
	}

	@Test
	public void xPath() throws Exception {

		driver.get("https://testautomationpractice.blogspot.com/");

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Selenium1");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Selenium1@gmail.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("12341234");

		driver.findElement(By.xpath("//*[@id='textarea']")).sendKeys("Dallas,Texas- 80130");
		driver.findElement(By.xpath("(//*[@class='form-check-label'])[2]")).click();
		driver.findElement(By.xpath("//*[text()='Friday']")).click();

		Select countryDropdown = new Select(driver.findElement(By.xpath("//*[@id='country']")));
		countryDropdown.selectByVisibleText("Germany");

		Select colorList = new Select(driver.findElement(By.xpath("//*[@id='colors']")));
		colorList.selectByVisibleText("Blue");
		colorList.selectByVisibleText("Green");

		Select animalList = new Select(driver.findElement(By.xpath("//*[@id='animals']")));
		animalList.selectByVisibleText("Deer");
		animalList.selectByVisibleText("Cheetah");
		// *************Datepicker
		// fields******************************************************************************************
		// 1. input datePicker field allows manual typing, the fastest method is to send
		// the date string directly using sendKeys().
		driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("05/29/2026");

		// 2. If datePicker field direct typing is blocked, you must interact with the
		// calendar UI as a user would.
		// Open the Calendar: Click the input field or date icon to trigger the popup.
		// Navigate to Year/Month: Compare the currently displayed month/year with your
		// target.
		// Use a while loop to click the "Next" or "Previous" buttons until the correct
		// month and year are reached.
		// Select the Day: Once the correct month is visible, locate all date cells
		// (usually <td> elements) and click the one that matches your target day.
		//driver.findElement(By.xpath("//*[@id='txtDate']")).sendKeys("09/09/2026");
		driver.findElement(By.xpath("//*[@id='txtDate']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='30']")).click();

		

		driver.findElement(By.xpath("//*[@id='start-date']")).sendKeys("08/08/2026");
		
		driver.findElement(By.xpath("//*[@id='end-date']")).sendKeys("09/30/2026");
		driver.findElement(By.xpath("//button[@class='submit-btn']")).click();

	}
}
