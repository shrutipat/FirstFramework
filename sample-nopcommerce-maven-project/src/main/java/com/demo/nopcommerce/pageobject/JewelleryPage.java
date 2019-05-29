package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class JewelleryPage extends Util {

    By jewelleryText = By.xpath("//h1[contains(text(), 'Jewelry')]");

    private static final Logger log = LogManager.getLogger(JewelleryPage.class.getName());

    public String getJewelleryPageText(){
        log.info("Get jewellery page text");
        return getTextFromElement(jewelleryText);
    }

    public boolean verifyThatUserIsOnJewelleryPage(){
        log.info("Verify that user is on Jewellery Page");
        if(getJewelleryPageText().equals("Jewelry")){
            return true;
        }
        else{
            return false;
        }
    }


}
