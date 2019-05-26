package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class GiftCardsPage extends Util {
    By giftCardsText = By.xpath("//h1[contains(text(), 'Gift Cards')]");

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public String getGiftCardsPageText(){
        log.info("Get gift cards page text");
        return getTextFromElement(giftCardsText);
    }

    public boolean verifyThatUserIsOnGiftCardsPage(){
        log.info("Verify that user is on gifts cards page");
        if(getGiftCardsPageText().equals("Gift Cards")){
            return true;
        }
        else{
            return false;
        }
    }
}
