package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethodDemo {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(" https://automationexercise.com/login");

		driver.findElement(By.name("name")).sendKeys("abcd");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"))
				.sendKeys("11223344@gmail.com");
		Thread.sleep(1000);
		//Sign up button
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
		//Thread.sleep(1000);
		
		//click on Back icon on browser
		driver.navigate().back();
		//Thread.sleep(1000);
		System.out.println("clicked on Back icon on browser****");
		//driver.findElement(By.name("email")).sendKeys("sreenivas@gmail.com");
		//Thread.sleep(1000);
		
		//Click on Refresh icon on browser
		driver.navigate().refresh();
		//Thread.sleep(1000);
		System.out.println("clicked on Refresh icon on browser****");

		//Click on Forward icon on browser
		driver.navigate().forward();
		System.out.println("clicked on Forward icon on browser****");


	}

}
