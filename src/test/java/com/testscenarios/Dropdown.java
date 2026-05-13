package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*Assignment_9 [Dropdown]
=================
Open URL: https://automationexercise.com/login
Type Name and email under "New User Signup!" form
Then click ojn Signup button
Fill all the fields (Radio button/Dropdown/Checkbox /Editbox/button)*/

public class Dropdown {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(" https://automationexercise.com/login");

		driver.findElement(By.name("name")).sendKeys("abcd");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"))
				.sendKeys("11223344@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("id_gender2")).click();
		driver.findElement(By.id("password")).sendKeys("passwordpassword");

		Select day = new Select(driver.findElement(By.id("days")));
		day.selectByVisibleText("15");

		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByVisibleText("August");

		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByVisibleText("1947");

		// scroll into element
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("newsletter")));

		driver.findElement(By.id("newsletter")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("optin")).click();

		driver.findElement(By.name("first_name")).sendKeys("aaaaaaaaaa");
		driver.findElement(By.name("last_name")).sendKeys("bbbbbbbb");
		driver.findElement(By.name("company")).sendKeys("ccccccccccc");

		driver.findElement(By.id("address1")).sendKeys("address1");
		driver.findElement(By.id("address2")).sendKeys("address2");
		driver.findElement(By.id("state")).sendKeys("Colorado");
		driver.findElement(By.id("city")).sendKeys("Denver");
		driver.findElement(By.id("zipcode")).sendKeys("80130");

		driver.findElement(By.id("country")).sendKeys("United States");

		jse.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button")));
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button")).click();

	}

}
