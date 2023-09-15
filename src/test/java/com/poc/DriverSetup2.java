package com.poc;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup2 {
	public static WebDriver driver;
	

	
	public static WebDriver getWebDriver(String sUrl) {
	
		WebDriverManager.chromedriver().setup();
	
		System.setProperty("webdriver.http.factory", "jdk-http-client");
	
		WebDriver driver = new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(6));
	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));
		
		driver.get(sUrl);
		
	return driver;
	}

}
