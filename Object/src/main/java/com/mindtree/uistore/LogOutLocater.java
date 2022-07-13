package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutLocater {

	public WebElement Logout;
	public LogOutLocater(WebDriver driver) {
		this.Logout=driver.findElement(By.id("logoutLink"));
	}
}
