package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class BooksPage extends Util {

    By booksText = By.xpath("//h1[contains(text(), 'Books')]");

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public String getBooksPageText(){
        log.info("Get Books Page Text");
        return getTextFromElement(booksText);
    }

    public boolean verifyThatUserIsOnBooksPage(){
        log.info("Verify that User is on Books Page");
        if(getBooksPageText().equals("Books")){
            return true;
        }
        else{
            return false;
        }
    }
}
