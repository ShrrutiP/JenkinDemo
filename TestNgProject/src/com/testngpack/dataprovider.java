package com.testngpack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider 
{
@DataProvider
	
	public static Object[] [] quantityForProduct()
	{
		return new Object [] []
				
				{
						{200},{199},{201},{0}
				};
		
	}
	
@DataProvider

public static Object[] [] SearchTestData()
{
	return new Object [] []
			
			{
					{"Shirts"},{"Pants"},{"Shoes"},{"Mobile"},{"Smart Watches"},{10}
			};
	
}

@Test (dataProvider="SearchTestData")

public void SearchforProduct(Object ProductNames)
{
	System.out.println("The different quanitites to be tested are" +ProductNames);
}
	@Test (dataProvider="quantityForProduct")
	
	public void CheckQuantity(int quanityValue)
	{
		System.out.println("The different quanitites to be tested are" +quanityValue);
	}
}
