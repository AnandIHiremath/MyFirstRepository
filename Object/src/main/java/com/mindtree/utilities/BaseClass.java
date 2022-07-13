package com.mindtree.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver initializeDriver(WebDriver driver, String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
