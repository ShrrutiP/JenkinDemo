package com.testngpack;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class asserDemo 
{
	WebDriver driver;
	@Test
	public void AssertExampleProgram() throws Exception 
	{ 
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
			driver.manage().window().maximize();
			
			//Give the URL to be navigated, we use get method to navigate to a URL
			
			driver.get("https://the-internet.herokuapp.com/login");
			
			WebElement userid = driver.findElement(By.id("username"));
			WebElement password = driver.findElement(By.name("password"));
			WebElement SubmitButton = driver.findElement(By.className("radius"));
			
			userid.sendKeys("anc");
			password.sendKeys("prt");
			SubmitButton.click();
					
			
			Thread.sleep(5000);
	String ActualTitle = driver.getTitle(); 
	System.out.println("The Actual Page Title" +ActualTitle); 
//	Assert.assertEquals(ActualTitle, "Internet1");
	SoftAssert s1= new SoftAssert();
	
	//Assert.assertEquals(ActualTitle, "The Internet1");
	
	s1.assertEquals(ActualTitle, "The Internet1");
	System.out.println("Assertion Completed....");
	s1.assertAll();
	//Assert.assertEquals(ActualTitle, "Google Search"); 
//	driver.quit(); 
	}
	
	  //Even though the assertion is failure we can use Soft Assert class to continue our code 
	 
	  //Make sure assertAll method is called in the end ofteh code toe see the Assertions/check point erros
	 
	 


		
}
	
	
