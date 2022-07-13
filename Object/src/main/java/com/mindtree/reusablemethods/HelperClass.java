package com.mindtree.reusablemethods;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class HelperClass {

	public static String captureScreenShot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath=System.getProperty("user.dir")+"./ScreenShots/picture"+ getCurrentDataTime() + ".png";

		try {
			FileHandler.copy(src, new File(screenShotPath));
		} catch (IOException e) {
			System.out.println("Unable to capture ScreenShot" + e.getMessage());
		}
		
		return screenShotPath;
	}

	public static String getCurrentDataTime() {
		DateFormat format=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return format.format(currentDate);
	}
}
