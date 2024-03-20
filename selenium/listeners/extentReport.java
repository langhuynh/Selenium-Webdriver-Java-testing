package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class extentReport implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Attach Pass message to report");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Take screenshot and attach to report");


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Attach Skip message to report");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

         }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
