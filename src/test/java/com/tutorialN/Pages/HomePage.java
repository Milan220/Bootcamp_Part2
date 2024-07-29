package com.tutorialN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	public WebDriver driver;

	@FindBy(xpath = "//div[@class = 'pull-left']/following::a[2]")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText ="Login")
	private WebElement loginLink;
	

	@FindBy(xpath = "//a[text() = 'Register']")
	private WebElement registerLink;
	

	@FindBy(name = "search")
	private WebElement searchTextBox;
	
	
	@FindBy(css = "button.btn.btn-default.btn-lg" )
	private WebElement searchButton;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnMyAccount() {
		myAccountDropdown.click();
	}
	

	public void clickOnLogin() {
		 loginLink.click();
	}
	
	
	public void clickOnRegister() {
		 registerLink.click();
	}
	
	
	public void entervalidProduct(String enterProduct) {
		searchTextBox.sendKeys(enterProduct);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	

	
	
	
}
