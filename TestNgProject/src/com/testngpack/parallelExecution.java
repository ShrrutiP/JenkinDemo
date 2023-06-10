package com.testngpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parallelExecution 
{
	public static WebDriver chromeDriver;
	public static WebDriver firefoxDriver;
	
	@Test
	
	public void LoginChromeTest()
	{
		WebDriverManager.chromedriver().setup();
		
		chromeDriver = new ChromeDriver();
		
		chromeDriver.manage().window().maximize();
		
		//Give the URL to be navigated, we use get method to navigate to a URL
		
		chromeDriver.get("https://the-internet.herokuapp.com/login");
		
		WebElement userid = chromeDriver.findElement(By.id("username"));
		WebElement password = chromeDriver.findElement(By.name("password"));
		WebElement SubmitButton = chromeDriver.findElement(By.className("radius"));
		
		userid.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		SubmitButton.click();
	}
	
@Test
	
	public void LoginFirefoxTest()
	{
		WebDriverManager.firefoxdriver().setup();
		
		firefoxDriver = new FirefoxDriver();
		
		firefoxDriver.manage().window().maximize();
		
		//Give the URL to be navigated, we use get method to navigate to a URL
		
		firefoxDriver.get("https://the-internet.herokuapp.com/login");
		
		WebElement userid = firefoxDriver.findElement(By.id("username"));
		WebElement password = firefoxDriver.findElement(By.name("password"));
		WebElement SubmitButton = firefoxDriver.findElement(By.className("radius"));
		
		userid.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		SubmitButton.click();


}
}