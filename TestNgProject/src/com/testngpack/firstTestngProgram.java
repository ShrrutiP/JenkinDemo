package com.testngpack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class firstTestngProgram 
{
	@Test
	public void runTest()
	{
		System.out.println("My first test");
	}
	@Test
	public void runTest2()
	{
		System.out.println("My second test");
		Assert.fail();
	}

}
