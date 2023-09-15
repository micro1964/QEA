package com.testautomationuniversity.web.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	//private static ExtentReports extent = 
	
	Logger logger = LoggerFactory.getLogger(TestListener.class);
	
	@Override
	public void onTestStart(ITestResult result) {
		logger.info(result.getName()+" test started "+getCurrentTime());
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getName()+" test passed!");
		//ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info(result.getName()+ " test failed!");
		//ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info(result.getName()+ " test was skipped!");
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.info(result.getName()+" test failed but within success percentage!");
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		logger.info(result.getName()+" test failed with timeout");
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("\n"+context.getName()+" started "+getCurrentTime()+"\n");
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("\n"+context.getName()+" finished "+getCurrentTime()+"\n");
		//ITestListener.super.onFinish(context);
	}
	
	public java.sql.Timestamp getCurrentTime() {
		java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
		
		logger.info("TimeStamp: "+timestamp.toString());
		return timestamp;
	}

}
