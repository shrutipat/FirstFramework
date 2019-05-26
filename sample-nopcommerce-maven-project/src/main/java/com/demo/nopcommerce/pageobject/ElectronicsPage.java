package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ElectronicsPage extends Util {
    By electronicsText = By.xpath("//h1[contains(text(), 'Electronics')]");

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public String getElectronicsPageText(){
        log.info("Get electronics page text");
        return getTextFromElement(electronicsText);
    }

    public boolean verifyThatUserIsOnElectronicsPage(){
        log.info("Verify that user is on electronics page");
        if(getElectronicsPageText().equals("Electronics")){
            return true;
        }
        else{
            return false;
        }
    }
}
