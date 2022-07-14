package com.test.sharmi.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    public WebDriver getDriver() {
        if (driver == null) {
        	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    private WebDriver driver;
}
