package com.DemoWebShop_GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	public void webPageScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.screenShotPath);
		FileHandler.copy(temp, dest);
	}

	public void webElementScreenShot(WebElement element) throws IOException {
		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.screenShotPath);
		FileHandler.copy(temp, dest);
	}

	public void selectByVisibleText(WebElement ele, String text) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}

	public void javascriptClick(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

	public void javascriptScrollIntoView(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

}
