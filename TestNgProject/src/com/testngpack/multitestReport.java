package com.testngpack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class multitestReport 
{

	
	public static ExtentReports report;
	
	public DateFormat dateformat;

	
		
		@BeforeClass
		
		public static void CreateReport()
		{
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			report = new ExtentReports("./Report/"+timestamp+"MutliTestReport.html");
		}
		
		
		@AfterClass
		
		public static void CloseReport()
		{
			
			report.flush();
			report.close();
			
		}
	@Test
		
		public void TestCase1()
		{
			ExtentTest test = report.startTest("Test case1");
			
			test.log(LogStatus.PASS, "Passed Test case");
			
			report.endTest(test);
			
		}
		
		@Test
		
		public void TestCase2()
		{
			ExtentTest test = report.startTest("Test case2");
			
			test.log(LogStatus.FAIL, "Failed Test Case");
			
			report.endTest(test);
		}
}
