package com.h2ojewellery_testscenarios;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_01_Registration {
	public WebDriver driver;// driver is null right now

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = new EdgeDriver();// driver is contains something
		driver.manage().window().maximize();
		driver.get(" https://seenu4selenium.github.io/devices-management-Webpage");
		driver.findElement(By.linkText("Sign Up")).click();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	// Create a method to validate an element
	public void validateWebElement(By locator) {
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			System.out.println(locator + "  is displayed on signup page****");
		} else {
			System.out.println(locator + " is NOT displayed on signup page*****");
		}
	}

	@Test(description = "Verify H2o Signup page will display  all fields")
	public void tc_001() throws Exception {

//		driver = new EdgeDriver();// driver is contains something
//		driver.manage().window().maximize();
//		driver.get(" https://seenu4selenium.github.io/devices-management-Webpage");
//		driver.findElement(By.linkText("Sign Up")).click();
//		Thread.sleep(2000);

		// Validate Name editbox is displayed or not on signup page
		validateWebElement(By.id("signUpName"));
		validateWebElement(By.id("signUpPassword"));
		validateWebElement(By.id("signUpEmail"));
		validateWebElement(By.id("signUpRole"));
		validateWebElement(By.xpath("//*[@id=\"signUpModal\"]/div/button[1]"));
		validateWebElement(By.xpath("//*[@id=\"signUpModal\"]/div/button[2]"));

//		size(): Validate given locator is displayed or not in the current page.
//	      if the given locator is NOT displayed  one time on the page, the SIZE of the element is =0
//	      if the given locator is displayed  one time on the page, the SIZE of the element is =1

//		
//		if (driver.findElements(By.id("signUpName")).size() > 0) {// 1>0
//			System.out.println("Name editbox is displayed on signup page#############");
//		} else {
//			System.out.println("Name editbox is NOT displayed on signup page#############");
//		}

		System.out.println("TC_001 test case PASSED!");
	}

	@Test(description = "Verify alert with blank data on  Signup page")
	public void tc_002() throws Exception {
		// Click on Sign Up button without fill any data
		driver.findElement(By.xpath("//*[@id=\"signUpModal\"]/div/button[1]")).click();
		Thread.sleep(2000);

		// Get the alert text
		String alertTextActualResults = driver.switchTo().alert().getText();
		String alertTextExpectedResults = "Error: Please fill all fields.";

		if (alertTextActualResults.equals(alertTextExpectedResults)) {
			System.out.println("Aletr text is matched as per test case******");
		} else {
			System.out.println("Aletr text is NOT matched as per test case******");
		}

		driver.switchTo().alert().accept();

		System.out.println("TC_002 test case PASSED!");
	}

	@Test(description = "Verify name field alert with invalid data on  Signup page")
	public void tc_003() throws Exception {
		// SignUp page locators
		WebElement signUpPage_Name_EditBox = driver.findElement(By.id("signUpName"));
		WebElement signUpPage_Password_EditBox = driver.findElement(By.id("signUpPassword"));
		WebElement signUpPage_Email_EditBox = driver.findElement(By.id("signUpEmail"));
		WebElement signUpPage_UserType_Dropdown = driver.findElement(By.id("signUpRole"));
		WebElement signUpPage_Signup_Button = driver.findElement(By.xpath("//*[@id=\"signUpModal\"]/div/button[1]"));

		// Expect name all values I have enter valid data
		signUpPage_Name_EditBox.sendKeys("98794753163516541645");// Invalid data
		signUpPage_Password_EditBox.sendKeys("Test@123");
		signUpPage_Email_EditBox.sendKeys("Test123@gmail.com");
		new Select(signUpPage_UserType_Dropdown).selectByVisibleText("Normal User");
		signUpPage_Signup_Button.click();
		Thread.sleep(2000);

		// validate Name data alert is displayed or not?

		// Get the alert text
		String alertTextActualResults = driver.switchTo().alert().getText();
		String alertTextExpectedResults = "Error: Name must contain only letters and spaces.";

		if (alertTextActualResults.equals(alertTextExpectedResults)) {
			System.out.println("Aletr text is matched as per 3rd test case******");
		} else {
			System.out.println("Aletr text is NOT matched as per 3rd test case******");
		}

		driver.switchTo().alert().accept();
		System.out.println("TC_003 test case PASSED!");
	}

	@Test(description = "Verify Password field alert with invalid data on  Signup page")
	public void tc_004() throws Exception {

		// SignUp page locators
		WebElement signUpPage_Name_EditBox = driver.findElement(By.id("signUpName"));
		WebElement signUpPage_Password_EditBox = driver.findElement(By.id("signUpPassword"));
		WebElement signUpPage_Email_EditBox = driver.findElement(By.id("signUpEmail"));
		WebElement signUpPage_UserType_Dropdown = driver.findElement(By.id("signUpRole"));
		WebElement signUpPage_Signup_Button = driver.findElement(By.xpath("//*[@id=\"signUpModal\"]/div/button[1]"));

		signUpPage_Name_EditBox.clear();
		signUpPage_Password_EditBox.clear();
		signUpPage_Email_EditBox.clear();

		// Except password, enter valid data for all other fields.
		signUpPage_Name_EditBox.sendKeys("abcdefghijklmnopqrstuvwxyz");
		signUpPage_Password_EditBox.sendKeys("123456789");// Invalid data
		signUpPage_Email_EditBox.sendKeys("Test000@gmail.com");
		new Select(signUpPage_UserType_Dropdown).selectByVisibleText("Normal User");
		signUpPage_Signup_Button.click();
		Thread.sleep(2000);

		// validate password data alert is displayed or not?

		// Get the alert text
		String alertTextActualResults = driver.switchTo().alert().getText();
		String alertTextExpectedResults = "Error: Password must be at least 8 characters and include uppercase, lowercase, number, and special character.";
		if (alertTextActualResults.equals(alertTextExpectedResults)) {
			System.out.println("Alert text is matched as per 4th test case******");
			System.out.println("TC_004 test case PASSED!");
		} else {
			System.out.println("Alert text is NOT matched as per 4th test case******");
			System.out.println("TC_004 test case FAILED!");
		}

		driver.switchTo().alert().accept();
		// driver.switchTo().alert().

		Thread.sleep(2000);

	}

	@Test(description = "Verify Email field alert with invalid data on  Signup page")
	public void tc_005() throws Exception {

		// Navigating page from Login to Signup page.
//		driver.findElement(By.linkText("Sign Up")).click();
//		Thread.sleep(2000);

		// SignUp page locators
		WebElement signUpPage_Name_EditBox = driver.findElement(By.id("signUpName"));
		WebElement signUpPage_Password_EditBox = driver.findElement(By.id("signUpPassword"));
		WebElement signUpPage_Email_EditBox = driver.findElement(By.id("signUpEmail"));
		WebElement signUpPage_UserType_Dropdown = driver.findElement(By.id("signUpRole"));
		WebElement signUpPage_Signup_Button = driver.findElement(By.xpath("//*[@id=\"signUpModal\"]/div/button[1]"));

		signUpPage_Name_EditBox.clear();
		signUpPage_Password_EditBox.clear();
		signUpPage_Email_EditBox.clear();

		// Expect Password all values I have enter valid data
		signUpPage_Name_EditBox.sendKeys("abcdefghijklmnopqrstuvwxyz");
		signUpPage_Password_EditBox.sendKeys("Abcd1234#");
		signUpPage_Email_EditBox.sendKeys("Test888");// Invalid data
		new Select(signUpPage_UserType_Dropdown).selectByVisibleText("Normal User");
		signUpPage_Signup_Button.click();

		// validate Email data alert is displayed or not?

		// Get the alert text
		String alertTextActualResults = driver.switchTo().alert().getText();
		String alertTextExpectedResults = "Error: Please enter a valid email address.";

		if (alertTextActualResults.equals(alertTextExpectedResults)) {
			System.out.println("Alert text is matched as per 5th test case******");
			System.out.println("TC_005 test case PASSED!");
		} else {
			System.out.println("Alert text is NOT matched as per 5th test case******");
			System.out.println("TC_005 test case FAILED!");
		}
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	@Test(description = "Verify admin user will able to Signup successfully")
	public void tc_006() throws Exception {
		/*
		 * // Navigating page from Login to Signup page.
		 * driver.findElement(By.linkText("Sign Up")).click(); Thread.sleep(2000);
		 */

		driver = new EdgeDriver();// driver is contains something
		driver.manage().window().maximize();
//		driver.get(" https://seenu4selenium.github.io/devices-management-Webpage");
		driver.get("https://h2o-applications.onrender.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.linkText("Sign Up")).click();
		Thread.sleep(2000);

		// SignUp page locators
		WebElement signUpPage_Name_EditBox = driver.findElement(By.id("signUpName"));
		WebElement signUpPage_Password_EditBox = driver.findElement(By.id("signUpPassword"));
		WebElement signUpPage_Email_EditBox = driver.findElement(By.id("signUpEmail"));
		WebElement signUpPage_UserType_Dropdown = driver.findElement(By.id("signUpRole"));
		WebElement signUpPage_Signup_Button = driver.findElement(By.xpath("//*[@id=\"signUpModal\"]/div/button[1]"));

		signUpPage_Name_EditBox.clear();
		signUpPage_Password_EditBox.clear();
		signUpPage_Email_EditBox.clear();

		// Enter valid data for all fields and user as Admin
		signUpPage_Name_EditBox.sendKeys("TestcaseSix");
		signUpPage_Password_EditBox.sendKeys("Abcd1234#");
		signUpPage_Email_EditBox.sendKeys("Test888@gmail.com");
		new Select(signUpPage_UserType_Dropdown).selectByVisibleText("Admin");// Admin user
		signUpPage_Signup_Button.click();

		// Check Admin user alert message for successful login

//		// Get the alert text
//		String alertTextActualResults = driver.switchTo().alert().getText();
//		String alertTextExpectedResults = "Account created successfully! You can now login.";
//
//		if (alertTextActualResults.equals(alertTextExpectedResults)) {
//			System.out.println("Alert text is matched as per 6th test case******");
//			System.out.println("TC_006 test case PASSED!");
//		} else {
//			System.out.println("Alert text is NOT matched as per 6th test case******");
//			System.out.println("TC_006 test case FAILED!");
//		}
//
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();

	}

	@Test(description = "Verify Normal user will able to Signup successfully")
	public void tc_007() throws Exception {
		driver = new EdgeDriver();// driver is contains something
		driver.manage().window().maximize();
//		driver.get(" https://seenu4selenium.github.io/devices-management-Webpage");
		driver.get("https://h2o-applications.onrender.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Navigating page from Login to Signup page.
		driver.findElement(By.linkText("Sign Up")).click();
		Thread.sleep(2000);

		// SignUp page locators
		WebElement signUpPage_Name_EditBox = driver.findElement(By.id("signUpName"));
		WebElement signUpPage_Password_EditBox = driver.findElement(By.id("signUpPassword"));
		WebElement signUpPage_Email_EditBox = driver.findElement(By.id("signUpEmail"));
		WebElement signUpPage_UserType_Dropdown = driver.findElement(By.id("signUpRole"));
		WebElement signUpPage_Signup_Button = driver.findElement(By.xpath("//*[@id=\"signUpModal\"]/div/button[1]"));

		signUpPage_Name_EditBox.clear();
		signUpPage_Password_EditBox.clear();
		signUpPage_Email_EditBox.clear();

		// Enter valid data for all fields and user as Admin
		signUpPage_Name_EditBox.sendKeys("TestcaseSeven");
		signUpPage_Password_EditBox.sendKeys("Abcd1234#");
		signUpPage_Email_EditBox.sendKeys("Test888@gmail.com");
		new Select(signUpPage_UserType_Dropdown).selectByVisibleText("Normal User");// Normal user
		signUpPage_Signup_Button.click();

		// Check Normal user alert message for successful login

//		// Get the alert text
//		String alertTextActualResults = driver.switchTo().alert().getText();
//		String alertTextExpectedResults = "Account created successfully! You can now login.";
//
//		if (alertTextActualResults.equals(alertTextExpectedResults)) {
//			System.out.println("Alert text is matched as per 7th test case******");
//			System.out.println("TC_007 test case PASSED!");
//		} else {
//			System.out.println("Alert text is NOT matched as per 7th test case******");
//			System.out.println("TC_007 test case FAILED!");
//		}
//
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();

	}

	@Test(description = "Verify alert message when sign up with existing user details")
	public void tc_008() throws Exception {
		driver = new EdgeDriver();// driver is contains something
		driver.manage().window().maximize();
//		driver.get(" https://seenu4selenium.github.io/devices-management-Webpage");
		driver.get("https://h2o-applications.onrender.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Navigating page from Login to Signup page.
		driver.findElement(By.linkText("Sign Up")).click();
		Thread.sleep(2000);

		// SignUp page locators
		WebElement signUpPage_Name_EditBox = driver.findElement(By.id("signUpName"));
		WebElement signUpPage_Password_EditBox = driver.findElement(By.id("signUpPassword"));
		WebElement signUpPage_Email_EditBox = driver.findElement(By.id("signUpEmail"));
		WebElement signUpPage_UserType_Dropdown = driver.findElement(By.id("signUpRole"));
		WebElement signUpPage_Signup_Button = driver.findElement(By.xpath("//*[@id=\"signUpModal\"]/div/button[1]"));

		signUpPage_Name_EditBox.clear();
		signUpPage_Password_EditBox.clear();
		signUpPage_Email_EditBox.clear();

		// Enter existing user credentials
		signUpPage_Name_EditBox.sendKeys("TestcaseSeven");
		signUpPage_Password_EditBox.sendKeys("Abcd1234#");
		signUpPage_Email_EditBox.sendKeys("Test888@gmail.com");
		new Select(signUpPage_UserType_Dropdown).selectByVisibleText("Normal User");
		signUpPage_Signup_Button.click();

		// Check existing user alert message.

		// Get the alert text
		String alertTextActualResults = driver.switchTo().alert().getText();
		String alertTextExpectedResults = "User already exists! An account with this name and email is already registered.";
		// User already exists! An account with this name and email is already
		// registered.

//		if (alertTextActualResults.equals(alertTextExpectedResults)) {
//			System.out.println("Alert text is matched as per 8th test case******");
//			System.out.println("TC_008 test case PASSED!");
//		} else {
//			System.out.println("Alert text is NOT matched as per 8th test case******");
//			System.out.println("TC_008 test case FAILED!");
//		}
//
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();

	}

}
