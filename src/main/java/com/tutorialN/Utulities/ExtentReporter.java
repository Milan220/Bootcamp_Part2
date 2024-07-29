package com.tutorialN.Utulities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReporter() throws Exception {
		ExtentReports extent = new ExtentReports();
		
		
		File extentreportfile = new File("C:\\Users\\benam\\eclipse-workspace\\Part2_HybrideFrameWork\\test-output\\ExtentReport2\\tutorialsninjaTest.html");
		
		ExtentSparkReporter spark = new ExtentSparkReporter( extentreportfile);
		
		
		spark.config().setReportName("Boot Camp Exam");
		spark.config().setDocumentTitle("Valid Credentials Test");
		spark.config().setTimeStampFormat(" MM/dd/YYYY : hh:mm:ss");
		
		
		extent.attachReporter(spark);
		
		Properties prop = new Properties();
		FileInputStream ip = new  FileInputStream("C:\\Users\\benam\\eclipse-workspace\\Part2_HybrideFrameWork\\src\\test\\java\\com\\tutorialN\\config\\config.properties");
		prop.load(ip);
		
		extent.setSystemInfo("Web application", prop.getProperty("url"));
		extent.setSystemInfo("Browser", prop.getProperty("browser"));
		extent.setSystemInfo("email", prop.getProperty("validEmail"));
		extent.setSystemInfo("password", prop.getProperty("validPassword"));
		extent.setSystemInfo("Tester", "Amina");
		
		
		return extent;
		  
		  
	}
	
	
	

}
