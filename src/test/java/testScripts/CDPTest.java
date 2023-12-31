package testScripts;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CDPTest {
	ChromeDriver driver;
	DevTools devTools;
	
	@BeforeTest
	public void Setup() {
		driver= new ChromeDriver();
		devTools = driver.getDevTools();
		devTools.createSession();
	}
	
		
  @Test
  public void viewPort() {
	  Map deviceMetrics = new HashMap() {{
		  	put("width",600);
		  	put("height", 1000);
		  	put("deviceScaleFactor", 50);
		  	put("mobile", true);
	  	  }};
	  	  
	  	  driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics );
	  	  driver.get("https://www.selenium.dev/");
	  }
@Test
  public void getNetworkTrafficDet() {
	   devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	   devTools.addListener(Network.requestWillBeSent(), 
			   entry -> {
				   System.out.println("Request URI: " + entry.getRequest().getUrl()+ "\n"
				   + "with Method : " + entry.getRequest().getMethod() + "\n" );
				   entry.getRequest().getMethod();
			   } );
	   
	   driver.get("https://www.google.co.in/");
	   devTools.send(Network.disable());
  }

}
/* 
package testScripts;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v114.emulation.Emulation;
import org.openqa.selenium.devtools.v113.network.model.Headers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CDPTest {
	ChromeDriver driver;
	DevTools devTools;
	
	@BeforeTest
	public void Setup() {
		
		driver= new ChromeDriver();
		devTools = driver.getDevTools();
		devTools.createSession();
	}
	
		
  @Test
  public void viewPort() {
	  Map deviceMetrics = new HashMap() {{
		  	put("width",600);
		  	put("height", 1000);
		  	put("deviceScaleFactor", 50);
		  	put("mobile", true);
	  	  }};
	  	  
	  	  driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics );
// devTools.send(Emulation.setDeviceMetricsOverride());
	  	//  driver.get("https://www.selenium.dev/");
	  }
//@Test
  public void getNetworkTrafficDet() {
	   devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	   devTools.addListener(Network.requestWillBeSent(), 
			   entry -> {
				   System.out.println("Request URI: " + entry.getRequest().getUrl()+ "\n"
				   + "with Method : " + entry.getRequest().getMethod() + "\n" );
				   entry.getRequest().getMethod();
			   } );
	   
	   driver.get("https://www.google.co.in/");
	   devTools.send(Network.disable());
	      
  }

//@Test
public void getLocTest() {
	devTools.send(Emulation.setGeolocationOverride(
			Optional.of(27.664827),
			Optional.of(-81.515755), 
			Optional.of(100))
			);
	driver.get("https://oldnavy.gap.com/stores");
}

@Test
public void basicAuthTest() {
	devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	Map<String,Object> headers = new HashMap<>();
	String strUser = "admin";
	String strPwd = "admin";
	
	String basicAuth = "Basic" + new String(new Base64().encode(
			String.format("%s:%s", strUser, strPwd).getBytes()));
	
	System.out.println("Auth ..." + basicAuth);
	headers.put("Authorization",basicAuth);
	devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
	
	driver.get("http://the-internet.herokuapp.com/basic_auth");
	String strMsg = driver.findElement(By.cssSelector("div.example p")).getText();
	Assert.assertEquals(strMsg, "Congratulation!  You must have proper the cerendtials.");
	
}
}
*/
