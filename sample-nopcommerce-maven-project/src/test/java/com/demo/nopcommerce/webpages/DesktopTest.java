package com.demo.nopcommerce.webpages;

import com.demo.nopcommerce.pageobject.BuildYourOwnPage;
import com.demo.nopcommerce.pageobject.ComputerPage;
import com.demo.nopcommerce.pageobject.DesktopPage;
import com.demo.nopcommerce.pageobject.HomePage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopTest extends TestBase {

    HomePage homePage = new HomePage();
    ComputerPage computerPage = new ComputerPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOwnPage buildYourOwnPage = new BuildYourOwnPage();


    @Test
    public void userShouldNavigateToBuildYourOwnPageSuccessfully(){
        homePage.clickOnComputers();
        computerPage.clickOnDesktopImage();
        desktopPage.scrollUpDown(600);
        desktopPage.clickOnAddToCartBtn();
        String actualText = buildYourOwnPage.getBuildYourOwnText();
        String expectedText = "Build your own computer";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void desktopShouldAddToBasketSuccessfully() throws InterruptedException {
        homePage.clickOnComputers();
        computerPage.clickOnDesktopImage();
        desktopPage.scrollUpDown(600);
        desktopPage.clickOnAddToCartBtn();
        Thread.sleep(2000);
        buildYourOwnPage.scrollUpDown(500);
        Thread.sleep(3000);
        buildYourOwnPage.clickOnHdd320GB();
        buildYourOwnPage.scrollUpDown(200);
        buildYourOwnPage.clickOnAddtoCart();
        Thread.sleep(2000);
        Assert.assertTrue(buildYourOwnPage.checkIfItemIsAddedSuccessfully());
    }
}