package com.demo.nopcommerce.webpages;

import com.demo.nopcommerce.pageobject.HomePage;
import com.demo.nopcommerce.pageobject.LoginPage;
import com.demo.nopcommerce.testbase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();


    @Test
    public void userShouldLoginSuccessfully() {
        homePage.clickOnLoginLink();
       /* String text = loginPage.getWelcomeText();
        Assert.assertTrue(text.equals("Welcome, Please Sign In!"));*/

        String actualText = loginPage.getWelcomeText();
        String expectedText = "Welcome, Please Sign In!";
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void loginShouldFailAndErrorMessageShouldAppearWhenLoginIsInvalid() {
        homePage.clickOnLoginLink();
        loginPage.enterEmail("abcd@abc.com");
        loginPage.enterPassword("password");
        loginPage.clickLoginBtn();
        WebElement text = driver.findElement(By.xpath("//li[contains(text(),'No customer account found')]"));
        Assert.assertTrue("No customer account found", text.isDisplayed());
    }

}
