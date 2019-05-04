package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.openqa.selenium.By;

public class HomePage extends Util {
    // save Homepage locators
    By loginLink = By.linkText("Log in");
    By registerLink = By.className("ico-register");
    By wishList = By.className("wishlist-label");
    By shoppingCart = By.className("cart-label");
    By computers = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]");
    By electronics = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Electronics')]");
    By apparel = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Apparel')]");
    By digitalDownloads = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]");
    By books = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]");
    By jewellery = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Jewelry')]");
    By giftCards = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Gift Cards')]");

    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }

    public void clickOnWishList(){
        clickOnElement(wishList);
    }

    public void clickOnShoppingCart(){
        clickOnElement(shoppingCart);
    }

    public void clickOnComputers(){
        clickOnElement(computers);
    }
    public void clickOnElectronics(){
        clickOnElement(electronics);
    }

    public void clickOnApparel(){
        clickOnElement(apparel);
    }

    public void clickOnDigitalDownloads(){
        clickOnElement(digitalDownloads);
    }

    public void clickOnBooks(){
        clickOnElement(books);
    }

    public void clickOnJewellery(){
        clickOnElement(jewellery);
    }

    public void clickOnGiftCards(){
        clickOnElement(giftCards);
    }
}
