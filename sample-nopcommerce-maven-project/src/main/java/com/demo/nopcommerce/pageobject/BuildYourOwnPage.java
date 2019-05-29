package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class BuildYourOwnPage extends Util {
    String buildYourOwn = "Build your own computer";
    By buildYourOwnText = By.xpath("//h1[contains(text(),'Build your own computer')]");
    By productIsAddedText = By.xpath("//p[@class='content']");
    By hdd_320GB = By.xpath("//input[@id='product_attribute_3_6']");
    By addToCartBtn = By.xpath("//input[@id='add-to-cart-button-1']");

    private static final Logger log = LogManager.getLogger(BuildYourOwnPage.class.getName());

    public String getBuildYourOwnText(){
        log.info("get build you own page text");
        return getTextFromElement(buildYourOwnText);
    }

    public void clickOnHdd320GB(){
        log.info("click on hdd 320GB");
        clickOnElement(hdd_320GB);
    }

    public boolean checkIfItemIsAddedSuccessfully(){
        log.info("check if item is added successfully");
       return driver.findElement(productIsAddedText).isDisplayed();
    }

    public void clickOnAddtoCart(){
        log.info("click on add to cart");
        clickOnElement(addToCartBtn);
    }
}
