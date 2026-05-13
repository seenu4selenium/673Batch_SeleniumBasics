package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		//create Web-driver Object 
		WebDriver driver;
		
		//Launch chrome browser
		driver=new ChromeDriver();	
		
		//Type any URL
		driver.get("https://www.facebook.com/");
		
		//Type EMAIL & Password
		//find the object by using any locator then do action
		driver.findElement(By.name("email")).sendKeys("aafdsjfsdkbjdbf");
		driver.findElement(By.name("pass")).sendKeys("sdgdsg");
			
		//Click on login button
		driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/div[1]/div/div[3]/div/div/div")).click();
		
		
		
	}

}
