package com.testscenarios;

/*Assignment_8 [Selenium basics]
=================
https://podfoods.co/
CLick on Login button on right top corner
Type Email & Password 
Clicko n VENDOR
then click on Login button*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PodFoodsLogin {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		// Maximize the window/browser
		driver.manage().window().maximize();
		
		driver.get("https://podfoods.co/");

		driver.findElement(By.linkText("Login")).click();
	

		driver.findElement(By.name("email")).sendKeys("harikawd2@gmail.com");
		driver.findElement(By.name("password")).sendKeys("password123");

		// select vendor
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/div/div[4]/div/div/label[1]/span")).click();

		// select Login button
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/div/div[6]/div/button/span")).click();

	}

}
