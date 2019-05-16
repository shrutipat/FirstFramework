package com.demo.nopcommerce.pageobject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public void clickOnLoginLink(){
        log.info("click on login link");
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink(){
        log.info("click on register link");
        clickOnElement(registerLink);
    }

    public void clickOnWishList(){
        log.info("click on wish list");
        clickOnElement(wishList);
    }

    public void clickOnShoppingCart(){
        log.info("click on shopping cart");
        clickOnElement(shoppingCart);
    }

    public void clickOnComputers(){
        log.info("click on computers");
        clickOnElement(computers);
    }
    public void clickOnElectronics(){
        log.info("click on electronics");
        clickOnElement(electronics);
    }

    public void clickOnApparel(){
        log.info("click on apparel");
        clickOnElement(apparel);
    }

    public void clickOnDigitalDownloads(){
        log.info("click on digital download");
        clickOnElement(digitalDownloads);
    }

    public void clickOnBooks(){
        log.info("click on books");
        clickOnElement(books);
    }

    public void clickOnJewellery(){
        log.info("click on jewellery");
        clickOnElement(jewellery);
    }

    public void clickOnGiftCards(){
        log.info("click on gift cards");
        clickOnElement(giftCards);
    }
}
