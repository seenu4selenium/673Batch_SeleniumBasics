package com.testscenarios;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/*
Assignment#13(Alert Demo end to end)
=================
Go to the H2o home page 
https://seenu4selenium.github.io/devices-management-Webpage/#login
Login with test/test credentials
Go to 'H2O Jewellery' tab
Click on Gold sub-tab
Click on Add to cart button for any product
Click on OK button on Alert
Go to Cart sub-tab
Click on Checkout button
Fill all valid information on Checkout page
Click on Place Order button
Capture success messge like " Congratulations! Your order has been confirmed!" 
Capture Invoice Number: 20260508030109
*/

public class AlertDemoEndtoEnd_Harika {

	@Test
	public static void alertDemo() throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seenu4selenium.github.io/devices-management-Webpage/#login");
		driver.findElement(By.id("username")).sendKeys("test");
		driver.findElement(By.id("password")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\"loginModal\"]/div/div/button")).click(); // Login

		driver.findElement(By.xpath("//*[@id=\"mainApp\"]/div[2]/button[4]")).click(); // H20 jEwellery tab
		driver.findElement(By.xpath("//*[@id=\"gold-earrings\"]/div/div[2]/button")).click();// Add to cart button

		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("Alert message is : " + alertMessage);

		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//*[@id=\"h2oJewellery\"]/div[1]/button[4]")).click();// Cart link
		driver.findElement(By.xpath("//*[@id=\"branches\"]/div[2]/button[1]")).click(); // checkout button

		driver.findElement(By.id("jewelleryAddress")).sendKeys("Denver,Colorado,80130");

		Select paymentType = new Select(driver.findElement(By.id("jewelleryPaymentType")));
		paymentType.selectByVisibleText("Credit Card");

		driver.findElement(By.id("jewelleryNameOnCard")).sendKeys("NAME");
		driver.findElement(By.id("jewelleryCardNumber")).sendKeys("123412341234");
		driver.findElement(By.id("jewelleryCvv")).sendKeys("134");
		driver.findElement(By.id("jewelleryExpiration")).sendKeys("10/12");

		Thread.sleep(2000);
		driver.findElement(By.id("jewelleryPayConfirmBtn")).click();
		

		String successMessage = driver.findElement(By.xpath("//*[@id=\"jewelleryOrderPlaced\"]/div/h3")).getText();
		System.out.println(successMessage);
		String invoiceNo = driver.findElement(By.id("jewelleryInvoiceNumberDisplay")).getText();
		System.out.println(invoiceNo);

		Thread.sleep(2000);
		driver.quit();

	}

}
