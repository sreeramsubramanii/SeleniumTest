package Test.TestVagrant;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Test.TestVagrant.common.IConstant;
import Test.TestVagrant.common.Utility;

public class BaseClass {

	protected WebDriver driver;

	@BeforeClass
	@Parameters({ "browserName", "url","driverPath" })
	public void setUp(String browserName, String url,String driverPath) {
		switch (browserName.toLowerCase()) {
		case IConstant.CHROME:
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
//		System.setProperty("webdriver.chrome.driver",
//					"/home/cepl/Documents/Selenium things/chromedriver_linux64/chromedriver");
		
		System.setProperty("webdriver.chrome.driver",
				driverPath);
	
			driver = new ChromeDriver(options);

			break;
		case IConstant.FIREFOX:

			driver = new FirefoxDriver();

			break;
		case IConstant.IE:
			driver = new InternetExplorerDriver();
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@AfterClass
	public void quiBrowser()
	{
		driver.quit();
		
	}

}
