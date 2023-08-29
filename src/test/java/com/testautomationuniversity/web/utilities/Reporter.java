package com.testautomationuniversity.web.utilities;

import org.bouncycastle.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testautomationuniversity.web.setup.BaseClass;


public class Reporter {
	
	public static ExtentReports report;
	
	public static ExtentReports getReportInstance() {
		
		if(report==null) {
			String sName = "AutomatedTestReport_"+DateUtils.getTimeStamp();
			String reportName = sName+".html";
			String fs = System.getProperty("file.separator");
			ExtentSparkReporter htmlReport = new ExtentSparkReporter(System.getProperty("user.dir")+fs+"test-output"+fs+"spark-reports"+fs+reportName.toLowerCase());
			report = new ExtentReports();
			report.attachReporter(htmlReport);
			
			report.setSystemInfo("OS", System.getProperty("os.name"));
			report.setSystemInfo("OS Version", System.getProperty("os.version"));
			//report.setSystemInfo("Browser", BaseClass.getBrowserUsed());
			
			htmlReport.config().setDocumentTitle("QEA Test Automation");
			htmlReport.config().setReportName("Sample Web UI Test Report");
			htmlReport.config().setTheme(Theme.DARK);
			htmlReport.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
			}
			return report;
		}
	}

