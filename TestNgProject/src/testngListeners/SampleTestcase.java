package testngListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(failedscreenshotUtility.class)
public class SampleTestcase 
{
	public static WebDriver driver;
	@Test
	public void testcase() throws Exception
	{
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();

	WebElement SearchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

	SearchBox.sendKeys("Shirts");

	Thread.sleep(500);

	WebElement DressCat = driver.findElement(By.xpath("//input[@id='nav-search-submit-butto']"));

	DressCat.click();

	WebElement VerifyText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));

	if (VerifyText.isDisplayed()) {
		System.out.println("Shirts Section Page is displayed");
		System.out.println(VerifyText.getText());
	} else {
		System.out.println("In correct Page");
	}

	driver.quit();

}
}