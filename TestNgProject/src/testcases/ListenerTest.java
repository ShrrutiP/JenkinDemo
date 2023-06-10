package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import testngListeners.SampleTestcase;


public class ListenerTest extends TestListenerAdapter
{
 public void onTestStart(ITestResult result)
 {
	 System.out.println("Test Started...");
 }
 public void onTestSuccess(ITestResult result)
 {
	 System.out.println("Test Success...");
 }
 public void onTestFailure(ITestResult result)
 {
	 System.out.println("Test Failure...");
	 TakeScreenshotOnFail(result,"Fail");
 }
 public void onTestSkipped(ITestResult result)
 {
	 System.out.println("Test Skipped...");
 }
 public static String TakeScreenshotOnFail(ITestResult result, String status)
	{
		
		File Screenshotfile = ((TakesScreenshot) LoginTestcase.driver).getScreenshotAs(OutputType.FILE);
		
		String OutputPath = "C:\\Users\\Lenovo\\SiplilearnPractice\\TestNgProject\\Screenshot\\screenshot1.png";
		
		try {
			FileUtils.copyFile(Screenshotfile, new File(OutputPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OutputPath;
		

	}
}