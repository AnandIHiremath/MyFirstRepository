package com.mindtree.runner;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mindtree.pageobject.LogOutObject;
import com.mindtree.pageobject.LoginPageObject;
import com.mindtree.reusablemethods.HelperClass;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.ConfigureData;
import com.mindtree.utilities.ExcelDataProvider;

public class Runner {

	public WebDriver driver = null;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public ConfigureData config;
	public ExcelDataProvider ex;
	BaseClass baseObject;
	public static Logger log = LogManager.getLogger(Runner.class);

	@BeforeSuite
	public void before() throws IOException {

		ex = new ExcelDataProvider();
		config = new ConfigureData();
		baseObject = new BaseClass();
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/FirstReport.html"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Mindtree");
		log.info("initilizing all the methods");
	}

	@BeforeClass
	public void setUp() {
		driver = baseObject.initializeDriver(driver, config.getUrl());
		log.info("Setting Up Browser");
	}

	@Test
	public void test1() throws InterruptedException {
		test = extent.createTest("Login Page Test ", "This is test to validate login page ");
		test.log(Status.INFO, "Starting Test case");
		Thread.sleep(3000);
		LoginPageObject lo=new LoginPageObject();
		lo.enterUsername(driver, ex.getStringData("Sheet1", 0, 0));
		test.pass("Entered username");
		lo.enterPassword(driver, ex.getStringData("Sheet1", 0, 1));
		test.pass("Entered password");
		lo.clickButton(driver);
		test.pass("Login Successful");
		log.info("Test Executed login successful");
	}
	
	@Test
	public void test2() {
		test = extent.createTest("Logout Test ", "This is test to validate logout ");
		test.log(Status.INFO, "Starting Teat case");
		LogOutObject loo=new LogOutObject();
		loo.clickButton(driver);
		test.pass("Logout Successful");
		log.info("Test Executed logout successful");
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail("Test failed",
					MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenShot(driver)).build());
			log.warn("This Test Failed captured ScreenShot");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenShot(driver)).build());
			log.info("Test Passed captured ScreenShot");
		}
		extent.flush();
	}
	
	@AfterSuite
	public void tearDown() {
		baseObject.quitBrowser(driver);
	}

}
