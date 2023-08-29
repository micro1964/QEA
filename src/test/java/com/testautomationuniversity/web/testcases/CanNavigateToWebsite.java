package com.testautomationuniversity.web.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.testautomationuniversity.web.pages.GoogleSearchPage;
import com.testautomationuniversity.web.pages.TauLandingPage;
import com.testautomationuniversity.web.setup.BaseClass;

@Listeners(com.testautomationuniversity.web.utilities.TestListener.class)
public class CanNavigateToWebsite extends BaseClass{
	
	public CanNavigateToWebsite(){
		super();
		}
	WebDriver driver;
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	
	@BeforeTest
	public void setUp() {
		this.driver = getWebDriver();
		
		extent.attachReporter(spark);
				
	}
	
	
	@Test
	public void navigateToTAUWebsite() {
		extentLogger =  report.createTest("Navigate To TAU Website");
		GoogleSearchPage googleSearchPage= new GoogleSearchPage(driver);
		
		openSearchApplication();
		
		googleSearchPage.clickRejectCookiesButton();
		
		if(googleSearchPage.getPageTitle().toLowerCase().contains("google")){
			String msg = "The page title contains the expected text";
			Assert.assertTrue(true,msg);
			extentLogger.info("1.1").log(Status.PASS, msg);
			//extent.createTest("1.1").log(Status.PASS, msg);
			}
		else {
			String msg = "The page title does not contain the expected text";
			Assert.assertTrue(false,msg);
			extentLogger.info("1.1").log(Status.FAIL, msg);
			//extent.createTest("1.1").log(Status.FAIL, msg);
			}
		
		String textSearchTerm = "Test Automation University";
		
		googleSearchPage.enterGoogleSearchText(textSearchTerm);
		
		googleSearchPage.submitSearch();
		
		googleSearchPage.clickApplitoolsLink();
		
		TauLandingPage tauLandingPage = new TauLandingPage(driver);
		
		tauLandingPage.waitForWebsite();
		
		if(tauLandingPage.getPageTitle().toLowerCase().contains(textSearchTerm.toLowerCase())) {
			String msg = "The page title contains the expected text";
			Assert.assertTrue(true,msg);
			//extent.createTest("1.2","Page Title Check").log(Status.PASS, msg);
			extentLogger.info("1.2-Page Title Check").log(Status.PASS, msg);
			}
		else {
			String msg = "The page title does not contain the expected text";
			Assert.assertTrue(false,msg);
			//extent.createTest("1.2","Page Title Check").log(Status.FAIL, msg).fail(MediaEntityBuilder.createScreenCaptureFromPath("img.jpg").build());
			extentLogger.info("1.2-Page Title Check").log(Status.FAIL, msg).fail(MediaEntityBuilder.createScreenCaptureFromPath("img.jpg").build());
			}
		
		//extent.createTest("1.3","Verify Failure Step").fail(MediaEntityBuilder.createScreenCaptureFromPath("img.jpg").build());
		//tauLandingPage.closePage();
		}
	
	@AfterTest
	public void cleanUp() {
		driver.quit();
		extent.flush();
	}
}
