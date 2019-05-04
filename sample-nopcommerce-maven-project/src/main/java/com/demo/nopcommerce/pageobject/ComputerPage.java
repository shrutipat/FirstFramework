package com.demo.nopcommerce.pageobject;
import com.demo.nopcommerce.utility.Util;
import org.openqa.selenium.By;

public class ComputerPage extends Util {
    By computersLink = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]");
    By computersText = By.xpath("//h1[contains(text(),'Computers')]");
    By desktopImage = By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[1]//a[1]//img[1]");
    By noteBookImage = By.xpath("//div[@class='page-body']//div[2]//div[1]//div[1]//a[1]//img[1]");
    By softwareImage = By.xpath("//div[@class='master-wrapper-content']//div[3]//div[1]//div[1]//a[1]//img[1]");

    public void mouseOverComputer() {
     mouseOver(computersLink);
     clickOnElement(computersLink);
    }

    public String getComputerText() {
        return getTextFromElement(computersText);
    }

    public void clickOnDesktopImage(){
        clickOnElement(desktopImage);
    }

    public void clickOnNoteBookImage(){
        clickOnElement(noteBookImage);
    }

    public void clickOnSoftware(){
        clickOnElement(softwareImage);
    }

}
