package com.testngpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class classExentreport 
{
public static WebDriver driver;
public static ExtentReports report;
public static ExtentTest test;
	
	@Test
	public void AmazonTestcase1()
	{
		report=new ExtentReports("./Report/report.html");
		test=report.startTest("Amazon Test case");
		WebDriverManager.chromedriver().setup();
		test.log(LogStatus.INFO, "Browsersetup");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		WebElement SearchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		
		SearchBox.sendKeys("Shirts");
		WebElement SearchIcon = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
	
	SearchIcon.click();
	test.log(LogStatus.PASS, "Click on Search Icon");
	
	
	//To verify it from the URL Parameters
	
	String CurrentURL = driver.getCurrentUrl();
	
	System.out.println(CurrentURL);
	
	if(CurrentURL.contains("Shirts"))
	{
		System.out.println("The Page is redirected to shirts correctly");
		test.log(LogStatus.PASS, "The Page is redirected to shirts correctly");
		
	}
	else
	{
		System.out.println("URL Redirection error");
	}
	
	driver.quit();
	report.endTest(test);
	report.flush();
	}

}
