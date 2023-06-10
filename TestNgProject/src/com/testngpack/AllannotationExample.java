package com.testngpack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllannotationExample 
{
//@BeforeSuite
	
	public void BeforeSuiteMethod()
	{
		System.out.println("BeforeSuite");
	}
	
	//@BeforeTest
	
	public void BeforeTestMethod()
	{
		System.out.println("BeforeTest");
	}


	//@BeforeClass

public void BeforeClassMethod()
{
		System.out.println("BeforeClass");
}


	@BeforeMethod

public void Beforemethod()
{
		System.out.println("BeforeMethod");
}
	
	@Test
	
	public void Testcase1()
	{
		System.out.println("Test case1");
	}
	
	
@Test
	
	public void Testcase2()
	{
		System.out.println("Test case2");
	}
	
	
	@AfterMethod
	
	public void Aftermethod()
	{
		System.out.println("AfterMethod");
	}
//@AfterClass
	
	public void AfterClassMethod()
	{
	System.out.println("AfterClass");
		
	}

//@AfterTest

public void AfterTestMethod()
{
	System.out.println("AfterTest");
	
}

//@AfterSuite

public void AfterSuiteMethod()
{
	System.out.println("After Suite");

}
}
