package RemoteBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HTMLUnitTest {
	
  @Test
  public void headlesstest() throws InterruptedException {
	  HtmlUnitDriver driver = new HtmlUnitDriver();
	  driver.navigate().to("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.name("q"));
		srcBox.sendKeys("Cypress Tutorial");
		srcBox.submit();
		//Thread.sleep(2000);
		System.out.println("Page Title .... "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Cypress Tutorial - Google Search");
  }
}
