package com.poc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InvoiceRegistration {

	
	// Use the below declarations

    public static WebDriver driver;

    public static List<WebElement> statusList;

    public static WebElement element;

    public static String result;

    public static int row;
    
    String appUnderTest = "https://webapps.tekstac.com/InvoiceUpdates/";

    public WebDriver createDriver() {   // Do not change the method signature
        // Create the driver using 'getWebDriver' method. Assign it to variable 'driver'

        // Return the variable driver
        driver = DriverSetup2.getWebDriver(appUnderTest);

        return driver;
    }

    public void testInvoice(String[] invoiceDetails) {  // Do not change the method signature

        // Find the form elements and set the passed parameter values.
        // Submit the form.
        //name invoice utype status category amount number comment
        //String name = ExcelUtils2.Row.getCell(0).getStringCellValue();

        // Fill the data into "Customer Name" text box
        driver.findElement(By.id("name")).sendKeys(invoiceDetails[0]);

        // Fill the data into "Invoice Number" text box
        driver.findElement(By.id("number")).sendKeys(invoiceDetails[1].replace(".0", ""));

    
        // Check Usertype parameter and select the appropriate check box

        String utype = ExcelUtils2.Row.getCell(2).getStringCellValue();

        if (utype.contains("oldUser")) {
        	driver.findElement(By.id("oldUser")).click();
        	}
        else if (utype.contains("newUser")) {
        	driver.findElement(By.id("newUser")).click();
        	}

        // Store all the radio button options in a list
        statusList = driver.findElements(By.name("status"));

        // Select Status from available radio button options

        String status = ExcelUtils2.Row.getCell(3).getStringCellValue();

        switch (status.toLowerCase()) {
        case "pending":
            driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[4]/td[2]/input[1]")).click();
            break;
        case "approved":
            driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[4]/td[2]/input[2]")).click();
            break;
        case "rejected":
            driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[4]/td[2]/input[3]")).click();
            break;
        }

        // select a Category from the drop down

        String invoice = ExcelUtils2.Row.getCell(4).getStringCellValue();

        Select objSelect = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[5]/td[2]/select[1]")));
        
        switch(invoice) {
        case "serviceInvoice":
            //Select objSelect = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[5]/td[2]/select[1]")));
            objSelect.selectByVisibleText("Service Invoice");
            break;
        case "standardInvoice":
            //Select objSelect = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[5]/td[2]/select[1]")));
            objSelect.selectByVisibleText("Standard Invoice");
            break;
        case "utilityInvoice":
            //Select objSelect = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[5]/td[2]/select[1]")));
            objSelect.selectByVisibleText("Utility Invoice");
            break;
        }
 
        // Fill the data into "Amount" text box
        driver.findElement(By.name("amount")).sendKeys(invoiceDetails[5]);
        
        // Fill the data into "Mobile number" text box
        driver.findElement(By.name("num")).sendKeys(invoiceDetails[6]);

        // Fill the data into "Comments" text area
        driver.findElement(By.name("comments")).sendKeys(invoiceDetails[7]);

        // Click on register button
        driver.findElement(By.id("submit")).click();
    }

    public void writeexcel() {  // Do not change the method signature
        // Identify web element displaying the Output text
        result = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]")).getText();

        // Invoke 'writeExcelData' method from ExcelUtil.java & // Pass 'result' as parameter
        ExcelUtils2.writeExcelData(result);  
    	}

    public void closeBrowser() { // Do not change the method signature
        // close the driver
        driver.quit();
    	}

 

    public static void main(String[] args) throws Exception { // Do not change the method signature
        InvoiceRegistration invReg = new InvoiceRegistration();
        
        // Implement the code
     // Invoke createDriver() method
        invReg.createDriver();
        
        // For loop 'row' only 2 times
        // Only 2 dataset rows in the excel sheet so keep 'row' as 1 and 2.  
        for(int a=1;a<=2;a++) {	        
	        // Invoke 'readExcelData' method from ExcelUtil.java
	        // Pass the variable 'row' and sheet name "TestData"
	        ExcelUtils2.readExcelData(row, "TestData");
	        
	        // Invoke ‘testInvoice’ method by passing testval array from class ExcelUtil
	        invReg.testInvoice(ExcelUtils2.testval);
	        
	        // Invoke writeexcel() method
	        invReg.writeexcel();
	        System.out.println();
        	}     
        // Invoke closeBrowser() method
        invReg.closeBrowser();
    }

}
