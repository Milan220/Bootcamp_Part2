package com.tutorialN.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialN.Pages.HomePage;
import com.tutorialN.Pages.LoginPage;
import com.tutorialN.Pages.MyAccountPage;
import com.tutorialN.testBase.TestBase;

public class LoginTest extends TestBase {
	
   
	public LoginTest() throws IOException {
		super();
		
	}


	public WebDriver driver;
	
	@BeforeMethod
	
	public void setup() {
		driver = initializeBrowser(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnLogin();
		
	}
	
	@Test(priority = 1)
	public void loginWithValidCredianls() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassord(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		
		Assert.assertTrue(myAccountPage.retreiveMyAcoountLink());
			
	}
	
	@Test(priority = 2)
	public void loginWithInValidCredianls() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(dataprop.getProperty("invalidEmail"));
		loginPage.enterPassord(dataprop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		
		String actualMessage = loginPage.retriveInvalidCredentialsWarningMessage();
		String expectedMessage = dataprop.getProperty("warningMessage");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		
	}
	
	@Test(priority = 3)
	public void loginWithInValidEmail() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(dataprop.getProperty("invalidEmail"));
		loginPage.enterPassord(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		
		
		String actualMessage = loginPage.retriveInvalidEmailWarningMessage();
		String expectedMessage =  dataprop.getProperty("warningMessage");;
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		
	}

	@Test(priority = 4)
	public void loginWithInValidPassword() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassord(dataprop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		String actualMessage = loginPage.retriveInvalidEmailWarningMessage();
		String expectedMessage =  dataprop.getProperty("warningMessage");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		
		
	}
	@Test(priority = 5)
	public void loginWithNoCredantias() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnLoginButton();
		String actualMessage = loginPage.retriveInvalidEmailWarningMessage();
		String expectedMessage =  dataprop.getProperty("warningMessage");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		
		
	}
	
	@Test(priority = 6)
	public void loginWithEmptyEmail() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterPassord(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		
		String actualMessage =loginPage.retriveInvalidEmailWarningMessage() ;
		String expectedMessage = dataprop.getProperty("warningMessage");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
			
	}
	@Test(priority = 7)
	public void loginWithEmptyPassword() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(prop.getProperty("validEmail"));
        loginPage.clickOnLoginButton();
		
		String actualMessage =loginPage.retriveInvalidEmailWarningMessage() ;
		String expectedMessage =  dataprop.getProperty("warningMessage");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
			
	}
	
	
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}
	
	
	
	}
	
	

