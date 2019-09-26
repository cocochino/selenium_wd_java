package com.herokuapp.theinternet;

import org.openqa.selenium.By;
//Import Web Driver and Chrome Driver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//Import test annotation
import org.testng.annotations.Test;

/*
 * Simple Test Case 1 using https://the-internet.herokuapp.com/login
 */

public class PositiveTests {

	// Add Test annotation
	@Test
	public void loginTest() {
		System.out.println("Start Login Page test.");

		// Create Chrom driver instance that perform command with
		// Name of the driver and path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximize the browser
		driver.manage().window().maximize();

		// Open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		// log to console
		System.out.println("URL is opened");

		// Sleep 3 sec for visual check by human
		// sleep(3000);

		// Enter user name
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");

		// Enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");

		// Click Login button
		WebElement loginbutton = driver.findElement(By.tagName("button"));
		loginbutton.click();

		// Verifications:
		// Correct URL
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		//String expectedUrl = "https://the-internet.herokuapp.com/secure/broke"; //This should fail test
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Page URL mismatch.");

		// Logout button exists
		WebElement logoutbutton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logoutbutton.isDisplayed(), "Logout button is not visible.");

		// Correct message
		// WebElement successMsg = driver.findElement(By.cssSelector("#flash"));
		WebElement successMsg = driver.findElement(By.className("success"));
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successMsg.getText();
		// Exact comparison
		// Assert.assertEquals(actualMessage, expectedMessage, "Actual message is not
		// the same with expected.");
		// Contains comparison
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message is not contain expected message.\nActual Message: " + actualMessage);

		// Close browser
		driver.quit();

	}

	private void sleep(long m) {
		// Slows down test
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
