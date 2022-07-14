package com.test.sharmi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.test.sharmi.Util.DriverManager;

import java.util.List;

/**
 * Created by Sharmi on 14-07-2022.
 */
public class TshirtPage extends PageBase {

    public TshirtPage(DriverManager context) {
        super(context);
    }

    public WebElement addProduct(String strProd){
        return driver.findElement(By.xpath("//a[@data-product_sku='"+strProd+"']"));
    }

    public WebElement cartIcon(){
        return getWebElementVisible(By.xpath("(//a[@href='https://cms.demo.katalon.com/cart/'])[1]"));
    }
    


    public List<WebElement> cartNumber() {
        return driver.findElements(By.xpath("//table[contains(@class,'_responsive cart')]//tbody/tr"));
    }

    public WebElement lowProduct(String strProd){
        return getWebElementVisible(By.xpath("//span[contains(text(),'"+strProd+"')]/ancestor::tr/td[@class='product-remove']"));
    }


}
