package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.openqa.selenium.By;

public class LoginPage extends Util {

By email = By.id("Email");
By password = By.id("Password");
By loginBtn = By.xpath("//input[@value='Log in']");
By welcomeText = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");

public void enterEmail(String str){
    sendTextToElement(email, str);
}

public void enterPassword(String str){
    sendTextToElement(password, str);
}

public void clickLoginBtn(){
    clickOnElement(loginBtn);
}

public String getWelcomeText(){
    return getTextFromElement(welcomeText);
}

}
