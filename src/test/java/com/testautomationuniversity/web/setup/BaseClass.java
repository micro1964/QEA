package com.testautomationuniversity.web.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.testautomationuniversity.web.utilities.DateUtils;
import com.testautomationuniversity.web.utilities.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports report = Reporter.getReportInstance();
	public ExtentTest extentLogger;
	
	public static final int IMPLICT_WAIT = 2;
	public static final int SCRIPT_TIMEOUT = 10;
	public static final int PAGE_LOAD_TIMEOUT = 30;
	
	Logger logger = LoggerFactory.getLogger(BaseClass.class);
	
	public BaseClass() {
		prop = new Properties();
		String fs = System.getProperty("file.separator");
		String configFile = System.getProperty("user.dir")+fs+"src"+fs+"test"+fs+"resources"+fs+"config.properties";
		File file = new File(configFile);
		
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			logger.info("The configuration properties file is located in: "+configFile);
			System.out.println();
			} catch (IOException e) {
			System.out.println(e.getMessage());
			}
		}
	
	public static WebDriver getWebDriver() {
		
		switch(prop.getProperty("browser").toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				System.out.println("To Do: - Set required options/properties");
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				System.out.println("To Do: - Set Required Options/properties");
				driver = new EdgeDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				driver = new ChromeDriver();
				break;
			}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICT_WAIT));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCRIPT_TIMEOUT));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
		
		driver.manage().window().maximize();
		return driver;
	}
	
	public void openApplicationUnderTest() {
		driver.get(prop.getProperty("applicationUnderTest"));
	}
	
	public void openSearchApplication() {
		driver.get(prop.getProperty("searchUrl"));
	}
	
	public String takeScreenShot(String sMethodName) {
		String fileName = sMethodName+"_"+DateUtils.getTimeStamp().replaceAll(":", "_").replaceAll(" ", "_");
		String fs = System.getProperty("file.separator");
		String folder = System.getProperty("user.dir")+fs+"test-output"+fs+"screenshots"+fs;
		new File(folder).mkdirs();
		String path = folder+fileName;
		
		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			}
		return path;
	}
	
	public static String getBrowserUsed() {
		String b = prop.getProperty("browser").toLowerCase();
		return b;
	}
	
	@AfterMethod
	public void flushReports() {
		report.flush();
	}
}
