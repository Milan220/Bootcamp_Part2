package com.tutorialN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidProductPage {
	
	public WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement productLink;
	
	@FindBy(xpath = "//p[text()= 'There is no product that matches the search criteria.']")
	private WebElement warningMessage;
	
	
	
	@FindBy(xpath = "//span[text() ='Add to Cart']")
	private WebElement addToCardButton;
	
	
	
	
	public ValidProductPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean linkProductIsDisplayed() {
		boolean display = productLink.isDisplayed();
		return display;
	}
	
	public String  retreiveWarningMessage() {
		String display = warningMessage.getText() ;
		return display;
	}
	
	public void clickOnAddToCard() {
		addToCardButton.click();
	}
	
	
	
}
