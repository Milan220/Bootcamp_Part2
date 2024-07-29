package com.tutorialN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;

	@FindBy( id ="input-email")
	private WebElement emailTextBox;
	

	@FindBy( id ="input-password")
	private WebElement passwordTextBox;
	
	@FindBy( css ="input.btn.btn-primary")
	private WebElement loginButton;
	
	@FindBy( css ="div.alert.alert-danger.alert-dismissible")
	private WebElement invalidCredentialsWarning;
	
	
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
	}
	public void enterPassord(String Password) {
		passwordTextBox.sendKeys(Password);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public String retriveInvalidCredentialsWarningMessage() {
		String warningMessage = invalidCredentialsWarning.getText();
		return warningMessage;
	}
	
	
	public String retriveInvalidEmailWarningMessage() {
		String warningMessage = invalidCredentialsWarning.getText();
		return warningMessage;
	}
	
}
