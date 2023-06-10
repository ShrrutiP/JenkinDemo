package testngListeners;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoggerTestExecution 
{

	public static WebDriver driver;
	//Creating the logger object for the class
	public static Logger log = Logger.getLogger(LoggerTestExecution.class);	
	@Test

	public void SampleTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		PropertyConfigurator.configure("./Log4jProp/Log4j.properties");

		driver = new ChromeDriver();
		log.info("Browser Opened Successfully");

		driver.get("https://www.amazon.in/");
		
		log.info("Amazon web site is opened");
		
		driver.manage().window().maximize();
		
		log.info("Browser is maximized");

		WebElement SearchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

		SearchBox.sendKeys("Shirts");
		log.info("Shirts is entered in the Search box");

		Thread.sleep(500);
		WebElement SearchIcon = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));

		SearchIcon.click();
		
		log.info("Search Icon is clicked");
		

		
		log.info("Shirts is entered in the Search box");
		WebElement VerifyText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));

		if (VerifyText.isDisplayed()) {
			System.out.println("Shirts Section Page is displayed");
			System.out.println(VerifyText.getText());
			log.info(VerifyText.getText()+"The page is loaded with Shirts");
		} else {
			System.out.println("In correct Page");
			log.info("Page is incorrect");
		}

		driver.quit();
		log.info("Browser Closed");
	}

		

}