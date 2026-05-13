package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/*Assignment_7 [Selenium basics]
=================
Open any browser
https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
Username : Admin
Password : admin123*/

public class OpenSourceLogin {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new EdgeDriver();
		// Maximize the window/browser
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).submit();

	}

}
