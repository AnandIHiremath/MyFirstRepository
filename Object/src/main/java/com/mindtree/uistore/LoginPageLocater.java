package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageLocater {

	public WebElement Username;
	public WebElement Password;
	public WebElement Login;
	public LoginPageLocater(WebDriver driver) {
		this.Username=driver.findElement(By.xpath("//input[@type='text']"));
	    this.Password=driver.findElement(By.xpath("//input[@type='password'][1]"));	
	    this.Login=driver.findElement(By.xpath("//a[@id=\"loginButton\"][1]"));
	}
}
