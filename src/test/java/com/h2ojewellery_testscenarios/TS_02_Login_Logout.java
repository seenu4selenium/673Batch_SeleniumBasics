package com.h2ojewellery_testscenarios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TS_02_Login_Logout {
	public WebDriver driver;

	@Parameters("browserName")
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
		driver.quit();
		System.out.println("Browser closed successfully****");
	}

	@Test(description = "Verify H2o login page will display  all fields")
	public void tc_009() throws Exception {

		driver.get("https://seenu4selenium.github.io/devices-management-Webpage/#");

		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		validateWebElement(By.id("username"));
		validateWebElement(By.id("password"));
		validateWebElement(By.xpath("//*[@id='loginModal']/div/div/button"));
		validateWebElement(By.xpath("//*[@id='loginModal']/div/div/div[5]/a[1]"));
		validateWebElement(By.xpath("//*[@id=\"loginModal\"]/div/div/div[5]/a[2]"));
		if (driver.findElements(By.id("username")).size() > 0) {// 1>0
			System.out.println("UserName editbox is displayed on login page#############");
		} else {
			System.out.println("UserName editbox is NOT displayed on login page#############");
		}
		takeCurrentPageScreenshot("tc_009");
		System.out.println("tc_009 test case PASSED!");
		
//		click on Login button without any data
		driver.findElement(By.xpath("//*[@id='loginModal']/div/div/button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		takeCurrentPageScreenshot("tc_009_ErrorMessages");

	}

	@Test
	public void tc_010() throws Exception {
		//Singup link clicked
		driver.findElement(By.xpath("//*[@id='loginModal']/div/div/div[5]/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		takeCurrentPageScreenshot("tc_010");
	}

	public void validateWebElement(By locator) {
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			System.out.println(locator + "  is displayed on signup page****");
		} else {
			System.out.println(locator + " is NOT displayed on signup page*****");
		}
	}

	public void takeCurrentPageScreenshot(String name) throws Exception {
		File myscreen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(myscreen, new File(".\\screenshots\\" + name + ".png"));
	}

}
