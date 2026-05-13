package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Assignment#10(Hyperlinks)
=================
 9.1.
 Go to URL https://www.pqe.io/go-signup/
 Click on 'terms & conditions' link on bottom of the page
 
 9.2. 
 Go to https://phptravels.com/demo/
 Click on About Us link on bottom of the page
 
 9.3.
 Go to URL https://autotestdata.com/
 click on footer link 'Need Help?'*/

public class Hyperlinks {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://phptravels.com/demo/");
		Thread.sleep(2000);
		// Get the webpage Title
		String phptravels_pageTitle = driver.getTitle();
		System.out.println("phptravels_pageTitle : " + phptravels_pageTitle);

		// Get the currentpageURL
		String phpURL = driver.getCurrentUrl();
		System.out.println("phpURL : " + phpURL);

		driver.findElement(By.linkText("About Us")).click();

		// Get the webpage Title
		String phptravelsAboutUs_pageTitle = driver.getTitle();
		System.out.println("phptravelsAboutUs_pageTitle : " + phptravelsAboutUs_pageTitle);

		// Get the currentpageURL
		String phpURLAboutUS = driver.getCurrentUrl();
		System.out.println("phpURLAboutUS : " + phpURLAboutUS);

		Thread.sleep(5000);

		System.out.println("*******************************");
		driver.get(" https://autotestdata.com/");
		// Get the webpage Title
		String autotestdata_pageTitle = driver.getTitle();
		System.out.println("autotestdata_pageTitle : " + autotestdata_pageTitle);

		// Get the currentpageURL
		String autoURL = driver.getCurrentUrl();
		System.out.println("autoURL : " + autoURL);
		System.out.println("*******************************");

		//Get pageSource code
		String pagecode = driver.getPageSource();
		System.out.println(pagecode);

		driver.findElement(By.linkText("Need Help?")).click();

	}

}
