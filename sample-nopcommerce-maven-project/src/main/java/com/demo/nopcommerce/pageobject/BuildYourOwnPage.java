package com.demo.nopcommerce.pageobject;
import com.demo.nopcommerce.utility.Util;
import org.openqa.selenium.By;

public class BuildYourOwnPage extends Util {
    String buildYourOwn = "Build your own computer";
    By buildYourOwnText = By.xpath("//h1[contains(text(),'Build your own computer')]");
    By productIsAddedText = By.xpath("//p[@class='content']");
    By hdd_320GB = By.xpath("//input[@id='product_attribute_3_6']");
    By addToCartBtn = By.xpath("//input[@id='add-to-cart-button-1']");

    public String getBuildYourOwnText(){
        return getTextFromElement(buildYourOwnText);
    }

    public void clickOnHdd320GB(){
        clickOnElement(hdd_320GB);
    }

    public boolean checkIfItemIsAddedSuccessfully(){
       return driver.findElement(productIsAddedText).isDisplayed();
    }

    public void clickOnAddtoCart(){
        clickOnElement(addToCartBtn);
    }

}
