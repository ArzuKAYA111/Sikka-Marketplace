package com.sikka.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sikka.utilities.ConfigsReader;
import com.sikka.utilities.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver setUp() {

		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		String headless=ConfigsReader.getProperty("headless");
		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
	
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions cOption=new ChromeOptions();

			if(headless.equalsIgnoreCase("true")) {
				cOption.setHeadless(true);
				driver = new ChromeDriver(cOption);
			}else {
				driver = new ChromeDriver(cOption);
			}
				break;
		
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");
		}

		 driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProperty("url"));
		// initialize all page objects as part of setup
		PageInitializer.initialize();

		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}}

