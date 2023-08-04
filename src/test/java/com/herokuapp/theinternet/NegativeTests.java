package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Negatgive using https://the-internet.herokuapp.com/login
 */

public class NegativeTests {

	@Test
	public void IncorrectUserTest() {
		// Create driver
		System.out.println("Starting incorrect user name test.");
		//Chrome driver
		//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//FireFox driver
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		// Open broswer and enter URL
		// Expand browser
		driver.manage().window().maximize();
		String testsite = "https://the-internet.herokuapp.com/login";
		driver.get(testsite);
		// log to console
		System.out.println("Opened test site.");

		// Enter incorrect User name
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("mooshu");
		// username.sendKeys("tomsmith"); //This should cause test to fail

		// Enter correct password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");

		// Click Login button
		WebElement loginbutton = driver.findElement(By.tagName("button"));
		loginbutton.click();

		// Check Error message
		WebElement errorMsg = driver.findElement(By.id("flash"));
		String extepctedMsg = "Your username is invalid!";
		String actualMsg = errorMsg.getText();

		Assert.assertTrue(actualMsg.contains(extepctedMsg),
				"Actual message does not contain expected message.\nActual Message: " + actualMsg);

		// Close driver
		driver.quit();
	}


	@Test
	public void IncorrectPasswordTest() {
		// Create driver
		System.out.println("Starting incorrect password test.");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Open broswer and enter URL
		// Expand browser
		driver.manage().window().maximize();
		String testsite = "https://the-internet.herokuapp.com/login";
		driver.get(testsite);
		// log to console
		System.out.println("Opened test site.");

		// Enter incorrect User name
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith"); 

		// Enter correct password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("NotSecretPassword!");
		//password.sendKeys("SuperSecretPassword!"); //This should cause test to fail

		// Click Login button
		WebElement loginbutton = driver.findElement(By.tagName("button"));
		loginbutton.click();

		// Check Error message
		WebElement errorMsg = driver.findElement(By.id("flash"));
		String extepctedMsg = "Your password is invalid!";
		String actualMsg = errorMsg.getText();

		Assert.assertTrue(actualMsg.contains(extepctedMsg),
				"Actual message does not contain expected message.\nActual Message: " + actualMsg);

		// Close driver
		driver.quit();
	}

}
