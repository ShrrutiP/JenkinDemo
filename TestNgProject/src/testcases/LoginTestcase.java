package testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import POModel.LoginPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import testngListeners.failedscreenshotUtility;
@Listeners(ListenerTest.class)
public class LoginTestcase 
{
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	
	LoginPageObject lp;
	ListenerTest ListnerT;
	
		@BeforeTest
	public void startTest()
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		report=new ExtentReports("./Report/"+timestamp+"Loginreport.html");
		report.addSystemInfo("Host Name", "Local Host");
		report.addSystemInfo("User Name", "Shruti");
		
	}
	
	@BeforeMethod
	
	public void StartBrowser()
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/login");
		lp = new LoginPageObject(driver);
		
	}
	
	@Test
	
	public void LoginTestcase()
	{
		test= report.startTest("Start First Test...");
		lp = new LoginPageObject(driver);
		test.log(LogStatus.INFO, "Enter User name");
		lp.enterusername("tomsmith");
		test.log(LogStatus.PASS, "Valid user name");
		lp.enterpassword("SuperSecretPassword");
		lp.submitButton();
		report.endTest(test);
	}
	
	@Test

public void NegativeLogin()
{
	 test= report.startTest("Start Second Test...");
	 lp=new LoginPageObject(driver);
	 test.log(LogStatus.INFO, "Enter User name");
	lp.enterusername("VEMU PREM");
	test.log(LogStatus.FAIL, "Invalid user name");
	lp.userName().clear();
	lp.enterusername("Atheka");
	lp.enterpassword("Neha");
	
	
	//This type is to make the webelement declared without doing any action on the Page objects
	lp.submitButton();
	Assert.assertTrue(false);
	
	
}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL,"Test case is failed"+ result.getName());
			test.log(LogStatus.FAIL,result.getThrowable());
			String Screenshotpath=ListenerTest.TakeScreenshotOnFail(result,"Fail");
			System.out.println(Screenshotpath);
			test.log(LogStatus.FAIL, "Failed Test Case", test.addBase64ScreenShot(Screenshotpath));
        }
			
			
		
		report.endTest(test);
	}
	
	@AfterTest
	public void endTest()
	{
		
		driver.quit();
		report.flush();
		
		
		
	}
}
