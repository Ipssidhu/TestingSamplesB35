package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleOneTest {
	WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void Setup(String strBrowser) {
		if(strBrowser.equalsIgnoreCase("chrome")) {
		 driver = new ChromeDriver();
		}
		else if(strBrowser.equalsIgnoreCase("edge")) {
			 driver = new EdgeDriver();
			}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
	}
  @Test(retryAnalyzer=RetryAnalyser.class)
  public void searchCypressTest() {
	  
		driver.navigate().to("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.name("q"));
		srcBox.sendKeys("Cypress Tutorial");
		srcBox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Cypress Tutorial - Google Search Page");
  }
  
  @AfterMethod
  public void teardown()
  {
  	driver.close();
  }
  
}
