package Test;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class Listener extends Baseclass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
	}
	
		
	@Override
	public void onTestSuccess(ITestResult result) {
		
	test.pass(result.getMethod().getMethodName()+" is passed");
	screen();
	
	
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
	test.fail(result.getMethod().getMethodName()+"is failed");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
