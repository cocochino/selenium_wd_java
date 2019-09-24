package com.herokuapp.theinternet;

//Import Web Driver and Chrome Driver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//Import test annotation
import org.testng.annotations.Test;

/*
 * Simple Test Case 1 using https://the-internet.herokuapp.com/login
 */

public class PositiveTest {
	
	//Add Test annotation
	@Test
	public void loginTest() {
		System.out.println("Start Login Page test.");
		
		// Create Chrom driver instance that perform command with
		// Name of the driver and path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximize the browser
		driver.manage().window().maximize();

		//Open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		//log to console
		System.out.println("URL is opened");

		// Sleep 3 sec for visual check by human
		sleep(3000);
		


//		Enter user name
//		Enter password
//		Click Login button

//		Verifications: 
//		Correct URL
//		Logout button exists
//		Correct message
		
		//Close browser
		driver.quit();

	}

	
	private void sleep(long m) {
		//Slows down test 
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
