package com.testngpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest 
{
	WebDriver driver;
	@Test
	@Parameters({"username","password"})
	public void logintest(String username,String Password) throws Exception
	{
		//Best Practise to follow is to maximize the browser before running the test
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
				driver.manage().window().maximize();
				
				//Give the URL to be navigated, we use get method to navigate to a URL
				
				driver.get("https://the-internet.herokuapp.com/login");
				
				WebElement userid = driver.findElement(By.id("username"));
				WebElement password = driver.findElement(By.name("password"));
				WebElement SubmitButton = driver.findElement(By.className("radius"));
				
				userid.sendKeys(username);
				password.sendKeys(Password);
				SubmitButton.click();
						
				
				Thread.sleep(5000);
				
				//Automatically close the browser session
				driver.close();


}
}
	
