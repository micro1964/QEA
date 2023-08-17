package com.testautomationuniversity.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testautomationuniversity.pages.GoogleSearchPage;
import com.testautomationuniversity.pages.TauLandingPage;
import com.testautomationuniversity.setup.BaseClass;

@Listeners(com.testautomationuniversity.utilities.TestListener.class)
public class CanNavigateToWebsite extends BaseClass{
	
	public CanNavigateToWebsite(){
		super();
		}
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		this.driver = getWebDriver();
	}
	
	
	@Test
	public void navigateToTAUWebsite() {
		GoogleSearchPage googleSearchPage= new GoogleSearchPage(driver);
		
		openSearchApplication();
		
		googleSearchPage.clickRejectCookiesButton();
		
		Assert.assertTrue(googleSearchPage.getPageTitle().toLowerCase().contains("google"));
		
		String textSearchTerm = "Test Automation University";
		
		googleSearchPage.enterGoogleSearchText(textSearchTerm);
		
		googleSearchPage.submitSearch();
		
		googleSearchPage.clickApplitoolsLink();
		
		TauLandingPage tauLandingPage = new TauLandingPage(driver);
		
		tauLandingPage.waitForWebsite();
		
		Assert.assertTrue(tauLandingPage.getPageTitle().toLowerCase().contains(textSearchTerm.toLowerCase()));
		
		//tauLandingPage.closePage();
		}
	
	@AfterTest
	public void cleanUp() {
		driver.quit();
	}
}
