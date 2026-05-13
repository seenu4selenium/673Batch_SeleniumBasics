package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
Assignment#11(navigational methods)
=================
 https://blazedemo.com/
 Choose first dropdown as Boston then second dropdown value as London..
click on FindFlights button
Click on back icon
clickon Refresh icon
click on Forward icon*/

public class NavigationalMethods {

	public static void main(String[] args) throws Exception {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://blazedemo.com/");
		
		Select fromPort = new Select(driver.findElement(By.name("fromPort")));
		fromPort.selectByVisibleText("Boston");			
		Select toPort = new Select(driver.findElement(By.name("toPort")));
		toPort.selectByVisibleText("London");
				driver.findElement(By.xpath("/html/body/div[3]/form/div/input")).click();
		
		Thread.sleep(1000);
		driver.navigate().back();
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.navigate().forward();
	
		//driver.close();
		Thread.sleep(1000);
		driver.quit();
	}

}
