package testScripts;
//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
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	private int retryCount =0;
	public static final int maxRetryCount=3;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (retryCount < maxRetryCount) {
		      retryCount++;
		      return true;			
		}
		return false;
	}
	

}
