package com.test.sharmi.stepdef;

import com.test.sharmi.Util.DriverManager;
import com.test.sharmi.pages.TshirtPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class orderstepdef {

    DriverManager context;
    double iLowPrice = 0;
    TshirtPage tshirtPage;

    private Scenario scenario;
    public orderstepdef(DriverManager context){
        this.context = context;

    }

    @Given("I am on homepage")
    public void iAmOnHomepage() {
        context.getDriver().get("https://cms.demo.katalon.com/");
        tshirtPage = new TshirtPage(context);
    	addScreenshot();

    }

    @When("I add products (.*) (.*) (.*) (.*)$")
    public void iOrderProducts(String product1, String product2, String product3, String product4) {
        tshirtPage.addProduct(product1).click();
        tshirtPage.addProduct(product2).click();
        tshirtPage.addProduct(product3).click();
        tshirtPage.addProduct(product4).click();
    	addScreenshot();

    }

    @And("I move to cart page")
    public void iMovetoCart() {
        tshirtPage.cartIcon().click();
        addScreenshot();

    }

    @Then("I should see my products in cart")
    public void iShouldSeeMyProductsinCart() {
        Assert.assertTrue(tshirtPage.cartNumber().size() >4);
        addScreenshot();

    }

    @When("I search lowest priced product")
    public void iFindLowPrice() {
        int icount=0;
        List<WebElement> arrElem = tshirtPage.cartNumber();
        String[] strPrice = new String[arrElem.size()-1];
        for(int i =0;i<arrElem.size()-1;i++){
            icount=icount+1;
            strPrice[i] =arrElem.get(0).findElement(By.xpath("(//td[@class='product-price']//span[@class='woocommerce-Price-amount amount'])["+icount+"]")).getText();
        }
        double[] numPrice = new double[strPrice.length];
        for(int j=0;j<strPrice.length;j++){
            String tempStr = strPrice[j].replace("$","");
            numPrice[j] = Double.valueOf(tempStr);
        }
        Arrays.sort(numPrice);
        iLowPrice = numPrice[0];
        addScreenshot();

    }


    @And("I remove lowest priced product")
    public void removeProduct() {
        tshirtPage.lowProduct(iLowPrice+"").click();
    	addScreenshot();
    }

    @Then("verify cart updated")
    public void updateCart() {
        Assert.assertTrue(tshirtPage.cartNumber().size() >4);
        addScreenshot();

    }
    @After
    public void closeDriver(){
        context.getDriver().quit();
    }
    @Before
    public void setUpScenario(Scenario scenario){
    this.scenario = scenario; 
    }
    
    public void addScreenshot(){
    	
    	TakesScreenshot ts = (TakesScreenshot) context.getDriver();
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

		scenario.attach(screenshot, "image/png", "");
    }
    
}
