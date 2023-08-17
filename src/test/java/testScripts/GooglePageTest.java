package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GooglePageTest {
	WebDriver driver;
//	@BeforeMethod
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
  @Test
  public void searchJavaTest() {
		driver.navigate().to("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.name("q"));
		srcBox.sendKeys("Java Tutorial");
		srcBox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
  }
    @Test
    public void searchSeleniumTest() {
		driver.navigate().to("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.name("q"));
		srcBox.sendKeys("Selenium Tutorial");
		srcBox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");	
    }
    
  //  @AfterMethod
    @AfterTest
    public void teardown()
    {
    	driver.close();
    }
    
}
