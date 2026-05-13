package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseVsQuitDemo {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://autotestdata.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Need Help?")).click();

		// close(): Close the current browser
		//driver.close();
		Thread.sleep(2000);
		driver.quit();

	}

}
