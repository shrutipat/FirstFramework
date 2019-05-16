package com.demo.nopcommerce.webpages;

import com.demo.nopcommerce.pageobject.*;
import com.demo.nopcommerce.testbase.TestBase;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuit extends TestBase {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    DesktopPage desktopPage = new DesktopPage();
    ComputerPage computerPage = new ComputerPage();
    LoginPage loginPage = new LoginPage();
    BuildYourOwnPage buildYourOwnPage = new BuildYourOwnPage();

    static final Logger logger = Logger.getLogger(TestSuit.class);


    //From home page user should navigate to registration page successfully
    @Test(priority = 0)
    public void userShouldNavigateToRegistrationPageSuccessfully() {
        homePage.clickOnRegisterLink();
        String expectedText = "Register";
        String actualText = registrationPage.getRegisterText();
        Assert.assertEquals(actualText, expectedText);
        BasicConfigurator.configure();
        logger.debug("Hello World!");
    }

    // From home page user should navigate to computer page successfully
    @Test(priority = 1)
    public void userShouldNavigateToComputerPageSuccessfully() {
        homePage.clickOnComputers();
        String actualText = computerPage.getComputerText();
        String expectedText = "Computers";
        Assert.assertEquals(actualText, expectedText);
    }

    // From home page user should navigate to login page successfully
    @Test(priority = 2)
    public void userShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnLoginLink();
        String text = loginPage.getWelcomeText();
        Assert.assertTrue(text.equals("Welcome, Please Sign In!"));
    }

    //Login should fail and error message should appear when login is invalid
    @Test(priority = 3)
    public void loginShouldFailAndErrorMessageShouldAppearWhenLoginIsInvalid() {
        homePage.clickOnLoginLink();
        loginPage.enterEmail("abcd@abc.com");
        loginPage.enterPassword("password");
        loginPage.clickLoginBtn();
        WebElement text = driver.findElement(By.xpath("//li[contains(text(),'No customer account found')]"));
        org.junit.Assert.assertTrue("No customer account found", text.isDisplayed());
    }

    // User should navigate to desktop page successfully
    @Test(priority = 4)
    public void userShouldNavigateToDesktopPageSuccessfully() {
        homePage.clickOnComputers();
        computerPage.clickOnDesktopImage();
        String actualText = desktopPage.getDesktopText();
        String expectedText = "Desktops";
        Assert.assertEquals(actualText, expectedText);
    }

    // User should navigate to build your own page successfully
    @Test(priority = 5)
    public void userShouldNavigateToBuildYourOwnPageSuccessfully() {
        homePage.clickOnComputers();
        computerPage.clickOnDesktopImage();
        desktopPage.scrollUpDown(600);
        desktopPage.clickOnAddToCartBtn();
        String actualText = buildYourOwnPage.getBuildYourOwnText();
        String expectedText = "Build your own computer";
        Assert.assertEquals(actualText, expectedText);
    }

    // Desktop item should be added to basket successfully
    @Test(priority = 6)
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
