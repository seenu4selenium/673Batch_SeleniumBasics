package com.testscenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class XpathDemo {
	public WebDriver driver;

	@Test
	public void f() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.xpath("//button[contains(@name,'st')]")).click();
		System.out.println("Start clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@name,'st')]")).click();
		System.out.println("stop clicked");

	}
}
