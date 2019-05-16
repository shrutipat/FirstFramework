package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class DesktopPage extends Util {

    By sortByDropDown = By.id("products-orderby");
    By desktopTextOnDesktopPage = By.xpath("//h1[contains(text(),'Desktops')]");
    String zToA = "Name: Z to A";
    By addToCartBtn = By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]");
    By buildYourOwnText = By.xpath("//h1[contains(text(),'Build your own computer')]");

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public void clickOnSortByDropDown(){
        log.info("click on sort by drop down");
        clickOnElement(sortByDropDown);
    }

    public void select_ZToA(){
        log.info("select Z to A");
        select_By_Visible_Text(sortByDropDown, zToA);
    }

    public void scrollDownDesktopPage(int i){
        log.info("scroll down desktop page");
        scrollUpDown(i);
    }

    public void clickOnAddToCartBtn(){
        log.info("click on add to cart button");
        clickOnElement(addToCartBtn);
    }

    public String getDesktopText(){
        log.info("get desktop text");
       return getTextFromElement(desktopTextOnDesktopPage);
    }
}
