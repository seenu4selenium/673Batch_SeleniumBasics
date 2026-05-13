package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/*
Assignment#11(navigational methods)
=================
 https://blazedemo.com/
 Choose first dropdown as Boston then second dropdown value as London..
click on FindFlights button
select any one of the flight and reserve it.
Print the confirmation message to console*/

public class FlightBooking {

	// public static void main(String[] args) throws Exception {
	@Test
	public void testnew() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://blazedemo.com/");

		Select fromPort = new Select(driver.findElement(By.name("fromPort")));
		fromPort.selectByVisibleText("Boston");
		Select toPort = new Select(driver.findElement(By.name("toPort")));
		toPort.selectByVisibleText("London");
		driver.findElement(By.xpath("/html/body/div[3]/form/div/input")).click();

		// Choose this flight button
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td[1]/input")).click();

		driver.findElement(By.id("inputName")).sendKeys("Henry");
		driver.findElement(By.id("address")).sendKeys("Highlands ranch");
		driver.findElement(By.id("city")).sendKeys("Denver");
		driver.findElement(By.id("state")).sendKeys("Colorado");
		driver.findElement(By.id("zipCode")).sendKeys("80130");

		Select country = new Select(driver.findElement(By.id("cardType")));
		country.selectByVisibleText("Diner's Club");

		driver.findElement(By.id("creditCardNumber")).sendKeys("1234 1234 1234");
		driver.findElement(By.id("creditCardMonth")).sendKeys("08");
		driver.findElement(By.id("creditCardYear")).sendKeys("1947");
		driver.findElement(By.id("nameOnCard")).sendKeys("HARIKA");

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/form/div[11]/div/input")).click();

		String print = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody")).getText();
		System.out.println("all values : " + print);

//		String print = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[1]/td[2]")).getText();
//		System.out.println("Thank you for your purchase today!");
//		System.out.println("ID                :                " + print);
//
//		print = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]")).getText();
//		System.out.println("Status            :                " + print);
//
//		print = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[3]/td[2]")).getText();
//		System.out.println("Amount            :                " + print);
//
//		print = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[4]/td[2]")).getText();
//		System.out.println("CardNumber        :                " + print);
//
//		print = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[5]/td[2]")).getText();
//		System.out.println("Expiration        :                " + print);
//
//		print = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[6]/td[2]")).getText();
//		System.out.println("AuthCode          :                " + print);
//
//		print = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[7]/td[2]")).getText();
//		System.out.println("Date              :                " + print);

		Thread.sleep(2000);
		driver.quit();
	}

}
