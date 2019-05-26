package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class LoginPage extends Util {

    By email = By.id("Email");
    By password = By.id("Password");
    By loginBtn = By.xpath("//input[@value='Log in']");
    By welcomeText = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
    By successfulLoginText = By.xpath("//h2[contains(text(),'Welcome to our store')]");

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public void enterEmail(String str) {
        log.info("enter email address");
        sendTextToElement(email, str);
    }

    public void enterPassword(String str) {
        log.info("enter password");
        sendTextToElement(password, str);
    }

    public void clickLoginBtn() {
        log.info("click on login button");
        clickOnElement(loginBtn);
    }

    public String getWelcomeText() {
        log.info("get welcome text");
        return getTextFromElement(welcomeText);
    }

    public boolean verifyWelcomeText() {
        if(getWelcomeText().equals("Welcome, Please Sign In!")){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean verifyThatUserIsLoggedInSuccessfully(){
        log.info("Verify that user is logged in successfully");
        if(getTextFromElement(successfulLoginText).equals("Welcome to our store")){
            return true;
        }
        else{
            return false;
        }
    }
}
