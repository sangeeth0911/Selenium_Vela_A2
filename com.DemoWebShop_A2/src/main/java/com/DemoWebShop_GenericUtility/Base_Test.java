package com.DemoWebShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.DemoWebShop_POM.Home_Page;
import com.DemoWebShop_POM.Login_Page;
import com.DemoWebShop_POM.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Test {

	public WebDriver driver;
	public static WebDriver sDriver;
	public FileUtility fileUtility = new FileUtility();
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_Page homePage;
	public WebDriverUtility webDriverUtility = new WebDriverUtility();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("DataBase Connected");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Pre Conditions");

		spark = new ExtentSparkReporter(FrameWorkConstants.reportsPath);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("Address");

	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Launch Browser");

		String browser = fileUtility.readDataFromPropertyFile("browserName");
		String url = fileUtility.readDataFromPropertyFile("url");
		
//		String browser = System.getProperty("browserName");
//		String url = System.getProperty("baseUrl");
		

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Enter Valid Browser Name");
		}

		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);

	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("Login");

		welcomePage = new Welcome_Page(driver);
		welcomePage.getLoginLink().click();

		loginPage = new Login_Page(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("username"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
		loginPage.getLoginBtn().click();

		homePage = new Home_Page(driver);

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("DataBase DisConnected");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Post Conditions");
		reports.flush();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("Close Browser");
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("LogOut");

		homePage.getLogOutBtn().click();

	}

}
