package testScripts;

import org.testng.annotations.Test;

public class SamplethreeTest {
  @Test(groups="feature1")
  public void testOne() {
	  System.out.println("Test 31 in SampleThree");
  }
  @Test(groups="feature2")
  public void testTwo() {
	  System.out.println("Test 32 in SampleThree");
  }
  @Test
  public void testThree() {
	  System.out.println("Test 33 in SampleThree");
  }
  @Test
  public void testFour() {
	  System.out.println("Test 34 in SampleThree");
  }
}
