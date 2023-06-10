package POModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pagefactoryExample 
{
public WebDriver driver;
	
	@FindBy(xpath="//input[@id='username']")
	public static WebElement UserID;
	
	@FindBy(xpath="//input[@id='password']")
	public static WebElement Password;
	
	
	public pagefactoryExample(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void EnterUserName(String username)
	{
		UserID.sendKeys(username);
	}
	
	public WebElement ClearUserNameField()
	{
		return UserID;
	}

}
