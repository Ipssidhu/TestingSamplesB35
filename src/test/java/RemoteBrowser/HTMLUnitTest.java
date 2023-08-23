package RemoteBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HTMLUnitTest {
	WebDriver driver;
  @Test
  public void headlesstest() {
	  
	  driver.navigate().to("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.name("q"));
		srcBox.sendKeys("Cypress Tutorial");
		srcBox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Cypress Tutorial - Google Search");
  }
}
