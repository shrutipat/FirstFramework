package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.openqa.selenium.By;

public class DesktopPage extends Util {

    By sortByDropDown = By.id("products-orderby");
    By desktopTextOnDesktopPage = By.xpath("//h1[contains(text(),'Desktops')]");
    String zToA = "Name: Z to A";
    By addToCartBtn = By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]");
    By buildYourOwnText = By.xpath("//h1[contains(text(),'Build your own computer')]");

    public void clickOnSortByDropDown(){
        clickOnElement(sortByDropDown);
    }

    public void select_zToA(){
        select_By_Visible_Text(sortByDropDown, zToA);
    }

    public void scrollDownDesktopPage(int i){
        scrollUpDown(i);
    }

    public void clickOnAddToCartBtn(){
        clickOnElement(addToCartBtn);
    }

    public String getDesktopText(){
       return getTextFromElement(desktopTextOnDesktopPage);
    }

}
