package com.demo.nopcommerce.webpages;

import com.demo.nopcommerce.pageobject.HomePage;
import com.demo.nopcommerce.pageobject.RegistrationPage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Parameters({"firstname","lastname"})
    public void userShouldRegisterSuccessfully(String firstname, String lastname) throws InterruptedException{
        homePage.clickOnRegisterLink();
        registrationPage.clickOnFemale();
        registrationPage.enterFirstName(firstname);
        registrationPage.enterLastName(lastname);
        registrationPage.selectDateOfBirthByIndex(10);
        registrationPage.selectMonthOfBirthByIndex(10);
        registrationPage.selectYearOfBirthByIndex(10);
        registrationPage.enterAutoEmail();
        registrationPage.enterCompanyName("My company name");
        registrationPage.enterPassword("abcxyz");
        registrationPage.enterConfirmPassword("abcxyz");
        registrationPage.clickOnRegisterBtn();
        Thread.sleep(1000);
        String expectedText = "Your registration completed";
        String actualText = registrationPage.getRegistrationSuccessfulText();
        Assert.assertEquals(actualText, expectedText);
    }
}
