package com.tutorialN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCardPage {
	
	
	
	public WebDriver driver;
	
	@FindBy(id = "button-cart")
	private WebElement addToCardButton;
	
	
	
	
	public AddToCardPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnAddButton() {
		addToCardButton.click();	
	}
	

}
