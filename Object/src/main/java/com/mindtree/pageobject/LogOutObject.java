package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;

import com.mindtree.uistore.LogOutLocater;



public class LogOutObject {

	LogOutLocater lo;
	public void clickButton(WebDriver driver) {
		lo=new LogOutLocater(driver);
		lo.Logout.click();
	}
}
