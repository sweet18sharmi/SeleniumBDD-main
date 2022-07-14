package com.test.sharmi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.sharmi.Util.DriverManager;

import java.util.List;
/**
 * Created by Sharmi on 14-07-2022.
 */
public class PageBase {

    WebDriver driver;

    public PageBase(DriverManager manager){
        this.driver = manager.getDriver();
    }

    public WebElement getWebElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> getWebElementsVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
