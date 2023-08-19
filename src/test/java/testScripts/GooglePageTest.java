package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonUtils.Utility;



public class GooglePageTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SparkRport.html");
		extentReports.attachReporter(spark);
	}
	
		
	@BeforeMethod
		public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
  //@Test(priority =1)
	//@Test
     public void searchJavaTest() {
       	driver.navigate().to("https://www.google.com/");
       	SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(driver.getTitle(), "Google Page");
		WebElement srcBox= driver.findElement(By.name("q"));
		srcBox.sendKeys("Java Tutorial");
		srcBox.sendKeys(Keys.ENTER);
		softAssert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
		softAssert.assertAll();
  }
  
    //@Test(priority =2)
	@Test
    public void searchSeleniumTest() {
		extentTest = extentReports.createTest("Search Selenium Test");
		driver.navigate().to("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.name("q"));
		srcBox.sendKeys("Selenium Tutorial");
		srcBox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");	
		
    }
	   
//  @Test(priority =1) //  @Test(enabled=false)
	@Test
	    public void searchCucumberTest() {
		extentTest = extentReports.createTest("Search Cucumber Test");
		driver.navigate().to("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.name("q"));
		srcBox.sendKeys("Cucumber Tutorial");
		srcBox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Cucumber Tutorial - Google Search Page");
    }
	
	 // @Test(priority =2)
  // @Test
    public void searchAppiumTest() {
		extentReports.createTest("Search Appium Test");
	   driver.navigate().to("https://www.google.com/");
		WebElement srcBox= driver.findElement(By.name("q"));
		srcBox.sendKeys("Appium Tutorial");
		srcBox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search");
    }
    
    @AfterMethod
    public void teardown(ITestResult result)
    {
    	if(ITestResult.FAILURE == result.getStatus() ) {
    		extentTest.fail(result.getThrowable().getMessage());
    		String path = Utility.getScreenshotPath(driver);
        	extentTest.addScreenCaptureFromPath(path);
    	}
    	driver.close();
    }
  /* public void teardown(ITestResult result)
    {
    	if(ITestResult.FAILURE == result.getStatus())
    	{
    		extentTest.fail(result.getThrowable().getMessage());
    	//	String path = Utility.getScreenshotPath(driver);
    	//	extentTest.addScreenCaptureFromPath(path);
    	    	}
    	driver.close();
    } */
    @AfterTest
    public void finishExtent() {
    	extentReports.flush();
    }
}
