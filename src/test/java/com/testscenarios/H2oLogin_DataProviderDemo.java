package com.testscenarios;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class H2oLogin_DataProviderDemo {
	public WebDriver driver;

	@Test(dataProvider = "mytestdata")
	public void f(String username, String password) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seenu4selenium.github.io/devices-management-Webpage/#");
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"loginModal\"]/div/div/button")).click();
	}

	@DataProvider
	public Object[][] mytestdata() {
		return new Object[][] { 
			new Object[] { "sdgsdggs", "sdsggs" }, 
			new Object[] { "test", "test" }, 
			new Object[] { "TestcaseSix", "Abcd1234#" }, 
		};
	}
}
