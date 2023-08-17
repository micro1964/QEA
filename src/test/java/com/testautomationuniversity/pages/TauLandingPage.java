package com.testautomationuniversity.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TauLandingPage {
	
	WebDriver driver;
	
	@FindBy(id="app")private WebElement TauWebsite;
			
	public TauLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void waitForWebsite() {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("app")));
	}
	
	public void closePage() {
		driver.quit();
	}

}
