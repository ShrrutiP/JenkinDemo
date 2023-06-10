package POModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject 
{
	//This pattern in normal java technique of implmenting POM
		
		public WebDriver driver;
		
		By userid = By.name("username");
		By password = By.id("password");
		By submitButton = By.className("radius");
		
		
		public void enterusername(String testdata)
		{
			driver.findElement(userid).sendKeys(testdata);
		}
		
		
		public void enterpassword(String testdata1)
		{
			driver.findElement(password).sendKeys(testdata1);
		}
		public void submitButton()
		{
			
			driver.findElement(submitButton).click();
			
		}
		public WebElement userName()
		{
			return driver.findElement(userid);
		}
		public LoginPageObject(WebDriver driver)
		{
			this.driver=driver;
		}

	
}
