package com.testautomationuniversity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleSearchPage {

	WebDriver driver;
	
	@FindBy(id="W0wltc") private WebElement RejectCookiesButton;
	@FindBy(id="APjFqb") private WebElement GoogleSearchTextfield;
	@FindBy(partialLinkText="testautomationu.applitools.com") private WebElement partialLinkTextApplitools;
	
	
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickRejectCookiesButton() {
		RejectCookiesButton.click();
	}
	
	public void enterGoogleSearchText(String searchText) {
		GoogleSearchTextfield.sendKeys(searchText);
	}
	
	public void submitSearch() {
		GoogleSearchTextfield.submit();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void clickApplitoolsLink() {
		partialLinkTextApplitools.click();
	}

}
