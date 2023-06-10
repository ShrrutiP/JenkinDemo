package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import POModel.LoginPageObject;
import POModel.pagefactoryExample;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCasePF 
{
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	
	LoginPageObject lp;
	pagefactoryExample pf;
	
	@BeforeMethod
	
	public void StartBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/login");
		pf = new pagefactoryExample(driver);
		
	}

	@Test
	
	public void LoginTestcase()
	{
	
		pf.EnterUserName("tomsmith");
		
		//Calling a Page Facotory Element 
		
		pagefactoryExample.UserID.sendKeys("Neha");
	//	pf.enterpassword("SuperSecretPassword!");
		
		//This type is to make the webelement declared without doing any action on the Page objects
		//lp.Rachana().click();

	
}
	
	@AfterMethod
	public void endTest()
	{
		driver.quit();
	}
}
