package com.tutorialN.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialN.Pages.HomePage;
import com.tutorialN.Pages.NewAccountPage;
import com.tutorialN.Pages.RegisterPage;
import com.tutorialN.Utulities.Utils;
import com.tutorialN.testBase.TestBase;

public class RegisterTest extends TestBase {
	
public RegisterTest() throws IOException {
		super();
		
	}



public WebDriver driver;
	
	@BeforeMethod
	
	public void setup() {
		driver = initializeBrowser(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnRegister();
		
		
	}
	
	@Test(priority = 1)
	public void registerWithValidDetails() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataprop.getProperty("firstName"));
		registerPage.enterLastName(dataprop.getProperty("lastName"));
		registerPage.enterEmail(Utils.emailWithDateStamp());
		registerPage.enterTelephone(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerPage.checkPrivacyPolicyCheckBox();
		registerPage.clickOnContinueButton();
		
		NewAccountPage newAccountPage = new NewAccountPage(driver);
		Assert.assertTrue(newAccountPage.successLinkIsDisplayed());
		
	}
	
	@Test(priority = 2)
	public void registerWithAllDetails() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataprop.getProperty("firstName"));
		registerPage.enterLastName(dataprop.getProperty("lastName"));
		registerPage.enterEmail(Utils.emailWithDateStamp());
		registerPage.enterTelephone(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerPage.clickOnNewsLetterRadioButton();
		registerPage.checkPrivacyPolicyCheckBox();
		registerPage.clickOnContinueButton();
		
		NewAccountPage newAccountPage = new NewAccountPage(driver);
		Assert.assertTrue(newAccountPage.successLinkIsDisplayed());
		
		
		
	}
	
	@Test(priority = 3)
	public void registerWithExsistEmail() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataprop.getProperty("firstName"));
		registerPage.enterLastName(dataprop.getProperty("lastName"));
		registerPage.enterEmail(prop.getProperty("validEmail"));
		registerPage.enterTelephone(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerPage.clickOnNewsLetterRadioButton();
		registerPage.checkPrivacyPolicyCheckBox();
		registerPage.clickOnContinueButton();
		
		String actualMessage = registerPage.retrieveDuplicateEmailWarningMessage();
		String expectedMessage = dataprop.getProperty("warningMessageFoeExsistingEmail");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		
	}
	
	/*
	@Test(priority = 4)
	public void registerWithWrongPassword() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataprop.getProperty("firstName"));
		registerPage.enterLastName(dataprop.getProperty("lastName"));
		registerPage.enterEmail(Utils.emailWithDateStamp());
		registerPage.enterTelephone(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("wrongPassword"));
		registerPage.clickOnNewsLetterRadioButton();
		registerPage.checkPrivacyPolicyCheckBox();
		registerPage.clickOnContinueButton();
		
	
		
		Assert.assertTrue(registerPage.retreiveWrongPasswordMessage().contains(dataprop.getProperty("warningMessageForPasswordCpnfirm")));
		
	}
	
	
	@Test(priority = 5)
	public void registerWithNoDeatails() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.checkPrivacyPolicyCheckBox();
		registerPage.clickOnContinueButton();
		
		
		
		String actualFirstNameMessage = registerPage. retrieveFirstnameWarningMessage();
		String expectedFirstNameMessage = dataprop.getProperty("firstNameWarningMessage");
		Assert.assertTrue(actualFirstNameMessage.contains(expectedFirstNameMessage));
		
		String actualLastNameMessage = registerPage.retrieveLastnameWarningMessage();
		String expectedLastNameMessage = dataprop.getProperty("lastNameWarningMessage");
		Assert.assertTrue(actualLastNameMessage.contains(expectedLastNameMessage));
		
		String actualEmailMessage = registerPage.retrieveEmailWarningMessage();
		String expectedEmailMessage = dataprop.getProperty("emailWarningMessage");
		Assert.assertTrue(actualEmailMessage.contains(expectedEmailMessage));
		
		String actualTelephonMessage = registerPage. retrieveTelephoneWarningMessage();
		String expectedTelephonMessage = dataprop.getProperty("telephoneWarningMessage");
		Assert.assertTrue(actualTelephonMessage.contains(expectedTelephonMessage));
		
		String actualPasswordMessage = registerPage.retrievePasswordWarningMessage();
		String expectedPasswordMessage = dataprop.getProperty("passwordWarningMessage");
		Assert.assertTrue(actualPasswordMessage.contains(expectedPasswordMessage));
		
	}
	*/
	
	
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
