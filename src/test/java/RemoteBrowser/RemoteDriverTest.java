package RemoteBrowser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteDriverTest {
	WebDriver driver;
  @Test
  public void remoteTest() throws MalformedURLException {
	  ChromeOptions options = new ChromeOptions();
	  options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
	  options.setCapability(CapabilityType.BROWSER_VERSION, "116");
	  String strHub ="";
	  driver = new RemoteWebDriver(new URL(strHub), options);
	  driver.navigate().to("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.name("q"));
		srcBox.sendKeys("Cypress Tutorial");
		srcBox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Cypress Tutorial - Google Search");
  }
}
