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
