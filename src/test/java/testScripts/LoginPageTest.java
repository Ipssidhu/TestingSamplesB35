package testScripts;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginPageTest {
	WebDriver driver;
	Properties prop;
	
  @BeforeMethod
  public void setup() throws IOException {
	  String path = System.getProperty("user.dir")+
			  "//src//test//configfiles//config.properties";
	  prop = new Properties();
	  FileInputStream fin= new FileInputStream(path);
	  prop.load(fin);
	  String strBrowser = prop.getProperty("broswer");
	  if(strBrowser.equalsIgnoreCase("chrome")) {
		  
		  driver = new ChromeDriver();
	  }
	  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
  }
  
  @Test(dataProvider="LoginData")
  public void validLogin(String strUsr, String strPwd) {
	  driver.get(prop.getProperty("url"));
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys(strUsr);
      driver.findElement(By.xpath("//input[@name='password' and @type='password']")).sendKeys(strPwd);
      driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
      boolean isDisp = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
      Assert.assertTrue(isDisp);
	  
  }
  
  @DataProvider(name ="LoginData")
  public Object[][] getData() throws CsvValidationException, IOException {
	  String path = System.getProperty("user.dir")+
			  "//src//test//testData//loginData.csv";
	  
	  CSVReader reader = new CSVReader(new FileReader(path));
	  String arr[];
	  ArrayList<Object> dataList = new ArrayList<Object>();
	  while((arr=reader.readNext())!= null) {
		 Object[] record = {arr[0],arr[1]} ;
		 dataList.add(record);
	  }
	  return dataList.toArray(new Object[dataList.size()][]);
  }
    
  @AfterMethod
  public void teardown() {
	  driver.close();
  }
  
}
