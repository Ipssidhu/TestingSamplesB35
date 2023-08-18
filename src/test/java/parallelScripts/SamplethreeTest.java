package parallelScripts;

import org.testng.annotations.Test;

public class SamplethreeTest {
  @Test
  public void testOne() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test 31 in SampleThree  " +id);
  }
  @Test
  public void testTwo() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test 32 in SampleThree  " +id);
  }
  @Test
  public void testThree() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test 33 in SampleThree " +id);
  }
  @Test
  public void testFour() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test 34 in SampleThree " +id);
  }
}
