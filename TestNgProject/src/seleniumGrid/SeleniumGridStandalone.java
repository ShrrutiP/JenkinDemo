package seleniumGrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridStandalone 
{
	//In Selenium grid we run test cases on remote machines, we have remotewebdriver
	//When we run @Test annotated methods in parallel, each test methods will be run by a different thread. Both threads will be sharing WebDriver class variable. So let’s declare it as ThreadLocal.
	
		public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
		public static String URL = "http://192.168.1.2:4444";

	@Test
	public void chromeTest() throws Exception
	{
		ChromeOptions options= new ChromeOptions();
		//Set the Grid URL for the test case to be executed
		
				driver.set(new RemoteWebDriver(new URL(URL), options));
				
				driver.get().get("https://www.google.com");
				
				driver.get().manage().window().maximize();
				Thread.sleep(20000);
				
				driver.get().quit();
			
			}
	
	@Test
	
	public void FirefoxTest() throws MalformedURLException, InterruptedException
	{
		FirefoxOptions options = new FirefoxOptions();
		
		//Set the Grid URL for the test case to be executed
		
		driver.set(new RemoteWebDriver(new URL(URL), options));
		
		driver.get().get("https://www.google.com");
		
		driver.get().manage().window().maximize();
		
		Thread.sleep(20000);
		
		driver.get().quit();
		
	}
			
			public WebDriver getDriver()
			{
				return driver.get();
				
			}
		
	}
	


