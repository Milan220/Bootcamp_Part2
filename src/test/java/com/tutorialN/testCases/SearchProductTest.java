package com.tutorialN.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialN.Pages.AddToCardPage;
import com.tutorialN.Pages.CheckoutPage;
import com.tutorialN.Pages.HomePage;
import com.tutorialN.Pages.ShoopingCardPage;
import com.tutorialN.Pages.ValidProductPage;
import com.tutorialN.testBase.TestBase;

public class SearchProductTest extends TestBase {
	
	
public SearchProductTest() throws IOException {
		super();
		
	}


public WebDriver driver;
	
	@BeforeMethod
	
	public void setup() {
		driver = initializeBrowser(prop.getProperty("browser"));
		
		
		
	}
	
	@Test(priority = 1)
	public void searchWithValidProduct() {
		HomePage homePage = new HomePage(driver);
		homePage.entervalidProduct(dataprop.getProperty("validProduct"));
		homePage.clickOnSearchButton();
		ValidProductPage validProductPage = new ValidProductPage(driver);
		Assert.assertTrue(validProductPage.linkProductIsDisplayed());
	}
	
	
	@Test(priority = 2)
	public void searchWithInValidProduct() {
		
		HomePage homePage = new HomePage(driver);
		homePage.entervalidProduct(dataprop.getProperty("invalidProduct"));
		homePage.clickOnSearchButton();
		ValidProductPage validProductPage = new ValidProductPage(driver);
		
		String actualMessage = validProductPage.retreiveWarningMessage() ;
		String expectedMessage = dataprop.getProperty("WarningMessage");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
	

	@Test(priority = 3)
	public void searchWithNoProduct() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnSearchButton();
        ValidProductPage validProductPage = new ValidProductPage(driver);
		String actualMessage = validProductPage.retreiveWarningMessage() ;
		String expectedMessage = dataprop.getProperty("WarningMessage");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test(priority = 4)
	public void addValidProductAndCompletCheckout() {
		HomePage homePage = new HomePage(driver);
		homePage.entervalidProduct(dataprop.getProperty("validProduct"));
		homePage.clickOnSearchButton();
		ValidProductPage validProductPage = new ValidProductPage(driver);
		Assert.assertTrue(validProductPage.linkProductIsDisplayed());
		validProductPage. clickOnAddToCard();
		AddToCardPage addToCardPage = new AddToCardPage(driver);
		addToCardPage.clickOnAddButton();
		ShoopingCardPage shoopingCard = new ShoopingCardPage(driver);
		Assert.assertTrue(shoopingCard.displayPriceWebElement());
		shoopingCard.clickOnCheckoutButton();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.checkoutLinkDisplay();
		
		
	}
	
	
	
	
	
	
@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
