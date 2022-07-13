package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;

import com.mindtree.uistore.LoginPageLocater;

public class LoginPageObject {
	LoginPageLocater lp;
	public void enterUsername(WebDriver driver,String uname) {
		lp=new LoginPageLocater(driver);
		lp.Username.sendKeys(uname);
	}

	public void enterPassword(WebDriver driver, String pwd) {
		lp=new LoginPageLocater(driver);
		lp.Password.sendKeys(pwd);
	}
	
	public void clickButton(WebDriver driver) {
		lp=new LoginPageLocater(driver);
		lp.Login.click();
	}
}
