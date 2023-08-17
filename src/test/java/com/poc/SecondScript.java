package com.poc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondScript {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		
		this.driver = driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		
		//driver.manage().window().maximize();
	}
	
	@Test
	public void testOne() {
		
		driver.get("https://google.com");
		
		driver.findElement(By.id("W0wltc")).click();
	
		Assert.assertTrue(driver.getTitle().toLowerCase().contains("google"), "Google page is loaded");
		
		String textSearchTerm = "Test Automation University";
		
		WebElement elem = driver.findElement(By.id("APjFqb"));
		
		elem.sendKeys(textSearchTerm);
		
		elem.submit();
		
		WebElement wLink = driver.findElement(By.partialLinkText("Applitools"));
		
		wLink.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.invisibilityOf(wLink));
		
		Assert.assertTrue(driver.getTitle().toLowerCase().contains(textSearchTerm.toLowerCase()), textSearchTerm+" is displayed in the page title.");

	}
	
	@AfterTest
	public void cleanUp() {
		driver.quit();
	}

}
