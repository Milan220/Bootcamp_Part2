package com.tutorialN.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.tutorialN.Utulities.Utils;




public class TestBase {

	
	public WebDriver driver;
	public Properties prop;
	public Properties dataprop;  
	public FileInputStream ip;
	public FileInputStream ip1;
	public ChromeOptions option;
	
	public TestBase() throws IOException {
		prop = new Properties();
		ip = new FileInputStream("C:\\Users\\benam\\eclipse-workspace\\Part2_HybrideFrameWork\\src\\test\\java\\com\\tutorialN\\config\\config.properties");
		prop.load(ip);
		dataprop = new Properties();
		ip1 = new FileInputStream("C:\\Users\\benam\\eclipse-workspace\\Part2_HybrideFrameWork\\src\\test\\java\\com\\tutorialN\\TestData\\dataProp.properties");
		dataprop.load(ip1);
	}
	
	public WebDriver initializeBrowser(String browserName) {
		if(browserName.equals("Chrome")) {
			option = new ChromeOptions();
			option.setPageLoadStrategy(PageLoadStrategy.NONE);
			option.addArguments("--start-maximized");
			driver = new ChromeDriver(option);
			
		}else {
			System.out.println("The Browser not mutch");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils. PAGELOAD_TIMEOUTS));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utils. PAGELOAD_TIMEOUTS));
		driver.get(prop.getProperty("url"));
		return driver;
		
		
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
