package com.demo.nopcommerce.webpages;

import com.demo.nopcommerce.pageobject.*;
import com.demo.nopcommerce.testbase.TestBase;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSuit extends TestBase {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    DesktopPage desktopPage = new DesktopPage();
    ComputerPage computerPage = new ComputerPage();
    LoginPage loginPage = new LoginPage();
    BuildYourOwnPage buildYourOwnPage = new BuildYourOwnPage();

    static final Logger logger = Logger.getLogger(TestSuit.class);


    //From home page user should navigate to registration page successfully
    @Test
    public void userShouldNavigateToRegistrationPageSuccessfully() {
        homePage.clickOnRegisterLink();
        String expectedText = "Register";
        String actualText = registrationPage.getRegisterText();
        Assert.assertEquals(actualText, expectedText);
        BasicConfigurator.configure();
        logger.debug("Hello World!");
    }

    //User should be able to register successfully
    @Test
    public void userShouldRegisterSuccessfully() throws InterruptedException{
        homePage.clickOnRegisterLink();
        registrationPage.clickOnFemale();
        registrationPage.enterFirstName("My first name");
        registrationPage.enterLastName("My last name");
        registrationPage.selectDateOfBirthByIndex(10);
        registrationPage.selectMonthOfBirthByIndex(10);
        registrationPage.selectYearOfBirthByIndex(10);
        registrationPage.enterAutoEmail();
        registrationPage.enterCompanyName("My company name");
        registrationPage.enterPassword("abcxyz");
        registrationPage.enterConfirmPassword("abcxyz");
        registrationPage.clickOnRegisterBtn();

        Thread.sleep(2000);

        String expectedText = "Your registration completed";
        String actualText = registrationPage.getRegistrationSuccessfulText();
        Assert.assertEquals(actualText, expectedText);

    }

    // From home page user should navigate to login page successfully
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnLoginLink();
        String text = loginPage.getWelcomeText();
        Assert.assertTrue(text.equals("Welcome, Please Sign In!"));
    }

    //Login should fail and error message should appear when login is invalid
    @Test
    public void loginShouldFailAndErrorMessageShouldAppearWhenLoginIsInvalid() {
        homePage.clickOnLoginLink();
        loginPage.enterEmail("abcd@abc.com");
        loginPage.enterPassword("password");
        loginPage.clickLoginBtn();
        WebElement text = driver.findElement(By.xpath("//li[contains(text(),'No customer account found')]"));
        org.junit.Assert.assertTrue("No customer account found", text.isDisplayed());
    }

    // From home page user should navigate to computer page successfully
    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        homePage.clickOnComputers();
        String actualText = computerPage.getComputerText();
        String expectedText = "Computers";
        Assert.assertEquals(actualText, expectedText);
    }

    // User should navigate to desktop page successfully
    @Test
    public void userShouldNavigateToDesktopPageSuccessfully() {
        homePage.clickOnComputers();
        computerPage.clickOnDesktopImage();
        String actualText = desktopPage.getDesktopText();
        String expectedText = "Desktops";
        Assert.assertEquals(actualText, expectedText);
    }

    // User should navigate to build your own page successfully
    @Test
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


    @Test
    public void  sortByZtoAShouldWorkSuccessfullyOnDesktopPage() throws InterruptedException {
        homePage.clickOnComputers();
        computerPage.clickOnDesktopImage();
        desktopPage.scrollUpDown(500);
        Thread.sleep(3000);
        //fetch and store list of items in array list
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='item-grid']/descendant::h2[@class='product-title']"));

        // Assign titles to String Array List
        ArrayList<String> sortedNames = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            sortedNames.add(list.get(i).getText());
        }

        // Re-arrange the original String Array in descending order
        Collections.sort(sortedNames, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.valueOf(s2.compareTo(s1));
            }
        });

        desktopPage.clickOnSortByDropDown();
        desktopPage.select_ZToA();
        desktopPage.scrollUpDown(500);
        Thread.sleep(1000);
        List<WebElement> listZToA = driver.findElements(By.xpath("//div[@class='item-grid']/descendant::h2[@class='product-title']"));
        Thread.sleep(1000);

        //verify that is sorted names is matching actual names after clicking Z to A
        for (int i = 0; i < listZToA.size(); i++) {
            Assert.assertEquals(sortedNames.get(i), listZToA.get(i).getText());
        }
    }

}
