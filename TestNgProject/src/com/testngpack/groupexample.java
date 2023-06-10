package com.testngpack;

import org.testng.annotations.Test;

public class groupexample 
{
@Test (groups={"SmokeTest","RegressionTest"})
	
	public void loginAmazon()
	{
		System.out.println("Login Amaozn");
	
	}
	
	@Test (groups="RegressionTest")
	
	public void Registrations()
	{
		System.out.println("Registration");
	}
	
	@Test (groups="RegressionTest")
	
	public void SearchForProduct()
	{
		System.out.println("Search For Prodcut");
	}
	
	@Test (groups="SmokeTest")
	
	public void Placeanorder()
	{
		System.out.println("Place an order");
	}
	
	@Test (groups="RegressionTest")
	
	public void additemtowishlist()
	{System.out.println("Add item to wishlist");

	}
}
