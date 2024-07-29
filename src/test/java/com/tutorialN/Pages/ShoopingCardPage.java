package com.tutorialN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoopingCardPage {


	
	public WebDriver driver;
	
	@FindBy(id = "cart-total")
	private WebElement displayPrice;
	
	@FindBy(linkText = "Checkout")
	private WebElement checkoutButton;
	
	
	
	public ShoopingCardPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean displayPriceWebElement() {
		boolean display =  displayPrice.isDisplayed();
		return display;
	}
	
	
	public void clickOnCheckoutButton() {
		checkoutButton.click();
	}
}
