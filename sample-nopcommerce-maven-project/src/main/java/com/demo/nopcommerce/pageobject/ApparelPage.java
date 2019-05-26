package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ApparelPage extends Util {

    By apparelText = By.xpath("//h1[contains(text(), 'Apparel')]");

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public String getApparelPageText(){
        log.info("Get Apparel Page Text");
        return getTextFromElement(apparelText);
    }

    public boolean verifyThatUserIsOnApparelPage(){
        log.info("Verify that User is on apparel page");
        if(getApparelPageText().equals("Apparel")){
            return true;
        }
        else{
            return false;
        }
    }
}
