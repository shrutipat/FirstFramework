package com.demo.nopcommerce.webpages;

import com.demo.nopcommerce.pageobject.ComputerPage;
import com.demo.nopcommerce.pageobject.HomePage;
import com.demo.nopcommerce.pageobject.LoginPage;
import com.demo.nopcommerce.pageobject.RegistrationPage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeTest extends TestBase {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    ComputerPage computerPage = new ComputerPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void userShouldNavigateToRegistrationPageSuccessfully(){
        homePage.clickOnRegisterLink();
        String expectedText = "Register";
        String actualText = registrationPage.getRegisterText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        homePage.clickOnComputers();
        String actualText = computerPage.getComputerText();
        String expectedText = "Computers";
        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        homePage.clickOnLoginLink();
        String text = loginPage.getWelcomeText();
        Assert.assertTrue(text.equals("Welcome, Please Sign In!"));
    }

}
