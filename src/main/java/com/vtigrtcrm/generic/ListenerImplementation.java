package com.vtigrtcrm.generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListenerImplementation extends BaseClass implements ITestListener {
	ExtentReports extent ;
	ExtentTest test;
	JavaUtility j = new JavaUtility();
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getName();
		 test = extent.createTest(name);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName()+" Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		//int num = j.randomNum(20);
		String time = j.currentTime();
		File src = ((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+testName+"-"+time+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getName()+" failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName()+" Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extend-reports/reports"+"["+j.currentTime()+"]"+".html");
		reporter.config().setDocumentTitle("Vtiger Report");
		reporter.config().setReportName("vtiger execution report");
		reporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("url", "http://localhost:8888/");
        extent.setSystemInfo("browser", "chrome");
        extent.setSystemInfo("os", "windows");
        extent.setSystemInfo("author", "deepak");
    
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	

}
