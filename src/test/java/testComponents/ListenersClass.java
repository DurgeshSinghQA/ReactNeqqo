package testComponents;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportClass;

public class ListenersClass extends BaseClass implements ITestListener{
	
	ExtentTest test;
	ThreadLocal<ExtentTest> localTest = new ThreadLocal<>();
	
	ExtentReports extent = ExtentReportClass.getReportObj();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		String SimpleClassName = result.getTestClass().getRealClass().getSimpleName();
		String methodName = result.getMethod().getMethodName();
		
		test = extent.createTest(SimpleClassName, methodName);
		//test = extent.createTest(result.getMethod().getMethodName());
		localTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		localTest.get().log(Status.PASS, "PASSED");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		localTest.get().fail(result.getThrowable());
		
		try {
			driver = (ThreadLocal<WebDriver>) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String path = null;
		
		try {
			path = takeScreenShot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		localTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		
		localTest.get().log(Status.SKIP, "SKIPPED");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		
		extent.flush();
		
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		File filePath = new File(path);
		
		try {
			Desktop.getDesktop().browse(filePath.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("Test Suite finished. Sending report...");
	    //EmailUtils.sendReport(path);
	}
	
}
