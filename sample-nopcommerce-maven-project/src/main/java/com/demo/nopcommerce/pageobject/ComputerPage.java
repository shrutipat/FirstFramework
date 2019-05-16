package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ComputerPage extends Util {
    By computersLink = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]");
    By computersText = By.xpath("//h1[contains(text(),'Computers')]");
    By desktopImage = By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[1]//a[1]//img[1]");
    By noteBookImage = By.xpath("//div[@class='page-body']//div[2]//div[1]//div[1]//a[1]//img[1]");
    By softwareImage = By.xpath("//div[@class='master-wrapper-content']//div[3]//div[1]//div[1]//a[1]//img[1]");

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public void mouseOverComputer() {
     log.info("mouse over computers");
     mouseOver(computersLink);
     clickOnElement(computersLink);
    }

    public String getComputerText() {
        log.info("get computer page text");
        return getTextFromElement(computersText);
    }

    public void clickOnDesktopImage(){
        log.info("click on desktop image");
        clickOnElement(desktopImage);
    }

    public void clickOnNoteBookImage(){
        log.info("click on notebook image");
        clickOnElement(noteBookImage);
    }

    public void clickOnSoftware(){
        log.info("click on software image");
        clickOnElement(softwareImage);
    }

}
