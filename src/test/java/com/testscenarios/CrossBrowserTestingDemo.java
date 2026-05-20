package com.testscenarios;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class CrossBrowserTestingDemo {
	public WebDriver driver;

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("Chrome")  String browserName) {
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

	@Test
	public void login() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"))
				.submit();
	}

}
