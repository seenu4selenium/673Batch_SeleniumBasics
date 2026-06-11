package com.testscenarios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TS_02_Login_DeviceManagement {
	public WebDriver driver;
	public WebElement datePicker;

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("Edge") String browserName) {
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

	//@AfterClass
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.quit();
		System.out.println("Browser closed successfully****");
	}

	@Test
	public void tc_001() throws Exception {

		driver.get("https://seenu4selenium.github.io/devices-management-Webpage/#");

		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("username")));

//		click on Login button with test/test
		driver.findElement(By.id("username")).sendKeys("test");
		driver.findElement(By.id("password")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id='loginModal']/div/div/button")).click();

		driver.findElement(By.id("deviceName2")).sendKeys("OnePlus2");

		Select deviceType = new Select(driver.findElement(By.id("deviceType2")));
		deviceType.selectByVisibleText("Mobile");
		Select iOSType = new Select(driver.findElement(By.id("deviceOS2")));
		iOSType.selectByVisibleText("iOS");

		driver.findElement(By.id("deviceIMEI2")).sendKeys("11111111111111");

		datePicker = driver.findElement(By.id("deviceUntilUse2"));
		datePicker.sendKeys("06/29/2026 0245PM");
//		datePicker.sendKeys(Keys.TAB);
//		datePicker.sendKeys("0245PM");
//		
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", datePicker);
//	
		
	
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[text()='30']")).click();
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Select deviceStatus = new Select(driver.findElement(By.id("deviceStatus2")));
		deviceStatus.selectByVisibleText("Available");

		driver.findElement(By.id("addDeviceBtn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//filter with added device name
		driver.findElement(By.id("nameFilter")).sendKeys("OnePlus2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

//		//As the page is not automatically scrolling down , we are not able to see the added device at the end of the list.
//		//using this script to scroll down the page and then take screenshot.
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"deviceTableBody2\"]")));
//				
		takeCurrentPageScreenshot("Addeddevice");

	}

	public void takeCurrentPageScreenshot(String name) throws Exception {
		File myscreen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(myscreen, new File(".\\screenshots\\" + name + ".png"));
	}

}
