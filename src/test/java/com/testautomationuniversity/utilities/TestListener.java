package com.testautomationuniversity.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" test started "+getCurrentTime());
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" test passed!");
		//ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+ " test failed!");
		//ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+ " test was skipped!");
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getName()+" test failed but within success percentage!");
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println(result.getName()+" test failed with timeout");
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("\n"+context.getName()+" started "+getCurrentTime()+"\n");
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("\n"+context.getName()+" finished "+getCurrentTime()+"\n");
		//ITestListener.super.onFinish(context);
	}
	
	public java.sql.Timestamp getCurrentTime() {
		java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
		return timestamp;
	}

}
