package com.testscenarios;

/*Assignment_7[Selenium basics]
=================
Create a program to login by using below test data
https://seenu4selenium.github.io/devices-management-Webpage/#login
test / test*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class H2OLogin {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		//Maximize the window/browser
		driver.manage().window().maximize();
		
		driver.get("https://seenu4selenium.github.io/devices-management-Webpage/#login");
		driver.findElement(By.id("username")).sendKeys("asbvihfvasdakfhlsdkjgkjsdgb");
		Thread.sleep(5000);
		driver.findElement(By.id("username")).clear();
		Thread.sleep(5000);
		driver.findElement(By.id("username")).sendKeys("test");
		
		driver.findElement(By.id("password")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\"loginModal\"]/div/div/button")).click();

	}

}
