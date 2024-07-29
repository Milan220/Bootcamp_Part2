package com.tutorialN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	public WebDriver driver;
	
	@FindBy( linkText ="My Account")
	private WebElement myAccountLink;
	
	
	
	public MyAccountPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean retreiveMyAcoountLink() {
		 boolean displayStatus = myAccountLink.isDisplayed();
		 return displayStatus;
	}

}
