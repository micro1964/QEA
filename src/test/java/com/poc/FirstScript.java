package com.poc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstScript {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://google.com");
		
		driver.findElement(By.id("W0wltc")).click();
		
		if(driver.getTitle().toLowerCase().contains("google")) {
			System.out.println("PASSED");
			driver.close();
			driver.quit();
		}
		
		
		
		
		
		
		
		
	}

}
