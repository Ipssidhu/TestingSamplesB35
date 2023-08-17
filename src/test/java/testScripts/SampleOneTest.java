package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleOneTest {
  @Test
  public void searchCypressTest() {
	  WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.name("q"));
		srcBox.sendKeys("Cypress Tutorial");
		srcBox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Cypress Tutorial - Google Search");
  }
  
}
