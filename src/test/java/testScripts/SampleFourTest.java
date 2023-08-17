package testScripts;

import org.testng.annotations.Test;

public class SampleFourTest {
	@Test(groups="feature1")
	  public void testOne() {
		  System.out.println("Test 41 in SampleFour");
	  }
	  @Test(groups="feature2")
	  public void testTwo() {
		  System.out.println("Test 42 in SampleFour");
	  }
	  @Test
	  public void testThree() {
		  System.out.println("Test 43 in SampleFour");
	  }
	  @Test
	  public void testFour() {
		  System.out.println("Test 44 in SampleFour");
	  }
}
